/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.paniertp3.view;

import fr.ufrsciencestech.paniertp3.controler.Controleur;
import fr.ufrsciencestech.paniertp3.model.Panier;
import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author celine
 */
public class VueGraphSwing extends JFrame implements VueG{
    private JButton inc;
    private JButton dec;
    private JLabel affiche;
    
    public VueGraphSwing(){
        super ("CompteurSwing");
        inc = new JButton("+");
        dec = new JButton("-");
        affiche = new JLabel("0", JLabel.CENTER);
        add(inc, BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
        
        inc.setName("Plus");
        dec.setName("Moins");
        affiche.setName("Affichage");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addControleur(Controleur c){
        getInc().addActionListener(c);
        getDec().addActionListener(c);
    }
    
    @Override
    public void update(Observable m, Object o) {
        Panier p = (Panier) m;
        getAffiche().setText(((Integer)p.getFruits().size()).toString());
    }

    /**
     * @return the inc
     */
    public JButton getInc() {
        return inc;
    }

    /**
     * @param inc the inc to set
     */
    public void setInc(JButton inc) {
        this.inc = inc;
    }

    /**
     * @return the dec
     */
    public JButton getDec() {
        return dec;
    }

    /**
     * @param dec the dec to set
     */
    public void setDec(JButton dec) {
        this.dec = dec;
    }

    /**
     * @return the affiche
     */
    public JLabel getAffiche() {
        return affiche;
    }

    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(JLabel affiche) {
        this.affiche = affiche;
    }
}
