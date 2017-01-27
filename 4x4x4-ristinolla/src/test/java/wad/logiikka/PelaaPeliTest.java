package wad.logiikka;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
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
public class PelaaPeliTest {

    ByteArrayOutputStream tulosvirta;
    private Peli peli;

    public PelaaPeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tulosvirta = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tulosvirta));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void taytaaOikeanRuudunPelatessa() {
        String syote = muodosta("3", "1", "3", "lopeta");

        this.peli = new Peli(new Scanner(syote));

        peli.pelaaUusi();

        String oletuspelitilanne = "---- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";
        oletuspelitilanne += "--x- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";

        assertEquals(oletuspelitilanne, peli.toString());

    }

    @Test
    public void vaihtaaVuoronOnnistuneenRuudunTaytonJalkeen() {
        String syote = muodosta("3", "1", "3", "lopeta");

        this.peli = new Peli(new Scanner(syote));

        peli.pelaaUusi();

        String tulos = tulosvirta.toString();
        
        assertTrue("Ilmoitus pelaajan RISTI vuorosta puuttuu", tulos.contains("Nyt on pelaajan RISTI vuoro."));
        assertTrue("Ilmoitus pelaajan NOLLA vuorosta puuttuu", tulos.contains("Nyt on pelaajan NOLLA vuoro."));

    }

    private String muodosta(String... rivit) {
        String muotoillutRivit = "";
        for (String rivi : rivit) {
            muotoillutRivit += rivi + "\n";
        }
        return muotoillutRivit;
    }
}
