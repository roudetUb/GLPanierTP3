/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.paniertp3.controler;

import fr.ufrsciencestech.paniertp3.model.Orange;
import fr.ufrsciencestech.paniertp3.view.VueGraphSwing;
import fr.ufrsciencestech.paniertp3.model.Panier;
import fr.ufrsciencestech.paniertp3.model.PanierPleinException;
import java.awt.event.ActionEvent;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class ControleurTest {
    Controleur c1;
    Controleur c2;
    Panier p, p4;
    VueGraphSwing vueg;
    ActionEvent einc;
    ActionEvent edec;

    public ControleurTest() {
    }
    
    @Before
    public void setUp(){
        c1 = new Controleur();
        c2 = new Controleur();
        p = new Panier(2);
        p4 = new Panier(4);
        vueg = new VueGraphSwing(); 
        c1.setPanier(p);
        
        edec = new ActionEvent(vueg.getDec(), 1, "dec");
        einc = new ActionEvent(vueg.getInc(), 0, "inc");
    }

    /**
     * Test of actionPerformed method, of class Controleur.
     */
    @Test   //ignore pour fonctionner dans Jenkins
    public void testActionPerformed() {
        System.out.println("actionPerformed");

        assertTrue(p.estVide());
        c1.actionPerformed(einc);
        assertTrue(p.getTaillePanier()==1);

        c1.actionPerformed(edec);
        assertTrue(p.estVide());
    }
    
    /**
     * Test of actionPerformed method, of class Controleur.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test   //ignore pour fonctionner dans Jenkins
    public void testActionPerformedPlein() throws PanierPleinException {
        System.out.println("actionPerformedPlein");
        
        p.ajout(new Orange(0.5, "Espagne"));
        p.ajout(new Orange(0.5, "Espagne"));
        assertTrue(p.getTaillePanier() == 2);
        c1.actionPerformed(einc);
        assertTrue(p.getTaillePanier() == 2);
    }
    
    /**
     * Test of actionPerformed method, of class Controleur.
     */
    @Test  //ignore pour fonctionner dans Jenkins
    public void testActionPerformedVide() {
        System.out.println("actionPerformedVide");

        assertTrue(p.estVide());
        c1.actionPerformed(edec);
        assertTrue(p.estVide());
    }

    /**
     * Test of setPanier method, of class Controleur.
     */
    @Test  //ignore pour fonctionner dans Jenkins
    public void testSetPanier() {
        System.out.println("setPanier");
        c1.setPanier(p4);
        c1.actionPerformed(einc);
        assertTrue(p4.getTaillePanier() == 1);
    }
}
