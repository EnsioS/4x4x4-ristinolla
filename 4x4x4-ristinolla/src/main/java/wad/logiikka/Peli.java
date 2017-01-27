package wad.logiikka;

import java.util.Scanner;

/**
 *
 * @author Ensio
 */
public class Peli {

    private Pelimerkki[][][] ruudut;
    private Voittorivi[] voittorivit;
    private Scanner lukija;

    public Peli() {
        // luodaan oikean kokoinen taulukko peliruuduille
        this.ruudut = new Pelimerkki[5][5][5];
        // luodaan oikean kokoinen taulukko voittoriveille, tässä vaiheessa vain pysty-ja vaakasuorille
        this.voittorivit = new Voittorivi[48];
        this.lukija = new Scanner(System.in);
    }

    public Peli(Scanner lukija) {
        // luodaan oikean kokoinen taulukko peliruuduille
        this.ruudut = new Pelimerkki[5][5][5];
        // luodaan oikean kokoinen taulukko voittoriveille, tässä vaiheessa vain pysty-ja vaakasuorille
        this.voittorivit = new Voittorivi[48];
        this.lukija = lukija;
    }

    public Pelimerkki[][][] getRuudut() {
        return ruudut;
    }

    public void setRuudut(Pelimerkki[][][] ruudut) {
        this.ruudut = ruudut;
    }

    public void pelaaUusi() {
        String syote = "";
        Pelimerkki pelaaja = Pelimerkki.RISTI;

        while (!syote.equals("lopeta")) {
            System.out.println("\n Pelitilanne \n");
            System.out.println(this.toString());
            System.out.println("Nyt on pelaajan " + pelaaja + " vuoro.");
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
            boolean vaihdetaanko = this.taytaRuutu(xKordinaatti, yKordinaatti, zKordinaatti, pelaaja);
            if (vaihdetaanko) {
                pelaaja = this.vaihdaVuoro(pelaaja);
            }
        }
    }

    private Pelimerkki vaihdaVuoro(Pelimerkki edellinen) {
        if (edellinen == Pelimerkki.NOLLA) {
            return Pelimerkki.RISTI;
        }
        return Pelimerkki.NOLLA;
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

    public Voittorivi[] getVoittorivit() {
        return voittorivit;
    }

    public void setVoittorivit(Voittorivi[] voittorivit) {
        this.voittorivit = voittorivit;
    }

    public boolean taytaRuutu(int x, int y, int z, Pelimerkki merkki) {
        if (x < 0 || x > 4 || y < 0 || y > 4 || z < 0 || z > 4) {
            System.out.println("Yritettiin täyttää ruutu, jota ei ole");
            return false;
        }

        if (ruudut[x][y][z] != null) {
            System.out.println("Ruutu " + new Vektori(x, y, z).toString() + " ei ole vapaa");
            return false;
        }

        ruudut[x][y][z] = merkki;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder tulos = new StringBuilder();

        for (int z = 1; z <= 4; z++) {
            for (int y = 1; y <= 4; y++) {
                for (int x = 1; x <= 4; x++) {
                    if (ruudut[x][y][z] == null) {
                        tulos.append("-");
                    } else if (ruudut[x][y][z] == Pelimerkki.NOLLA) {
                        tulos.append("o");
                    } else if (ruudut[x][y][z] == Pelimerkki.RISTI) {
                        tulos.append("x");
                    }

                }
                tulos.append(" ");
            }
            tulos.append("\n");
        }

        return tulos.toString();
    }

}
