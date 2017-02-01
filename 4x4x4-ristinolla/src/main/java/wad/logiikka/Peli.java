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

    public void alustaVoittorivit() {
        int laskuri = 0;

        Vektori suuntaX = new Vektori(1, 0, 0);
        Vektori suuntaY = new Vektori(0, 1, 0);
        Vektori suuntaZ = new Vektori(0, 0, 1);

        //lisätään x-suuntaiset voittorivit
        for (int y = 1; y <= 4; y++) {
            for (int z = 1; z <= 4; z++) {
                this.voittorivit[laskuri] = new Voittorivi(new Vektori(1, y, z), suuntaX);
                laskuri++;
            }
        }

        for (int x = 1; x <= 4; x++) {
            //lisätään y-suuntaiset voittorivit
            for (int z = 1; z <= 4; z++) {
                this.voittorivit[laskuri] = new Voittorivi(new Vektori(x, 1, z), suuntaY);
                laskuri++;
            }

            //lisätään z-suuntaiset voittorivit
            for (int y = 1; y <= 4; y++) {
                this.voittorivit[laskuri] = new Voittorivi(new Vektori(x, y, 1), suuntaZ);
                laskuri++;
            }

        }
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
        kirjaaMerkkiVoittoriveihin(x, y, z, merkki);
        return true;
    }

    public void kirjaaMerkkiVoittoriveihin(int x, int y, int z, Pelimerkki merkki) {
        for (Voittorivi rivi : this.voittorivit) {
            if (rivi.sisaltaa(new Vektori(x, y, z))) {
                if (merkki == Pelimerkki.NOLLA) {
                    rivi.setNollia(rivi.getNollia() + 1);
                } else {
                    rivi.setRisteja(rivi.getRisteja() + 1);
                }
            }
        }
    }

    public Pelimerkki pelinVoittaja() {

        for (Voittorivi rivi : this.voittorivit) {

            if (rivi.getNollia() == 4) {
                return Pelimerkki.NOLLA;
            }

            if (rivi.getRisteja() == 4) {
                return Pelimerkki.RISTI;
            }
        }

        return null;
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
