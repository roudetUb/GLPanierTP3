/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.paniertp3.controler;

import fr.ufrsciencestech.paniertp3.model.Orange;
import fr.ufrsciencestech.paniertp3.view.*;
import fr.ufrsciencestech.paniertp3.model.Panier;
import fr.ufrsciencestech.paniertp3.model.PanierPleinException;
import fr.ufrsciencestech.paniertp3.model.PanierVideException;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author celine
 */
public class Controleur implements ActionListener {
    private Panier p;
    private VueG vg;
    
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        if(((Component)e.getSource()).getName().equals("Plus")) 
        {
            try {
                p.ajout(new Orange(0.5, "Espagne"));
            } catch (PanierPleinException ex) {
            }
        }
        else
            try {
                p.retrait(); 
            } catch (PanierVideException ex) {
        }
            
    }
    public void setPanier(Panier p){
        this.p = p;
    }
    public void setVue(VueG vg){
        this.vg = vg;
    }
}
