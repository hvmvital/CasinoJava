package Jeux;

import Casinos.Casino;
import Joueurs.Joueur;

public class Jeu {

    private String nom;

    public Jeu() {
        this("");
    }

    public Jeu(String nom) {
        this.nom = nom;
    }

    public Jeu(Jeu autre) {
        this.nom = autre.nom;
    }

    public boolean equals(Jeu autre) {
        if (this.nom.equals(autre.nom)) {
            return true;
        }
        return false;
    }

    public String toString() {
        String chaine;
        chaine = "\nLes règles du jeu Pile ou Face sont simples:\nPar défaut, "
                + "le joueur prend face, donc si le casino affiche face, vous doublez votre mise.";
        return chaine;
    }

    public int calculerGains(int mise) {
        //Assumons que pile vaut 0 et que le joueur prend toujours face.
        int pileOuFace = (int) (2 * Math.random());
        if (pileOuFace == 0) {
            return mise * 2;
        } else {
            return 0;
        }

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
