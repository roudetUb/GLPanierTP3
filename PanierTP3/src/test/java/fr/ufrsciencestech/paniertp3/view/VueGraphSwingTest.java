/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.paniertp3.view;

import fr.ufrsciencestech.paniertp3.TestUtils;
import fr.ufrsciencestech.paniertp3.controler.Controleur;
import fr.ufrsciencestech.paniertp3.model.Orange;
import fr.ufrsciencestech.paniertp3.model.Panier;
import fr.ufrsciencestech.paniertp3.model.PanierPleinException;
import fr.ufrsciencestech.paniertp3.model.PanierVideException;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class VueGraphSwingTest {
    private static VueGraphSwing vueg;
    private Controleur c1;
    private Panier p;

    @Before
    public void setUp() {
        vueg = new VueGraphSwing();
        p = new Panier(2);
        c1 = new Controleur();
        c1.setPanier(p);
        p.addObserver(vueg);
        vueg.addControleur(c1);
    }


    /**
     * Test of update method, of class VueGraphiqueSimple.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     * @throws fr.ufrsciencestech.panier.Model.PanierVideException
     */
    @Test  //ignore pour fonctionner dans Jenkins
    public void testUpdate() throws PanierPleinException, PanierVideException {
        System.out.println("update");
        p.ajout(new Orange(0.5, "Espagne"));
        assertEquals(vueg.getAffiche().getText(), "1");
        p.ajout(new Orange(0.5, "Espagne"));
        assertEquals(vueg.getAffiche().getText(), "2");
        
        vueg.setAffiche(new JLabel("0", JLabel.CENTER));
        assertEquals(vueg.getAffiche().getText(), "0");
    }

    /**
     * Test of addControleur method, of class VueGraphiqueSimple.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        plus.doClick();
        assertEquals(res.getText(), "2");
    }
    
    @Test
    public void testAddPlein() {
        System.out.println("addplein");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        plus.doClick();
        assertEquals(res.getText(), "2");
        plus.doClick();
        assertEquals(res.getText(), "2");
    }
    
    //https://www.javaworld.com/article/2073056/swing-gui-programming/automate-gui-tests-for-swing-applications.html
    @Test
    public void testRemoveOk() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        minus.doClick();
        assertEquals(res.getText(), "0");
    }
    
    @Test
    public void testRemoveZero() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        minus.doClick();
        assertEquals(res.getText(), "0");
    }
}
