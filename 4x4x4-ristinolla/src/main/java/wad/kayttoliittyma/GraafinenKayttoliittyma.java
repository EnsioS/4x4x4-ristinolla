/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import wad.logiikka.Peli;

/**
 *
 * @author Ensio
 */
public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli peli;

    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(500, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.peli = new Peli();
        this.peli.alustaVoittorivit();

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(5, 1);
        container.setLayout(layout);
        container.setBackground(Color.WHITE);

        JLabel vuoroTeksti = new JLabel("Pelaajan " + this.peli.getVuoro() + " vuoro");
        vuoroTeksti.setHorizontalAlignment(SwingConstants.CENTER);
        
        //epätyypillinen läpikäymisjärjestys tason y = 1 alas saamiseksi
        for (int y = 4; y >= 1; y--) {
            Pelitaso taso = new Pelitaso(y, peli, vuoroTeksti);
            container.add(taso);

        }
        
        container.add(vuoroTeksti);
    }

}
