package hraciaPlocha;

import java.io.BufferedWriter;
import java.io.FileWriter;
import hra.Hrac;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Skore {

    public Skore(Hrac []hraci) {
        
        
                try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/hraciaPlocha/stav.txt"))) {
            buffer.write("---------PEXESO----------");
            buffer.newLine();
            buffer.write(getDatum());
            buffer.newLine();
            buffer.write("Posledný zápas  :");
            buffer.newLine();
            buffer.newLine();
            buffer.write("Hráč 1");
            buffer.newLine();
            buffer.write("nick : " + hraci[0].getMeno());
            buffer.newLine();
            buffer.write("body : " + hraci[0].getBody());
            buffer.newLine();
            buffer.write("Hráč 2");
            buffer.newLine();
            buffer.write("nick : " + hraci[1].getMeno());
            buffer.newLine();
            buffer.write("body : " + hraci[1].getBody());     
            buffer.flush();
        } catch (Exception exe) {
            System.err.println("Nastala chyba, do suboru sa nepodarilo zapísať.");
        }
    }
    
    public String getDatum(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'o' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return(formatter.format(date));
    }
}
