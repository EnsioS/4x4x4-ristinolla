package wad;

import wad.logiikka.Peli;

/**
 *
 * @author Ensio
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Peli peli = new Peli();
        
        peli.alustaRuudut();
        
        peli.getRuudut()[2][3][3].getX();
        
        peli.kaynnista();
    }
    
}
