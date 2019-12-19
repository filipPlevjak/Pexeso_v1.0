package hra;

public class Postava {
    private String meno;
    private int body;

    public Postava(String paMeno, int paBody) {
        this.meno = paMeno;
        this.body = paBody;
    }

    public void pridelBody(){
    }

    public String getMeno() {
        return meno;
    }
    
    public void setMeno(String meno) {
        this.meno = meno;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }  
}