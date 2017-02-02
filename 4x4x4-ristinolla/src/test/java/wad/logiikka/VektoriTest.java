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

    @Test
    public void konstruktorialustaaOliomuttujatOikein() {
        Vektori a = new Vektori(1, 1, 2);
        
        assertEquals(1, a.getX());
        assertEquals(1, a.getY());
        assertEquals(2, a.getZ());
    }
    
    @Test
    public void lisaysToimiiOikein() {
        Vektori a = new Vektori(1, 2, 3);
        Vektori b = new Vektori(-1, 1, 2);
        
        Vektori summa = a.lisaa(b);
        
        assertEquals("(0, 3, 5)", summa.toString());
    }
    
    @Test
    public void kertominenToimiiOikein() {
        Vektori vektori = new Vektori(1, 2, -4);
        
        Vektori tulo = vektori.kerro(3);
        
        assertEquals("(3, 6, -12)", tulo.toString());
    }

}
