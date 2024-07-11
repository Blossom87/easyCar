package afpafr.afpacom;

import java.time.LocalDate;

public class Velo extends Vehicle {

    private char s;
    private char m;
    private char l;

    public Velo(char s, char m, char l, String brand, String modele, String color, LocalDate acquisition,
            int pricePerDay) {

        super(brand, modele, color, acquisition, pricePerDay);
        this.s = s;
        this.m = m;
        this.l = l;
    }

    public char getS() {
        return s;
    }

    public void setS(char s) {
        this.s = s;
    }

    public char getM() {
        return m;
    }

    public void setM(char m) {
        this.m = m;
    }

    public char getL() {
        return l;
    }

    public void setL(char l) {
        this.l = l;
    }

    @Override

    public String toString() {

        return "Détails du véhicule loué : "
                + "\n Taille du vélo : " + getS()
                + "\n Taille du vélo : " + getM()
                + "\n Tailel du vélo : " + getL()
                + "\n";
    }

}