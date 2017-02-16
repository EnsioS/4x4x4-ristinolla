/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.logiikka;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ensio
 */
public class PeliTest {

    private Peli peli;

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.peli = new Peli();
        peli.alustaVoittorivit();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ruudutTyhjiaPelinAlussa() {

        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= 4; y++) {
                for (int z = 1; z <= 4; z++) {

                    assertEquals(null, peli.getRuudut()[x][y][z]);

                }
            }
        }
        String oletuspelitilanne = "---- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";

        assertEquals(oletuspelitilanne, peli.toString());
    }

    @Test
    public void tayttaaTyhjanRuudunOikeinMetodillaTaytaRuutu() {
        peli.taytaRuutu(3, 1, 3);

        String oletuspelitilanne = "---- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";
        oletuspelitilanne += "--x- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";

        assertEquals(oletuspelitilanne, peli.toString());
        assertEquals(Pelimerkki.RISTI, peli.getRuudut()[3][1][3]);
    }

    @Test
    public void eiTaytaJoTaytettyaRuutuaMetodillaTaytaRuutu() {
        peli.taytaRuutu(3, 1, 3);
        peli.vaihdaVuoro();
        peli.taytaRuutu(3, 1, 3);

        String oletuspelitilanne = "---- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";
        oletuspelitilanne += "--x- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";

        assertEquals(oletuspelitilanne, peli.toString());
    }

    @Test
    public void yritysTayttaaOlematonRuutuMetodillaTaytaRuutuEiMuutaPeliTilannetta() {
        peli.taytaRuutu(0, 0, 7);

        String oletuspelitilanne = "---- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";

        assertEquals(oletuspelitilanne, peli.toString());
    }
    
    @Test
    public void pelinVoittajaPalauttaaVoittajanJosVoittoriviTaysi() {
        
        assertFalse("Tässä tilanteessa metodin pelinVoittaja pitäisi palauttaa null", peli.pelinVoittaja() != null);
        
        for (int x = 1; x <= 4; x++) {
            peli.taytaRuutu(x, 1, 1);
        }
                
        assertEquals("RISTI", peli.pelinVoittaja().toString());
        
        Peli uusi = new Peli();
        uusi.alustaVoittorivit();
        
        assertFalse("Tässä tilanteessa metodin pelinVoittaja pitäisi palauttaa null", uusi.pelinVoittaja() != null);
        
        uusi.vaihdaVuoro();
        for (int x = 1; x <= 4; x++) {
            uusi.taytaRuutu(x, 1, 1);
        }
        
        assertEquals("NOLLA", uusi.pelinVoittaja().toString());
    }
}
