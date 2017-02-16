package wad.logiikka;

/**
 * Luokka luo pelin ja pitää yllä sen pelitilannetta.
 *
 * @author Ensio
 */
public class Peli {

    private Pelimerkki[][][] ruudut;
    private Voittorivi[] voittorivit;
    private Pelimerkki vuoro;

    /**
     * Konstruktori oliomuuttujien alustamiseen.
     */
    public Peli() {
        this.ruudut = new Pelimerkki[5][5][5];
        this.voittorivit = new Voittorivi[76];
        this.vuoro = Pelimerkki.RISTI;
    }

    public Pelimerkki[][][] getRuudut() {
        return ruudut;
    }

    public Pelimerkki getVuoro() {
        return this.vuoro;
    }

    /**
     * Metodi pelivuoron vaihtamiseen.
     */
    public void vaihdaVuoro() {
        this.vuoro = (this.vuoro == Pelimerkki.RISTI) ? Pelimerkki.NOLLA : Pelimerkki.RISTI;
    }

    /**
     * Metodi alustaa kaikki mahdolliset pelin voittorivit.
     */
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
        for (int x = 1; x <= 4; x++) {
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(x, 1, 1), new Vektori(0, 1, 1));
            laskuri++;
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(x, 1, 4), new Vektori(0, 1, -1));
            laskuri++;
        }
        
        for (int z = 1; z <= 4; z++) {
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(1, 1, z), new Vektori(1, 1, 0));
            laskuri++;
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(4, 1, z), new Vektori(-1, 1, 0));
            laskuri++;
        }
        for (int y = 1; y <= 4; y++) {
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(1, y, 1), new Vektori(1, 0, 1));
            laskuri++;
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(4, y, 1), new Vektori(-1, 0, 1));
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

    /**
     * Metodi yrittää täyttää parametreissa pyydettävän ruudun vuorossa olevan
     * pelaajan merkillä.
     *
     * @param x täytettävän ruudun x-koordinaatti
     * @param y täytettävän ruudun y-koordinaatti
     * @param z täytettävän ruudun z-koordinaatti
     *
     * @return onnistuiko ruudun tÃ¤yttÃ¤minen
     */
    public boolean taytaRuutu(int x, int y, int z) {
        if (x < 0 || x > 4 || y < 0 || y > 4 || z < 0 || z > 4) {
            System.out.println("Yritettiin täyttää ruutu, jota ei ole");
            return false;
        }

        if (ruudut[x][y][z] != null) {
            System.out.println("Ruutu " + new Vektori(x, y, z).toString() + " ei ole vapaa");
            return false;
        }

        ruudut[x][y][z] = this.vuoro;
        kirjaaMerkkiVoittoriveihin(x, y, z);
        return true;
    }

    /**
     * Metodi kirjaa tiedon täytetystä ruudusta voittoriveihin.
     *
     * @param x kirjattavan ruudun x-koordinaatti
     * @param y kirjattavan ruudun y-koordinaatti
     * @param z kirjattavan ruudun z-koordinaatti
     */
    public void kirjaaMerkkiVoittoriveihin(int x, int y, int z) {
        for (Voittorivi rivi : this.voittorivit) {
            if (rivi.sisaltaa(new Vektori(x, y, z))) {
                if (this.vuoro == Pelimerkki.NOLLA) {
                    rivi.setNollia(rivi.getNollia() + 1);
                } else {
                    rivi.setRisteja(rivi.getRisteja() + 1);
                }
            }
        }
    }

    /**
     * Metodi kertoo onko pelillä voittaja ja jos on niin kuka.
     *
     * @return palauttaa pelin voittajan, jos pelillä on voittaja
     */
    public Pelimerkki pelinVoittaja() {
        for (Voittorivi rivi : this.voittorivit) {
            if (rivi.getNollia() == 4) {
                return Pelimerkki.NOLLA;
            } else if (rivi.getRisteja() == 4) {
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
