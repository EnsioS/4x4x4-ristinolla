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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Ensio
 */
public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(350, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
//        container.add(new Piirtoalusta());
//        
//        JButton nappi = new JButton();
//        nappi.setBackground(Color.WHITE);
//        container.add(nappi);
        GridLayout layout = new GridLayout(4, 1);
        container.setLayout(layout);
        container.setBackground(Color.WHITE);

        for (int y = 1; y <= 4; y++) {
            Pelitaso taso = new Pelitaso();
            container.add(taso);

        }
    }

}
