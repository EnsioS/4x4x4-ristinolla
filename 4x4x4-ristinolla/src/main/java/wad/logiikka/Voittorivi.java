

package wad.logiikka;

/**
 *
 * @author Ensio
 */
public class Voittorivi {
    
    private Ruutu[] voittorivi;
    private boolean voiSaadaViela;
    private int ruutujaSaatuna;
    private Ruudussa omistaja;
    
    public Ruutu[] getVoittorivi() {
        return voittorivi;
    }

    public void setVoittorivi(Ruutu[] voittorivi) {
        this.voittorivi = voittorivi;
    }

    public boolean isVoiSaadaViela() {
        return voiSaadaViela;
    }

    public void setVoiSaadaViela(boolean voiSaadaViela) {
        this.voiSaadaViela = voiSaadaViela;
    }

    public int getRuutujaSaatuna() {
        return ruutujaSaatuna;
    }

    public void setRuutujaSaatuna(int ruutujaSaatuna) {
        this.ruutujaSaatuna = ruutujaSaatuna;
    }

    public Ruudussa getOmistaja() {
        return omistaja;
    }

    public void setOmistaja(Ruudussa omistaja) {
        this.omistaja = omistaja;
    }
    
    
}
