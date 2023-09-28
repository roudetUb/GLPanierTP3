/**
 *
 * @author roudet
 */
public class Melon {
    private double prix;
    private String origine;
	
    public Melon() 
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }
    
    public Melon(double prix, String origine) 
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Espagne";  //Espagne par défaut
	else
            this.origine = origine;   
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }

    public String getOrigine(){
	return origine;
    }
 
    public void setOrigine(String origine){
	this.origine=origine;
    }

    @Override
    public String toString(){
        return "Melon de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object m){  //predicat pour tester si 2 melons sont equivalentes
        if(m != null && getClass() == m.getClass()){
            Melon mel = (Melon) m;
            return (prix == mel.prix && origine.equals(mel.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une melon a des pepins
        return false;
    }

    public static void main(String[] args) {
        // Test de constructeurs
        Melon melon1 = new Melon();
        Melon melon2 = new Melon(1.0, "France");

        // Test des getters
        System.out.println("Prix de melon1 : " + melon1.getPrix()); // Devrait afficher 0.5
        System.out.println("Origine de melon1 : " + melon1.getOrigine()); // Devrait afficher "Espagne"
        System.out.println("Prix de melon2 : " + melon2.getPrix()); // Devrait afficher 1.0
        System.out.println("Origine de melon2 : " + melon2.getOrigine()); // Devrait afficher "France"

        // Test des setters
        melon1.setPrix(0.8);
        melon1.setOrigine("Italie");
        System.out.println("Nouveau prix de melon1 : " + melon1.getPrix()); // Devrait afficher 0.8
        System.out.println("Nouvelle origine de melon1 : " + melon1.getOrigine()); // Devrait afficher "Italie"

        // Test de la méthode toString
        System.out.println("melon1 : " + melon1); // Devrait afficher "Melon de Italie a 0.8 euros"
        System.out.println("melon2 : " + melon2); // Devrait afficher "Melon de France a 1.0 euros"

        // Test de la méthode equals
        System.out.println("melon1 equals melon2 : " + melon1.equals(melon2)); // Devrait afficher false

        // Test de la méthode isSeedless
        System.out.println("melon1 isSeedless : " + melon1.isSeedless()); // Devrait afficher false
        System.out.println("melon2 isSeedless : " + melon2.isSeedless()); // Devrait afficher false
    }
}