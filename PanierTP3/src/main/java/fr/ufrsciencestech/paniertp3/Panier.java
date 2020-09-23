package fr.ufrsciencestech.paniertp3;

import fr.ufrsciencestech.paniertp3.Fruit;
import fr.ufrsciencestech.paniertp3.Fruit;
import fr.ufrsciencestech.paniertp3.PanierPleinException;
import fr.ufrsciencestech.paniertp3.PanierVideException;
import java.util.*;
/**
 *
 * @author roudet
 */
public class Panier {
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private int contenanceMax;        //nb maximum d'oranges que peut contenir le panier
	
    //groupe 1
    public Panier(int contenanceMax){  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
        this.contenanceMax = contenanceMax;
    }

    @Override
    public String toString(){  //affichage de ce qui est contenu dans le panier : liste des fruits presents
        String toString = "Contenu du Panier : \n";
        for (Fruit fruit : fruits) {
          toString += fruit.toString() + '\n';
        }
        return toString;
    }
    
    //groupe 2
    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
        return null;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut
      
    }

    public int getTaillePanier(){  //accesseur retournant la taille allouee pour l'attibut fruits
        return this.fruits.size();
    }
    
    public int getContenanceMax(){  //accesseur du second attribut
	return this.contenanceMax;
    }

    //groupe 3
    public Fruit getFruit(int i){  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
        if(i <= this.fruits.size()) 
            return null;
        return this.fruits.get(i);
    }
    
    public void setFruit(int i, Fruit f){  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
        if(i < this.fruits.size())
            this.fruits.set(i, f);
    }
    
    public boolean estVide(){  //predicat indiquant que le panier est vide
	return this.fruits.isEmpty();    //modifie par C. Roudet
    }
    
    public boolean estPlein(){  //predicat indiquant que le panier est plein
	return this.fruits.size() == this.contenanceMax;
    }

    //groupe 4
    public void ajout(Fruit o) throws PanierPleinException{  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
        
    }

    //groupe 5
    public void retrait() throws PanierVideException{ //retire le dernier fruit du panier si celui-ci n'est pas vide
        
    }

    //groupe 6
    public double getPrix(){  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans
        double prix = 0;
        for(Fruit f : fruits)
        {
            prix += f.getPrix();
        }
	return prix;
    }
    
    //groupe 7
    public void boycotteOrigine(String origine){  //supprime du panier tous les fruits provenant du pays origine
	for(int i=0; i<fruits.size(); i++){
		if(fruits.get(i).getOrigine().equals(origine)){
			fruits.remove(fruits.get(i));
}
}
    }  
        
    //groupe 8    
    @Override
    public boolean equals(Object o){  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
        if (o == null || getClass() != o.getClass()) 
            return false;
        Panier p = (Panier)o;
        int length = Math.min( p.getTaillePanier(), this.getTaillePanier() );
        for (int i = 0; i < length; i++) 
        {
            if (!p.getFruit(i).equals(this.getFruit(i))) 
                return false;
        }
        return true;
    }
    
    //tests
    public static void main (String[] args){
    	//Ecrire ici vos tests
        System.out.println("premier test Panier");
    }
}
