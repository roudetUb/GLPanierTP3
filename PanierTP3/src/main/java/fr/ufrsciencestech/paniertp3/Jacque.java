package fr.ufrsciencestech.paniertp3;

/**
 *
 * @author Gary
 */
public class Jacque implements Fruit{
    private double prix;
    private String origine;

    public Jacque()
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Pole Nord";
    }

    public Jacque(double prix, String origine)
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Pole Nord";  //Espagne par défaut
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
        return "Jacque de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Mangues sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Jacque j = (Jacque) o;
            return ( this.prix == j.prix && this.origine.equals(j.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'un Jacque a des pepins
        return false;
    }


    public static void main (String[] args){
        System.out.println("premier test Jacque");
        Jacque j1 = new Jacque(-2, "Pole Nord");
        Jacque j2 = new Jacque(2, "");
        System.out.println(j1);
        System.out.println(j1.isSeedless());
        System.out.println(j2.equals(j1));
   }
}
