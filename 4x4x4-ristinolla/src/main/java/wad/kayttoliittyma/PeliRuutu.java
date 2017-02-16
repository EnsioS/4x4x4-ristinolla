/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import javax.swing.Action;
import javax.swing.JButton;
import wad.logiikka.Vektori;

/**
 *
 * @author Ensio
 */
public class PeliRuutu extends JButton {

    private Vektori paikka;

    public PeliRuutu(Vektori paikka) {
        this.paikka = paikka;
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        
        this.setForeground(Color.red);
    }
    
    public Vektori getPaikka() {
        return this.paikka;
    }
    
//    private Shape muoto = ruudunMuoto();
//    
//    @Override
//    public void paintBorder(Graphics g) {
//        ((Graphics2D) g).draw(muoto);
//    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        ((Graphics2D) g).fill(muoto);
//    }
//
//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(20, 10);
//    }
//
//    @Override
//    public boolean contains(int x, int y) {
//        return muoto.contains(x, y);
//    }
//
//    private Shape ruudunMuoto() {
//        Polygon muoto = new Polygon();
//        muoto.addPoint(0, 10);
//        muoto.addPoint(16, 10);
//        muoto.addPoint(19, 0);
//        muoto.addPoint(3, 0);
//
//        return muoto;
//    }
}
