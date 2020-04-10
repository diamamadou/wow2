package aston.wow.poo;

public class Main {

    public static void main(String[] args) {
        System.out.println("------------WOW-------------");

        // Armes

        Arme epee = new Arme("excalibur", 5, 70, 1000);
        Arme gourdin = new Arme("L'abatoir", 3, 65, 2000);

        //Personnages
        Personnage heros1 = new Personnage(30, "Arthur", epee,"heros", 36);
        Personnage monstre1 = new Personnage(14, "Grum", gourdin,"monstre", 100);
        Personnage heros2 = new Personnage(7, "Art", epee,"heros", 50);
        Personnage monstre2 = new Personnage(14, "Gru", gourdin,"monstre", 70);
        Personnage heros3 = new Personnage(3, "Thur", epee,"heros", 90);
        Personnage monstre3 = new Personnage(60, "Rum", gourdin,"monstre", 100);

        //Nourriture
        Nourriture pomme = new Nourriture("pomme", 6, 250);
        Nourriture banane = new Nourriture("banane", 7, 230);

        //Bouclier
        Bouclier bouclier1 = new Bouclier("Bouclier 1", 2, 500);
        Bouclier bouclier2 = new Bouclier("Bouclier 2", 5, 500);

        //Sacoche
        Sacoche sacoche1 = new Sacoche(epee, bouclier1, pomme);
        Sacoche sacoche2 = new Sacoche(gourdin, bouclier2, banane);

        System.out.println("----------------------");
        System.out.println(heros1.toString());
        System.out.println(monstre1.toString());
        System.out.println(heros2.toString());
        System.out.println(monstre2.toString());
        System.out.println(heros3.toString());
        System.out.println(monstre3.toString());

        System.out.println("---------Sacoche-------------");
        sacoche1.ajouterObjet(pomme);
        sacoche1.ajouterObjet(bouclier1);

        sacoche2.ajouterObjet(banane);
        sacoche2.ajouterObjet(bouclier2);

        heros1.setSacoche(sacoche1);
        monstre1.setSacoche(sacoche2);
        heros2.setSacoche(sacoche1);
        monstre2.setSacoche(sacoche2);
        heros3.setSacoche(sacoche1);
        monstre3.setSacoche(sacoche2);

        System.out.println();

        System.out.println("-----------Equipes-----------");
        Equipe equipeHeros = new Equipe("heros");
        Equipe equipeMonstre = new Equipe("monstres");

        equipeHeros.ajouterJoueur(heros1);
        equipeHeros.ajouterJoueur(heros2);
        equipeHeros.ajouterJoueur(heros3);

        equipeMonstre.ajouterJoueur(monstre1);
        equipeMonstre.ajouterJoueur(monstre2);
        equipeMonstre.ajouterJoueur(monstre3);

        System.out.println("-----------Combat-----------");

        Jeu jeu = new Jeu();
        System.out.println(jeu.combattre(equipeHeros, equipeMonstre));

    }
}
