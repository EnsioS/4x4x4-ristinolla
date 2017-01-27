/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.logiikka;

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
public class VektoriTest {

    public VektoriTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lisaysToimiiOikein() {
        Vektori a = new Vektori(1, 2, 3);
        Vektori b = new Vektori(-1, 0, 2);
        
        Vektori summa = a.lisaa(b);
        
        assertEquals("(0, 2, 5)", summa.toString());
    }
    
    @Test
    public void kertominenToimiiOikein() {
        Vektori vektori = new Vektori(1, 2, -4);
        
        Vektori tulo = vektori.kerro(3);
        
        assertEquals("(3, 6, -12)", tulo.toString());
    }

}
