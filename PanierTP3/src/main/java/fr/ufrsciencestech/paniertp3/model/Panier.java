package fr.ufrsciencestech.paniertp3.model;

import java.util.*;
/**
 *
 * @author roudet
 */
public class Panier extends Observable{
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private int contenanceMax;        //nb maximum d'oranges que peut contenir le panier

    public Panier(int contenanceMax){  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
        this.contenanceMax = Math.abs(contenanceMax);
        this.fruits = new ArrayList<Fruit>();
    }

    @Override
    public String toString(){  //affichage de ce qui est contenu dans le panier : liste des fruits presents
        return "Le panier comporte " + this.fruits.size() + " et a une contenanceMax de " + this.contenanceMax;
    }

    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
       return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut
	this.fruits = fruits;
    }

    public int getTaillePanier(){  //accesseur retournant la taille allouee pour l'attibut fruits
        return fruits.size();
    }

    public int getContenanceMax(){  //accesseur du second attribut
	return contenanceMax;
    }

    public Fruit getFruit(int i){  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
	if(i >= 0 && i < getFruits().size())
            return getFruits().get(i);
        else
            return null;
    }

    public void setFruit(int i, Fruit f){  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
        fruits.set(i, f);
    }

    public boolean estVide(){  //predicat indiquant que le panier est vide
	return fruits.isEmpty();
    }

    public boolean estPlein(){  //predicat indiquant que le panier est plein
	return fruits.size() == contenanceMax;
    }

    public void ajout(Fruit o) throws PanierPleinException{  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
        if(o == null)
            return;
        if(this.fruits.size() < this.contenanceMax){
            this.fruits.add(o);
            setChanged();
            notifyObservers();
        }
        else throw new PanierPleinException();
    }

    public void retrait() throws PanierVideException{  //retire le dernier fruit du panier si celui-ci n'est pas vide
        if(!estVide()){
            getFruits().remove(getFruits().size()-1);
            setChanged();
            notifyObservers();
        }
        else 
        {
            throw new PanierVideException();
        }
    }

    public double getPrix(){  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans
	double total=0;
	for(int i = 0 ; i < getFruits().size() ; i++)
            total += fruits.get(i).getPrix();
	return total;
    }

    public void boycotteOrigine(String origine){  //supprime du panier tous les fruits provenant du pays origine
        int i = 0;					//A
	while(i < fruits.size()){			//B
            if(fruits.get(i).getOrigine().equals(origine)) //C
		fruits.remove(i);			//D
            else								 
		i++ ;					//E
        }
    }

    @Override
    public boolean equals(Object o){  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
      if (o == null || getClass() != o.getClass()) return false;
      Panier p = (Panier)o;
      int length = Math.min(p.getTaillePanier(), this.getTaillePanier());
      for (int i = 0; i < length; i++) {
        if (!p.getFruit(i).equals(this.getFruit(i))) return false;
      }

      return true;
    }

}
