package aston.wow.poo;

import java.util.ArrayList;
import java.util.List;

public class Sacoche {
    //public List<Arme> arme = new ArrayList<>();
    //public List<Bouclier> bouclier = new ArrayList<>();
    //public List<Nourriture> nourriture = new ArrayList<>();

    private Arme arme;
    private Bouclier bouclier;
    private Nourriture nourriture;
    private List<Object> sacoche = new ArrayList<>();

    public Sacoche(Arme arme) {
        this.arme = arme;
    }

    public Sacoche(Arme arme, Nourriture nourriture) {
        this.arme = arme;
        this.nourriture = nourriture;
    }

    public Sacoche(Arme arme, Bouclier bouclier, Nourriture nourriture) {
        this.arme = arme;
        this.bouclier = bouclier;
        this.nourriture = nourriture;
    }

    @Override
    public String toString() {
        String string = " + ";
        for(Object o: sacoche) {
            string += o;
            System.out.println(o.getClass().getSimpleName());
        }
        return string;
    }

    public void ajouterObjet(Object objet) {
        sacoche.add(objet);
       /* if(objet == arme) {
            sacoche.add(arme);
            System.out.println(arme.nom + " a été ajouté dans votre sacoche");
        } else if(objet == bouclier) {
            sacoche.add(bouclier);
            System.out.println(bouclier.nom + " a été ajouté dans votre sacoche");
        } else if(objet == nourriture) {
            sacoche.add(bouclier);
            System.out.println(nourriture.nom + " a été ajouté dans votre sacoche");
        }*/
    }


    public boolean aUnObjet(Object objet) {
        switch (objet.getClass().getSimpleName()) {
            case "Bouclier":
                if (sacoche.indexOf(bouclier) > 0) {
                    return true;
                }
                break;
            case "Nourriture":
                if (sacoche.indexOf(nourriture) > 0 && nourriture.reccuperation > 0) {
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    public void supprimerNourriture() {
        if(nourriture.reccuperation < 1) {
            int inourriture = sacoche.indexOf(nourriture);
            sacoche.remove(inourriture);
        }
    }

    public Arme getArme() {
        return arme;
    }

    public Object selectionnerArme(String nom) {
        for (Object o: sacoche) {
            if(o == arme && arme.nom == nom ) {
                return o;
            }
        }
        return arme;
    }

    public Bouclier getBouclier() {
        return bouclier;
    }

    public Nourriture getNourriture() {
        return nourriture;
    }

    public List<Object> getSacoche() {
        return sacoche;
    }

}
