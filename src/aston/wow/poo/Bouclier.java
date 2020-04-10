package aston.wow.poo;

public class Bouclier {
    protected String nom;
    protected int ped;
    protected double poids;

    public Bouclier() {
        super();
    }

    public Bouclier(String nom, int ped, double poids) {
        this.nom = nom;
        this.ped = ped;
        this.poids = poids;
    }

    @Override
    public String toString() {
        return nom + " est un bouclier de poids " + poids + " de " + ped + " points d'encaissements de dégats";
    }


}
