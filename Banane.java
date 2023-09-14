/**
 *
 * @author cristan
 */
public class Banane implements Fruit {
    private double prix;
    private String origine;

    public Banane() {
        this.prix = 0.5; // prix en euros
        this.origine = "Espagne";
    }

    public Banane(double prix, String origine) {
        if (prix < 0)
            this.prix = -prix; // une solution possible pour interdire les prix negatifs
        else
            this.prix = prix;

        if (origine.equals(""))
            this.origine = "Espagne"; // Espagne par défaut
        else
            this.origine = origine;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    @Override
    public String toString() {
        return "Banane de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o) { // predicat pour tester si 2 Bananes sont equivalentes
        if (o != null && getClass() == o.getClass()) {
            Banane or = (Banane) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() { // predicat indiquant qu'une Banane a des pepins
        return false;
    }

    /*
     * public static void main(String[] args) {
     * Banane or1 = new Banane();
     * Banane or2 = new Banane(12, "Conakry");
     * // Ecrire ici vos tests
     * System.out.println("verification Banane par default");
     * System.out.println("le prix de départ est" + or1.getPrix());
     * System.out.println("Vrai origine" + or1.getOrigine());
     * or1.setOrigine("Congo");
     * System.out.println("changement de l'origine " + or1.getOrigine());
     * 
     * System.out.println("verification Banane avec parametre");
     * System.out.println(or2.getPrix());
     * System.out.println(or2.getOrigine());
     * }
     */
}
