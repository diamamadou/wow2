package aston.wow.poo;

public class Nourriture {
    protected String nom;
    protected int reccuperation;
    protected double poids;

    public Nourriture() {
        super();
    }

    public Nourriture(String nom, int reccuperation, double poids) {
        this.nom = nom;
        this.reccuperation = reccuperation;
        this.poids = poids;
    }

    @Override
    public String toString() {
        return nom + " a comme poids " + poids + " et permet de gagner " + reccuperation + " points d'endurance'";
    }

}
