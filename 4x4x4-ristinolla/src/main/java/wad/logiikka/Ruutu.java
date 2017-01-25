package wad.logiikka;

import static wad.logiikka.Ruudussa.TYHJA;

/**
 *
 * @author Ensio
 */
public class Ruutu {
    
    private int x;
    private int y;
    private int z;

    private Ruudussa sisalto;

    public Ruutu(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.sisalto = TYHJA;
    }

    
    
    public Ruudussa getSisalto() {
        return sisalto;
    }

    public void setSisalto(Ruudussa sisalto) {
        this.sisalto = sisalto;
    }
   
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    
    
}
