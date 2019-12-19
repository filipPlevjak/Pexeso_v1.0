package hraciaPlocha;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import hra.Postava;
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


    public Panel(Postava postava1, Postava postava2) {
        skore = new Skore(postava1, postava2);
        vrchnyPanel = new JPanel(new GridBagLayout());
        vrchnyPanel.setLayout(new GridLayout(1, 2, 100, 40));
        vrchnyPanel.add(lavyHrac);
        vrchnyPanel.add(menoHraca1);
        vrchnyPanel.add(bodyHraca1);
        vrchnyPanel.add(stred);
        vrchnyPanel.add(menoHraca2);
        vrchnyPanel.add(bodyHraca2);   
        vrchnyPanel.add(pravyHrac);

        
        menoHraca1.setText("hrač 1:" + postava1.getMeno());
        menoHraca2.setText("hrač 2:" + postava2.getMeno());
        
        bodyHraca1.setText("body" + postava1.getBody());
        bodyHraca2.setText("body" + postava2.getBody());
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
    public void zmenBody(Postava postava, int hracNaRade) {
        if (hracNaRade == 1) {
            bodyHraca1.setText("body : " + postava.getBody());
        } else {
            bodyHraca2.setText("body : " + postava.getBody());
        }
    }

    public void vyherca(Postava postava1, Postava postava2) {
        JFrame jframe2 = new JFrame("Ukončenie hry");
    skore = new Skore(postava1, postava2);
    }

}