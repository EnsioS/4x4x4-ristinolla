package wad;

import wad.logiikka.Peli;

/**
 *
 * @author Ensio
 */
public class Main {

    public static void main(String[] args) {
        Peli peli = new Peli();
        
        peli.pelaaUusi();
        
        System.out.println(peli);               
    }
    
}
