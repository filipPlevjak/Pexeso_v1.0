package hraciaPlocha;

import java.io.BufferedWriter;
import java.io.FileWriter;
import hra.Postava;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Skore {

    public Skore(Postava postava1, Postava postava2) {
        
        
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
            buffer.write("nick : " + postava1.getMeno());
            buffer.newLine();
            buffer.write("body : " + postava1.getBody());
            buffer.newLine();
            buffer.write("Hráč 2");
            buffer.newLine();
            buffer.write("nick : " + postava2.getMeno());
            buffer.newLine();
            buffer.write("body : " + postava2.getBody());     
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