/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.kayttoliittyma;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import wad.logiikka.Peli;
import wad.logiikka.Vektori;

/**
 *
 * @author Ensio
 */
public class Pelitaso extends JPanel {

    private int y;
    private Peli peli;
    private JLabel teksti;
    
    public Pelitaso(int y, Peli peli, JLabel teksti) {
        super(new GridLayout(4, 4));
        this.y = y;
        this.peli = peli;
        this.teksti = teksti;
        
        luoKomponentit();
        
        setBorder(new LineBorder(Color.WHITE, 20));
    }

    private void luoKomponentit() {
        for (int z = 1; z <= 4; z++) {
            for (int x = 1; x <= 4; x++) {
                PeliRuutu peliRuutu = new PeliRuutu(new Vektori(x, y, z));
//                JButton peliRuutu = new JButton();
                RuudunTayttaja tayttaja = new RuudunTayttaja(peliRuutu, peli, teksti);
                peliRuutu.addActionListener(tayttaja);
                
                peliRuutu.setBackground(Color.WHITE);
                add(peliRuutu);
            }
        }
    }

}
