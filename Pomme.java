/**
 *
 * @author nathan voizeux
 */
public class Pomme {
    private double prix;
    private String origine;
	
    public Pomme() 
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }
    
    public Pomme(double prix, String origine) 
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
        return "Pomme de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Pommes sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Pomme or = (Pomme) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Pomme a des pepins
        return false;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
        Pomme o1 = new Pomme();
    System.out.println(o1+"\n");
        Pomme o2 = new Pomme(-5,"");
        Pomme o3 = new Pomme(15,"Grece");
    System.out.println(o2+"\n");
    System.out.println(o3+"\n");
        o1.setOrigine("France");
        o1.setPrix(25);
    System.out.println(o1+"\n");
    //System.out.println(o2.equals(o3));
	//System.out.println("premier test Pomme");
   }
}
