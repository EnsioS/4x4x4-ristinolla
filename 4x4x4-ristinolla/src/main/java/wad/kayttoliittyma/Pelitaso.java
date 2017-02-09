/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.kayttoliittyma;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Ensio
 */
public class Pelitaso extends JPanel {

    public Pelitaso() {
        super(new GridLayout(4, 4));
        luoKomponentit();
        
        setBorder(new LineBorder(Color.WHITE, 20));
    }

    private void luoKomponentit() {
        for (int x = 1; x <= 4; x++) {
            for (int z = 1; z <= 4; z++) {
//                PeliRuutu peliRuutu = new PeliRuutu();
                JButton peliRuutu = new JButton();
                peliRuutu.setBackground(Color.WHITE);
                add(peliRuutu);
            }
        }
    }

}
