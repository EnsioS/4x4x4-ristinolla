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
public class VoittoriviTest {

    @Test
    public void konstruktoriAlustaaOliomuuttujatOikein() {
        Voittorivi rivi = new Voittorivi(new Vektori(1, 1, 1), new Vektori(0, 1, 0));
        
        assertEquals("(0, 1, 0)", rivi.getSuuntavektori().toString());
        assertEquals("(1, 1, 1)", rivi.getAloituspaikka().toString());
        assertEquals(0, rivi.getNollia());
        assertEquals(0, rivi.getRisteja());
    }
    
    @Test
    public void voittoriviTietaaSisaltavansaRuutunsa() {
        Voittorivi rivi = new Voittorivi(new Vektori(1, 1, 1), new Vektori(1, 0, 0));

        assertTrue("Voittorivin tulisi sisältää ruutu (1, 1, 1)", rivi.sisaltaa(new Vektori(1, 1, 1)));
        assertTrue("Voittorivin tulisi sisältää ruutu (2, 1, 1)", rivi.sisaltaa(new Vektori(2, 1, 1)));
        assertTrue("Voittorivin tulisi sisältää ruutu (3, 1, 1)", rivi.sisaltaa(new Vektori(3, 1, 1)));
        assertTrue("Voittorivin tulisi sisältää ruutu (4, 1, 1)", rivi.sisaltaa(new Vektori(4, 1, 1)));
    }

    @Test
    public void voittoriviEiLuuleSisaltavansaVaaraaRuutua() {
        Voittorivi rivi = new Voittorivi(new Vektori(1, 1, 1), new Vektori(1, 0, 0));

        assertFalse("Voittorivin ei kuulu sisältää ruutua (1, 2, 1)", rivi.sisaltaa(new Vektori(1, 2, 1)));
    }

    @Test
    public void toStringTulostusOikea() {
        Voittorivi rivi = new Voittorivi(new Vektori(1, 1, 1), new Vektori(0, 1, 0));

        String oletus = "Aloituspaikka: (1, 1, 1)\n"
                + "Suuntavektori: (0, 1, 0)\n"
                + "Ristejä: 0" + "\n" + "Nollia: 0";

        assertEquals(oletus, rivi.toString());
    }
}
