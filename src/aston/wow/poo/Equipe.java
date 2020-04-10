package aston.wow.poo;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    public String nom;
    public List<Personnage> liste = new ArrayList<Personnage>();

    public Equipe(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Equipe de " + nom;
    }

    public void ajouterJoueur(Personnage personnage) {
        if(liste.size() <= 4 && nom == "heros") {
            liste.add(personnage);
            System.out.println(personnage.nom + " a été ajouté dans l'équie héros");
        } else if(liste.size() <= 4 && nom == "monstres") {
            liste.add(personnage);
            System.out.println(personnage.nom + " a été ajouté dans l'équie monstre");
        } else {
            System.out.println("L'équipe est pleine / ce joeur ne peut pas etre ajouté à cette équipe");
        }
    }

    public List<Personnage> getEquipe() {
        return liste;
    }

    public Personnage joueurCombat(int i) {
        return liste.get(i);
    }
}
