package aston.wow.poo;

public class Arme {
    public String nom;
    public int pointsDeDegatsParAttaque;
    public double longueur;
    public double poids;

    public Arme(String nom, int pointsDeDegatsParAttaque, double longueur, double poids) {
        this.nom = nom;
        this.pointsDeDegatsParAttaque = pointsDeDegatsParAttaque;
        this.longueur = longueur;
        this.poids = poids;
    }

    @Override
    public String toString() {
        return nom + " qui  est une arme de " + longueur + " cm, de " + poids + " g et " + pointsDeDegatsParAttaque + " points par dégats";
    }
}
