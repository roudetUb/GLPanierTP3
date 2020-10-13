package fr.ufrsciencestech.paniertp3.model;

/**
 *
 * @author roudet
 */
public class PanierPleinException extends Exception {
    
    public PanierPleinException()
    {
	super("Ajout impossible car le panier est plein !");
    }

}
