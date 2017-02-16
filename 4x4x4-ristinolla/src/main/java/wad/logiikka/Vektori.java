package wad.logiikka;

/**
 * Luokka tarjoaa kolmiulotteisen vektorin summa-, skalaaritulo- ja
 * vertailutoiminnallisuudet.
 *
 * @author Ensio
 */
public class Vektori {

    private int x;
    private int y;
    private int z;

    /**
     * Konstruktori parametrina annetujen koordinaattien mukaisen vektorin
     * luomiseksi.
     *
     * @param x luotavan vektorin x-koordinaatti
     * @param y luotavan vektorin y-koordinaatti
     * @param z luotavan vektorin z-koordinaatti
     */
    public Vektori(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    /**
     * Metodi laskee tämän vektorin ja parametrina annettavan vektorin
     * suummavektorin.
     *
     * @param lisattava lisättävä vektori
     *
     * @return summavektori
     */
    public Vektori lisaa(Vektori lisattava) {
        return new Vektori(x + lisattava.getX(), y + lisattava.getY(), z + lisattava.getZ());
    }

    /**
     * Metodi laskee tämän vektorin ja parametrina annettavan kokonaisluvun
     * skalaaritulon.
     *
     * @param a kokonaisluku
     *
     * @return skalaaritulo
     */
    public Vektori kerro(int a) {
        return new Vektori(a * x, a * y, a * z);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final Vektori other = (Vektori) object;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.z != other.z) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
