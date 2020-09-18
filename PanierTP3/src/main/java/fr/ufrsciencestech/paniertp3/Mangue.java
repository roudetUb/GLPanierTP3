package fr.ufrsciencestech.paniertp3;

/**
 *
 * @author guillemin
 */
public class Mangue {
    private double prix;
    private String origine;
	
    public Mangue() 
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }
    
    public Mangue(double prix, String origine) 
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
        return "Mangue de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Mangues sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Mangue or = (Mangue) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Mangue a des pepins
        return false;
    }


    public static void main (String[] args){
        System.out.println("premier test Mangue");
        Mangue mangue1 = new Mangue(-2, "France");
        Mangue mangue2 = new Mangue(2, "");
        System.out.println(mangue1);
        System.out.println(mangue1.isSeedless());
        System.out.println(mangue2.equals(mangue1));
   }
}
