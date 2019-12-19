package hra;


 
import hraciaPlocha.Panel;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import hraciaPlocha.KoniecHry;
import hraciaPlocha.Menu;
import hraciaPlocha.Skore;
import java.awt.Color;

public class Pexeso extends JFrame implements ActionListener {

    
    private static final String DEFAULT_IMAGE_FOLDER = "/obrazky/obal.jpg";
    private int MAX_OBRAZKOV = 40;
    private int MAX_STLACENE_OBRAZKY = 2;
    private int POCET_PAROV_PEXESA = 20;
    private int CAKACI_CAS = 500;
    
    private final JButton[] tlacidloPexeso = new JButton[MAX_OBRAZKOV];
    private final int[] stlaceneKarty = new int[MAX_STLACENE_OBRAZKY];
    private final Karty[] karty = new Karty[MAX_OBRAZKOV];
    
    private final ImageIcon zadnaStrana;
    private final Panel panel;

 

    private final Postava postava1;
    private final Postava postava2;
    private int pocetStlacenychKariet = 0;
    private int pocetUhadnutychkariet = 0;
    private int hracNaRade = 1;
    private int kliknutaPoziciaPexesa;
    private boolean parPexesa = false;
    private boolean opakujTah;
    private int body1,body2;
    
    private Skore skore;

    /*
     Konštruktor nám vytvára pexeso, obal,karty,panel a ukladá do súboru
    stav hry
     */
    public Pexeso(Postava postava1, Postava postava2) {
        
        //
       
        this.postava1 = postava1;
        this.postava2 = postava2;

        panel = new Panel(postava1, postava2);
        skore = new Skore(postava1,postava2);
        zadnaStrana = new ImageIcon(Pexeso.class.getResource(DEFAULT_IMAGE_FOLDER));
        kliknutaPoziciaPexesa = -1;


       // for (int i = 0; i < MAX_OBRAZKOV; i++) {
        //    karty[i] = new Karty(null,0,false,i);
       // }
        
        //premiesa vsetky ie karty
        Collections.shuffle(Arrays.asList(karty));

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

        JButton tlačidlo = (JButton) event.getSource();

        for (int i = 0; i < MAX_OBRAZKOV; i++) {
            if (((tlačidlo).equals(tlacidloPexeso[i])) && (karty[i].getNajdenyPar() == false) && (i != kliknutaPoziciaPexesa) ) {//
                kliknutaPoziciaPexesa = i;
                tlačidlo.setIcon(karty[i].getObrazok());

                if (pocetStlacenychKariet == 0) stlaceneKarty[0] = i;
                if (pocetStlacenychKariet == 1) stlaceneKarty[1] = i;
                pocetStlacenychKariet++;
            }
        }
        if (pocetStlacenychKariet == MAX_STLACENE_OBRAZKY) {
            //tvoria par
            if ((karty[stlaceneKarty[0]].getCisloObrazku()) == (karty[stlaceneKarty[1]].getCisloObrazku())) {
                parPexesa = true;
                pocetStlacenychKariet = 0;
                karty[stlaceneKarty[0]].setNajdenyPar(true);
                karty[stlaceneKarty[1]].setNajdenyPar(true);
                kliknutaPoziciaPexesa = -1;
                
                pocetUhadnutychkariet++;
                setBody();
                skore = new Skore(postava1,postava2);
                koniecHry(pocetUhadnutychkariet);
                opakujTah = true;

            }
            
     //netvoria pár
            else {
           
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
            if (opakujTah == false) {
            hracNaRade++;
            }
            
            hracNaRade = getHrac(hracNaRade); 
            zmenFarbu();
            parPexesa = false;

        }
    }

//priradí bod danemu hračovi, podla toho kto je na rade
private void setBody(){
           if ((hracNaRade % 2) == 0) {
                    body2++;
                    postava2.setBody(body2);
                    panel.zmenBody(postava2, 2);
                     
                 }
                 else
                 {  body1++;
                     postava1.setBody(body1);
                    panel.zmenBody(postava1, 1);
                 }
}
 //zakryje karty ak uhádnutý pár nebol správny
    private void zakryPar() {
        tlacidloPexeso[stlaceneKarty[0]].setIcon(zadnaStrana);
        tlacidloPexeso[stlaceneKarty[1]].setIcon(zadnaStrana);
        pocetStlacenychKariet = 0;
        kliknutaPoziciaPexesa = -1;
    }

 //urcuje ktory hrac je na rade
    private int getHrac(int naRade) {
        if ((naRade % 2) != 0) {
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
    private void koniecHry(int pocet) {
        if (pocet == POCET_PAROV_PEXESA) {
            
            if(postava1.getBody() >  postava2.getBody()){
             KoniecHry koniec = new KoniecHry(postava1.getMeno(),postava1.getBody());
             koniec.setVisible(true);
            }
            else{
            
             KoniecHry koniec = new KoniecHry(postava2.getMeno(),postava2.getBody());
             koniec.setVisible(true);
            }      
       }
    }

        public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
        new Menu().setVisible(true);
        });
    }
    
}
