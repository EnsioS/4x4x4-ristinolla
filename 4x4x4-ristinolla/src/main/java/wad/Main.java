package wad;

import javax.swing.SwingUtilities;
import wad.kayttoliittyma.GraafinenKayttoliittyma;
import wad.kayttoliittyma.KomentoKayttoliittyma;
import wad.logiikka.Peli;
import wad.logiikka.Pelimerkki;

/**
 * 
 * @author Ensio
 */
public class Main {

    public static void main(String[] args) {

//        KomentoKayttoliittyma kayttoliittyma = new KomentoKayttoliittyma();
//        kayttoliittyma.kaynnista();

        GraafinenKayttoliittyma kayttoliittyma = new GraafinenKayttoliittyma();
        
        SwingUtilities.invokeLater(kayttoliittyma);
    }

}
