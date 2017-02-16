package wad.kayttoliittyma;

import java.util.Scanner;
import wad.logiikka.Peli;
import wad.logiikka.Pelimerkki;

/**
 *
 * @author Ensio
 */
public class KomentoKayttoliittyma {

    private Peli peli;
    private Scanner lukija;
    private Pelimerkki voittaja;

    public KomentoKayttoliittyma() {
        this.lukija = new Scanner(System.in);
    }

    public KomentoKayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
    }

    public void kaynnista() {
        boolean sammuta = false;

        System.out.println("Tervetuloa");
        System.out.println("-------------");

        while (!sammuta) {
            System.out.println("Mitä tehdään?");
            System.out.println("[1] Pelaa kaksinpeli");
            System.out.println("[x] Sammuta");
            String syote = lukija.nextLine();
            
            if (syote.equals("1")) {
                pelaaKaksinpeli();
            } else if (syote.equals("x")) {
                System.out.println("Sammutetaan");
                break;
            } else {
                System.out.println("Et antanut kunnollista syötettä");
            }

        }

    }

    public void pelaaKaksinpeli() {
        this.peli = new Peli();

        peli.alustaVoittorivit();
        
        String syote = "";

        while (!syote.equals("lopeta")) {
            System.out.println("\n Pelitilanne \n");
            System.out.println(peli.toString());
            System.out.println("Nyt on pelaajan " + peli.getVuoro() + " vuoro.");
            System.out.println("Syote lopeta lopettaa pelin.");
            int xKordinaatti = lueKoordinaatti("Anna x-koordinaatti: ");
            if (xKordinaatti < 0) {
                syote = "lopeta";
                continue;
            }

            int yKordinaatti = lueKoordinaatti("Anna y-koordinaatti: ");
            if (yKordinaatti < 0) {
                syote = "lopeta";
                continue;
            }
            int zKordinaatti = lueKoordinaatti("Anna z-koordinaatti: ");
            if (zKordinaatti < 0) {
                syote = "lopeta";
                continue;
            }
            boolean vaihdetaanko = peli.taytaRuutu(xKordinaatti, yKordinaatti, zKordinaatti);
            if (vaihdetaanko) {
                this.peli.vaihdaVuoro();
            }

            if (peli.pelinVoittaja() != null) {
                System.out.println("\n" + peli.pelinVoittaja().toString() + " voitti pelin.\n");
                System.out.println(peli);
                break;
            }
        }
    }

    private int lueKoordinaatti(String pyynto) {
        int koordinaatti = -1;
        boolean eiLoytynyt = true;

        while (eiLoytynyt) {
            System.out.print(pyynto);
            String syote = lukija.nextLine();

            try {
                koordinaatti = Integer.parseInt(syote);
                if (koordinaatti < 1 || koordinaatti > 4) {
                    System.out.println("Koordinaatin täytyy olla 1, 2, 3 tai 4.");
                } else {
                    eiLoytynyt = false;
                }
            } catch (Exception e) {
                if (syote.equals("lopeta")) {
                    return -1;
                }
                System.out.println("Et syöttänyt lukua");
            }
        }

        return koordinaatti;
    }
    
    public Peli getPeli() {
        return this.peli;
    }
}
