package aston.wow.poo;
import java.util.concurrent.ThreadLocalRandom;

public class Jeu {

    public Jeu(){
    }

    /**
     *
     * @param personnage1
     * @param personnage2
     * @return
     */

    public String combat(Personnage personnage1, Personnage personnage2) {
        String message = "";
        while(true) {

            if(personnage1.pointDeVie > 0 && personnage2.pointDeVie > 0) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);
                // 0: manger
                // 1: attaquer
                // 2: se défendre

                if(randomNum == 0) {
                    personnage1.manger();
                } else if(randomNum == 1) {
                    personnage1.attaquer(personnage2);
                    personnage2.recevoirDesDegats(personnage1);
                } else if(randomNum == 2) {
                    personnage1.seDefendre(personnage2);
                }

            } else {
                break;
            }
            if (personnage1.pointDeVie > 0 && personnage2.pointDeVie > 0) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);

                if(randomNum == 0) {
                    personnage2.manger();
                } else if (randomNum == 1) {
                    personnage2.attaquer(personnage1);
                    personnage1.recevoirDesDegats(personnage2);
                } else if (randomNum == 2) {
                    personnage2.seDefendre(personnage1);
                }
            } else {
                break;
            }
        }
        if(personnage1.pointDeVie <= 0) {
            message = personnage2.type;
        } else if(personnage2.pointDeVie <= 0) {
            message = personnage1.type;
        }
        return message;
    }

    public String combattre(Equipe heros, Equipe monstres) {
        int comptH = 0;
        int comptM = 0;

        for(int i = 0; i < heros.getEquipe().size(); i++) {
            String annonceVictoire = "";
            String cimetiere = "";
            Personnage iheros = heros.joueurCombat(i);
            Personnage monstre = monstres.joueurCombat(i);

            int randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);

            if(randomNum == 0) {
                String message = combat(iheros, monstre);
                if(message == "heros") {
                    comptH++;
                    cimetiere = monstre.nom + " est au cimetiere";
                    System.out.println("");
                    System.out.println(cimetiere);
                    System.out.println("");
                } else {
                    comptM++;
                    cimetiere = iheros.nom + " est au cimetiere";
                    System.out.println("");
                    System.out.println(cimetiere);
                    System.out.println("");
                }
            } else if(randomNum == 1) {
                String message = combat(monstre, iheros);
                if(message == "montre") {
                    comptM++;
                    cimetiere = iheros.nom + " est au cimetiere";
                    System.out.println("");
                    System.out.println(cimetiere);
                    System.out.println("");
                } else {
                    comptH++;
                    cimetiere = monstre.nom + " est au cimetiere";
                    System.out.println("");
                    System.out.println(cimetiere);
                    System.out.println("");
                }
            }
        }
        if(comptH>comptM) {
            System.out.println("");
            System.out.println("----------Fin du combat----------");
            return "L'équipe des héros a gagné :)";
        } else if(comptH<comptM) {
            System.out.println("");
            System.out.println("----------Fin du combat----------");
            return "L'équipe des montres a gagné :)";
        }
        return  "";
    }
}