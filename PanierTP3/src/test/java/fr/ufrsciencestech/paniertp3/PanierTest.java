/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.paniertp3;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import static org.mockito.Mockito.*;

/**
 *
 * @author celine
 */
public class PanierTest {
    Panier p0, p3, pm1;
    Orange mockor, or, or2;
    String origineEsp, origineFr;
    
    public PanierTest() {
    }
    
    @Before
    public void setUp() {
        p3 = new Panier(3);   //initialisation d'un panier vide avec 3 places
        p0 = new Panier(0);   //initialisation d'un panier vide avec 0 place (deja plein !)
        pm1 = new Panier(-1);   //initialisation d'un panier vide avec 1 place 
        
        mockor = mock(Orange.class);     //initialisation d'un test en isolation
        when(mockor.getPrix()).thenReturn(0.5);
        when(mockor.getOrigine()).thenReturn("Espagne");
        
        or = new Orange(1.0, "France");
        or2 = new Orange(0.5, "Espagne");
        
        origineEsp = "Espagne";
        origineFr = "France";
    }
    
    @After
    public void tearDown() {
    }
       
    //TESTS EN ISOLATION DE AJOUT
    
    //DT1 : panier vide (de contenanceMax=3) et on lui ajoute une Orange a 0.5 euro et provenant d'Espagne (non null) / resultat : le panier contient un element : l'orange
    @Test
    public void testAjoutPanierVideMockOrange() throws PanierPleinException {
        System.out.println("ajoutPanierVideMockOrange");
        p3.ajout(mockor);   //test
        assertFalse(p3.estVide());
        assertTrue(p3.getTaillePanier() == 1);
    }
    
    //DT2 : panier (de contenanceMax=3) contenant 1 orange et on lui ajoute 1 Orange a 0.5 euro et provenant d'Espagne (non null) / resultat : le panier contient 2 elements 
    @Test
    public void testAjoutPanier1MockOrange() throws PanierPleinException {
        System.out.println("ajoutPanier1MockOrange");
        p3.ajout(mockor);
        p3.ajout(mockor);   //test
        assertFalse(p3.estVide());
        assertTrue(p3.getTaillePanier() == 2);
        assertFalse(p3.estPlein());
    }
    
    //DT3 : panier (de contenanceMax=3) contenant 2 oranges et on lui ajoute 1 Orange a 0.5 euro et provenant d'Espagne (non null) / resultat : le panier contient 3 elements ; il est plein
    @Test
    public void testAjoutPanierPresquePleinMockOrange() throws PanierPleinException {
        System.out.println("ajoutPanierPresquePleinMockOrange");
        p3.ajout(mockor);
        p3.ajout(mockor);
        p3.ajout(mockor);   //test
        assertFalse(p3.estVide());
        assertTrue(p3.getTaillePanier() == 3);
        assertTrue(p3.estPlein());
    }
    
    //DT4 : panier plein (de contenanceMax=3) contenant les 3 memes oranges et o est toujours la meme orange (non null) / resultat : envoi de l'exception, car on ne peut pas ajouter une nouvelle orange
    @Test(expected=PanierPleinException.class)
    public void testAjoutPanierPleinMockOrange() throws PanierPleinException {
        p3.ajout(mockor);
        p3.ajout(mockor);
        p3.ajout(mockor);
        p3.ajout(mockor);   //test
    }
    
    //DT5, 6, 7 et 8 : on ajoute "null" / resultat : aucun ajout dans le panier
    @Test
    public void testAjoutPanierNull() throws PanierPleinException {
        System.out.println("ajoutPanierNull");
        p3.ajout(null);   //test
        assertTrue(p3.estVide());
        assertTrue(p3.getTaillePanier() == 0);
        assertFalse(p3.estPlein());
    }
    
    //DT9 : panier vide (de contenanceMax=0) et o est une Orange a 0.5 euro et provenant d'Espagne (non null) / resultat : envoi de l'exception, car on ne peut pas ajouter une nouvelle orange, le panier est vide et plein a la fois !
    @Test(expected=PanierPleinException.class)
    public void testAjoutPanierVidePleinMockOrange() throws PanierPleinException {
        p0.ajout(mockor);   //test
    }
    
    //DT10 : panier vide (de contenanceMax = -1 : parametre -1 passe au constructeur de la classe Panier) et on ajoute une Orange a 0.5 euro et provenant d'Espagne (non null) / résultat : dans le constructeur de la classe Panier, on fait en sorte d'initialiser un panier de contenanceMax = - (-1) en prenant la valeur absolue du chiffre passe en parametre. Ainsi, le panier contient un element : l'orange ajoutee et est maintenant plein
    @Test
    public void testAjoutPanierNegMockOrange() throws PanierPleinException {
        System.out.println("ajoutPanierNegMockOrange");
        pm1.ajout(mockor);   //test
        assertFalse(pm1.estVide());
        assertTrue(pm1.getTaillePanier() == 1);
        assertTrue(pm1.estPlein());
    }
    
    
    
    //TESTS A LANCER QUAND LA CLASSE ORANGE A ETE TESTEE : INTEGRATION DE AJOUT
    //DT1 : panier vide (de contenanceMax=3) et on lui ajoute une Orange a 0.5 euro et provenant d'Espagne (non null) / resultat : le panier contient un element : l'orange
    @Test
    public void testAjoutPanierVideOrange() throws PanierPleinException {
        System.out.println("ajoutPanierVideOrange");
        p3.ajout(or);   //test
        assertFalse(p3.estVide());
        assertTrue(p3.getTaillePanier() == 1);
    }
    
    //DT2 : panier (de contenanceMax=3) contenant 1 orange et on lui ajoute 1 Orange a 0.5 euro et provenant d'Espagne (non null) / resultat : le panier contient 2 elements 
    @Test
    public void testAjoutPanier1Orange() throws PanierPleinException {
        System.out.println("ajoutPanier1Orange");
        p3.ajout(or);
        p3.ajout(or);   //test
        assertFalse(p3.estVide());
        assertTrue(p3.getTaillePanier() == 2);
        assertFalse(p3.estPlein());
    }
    
    //DT3 : panier (de contenanceMax=3) contenant 2 oranges et on lui ajoute 1 Orange a 0.5 euro et provenant d'Espagne (non null) / resultat : le panier contient 3 elements ; il est plein
    @Test
    public void testAjoutPanierPresquePleinOrange() throws PanierPleinException {
        System.out.println("ajoutPanierPresquePleinOrange");
        p3.ajout(or);
        p3.ajout(or);
        p3.ajout(or);   //test
        assertFalse(p3.estVide());
        assertTrue(p3.getTaillePanier() == 3);
        assertTrue(p3.estPlein());
    }
    
    //DT4 : panier plein (de contenanceMax=3) contenant les 3 memes oranges et o est toujours la meme orange (non null) / resultat : envoi de l'exception, car on ne peut pas ajouter une nouvelle orange
    @Test(expected=PanierPleinException.class)
    public void testAjoutPanierPleinOrange() throws PanierPleinException {
        p3.ajout(or);
        p3.ajout(or);
        p3.ajout(or);
        p3.ajout(or);   //test
    }
    
    //DT9 : panier vide (de contenanceMax=0) et o est une Orange a 0.5 euro et provenant d'Espagne (non null) / resultat : envoi de l'exception, car on ne peut pas ajouter une nouvelle orange, le panier est vide et plein a la fois !
    @Test(expected=PanierPleinException.class)
    public void testAjoutPanierVidePleinOrange() throws PanierPleinException {
        p0.ajout(or);   //test
    }
    
    //DT10 : panier vide (de contenanceMax = -1 : parametre -1 passe au constructeur de la classe Panier) et on ajoute une Orange a 0.5 euro et provenant d'Espagne (non null) / résultat : dans le constructeur de la classe Panier, on fait en sorte d'initialiser un panier de contenanceMax = - (-1) en prenant la valeur absolue du chiffre passe en parametre. Ainsi, le panier contient un element : l'orange ajoutee et est maintenant plein
    @Test
    public void testAjoutPanierNegOrange() throws PanierPleinException {
        System.out.println("ajoutPanierNegMockOrange");
        pm1.ajout(or);   //test
        assertFalse(pm1.estVide());
        assertTrue(pm1.getTaillePanier() == 1);
        assertTrue(pm1.estPlein());
    }
    
    
    
    //TESTS EN ISOLATION DE GETPRIX
    
    //DT1 : panier vide / resultat : prix == 0
    @Test
    public void testGetPrixPanierVide() throws PanierPleinException{
        System.out.println("getPrixPanierVide");
        double prix = p3.getPrix();   //ajout d'un element
        assertTrue(prix == 0.0);
    }
    
    //DT2 : panier contenant 1 orange / resultat : prix == le prix de l'orange
    @Test
    public void testGetPrixPanier1MockOrange() throws PanierPleinException {
        System.out.println("getPrixPanier1MockOrange");
        p3.ajout(mockor);   
        double prix = p3.getPrix();
        assertTrue(prix == 0.5);
        assertTrue(prix == mockor.getPrix());
    }

    //DT3 : panier contenant 2 oranges (presque plein) / resultat : prix == la somme des prix des 2 oranges
    @Test
    public void testGetPrixPanierPresquePleinMockOrange() throws PanierPleinException {
        System.out.println("getPrixPanierPresquePleinMockOrange");
        p3.ajout(mockor);   
        p3.ajout(mockor); 
        double prix = p3.getPrix();
        assertTrue(prix == 1.0);
        assertTrue(prix == 2*mockor.getPrix());
    }
    
    //DT4 : panier contenant 3 oranges (plein) / resultat : prix == la somme des prix des 3 oranges
    @Test
    public void testGetPrixPanierPleinMockOrange() throws PanierPleinException {
        System.out.println("getPrixPanierPleinMockOrange");
        p3.ajout(mockor);   
        p3.ajout(mockor); 
        p3.ajout(mockor); 
        double prix = p3.getPrix();
        assertTrue(prix == 1.5);
        assertTrue(prix == 3*mockor.getPrix());
    }
    
    
    //TESTS A LANCER QUAND LA CLASSE ORANGE A ETE TESTEE : INTEGRATION DE GETPRIX
    //DT2 : panier contenant 1 orange / resultat : prix == le prix de l'orange
    @Test
    public void testGetPrixPanier1Orange() throws PanierPleinException {
        System.out.println("getPrixPanier1Orange");
        p3.ajout(or);   
        double prix = p3.getPrix();
        assertTrue(prix == 1.0);
        assertTrue(prix == or.getPrix());
    }

    //DT3 : panier contenant 2 oranges (presque plein) / resultat : prix == la somme des prix des 2 oranges
    @Test
    public void testGetPrixPanierPresquePleinOrange() throws PanierPleinException {
        System.out.println("getPrixPanierPresquePleinOrange");
        p3.ajout(or);   
        p3.ajout(or2); 
        double prix = p3.getPrix();
        assertTrue(prix == 1.0+0.5);
        assertTrue(prix == or.getPrix() + or2.getPrix());
    }
    
    //DT4 : panier contenant 3 oranges (plein) / resultat : prix == la somme des prix des 3 oranges
    @Test
    public void testGetPrixPanierPleinOrange() throws PanierPleinException {
        System.out.println("getPrixPanierPleinMockOrange");
        p3.ajout(or);   
        p3.ajout(or); 
        p3.ajout(or); 
        double prix = p3.getPrix();
        assertTrue(prix == 1.0*3);
        assertTrue(prix == 3*or.getPrix());
    }
    
    
    //TESTS DE LA METHODE EQUALS
    @Test
    public void testEqualsVide() {
        System.out.println("equalsVide");
	Panier p3_1 = new Panier(3);
	Panier p3_2 = new Panier(3);
	assertEquals(p3_1, p3_2);
    }
    
    @Test
    public void testEqualsAjout1() throws PanierPleinException{
        System.out.println("equalsAjout1");
        Panier p3_1 = new Panier(3);
	p3_1.ajout(or);
	Panier p3_2 = new Panier(3);
	p3_2.ajout(or);
	assertEquals(p3_1, p3_2);
    }
    
    
    //TESTS A LANCER QUAND LA CLASSE ORANGE A ETE TESTEE : INTEGRATION DE BOYCOTTEORIGINE
    //DT1 panier vide (de contenanceMax=3) et origine = "Espagne" / resultat : le panier est toujours vide
    @Test
    public void testBoycotteOriginePanierVide() {
        System.out.println("boycotteOriginePanierVide");
        p3.boycotteOrigine(origineEsp);
        assertTrue(p3.estVide());
    }
    
    //DT2 panier (de contenanceMax=3) contenant une Orange a 1.0 euro et provenant de France et origine = "France" / resultat : le panier est vide
    @Test
    public void testBoycotteOriginePanier1Orange() throws PanierPleinException {
        System.out.println("boycotteOriginePanier1Orange");
        p3.ajout(or);
        p3.boycotteOrigine(origineFr);
        assertTrue(p3.estVide());
    }

    //DT3 panier (de contenanceMax=3) contenant 2 oranges a 1.0 euro et provenant de France et origine = "France" / resultat : le panier est vide
    @Test
    public void testBoycotteOriginePanier2Orange() throws PanierPleinException {
        System.out.println("boycotteOriginePanier2Orange");
        p3.ajout(or);
        p3.ajout(or);
        p3.boycotteOrigine(origineFr);
        assertTrue(p3.estVide());
    }
    
    //DT4 panier plein (de contenanceMax=3) contenant 3 oranges a 1.0 euro et provenant de France et origine = "France" / resultat : le panier est vide
    @Test
    public void testBoycotteOriginePanierPleinOrange() throws PanierPleinException {
        System.out.println("boycotteOriginePanierPleinOrange");
        p3.ajout(or);
        p3.ajout(or);
        p3.ajout(or);
        p3.boycotteOrigine(origineFr);
        assertTrue(p3.estVide());
    }
    
    //DT5 panier (de contenanceMax=3) contenant une Orange a 1.0 euro et provenant de France et origine = "" / resultat : le panier reste tel quel
    @Test
    public void testBoycotteOriginePanier1OrangeStringNonValide() throws PanierPleinException {
        System.out.println("boycotteOriginePanier1OrangeStringNonValide");
        p3.ajout(or);
        p3.boycotteOrigine("");
        assertFalse(p3.estVide());
        assertTrue(p3.getTaillePanier() == 1);
        assertFalse(p3.estPlein());
    }

    //DT9 panier (de contenanceMax=3) contenant une Orange a 1.0 euro et provenant de France et origine = "Espagne" / resultat : le panier reste tel quel
    @Test
    public void testBoycotteOriginePanier1Orange2() throws PanierPleinException {
        System.out.println("boycotteOriginePanier1Orange2");
        p3.ajout(or);
        p3.boycotteOrigine("Espagne");
        assertFalse(p3.estVide());
        assertTrue(p3.getTaillePanier() == 1);
        assertFalse(p3.estPlein());
    }
    
    
    
    
    /**
     * Test of retrait method, of class Panier.
     */
    @Ignore
    public void testRetrait() throws PanierVideException {
        System.out.println("retrait");
        Panier instance = null;
        instance.retrait();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    /**
     * Test of toString method, of class Panier.
     */
    @Ignore
    public void testToString() {
        System.out.println("toString");
        Panier instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFruits method, of class Panier.
     */
    @Ignore
    public void testGetFruits() {
        System.out.println("getFruits");
        Panier instance = null;
        ArrayList<Fruit> expResult = null;
        ArrayList<Fruit> result = instance.getFruits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFruits method, of class Panier.
     */
    @Ignore
    public void testSetFruits() {
        System.out.println("setFruits");
        ArrayList<Fruit> fruits = null;
        Panier instance = null;
        instance.setFruits(fruits);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaillePanier method, of class Panier.
     */
    @Ignore
    public void testGetTaillePanier() {
        System.out.println("getTaillePanier");
        Panier instance = null;
        int expResult = 0;
        int result = instance.getTaillePanier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContenanceMax method, of class Panier.
     */
    @Ignore
    public void testGetContenanceMax() {
        System.out.println("getContenanceMax");
        Panier instance = null;
        int expResult = 0;
        int result = instance.getContenanceMax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFruit method, of class Panier.
     */
    @Ignore
    public void testGetFruit() {
        System.out.println("getFruit");
        int i = 0;
        Panier instance = null;
        Fruit expResult = null;
        Fruit result = instance.getFruit(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFruit method, of class Panier.
     */
    @Ignore
    public void testSetFruit() {
        System.out.println("setFruit");
        int i = 0;
        Fruit f = null;
        Panier instance = null;
        instance.setFruit(i, f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estVide method, of class Panier.
     */
    @Ignore
    public void testEstVide() {
        System.out.println("estVide");
        Panier instance = null;
        boolean expResult = false;
        boolean result = instance.estVide();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estPlein method, of class Panier.
     */
    @Ignore
    public void testEstPlein() {
        System.out.println("estPlein");
        Panier instance = null;
        boolean expResult = false;
        boolean result = instance.estPlein();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
