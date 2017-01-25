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
    private Random random;

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
        this.random = new Random();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void alustaRuudutAlustaaSatunnaisenRuudunOikein() {
        this.peli.alustaRuudut();

        int randomX = random.nextInt(4) + 1;
        int randomY = random.nextInt(4) + 1;
        int randomZ = random.nextInt(4) + 1;

        System.out.println("(" + randomX + ", " + randomY + ", " + randomZ + ") randomeina");

        Ruutu randomRuutu = this.peli.getRuudut()[randomX][randomY][randomZ];

        assertEquals(randomX, randomRuutu.getX());
        assertEquals(randomY, randomRuutu.getY());
        assertEquals(randomZ, randomRuutu.getZ());

        assertEquals(Ruudussa.TYHJA, randomRuutu.getSisalto());
    }

}
