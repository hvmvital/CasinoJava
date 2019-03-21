package Main;

import Joueurs.Joueur;
import Casinos.Casino;

public class TestCasino {

    public static void main(String[] args) {

        Casino casino = new Casino("Casino Rosemont", 2);
        Joueur joueur1 = new Joueur("Steeve", 1000);
        Joueur joueur2 = new Joueur("Sylvain", 1000);
        Joueur joueur3 = new Joueur("Emilie", 100);
        System.out.println("-----------------");
        System.out.println("Test ajout de joueurs");
        System.out.println("-----------------");
        joueur1.joindreCasino(casino);
        joueur2.joindreCasino(casino);
        joueur3.joindreCasino(casino);
        
        System.out.println("-----------------");
        System.out.println("Test jouer au jeu, joueur dans un Casino");
        System.out.println("-----------------");

        System.out.println(joueur1);
        joueur1.jouer(100);
        System.out.println(joueur1);
        
        System.out.println("-----------------");
        System.out.println("Test jouer au jeu, joueur dans aucun Casino");
        System.out.println("-----------------");
        
        System.out.println("-----------------");
        System.out.println("Test quitterCasino, joueur dans un Casino");
        System.out.println("-----------------");
        System.out.println(casino);
        joueur1.quitterCasino();
        System.out.println(casino);
        
        
        System.out.println("-----------------");
        System.out.println("Test quitterCasino, joueur dans aucun Casino");
        System.out.println("-----------------");
        joueur3.quitterCasino();

    }
}
