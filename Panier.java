import java.util.*;

/**
 *
 * @author roudet
 */
public class Panier {
    private ArrayList<Fruit> fruits; // attribut pour stocker les fruits
    private int contenanceMax; // nb maximum d'oranges que peut contenir le panier

    // groupe 1
    public Panier(int contenanceMax) { // initialise un panier vide ayant une certaine contenance maximale (precisee en
                                       // parametre)
        this.fruits = new ArrayList<Fruit>();
        this.contenanceMax = contenanceMax;
    }

    @Override

    public String toString() { // affichage de ce qui est contenu dans le panier : liste des fruits presents
        String res = "";
        String newLine = System.getProperty("line.separator");
        for (int i = 0; i < fruits.size(); i++) {
            res += fruits.get(i).toString() + newLine;
        }
        return res;
    }

    // groupe 2
    public ArrayList<Fruit> getFruits() { // accesseur du premier attribut

        return this.fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { // modificateur du premier attribut
        this.fruits = fruits;

    }

    public int getTaillePanier() { // accesseur retournant la taille allouee pour l'attibut fruits
        return this.fruits.size();
    }

    public int getContenanceMax() { // accesseur du second attribut
        return this.contenanceMax;
    }

    // groupe 3
    public Fruit getFruit(int i) { // accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou
                                   // null s'il n'y a rien a cet emplacement
        return null;
    }

    // groupe 4
    public void ajout(Fruit o) throws PanierPleinException { // ajoute le fruit o a la fin du panier si celui-ci n'est
                                                             // pas plein
        if (fruits.size() < contenanceMax)
            fruits.add(o);
        else
            throw new PanierPleinException();

    }

    public void setFruit(int i, Fruit f) { // modificateur du fruit contenu dans le panier a l'emplacement n°i par f
                                           // (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)

    }

    public boolean estVide() { // predicat indiquant que le panier est vide
        return false;
    }

    public boolean estPlein() { // predicat indiquant que le panier est plein
        return false;
    }

    // groupe 5
    public void retrait() throws PanierVideException { // retire le dernier fruit du panier si celui-ci n'est pas vide

    }

    // groupe 6
    public double getPrix() { // calcule le prix du panier par addition des prix de tous les fruits contenus
                              // dedans
        return 0;
    }

    // groupe 7
    public void boycotteOrigine(String origine) {  //supprime du panier tous les fruits provenant du pays origine
    	for(int i = fruits.size()-1; i>= 0; --i) 
    	{
    		if(fruits.get(i).getOrigine().equals(origine))
    		{
                fruits.remove(i);
        	}
        }
    }

    // groupe 8
    @Override
    public boolean equals(Object o) { /// predicat pour tester si 2 paniers sont equivalents : s'ils contiennent
                                      /// exactement les memes fruits
        if (o != null && o instanceof Panier) {
            Panier or = (Panier) o;
            if (getTaillePanier() == or.getTaillePanier()) {
                for (int i = 0; i < getTaillePanier(); i++) {
                    if (!getFruit(i).equals(or.getFruit(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    // tests
    public static void main(String[] args) {
        // Ecrire ici vos tests
        System.out.println("premier test Panier");
        Panier P = new Panier(10);
        System.out.println(P.toString());

        Banane banane = new Banane();
        Banane bananeParams = new Banane(158, "Danemark");
        Banane bananeNegatif = new Banane(-3, "Allemagne");

        System.out.println("Banane avec le const vide: " + banane);
        System.out.println("Banane avec les param initialisé: " + bananeParams);
        // test de Panier.equals(Object)
        Panier p1 = new Panier(3); // exemple de panier (ananas, orange, <vide>)
        Panier p2 = new Panier(3); // panier identique au premier
        Panier p3 = new Panier(3); // panier différent du premier (mais premier fruit identique)
        Panier p4 = new Panier(3); // panier différent du premier (mais seul les deux premiers fruits sont
                                   // identiques)
        Fruit f1 = (Fruit) new Ananas(3.56, "");
        Fruit f2 = (Fruit) new Orange(0.5, "France");
        try {
            p1.ajout(f1);
            p1.ajout(f2);
            p2.ajout(f1);
            p2.ajout(f2);
            p3.ajout(f1);
            p3.ajout(new Orange(0.5, "Espagne"));
            p4.ajout(f1);
            p4.ajout(f2);
            p4.ajout(new Orange(0.75, "Costa Rica"));
            if (p1.equals(p2) && !p1.equals(p3) && !p1.equals(p4) && !p3.equals(p4)) {
                System.out.println("Test Panier.equals(Object) : OK");
            } else {
                System.out.println("Test Panier.equals(Object) : NOK");
            }
        } catch (PanierPleinException e) {
            System.out.println("Test Panier.equals(Object) : NOK");
        }

        System.out.println("premier test Panier");
        Panier P = new Panier(10);
        System.out.println(P.toString());

        System.out.println("Test ajout panier");
        try {
            for (int i = 0; i < 10; i++)
                P.ajout(new Orange());
            System.out.println("Ajout bien réalisé\n");
        } catch (PanierPleinException e) {
            e.printStackTrace();
        }

        System.out.println("Test ajout panier");
        try {
            for (int i = 0; i < 10; i++)
                P.ajout(new Orange());
            System.out.println("Ajout bien réalisé\n");
        } catch (PanierPleinException e) {
            e.printStackTrace();
        }
        System.out.println("Banane avec le prix negatif: " + bananeNegatif);
        
        // Test fraise 
        Fraise fraise = new Fraise();
        System.out.println("Fruit = Fraise -> Prix:" + fraise.getPrix());
        System.out.println("Fruit = Fraise -> Origine:" + fraise.getOrigine());
    }
}
