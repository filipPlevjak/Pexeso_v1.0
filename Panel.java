package hraciaPlocha;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import hra.Hrac;
import java.awt.BorderLayout;
 
import java.awt.GridLayout;
import javax.swing.*;


public class Panel extends JFrame {

    public JPanel vrchnyPanel;
    public JPanel mainPanel;
    public final JButton lavyHrac = new JButton(); 
    public final JButton pravyHrac = new JButton();
    public final JLabel menoHraca1 = new JLabel();
    public final JLabel menoHraca2 = new JLabel();    
    public final JLabel bodyHraca1 = new JLabel();
    public final JLabel stred = new JLabel();  
    public final JLabel bodyHraca2 = new JLabel();
    private Skore skore;
    
    private final Hrac []hraci;


    public Panel(Hrac []paHraci) {
        this.hraci = paHraci;
        skore = new Skore(hraci);
        vrchnyPanel = new JPanel(new GridBagLayout());
        vrchnyPanel.setLayout(new GridLayout(1, 2, 100, 40));
        vrchnyPanel.add(lavyHrac);
        vrchnyPanel.add(menoHraca1);
        vrchnyPanel.add(bodyHraca1);
        vrchnyPanel.add(stred);
        vrchnyPanel.add(menoHraca2);
        vrchnyPanel.add(bodyHraca2);   
        vrchnyPanel.add(pravyHrac);

        
        menoHraca1.setText("hrač 1:" + hraci[0].getMeno());
        menoHraca2.setText("hrač 2:" + hraci[1].getMeno());
        
        bodyHraca1.setText("body" + hraci[0].getBody());
        bodyHraca2.setText("body" + hraci[1].getBody());
        stred.setText("!");
       

        mainPanel = new JPanel(new GridBagLayout());
        vrchnyPanel.setBorder(BorderFactory.createTitledBorder(" Menu "));
        mainPanel.setBorder(BorderFactory.createTitledBorder(" Karty "));
        mainPanel.setLayout(new GridLayout(5, 0, 0, 0));

        JFrame jframe1 = new JFrame("Hra Pexeso");
        jframe1.setLayout(new BorderLayout());   
        jframe1.add(vrchnyPanel, BorderLayout.NORTH);
        jframe1.add(mainPanel, BorderLayout.CENTER);

        jframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe1.pack();
        jframe1.setLocationRelativeTo(null);
        jframe1.setVisible(true);
        jframe1.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
//zmení body vo vrchnom paneli hráčom
    public void zmenBody(Hrac postava, int hracNaRade) {
        if (hracNaRade == 1) {
            bodyHraca1.setText("body : " + postava.getBody());
        } else {
            bodyHraca2.setText("body : " + postava.getBody());
        }
    }

    public void vyherca(Hrac postava1, Hrac postava2) {
        JFrame jframe2 = new JFrame("Ukončenie hry");
        skore = new Skore(hraci);
    }

}
