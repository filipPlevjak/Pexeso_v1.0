package hra;

import javax.swing.*; 

public class Karty {

   public final Karty[] karty = new Karty[41];
    
    private ImageIcon obrazok;
    private int idPexesa;
    private boolean najdenyPar;
    private static final String DEFAULT_IMAGE_FOLDER = "/obrazky/karty/";
////

    public Karty(ImageIcon ikona, int paCisloObrazku, boolean paNajdenyPar) {
        this.obrazok = ikona;
        this.idPexesa = paCisloObrazku;
        this.najdenyPar = paNajdenyPar;
         
        setObrazky(40);
                  
        }
    
    

      

    //metoda ktora nam postupne nacitava karticky pexesa
    private void setObrazky(int i){

        for ( i = 0; i < 40; i++) {
                    karty[i].setObrazok(new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+ "1.jpg") ));
                    karty[i].setNajdenyPar(false); 
                    karty[i].setCisloObrazku(i);
                }
/*
         switch (cislo) {  
            case 0:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+ "1.jpg"));idPexesa = 0;break;
            case 1:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"1.jpg"));idPexesa = 0;break;
            case 2:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"2.jpg "));idPexesa = 1;break;
            case 3:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"2.jpg"));idPexesa = 1;break;
            case 4:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"3.jpg"));idPexesa = 2;break;
            case 5:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"3.jpg"));idPexesa = 2;break;
            case 6:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"4.jpg"));idPexesa = 3;break;
            case 7:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"4.jpg"));idPexesa = 3;break;
            case 8:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"5.jpg"));idPexesa = 4;break;
            case 9:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"5.jpg"));idPexesa = 4;break;
            case 10:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"6.jpg"));idPexesa = 5;break;
            case 11:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"6.jpg"));idPexesa = 5;break;
            case 12:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"7.jpg"));idPexesa = 6;break;
            case 13:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"7.jpg"));idPexesa = 6;break;
            case 14:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"8.jpg"));idPexesa = 7;break;
            case 15:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"8.jpg"));idPexesa = 7;break;
            case 16:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"9.jpg"));idPexesa = 8;break;
            case 17:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"9.jpg"));idPexesa = 8;break;
            case 18:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"10.jpg"));idPexesa = 9;break;
            case 19:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"10.jpg"));idPexesa = 9;break;
            case 20:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"11.jpg"));idPexesa = 10;break;
            case 21:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"11.jpg"));idPexesa = 10;break;
            case 22:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"12.jpg"));idPexesa = 11;break;
            case 23:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"12.jpg"));idPexesa = 11;break;
            case 24:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"13.jpg"));idPexesa = 12;break;
            case 25:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"13.jpg"));idPexesa = 12;break;
            case 26:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"14.jpg"));idPexesa = 13;break;
            case 27:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"14.jpg"));idPexesa = 13;break;
            case 28:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"15.jpg"));idPexesa = 14;break;
            case 29:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"15.jpg"));idPexesa = 14;break;
            case 30:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"16.jpg"));idPexesa = 15;break;
            case 31:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"16.jpg"));idPexesa = 15;break;   
            case 32:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"17.jpg"));idPexesa = 16;break;                     
            case 33:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"17.jpg"));idPexesa = 16;break;
            case 34:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"18.jpg"));idPexesa = 17;break;
            case 35:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"18.jpg"));idPexesa = 17;break;                                                                                                                                
            case 36:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"19.jpg"));idPexesa = 18;break;                                                                                                                                                                                     
            case 37:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"19.jpg"));idPexesa = 18;break;                                                                                                                                                                                                                                     
            case 38:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"20.jpg"));idPexesa = 19;break;                                                                                                                                                                                                                                                                                    
            case 39:obrazok = new ImageIcon(Karty.class.getResource(DEFAULT_IMAGE_FOLDER+"20.jpg"));idPexesa = 19;break;                                                                                                                                                                                                                                                                                                                                                   
        }  
*/
    }


    public boolean getNajdenyPar() {
        return this.najdenyPar;
    }


    public ImageIcon getObrazok() {
        return this.obrazok;
    }


    public int getCisloObrazku() {
        return this.idPexesa;
    }

    public void setNajdenyPar(boolean najdenyPar) {
        this.najdenyPar = najdenyPar;
    }

 
    public void setCisloObrazku(int cisloObrazku) {
        this.idPexesa = cisloObrazku;
    }

 
    public void setObrazok(ImageIcon paObrazok) {
        this.obrazok = paObrazok;
    }
}
