package aston.wow.poo;

public class Personnage {
    protected int pointDeVie;
    protected String nom;
    protected Arme arme;
    protected String type;
    protected int endurance;
    private Sacoche sacoche;

    public Personnage(int pointDeVie, String nom, Arme arme, String type, int endurance) {
        this.pointDeVie = pointDeVie;
        this.nom = nom;
        this.arme = arme;
        this.type = type;
        this.endurance = endurance;
    }

    @Override
    public String toString() {
        return nom + " est un " + type + ", a comme arme " + arme + " et " + pointDeVie + " points de vie";
    }

    public void equiperArme(String nom, Sacoche sacoche) {
        arme = (Arme) sacoche.selectionnerArme(nom);
    }

    public void attaquer(Personnage adversaire) {

        if(pointDeVie > 0 && adversaire.pointDeVie > 0) {
            adversaire.pointDeVie -= arme.pointsDeDegatsParAttaque;
            adversaire.endurance -= (arme.longueur*arme.poids)/10000;
            System.out.println(nom + " a attaqué " + adversaire.nom);
        }
    }

    public void recevoirDesDegats(Personnage adversaire) {
        System.out.println(nom + " a reçu un coup en perdant " + adversaire.arme.pointsDeDegatsParAttaque + " points, il lui reste " + pointDeVie + " points de vie");
    }

    public void seDefendre(Personnage adversaire) {
        if(sacoche.getSacoche().contains(sacoche.getBouclier())){
            Bouclier bouclier = sacoche.getBouclier();
            if(endurance >= adversaire.arme.pointsDeDegatsParAttaque/2){
                endurance -= (bouclier.poids/1000);
                pointDeVie -= (adversaire.arme.pointsDeDegatsParAttaque - bouclier.ped);
                System.out.println(nom + " s'est defendu contre " + adversaire.nom + " et il lui reste " + endurance + " points en endurance.");
            }
        }
    }

    public void manger() {
        if(sacoche.getSacoche().contains(sacoche.getNourriture())){
            Nourriture nourriture = sacoche.getNourriture();
            endurance += nourriture.reccuperation;
            nourriture.reccuperation = 0;
            sacoche.supprimerNourriture();
            System.out.println(nom + " a mangé un(e) " + sacoche.getNourriture().nom + " il a désormais comme endurance " + endurance);
        }
    }

    public void setSacoche(Sacoche sacoche) {
        this.sacoche = sacoche;
    }
}
