package wad.logiikka;

/**
 *
 * @author Ensio
 */
public class Peli {
    
    private Ruutu[][][] ruudut;
    private Voittorivi[] voittorivit;

    public Peli() {
        // luodaan oikean kokoinen taulukko peliruuduille
        this.ruudut = new Ruutu[5][5][5];
        // luodaan oikean kokoinen taulukko voittoriveille, tässä vaiheessa vain pysty-ja vaakasuorille
        this.voittorivit = new Voittorivi[48];
    }
    
    public void alusta() {
        this.alustaRuudut();
        this.alustaVoittorivit();
    }
    
    public void alustaRuudut() {
        
        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= 4; y++) {
                for (int z = 1; z <= 4; z++) {
                    Ruutu peliRuutu = new Ruutu(x, y, z);
                    this.ruudut[x][y][z] = peliRuutu;
                }
            }
        }
    }
    
    public void alustaVoittorivit() {
        
    }
    
    public void kaynnista() {
        
    }
    
    public void pelaa() {
        
    }

    public Ruutu[][][] getRuudut() {
        return ruudut;
    }

    public void setRuudut(Ruutu[][][] ruudut) {
        this.ruudut = ruudut;
    }

    public Voittorivi[] getVoittorivit() {
        return voittorivit;
    }

    public void setVoittorivit(Voittorivi[] voittorivit) {
        this.voittorivit = voittorivit;
    }
    
    
}
