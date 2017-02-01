package wad.kayttoliittyma;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wad.logiikka.Peli;

/**
 *
 * @author Ensio
 */
public class KomentoKayttoliittymaTest {

    ByteArrayOutputStream tulosvirta;
    KomentoKayttoliittyma kayttoliittyma;

    public KomentoKayttoliittymaTest() {
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
    public void syoteXsammuttaaKayttoliittyman() {
        String syote = "x";

        this.kayttoliittyma = new KomentoKayttoliittyma(new Scanner(syote));

        kayttoliittyma.kaynnista();
        String tulos = tulosvirta.toString();

        assertTrue("Käyttöliittymän pitäisi sammua syötteellä x", tulos.contains("Sammutetaan"));
    }

    @Test
    public void syote1aloittaaPelin() {
        String syote = muodosta("1", "lopeta", "x");

        this.kayttoliittyma = new KomentoKayttoliittyma(new Scanner(syote));

        kayttoliittyma.kaynnista();
        String tulos = tulosvirta.toString();
        assertTrue("Käyttöliittymän pitäisi aloittaa peli syöteellä 1", tulos.contains("Nyt on pelaajan RISTI vuoro."));
    }

    @Test
    public void taytaaOikeanRuudunPelatessa() {
        String syote = muodosta("3", "1", "3", "lopeta");

        this.kayttoliittyma = new KomentoKayttoliittyma(new Scanner(syote));

        kayttoliittyma.pelaaKaksinpeli();

        String oletuspelitilanne = "---- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";
        oletuspelitilanne += "--x- ---- ---- ---- \n";
        oletuspelitilanne += "---- ---- ---- ---- \n";

        assertEquals(oletuspelitilanne, kayttoliittyma.getPeli().toString());

    }

    @Test
    public void vaihtaaVuoronOnnistuneenRuudunTaytonJalkeen() {
        String syote = muodosta("3", "1", "3", "lopeta");

        this.kayttoliittyma = new KomentoKayttoliittyma(new Scanner(syote));

        kayttoliittyma.pelaaKaksinpeli();

        String tulos = tulosvirta.toString();

        assertTrue("Ilmoitus pelaajan RISTI vuorosta puuttuu", tulos.contains("Nyt on pelaajan RISTI vuoro."));
        assertTrue("Ilmoitus pelaajan NOLLA vuorosta puuttuu", tulos.contains("Nyt on pelaajan NOLLA vuoro."));

    }

    @Test
    public void pelaajaVoittaaOikein() {
        //yhdellä rivillä yhden vuoron koordinaatit
        String syote = muodosta("1", "1", "1",
                "1", "2", "1",
                "1", "1", "2",
                "1", "3", "1",
                "1", "1", "3",
                "1", "4", "1",
                "1", "1", "4");

        this.kayttoliittyma = new KomentoKayttoliittyma(new Scanner(syote));

        kayttoliittyma.pelaaKaksinpeli();

        String tulos = tulosvirta.toString();

        assertTrue("Pelaajan RISTI olisi pitänyt voittaa", tulos.contains("RISTI voitti pelin."));

    }

    private String muodosta(String... rivit) {
        String muotoillutRivit = "";
        for (String rivi : rivit) {
            muotoillutRivit += rivi + "\n";
        }
        return muotoillutRivit;
    }

}
