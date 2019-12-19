package hra;

public class Hrac {
    private String meno;
    private int body;

    public Hrac(String paMeno) {
        this.meno = paMeno;
        this.body = 0;
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

    public void setBody(int paBody) {
        this.body = this.body + paBody;
    }  
}
