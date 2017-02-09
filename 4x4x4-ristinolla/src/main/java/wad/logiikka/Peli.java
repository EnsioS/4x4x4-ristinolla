package wad.logiikka;

/**
 *
 * @author Ensio
 */
public class Peli {

    private Pelimerkki[][][] ruudut;
    private Voittorivi[] voittorivit;

    public Peli() {
        // luodaan oikean kokoinen taulukko peliruuduille
        this.ruudut = new Pelimerkki[5][5][5];
        // luodaan oikean kokoinen taulukko voittoriveille, tässä vaiheessa vain pysty-ja vaakasuorille
        this.voittorivit = new Voittorivi[76];
    }

    public Pelimerkki[][][] getRuudut() {
        return ruudut;
    }

    public void alustaVoittorivit() {
        int laskuri = 0;

        laskuri = alustaAkselienSuuntaiset(laskuri);
        
        laskuri = alustaTasolavistajienSuuntaiset(laskuri);
        
        alustaAvaruuslavistajienSuuntaiset(laskuri);
    }

    private int alustaAkselienSuuntaiset(int laskuri) {
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
        return laskuri;
    }

    private int alustaTasolavistajienSuuntaiset(int laskuri) {
        Vektori suuntaXY = new Vektori(1, 1, 0);
        Vektori suuntaMiinusXY = new Vektori(-1, 1, 0);

        Vektori suuntaZY = new Vektori(0, 1, 1);
        Vektori suuntaMiinusZY = new Vektori(0, 1, -1);

        Vektori suuntaXZ = new Vektori(1, 0, 1);
        Vektori suuntaMiinusXZ = new Vektori(-1, 0, 1);

        for (int x = 1; x <= 4; x++) {
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(x, 1, 1), suuntaZY);
            laskuri++;

            this.voittorivit[laskuri] = new Voittorivi(new Vektori(x, 1, 4), suuntaMiinusZY);
            laskuri++;
        }

        for (int z = 1; z <= 4; z++) {
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(1, 1, z), suuntaXY);
            laskuri++;

            this.voittorivit[laskuri] = new Voittorivi(new Vektori(4, 1, z), suuntaMiinusXY);
            laskuri++;
        }

        for (int y = 1; y <= 4; y++) {
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(1, y, 1), suuntaXZ);
            laskuri++;

            this.voittorivit[laskuri] = new Voittorivi(new Vektori(4, y, 1), suuntaMiinusXZ);
            laskuri++;
        }
        return laskuri++;
    }

    private void alustaAvaruuslavistajienSuuntaiset(int laskuri) {
        this.voittorivit[laskuri] = new Voittorivi(new Vektori(1, 1, 1), new Vektori(1, 1, 1));
        laskuri++;
        this.voittorivit[laskuri] = new Voittorivi(new Vektori(4, 1, 1), new Vektori(-1, 1, 1));
        laskuri++;
        this.voittorivit[laskuri] = new Voittorivi(new Vektori(1, 1, 4), new Vektori(1, 1, -1));
        laskuri++;
        this.voittorivit[laskuri] = new Voittorivi(new Vektori(4, 1, 4), new Vektori(-1, 1, -1));
    }

    public Voittorivi[] getVoittorivit() {
        return voittorivit;
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
