/**
 *
 * @author roudet
 */
public class Cerise implements Fruit{
    private double prix;
    private String origine;
	
    public Cerise() 
    {
        this.prix = 0.6;  //prix en euros
        this.origine="Italie";
    }
    
    public Cerise(double prix, String origine) 
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals("") || origine == null)
            this.origine = "Italie";  //Espagne par défaut
	else
            this.origine = origine;   
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
    	if(prix >= 0)
		this.prix=prix;
	else 
		System.out.println("Il n'est pas possible de donner un prix négatif");
    }

    public String getOrigine(){
	return origine;
    }
 
    public void setOrigine(String origine){
    	if(origine.equals("") || origine == null)
            System.out.println("Origine invalide, rentrez une origine avec au minimum un caractère");
	else
		this.origine=origine;
    }

    @Override
    public String toString(){
        return "Cerise de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 oranges sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Cerise cer = (Cerise) o;
            return (prix == cer.prix && origine.equals(cer.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une orange a des pepins
        return false;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
        Cerise c1 = new Cerise();
        Cerise c2 = new Cerise(1,"Colombie");
        Cerise c3 = new Cerise(-10,"");
        System.out.println("La cerise 1 : "+c1);
        System.out.println("La cerise 2 : "+c2);
        System.out.println("La cerise 3 : "+c3);
        System.out.println("");
        c1.setPrix(1.5);
        c2.setOrigine("Portugal");
        System.out.println("Prix cerise 1 : "+c1.getPrix());
        System.out.println("Origine cerise 1 : "+c1.getOrigine());
        System.out.println("");
        System.out.println("Prix cerise 2 : "+c2.getPrix());
        System.out.println("Origine cerise 2 : "+c2.getOrigine());
   }
}
