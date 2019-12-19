package hra;
import javax.swing.ImageIcon;


public class Karta {

    private ImageIcon obrazok;
    private int idPexesa;
    private boolean najdenyPar = false;
    private static final String DEFAULT_IMAGE_FOLDER = "/obrazky/karty/";

    public Karta(int paCisloKarty) {
        this.obrazok = new ImageIcon(Karta.class.getResource(DEFAULT_IMAGE_FOLDER + (paCisloKarty + 1) + ".jpg"));
    }

    public boolean getNajdenyPar() {
        return this.najdenyPar;
    }

    public ImageIcon getObrazok() {
        return this.obrazok;
    }

    private void setObrazok(int cislo){
        this.idPexesa = cislo;
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
}
