package hra;
import hraciaPlocha.Panel;
import hraciaPlocha.KoniecHry;
import hraciaPlocha.Skore;
import java.util.Collections;
import java.util.Arrays;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Pexeso extends JFrame implements ActionListener {

    private final String DEFAULT_IMAGE_FOLDER = "/obrazky/obal.jpg";
    private final int MAX_OBRAZKOV = 40;
    private final int MAX_STLACENE_OBRAZKY = 2;
    private final int POCET_PAROV_PEXESA = 20;
    private final int CAKACI_CAS = 500;
    private final JButton[] tlacidloPexeso = new JButton[MAX_OBRAZKOV];
    private final int[] stlaceneKarty = new int[MAX_STLACENE_OBRAZKY];
    private final ImageIcon zadnaStrana;
    private int pocetStlacenychKariet = 0;
    private int pocetUhadnutychkariet = 0;
    private int hracNaRade = 1;
    private int kliknutaPoziciaPexesa;
    private boolean opakujTah;
    private final Karta[] karta = new Karta[MAX_OBRAZKOV];
    private Skore skore;
    private final Panel panel;
    private final Hrac []hraci ;

    /*
     Konštruktor nám vytvára pexeso, obal,karty,panel a ukladá do súboru
    stav hry
     */
    public Pexeso(Hrac []paHraci) {
    this.hraci = paHraci;


        panel = new Panel(hraci);
        skore = new Skore(hraci);
        zadnaStrana = new ImageIcon(Pexeso.class.getResource(DEFAULT_IMAGE_FOLDER));
        kliknutaPoziciaPexesa = -1;

        int j = 0;
        for (int i = 0; i < MAX_OBRAZKOV; i+=2) {
            karta[i] = new Karta(j%20);
            karta[i].setCisloObrazku(j);
            karta[i+1] = new Karta(j%20);
            karta[i+1].setCisloObrazku(j);
            j++;
        }
        
        //premiesa vsetky ie karty
        Collections.shuffle(Arrays.asList(karta));

        for (int i = 0; i < MAX_OBRAZKOV; i++) {
            tlacidloPexeso[i] = new JButton();
            tlacidloPexeso[i].addActionListener(this);
            panel.mainPanel.add(tlacidloPexeso[i]);
            tlacidloPexeso[i].setIcon(zadnaStrana);
        }

        if (hracNaRade == 1) {
            panel.lavyHrac.setBackground(new Color(0,250,0));
        }

    }

//akcia po kliku na karticku
    @Override
    public void actionPerformed(ActionEvent event) {

        if (pocetStlacenychKariet == MAX_STLACENE_OBRAZKY) {
            return;
        }

        JButton tlacidlo = (JButton) event.getSource();

        for (int i = 0; i < MAX_OBRAZKOV; i++) {
            if ((tlacidlo.equals(tlacidloPexeso[i])) && (!karta[i].getNajdenyPar()) && ( i != kliknutaPoziciaPexesa)) {
                kliknutaPoziciaPexesa = i;
                tlacidlo.setIcon(karta[i].getObrazok());

                if (pocetStlacenychKariet == 0)
                    stlaceneKarty[0] = i;
                
                if (pocetStlacenychKariet == 1)
                    stlaceneKarty[1] = i;
                
                pocetStlacenychKariet++;
                break;
            }
        }

        if (pocetStlacenychKariet == MAX_STLACENE_OBRAZKY) {
            // tvoria par
            if ((karta[stlaceneKarty[0]].getCisloObrazku()) == (karta[stlaceneKarty[1]].getCisloObrazku())) {
                pocetStlacenychKariet = 0;
                karta[stlaceneKarty[0]].setNajdenyPar(true);
                karta[stlaceneKarty[1]].setNajdenyPar(true);
                kliknutaPoziciaPexesa = -1;
                
                pocetUhadnutychkariet++;
                setBody(hraci);
                skore = new Skore(hraci);
                koniecHry(pocetUhadnutychkariet);
                opakujTah = true;

            } else {
                //netvoria pár

                Pexeso hra = this;

                //cakanie po neúpešnom otočenom páre
                //karticky sa vrátia do pôvodného tvaru
                Thread thread = new Thread(() -> {
                        try {
                            Thread.sleep(CAKACI_CAS);
                        } catch (Exception exe) {
                        }
                        hra.zakryPar();
                    });

                thread.start();
                opakujTah = false;
            }

            if (!opakujTah) {
                hracNaRade++;
            }
            
            hracNaRade = getHrac(hracNaRade); 
            zmenFarbu();
        }
    }

    // priradí bod danemu hračovi, podla toho kto je na rade
    private void setBody(Hrac[] hraci){
        if ((hracNaRade % 2) == 0) {
            hraci[1].setBody(1);
            panel.zmenBody(hraci[1], 2);
        } else { 
            hraci[0].setBody(1);
            panel.zmenBody(hraci[0], 1);
        }
}
    // zakryje karty ak uhádnutý pár nebol správny
    private void zakryPar() {
        tlacidloPexeso[stlaceneKarty[0]].setIcon(zadnaStrana);
        tlacidloPexeso[stlaceneKarty[1]].setIcon(zadnaStrana);
        pocetStlacenychKariet = 0;
        kliknutaPoziciaPexesa = -1;
    }

 //urcuje ktory hrac je na rade
    private int getHrac(int hracNaRade) {
        if ((hracNaRade % 2) != 0) {
            return 1;
        } else {
            return 2;
        }
    }

 //mení farbu na vrhnom paneli podla toho ktorý hráč  na rade
    private void zmenFarbu() {
        if (hracNaRade != 1) {
            panel.pravyHrac.setBackground(new Color(0, 250, 0));
            panel.lavyHrac.setBackground(new Color(200, 200, 200));
        } else {
            panel.lavyHrac.setBackground(new Color(0, 250, 0));
            panel.pravyHrac.setBackground(new Color(200, 200, 200));

        }
    }

//koniec hry pri uhádnutí všetkých kariet
    private void koniecHry(int pocetUhadnutych) {
        KoniecHry koniec;
        if (pocetUhadnutych == POCET_PAROV_PEXESA) {
            
            if(hraci[0].getBody() >  hraci[1].getBody()){
                koniec = new KoniecHry(hraci[0].getMeno(),hraci[0].getBody());
            } else{
                koniec = new KoniecHry(hraci[1].getMeno(),hraci[1].getBody());
            }   
            koniec.setVisible(true);
       }
    }
  
}
