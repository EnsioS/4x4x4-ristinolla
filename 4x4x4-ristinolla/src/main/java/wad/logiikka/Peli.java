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
     * Metodi voittorivien alustamiseen.
     */
    public void alustaVoittorivit() {
        VoittoriviGeneraattori generaattori = new VoittoriviGeneraattori();
        generaattori.alustaVoittorivit();
        
        this.voittorivit = generaattori.getVoittorivit();
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
