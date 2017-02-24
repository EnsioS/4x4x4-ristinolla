package wad.logiikka;

/**
 * Luokka pelin voittorivien alustamiseen.
 *
 * @author ensio
 */
public class VoittoriviGeneraattori {

    private Voittorivi[] voittorivit;

    /**
     * Konstruktori oliomuuttujan alustamiseen.
     */
    public VoittoriviGeneraattori() {
        this.voittorivit = new Voittorivi[76];
    }

    public Voittorivi[] getVoittorivit() {
        return this.voittorivit;
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
        //lisätään yz- ja -yz-suuntiset voittorivit
        for (int x = 1; x <= 4; x++) {
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(x, 1, 1), new Vektori(0, 1, 1));
            laskuri++;
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(x, 1, 4), new Vektori(0, 1, -1));
            laskuri++;
        }

        //lisätään xy- ja -xy-suuntiset voittorivit
        for (int z = 1; z <= 4; z++) {
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(1, 1, z), new Vektori(1, 1, 0));
            laskuri++;
            this.voittorivit[laskuri] = new Voittorivi(new Vektori(4, 1, z), new Vektori(-1, 1, 0));
            laskuri++;
        }

        //lisätään xz- ja -xz-suuntiset voittorivit
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

}
