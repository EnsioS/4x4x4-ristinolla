package wad.logiikka;

/**
 * Luokka talettaa pelin mahdollisen voittorivin tiedot.
 *
 * @author Ensio
 */
public class Voittorivi {

    private Vektori aloituspaikka;
    private Vektori suuntavektori;
    private int risteja;
    private int nollia;

    public Voittorivi(Vektori aloituspaikka, Vektori suuntavektori) {
        this.aloituspaikka = aloituspaikka;
        this.suuntavektori = suuntavektori;
        this.risteja = 0;
        this.nollia = 0;
    }

    public Vektori getAloituspaikka() {
        return aloituspaikka;
    }

    public Vektori getSuuntavektori() {
        return suuntavektori;
    }

    public int getRisteja() {
        return risteja;
    }

    public void setRisteja(int risteja) {
        this.risteja = risteja;
    }

    public int getNollia() {
        return nollia;
    }

    public void setNollia(int nollia) {
        this.nollia = nollia;
    }

    /**
     * Metodi kertoo kuuluuko tietty paikka tähän voittoriviin.
     *
     * @param paikkavektori paikka
     *
     * @return kuuluuko paikka tähän voittoriviin
     */
    public boolean sisaltaa(Vektori paikkavektori) {
        for (int i = 0; i < 4; i++) {
            Vektori rivinRuutu = this.aloituspaikka.lisaa(this.suuntavektori.kerro(i));

            if (paikkavektori.equals(rivinRuutu)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String tulos = "Aloituspaikka: " + aloituspaikka.toString() + "\n";
        tulos += "Suuntavektori: " + suuntavektori.toString() + "\n";
        tulos += "Ristejä: " + risteja + "\n";
        tulos += "Nollia: " + nollia;

        return tulos;
    }
}
