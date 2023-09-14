/**
 * Classe Ananas
 * @author gbeldilmi
 */
public class Ananas implements Fruit {
  private double prix;
  private String origine;

  public Ananas() {
    this(0.5, "");
}

public Ananas(double prix, String origine) {
    setPrix(prix);
    setOrigine(origine);
}

  public double getPrix() {
    return prix;
  }

  public void setPrix(double prix) {
    if (prix < 0)
      prix = -prix;
    this.prix = prix;
  }

  public String getOrigine() {
    return origine;
  }

  public void setOrigine(String origine) {
    if (origine.equals(""))
      origine = "Brésil";
    this.origine = origine;
  }

  @Override
  public String toString() {
    return "Ananas de " + getOrigine() + " a " + getPrix() + " euros";
  }

  @Override
  public boolean equals(Object o) {
    if (o != null && o instanceof Ananas) {
      Ananas or = (Ananas) o;
      return (getPrix() == or.getPrix() && getOrigine().equals(or.getOrigine()));
    }
    return false;
  }

  public boolean isSeedless() {
    return true;
  }
}
