/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import wad.logiikka.Peli;
import wad.logiikka.Pelimerkki;
import wad.logiikka.Vektori;

/**
 *
 * @author Ensio
 */
public class RuudunTayttaja implements ActionListener {

    private PeliRuutu ruutu;
    private Peli peli;
    private JLabel teksti;

    public RuudunTayttaja(PeliRuutu ruutu, Peli peli, JLabel teksti) {
        this.ruutu = ruutu;
        this.peli = peli;
        this.teksti = teksti;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (this.peli.getVuoro() == Pelimerkki.NOLLA) {
            this.ruutu.setText("0");
        } else if (this.peli.getVuoro() == Pelimerkki.RISTI) {
            this.ruutu.setText("X");
        }

        int x = ruutu.getPaikka().getX();
        int y = ruutu.getPaikka().getY();
        int z = ruutu.getPaikka().getZ();

        this.peli.taytaRuutu(x, y, z);
        this.peli.vaihdaVuoro();

        this.teksti.setText("Pelaajan " + this.peli.getVuoro() + " vuoro");

        System.out.println(peli.toString());
//        this.ruutu.setText("<html><font color = red>X</font></html>");
        this.ruutu.setEnabled(false);

        if (this.peli.pelinVoittaja() != null) {
            System.out.println(this.peli.pelinVoittaja().toString() + " voitti pelin");
            this.teksti.setText(this.peli.pelinVoittaja().toString() + " voitti pelin");
        }
    }
}
