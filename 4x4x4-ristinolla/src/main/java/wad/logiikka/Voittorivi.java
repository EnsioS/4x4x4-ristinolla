

package wad.logiikka;

/**
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

    public void setAloituspaikka(Vektori aloituspaikka) {
        this.aloituspaikka = aloituspaikka;
    }

    public Vektori getSuuntavektori() {
        return suuntavektori;
    }

    public void setSuuntavektori(Vektori suuntavektori) {
        this.suuntavektori = suuntavektori;
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
