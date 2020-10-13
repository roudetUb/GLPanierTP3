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
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class VueGraphAWTTest {
    static VueGraphAWT vueg;
    private Controleur c1;
    private Panier p;
    
    @Before
    public void setUp() {
        vueg = new VueGraphAWT();
        p = new Panier(2);
        c1 = new Controleur();
        c1.setPanier(p);
        //c1.setVue(vueg);
        p.addObserver(vueg);
        vueg.addControleur(c1);
    }

    /**
     * Test of update method, of class VueGraphiqueSimpleAWT.
     */
    @Test
    public void testUpdate() throws PanierPleinException {
        System.out.println("update");
        p.ajout(new Orange(0.5, "Espagne"));
        assertEquals(vueg.getAffiche().getText(), "1");
        p.ajout(new Orange(0.5, "Espagne"));
        assertEquals(vueg.getAffiche().getText(), "2");
        
        vueg.setAffiche(new Label("0", Label.CENTER));
        assertEquals(vueg.getAffiche().getText(), "0");
    }

    /**
     * Test of addControleur method, of class VueGraphiqueSimple.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        assertNotNull(vueg);  // Instantiated?
        Label res = (Label)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final Button plus = (Button)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        //tests d'acceptation (de l'interface) : 
        //plus.doClick(); //ne marche pas avec AWT
        ActionEvent ae = new ActionEvent((Object)plus, ActionEvent.ACTION_PERFORMED, "");
        plus.dispatchEvent(ae);  
        
        assertEquals(res.getText(), "1");
        plus.dispatchEvent(ae);    //plus.doClick();
        assertEquals(res.getText(), "2");
    }
    
    //https://www.javaworld.com/article/2073056/swing-gui-programming/automate-gui-tests-for-swing-applications.html
    @Test
    public void testRemoveOk() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        Label res = (Label)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final Button plus = (Button)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final Button minus = (Button)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        //plus.doClick(); //ne marche pas avec AWT
        ActionEvent aep = new ActionEvent((Object)plus, ActionEvent.ACTION_PERFORMED, "");
        ActionEvent aem = new ActionEvent((Object)minus, ActionEvent.ACTION_PERFORMED, "");
        plus.dispatchEvent(aep); 
        assertEquals(res.getText(), "1");
        minus.dispatchEvent(aem);   //minus.doClick();
        assertEquals(res.getText(), "0");
    }
    
    @Test
    public void testRemoveZero() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        Label res = (Label)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final Button minus = (Button)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        ActionEvent aem = new ActionEvent((Object)minus, ActionEvent.ACTION_PERFORMED, "");
        minus.dispatchEvent(aem);   //minus.doClick();
        assertEquals(res.getText(), "0");
    }
}
