package org.htw.prog2.aufgabe0;

public class TestRechnung {
    public static void main(String[] args) {
        double S = 10;
        double X = 3;
        double W;
        double maxerror;
        double e;

        for (int n=0;n<10;n++){
            W = 0.5 * (X + (S/X));
            X = W;
            System.out.println(W);
        }
    }


}
