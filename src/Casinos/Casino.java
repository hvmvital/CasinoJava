package Casinos;

import Joueurs.Joueur;
import Jeux.Jeu;

public class Casino {

    private String nom;
    private Joueur joueurs[];
    private int joueursPresents;
    private Jeu jeu;

    public Casino() {
        this("", 0);
    }

    public Casino(String nom, int nbJoueursMax) {
        this.nom = nom;
        jeu = new Jeu();
        joueursPresents = 0;
        joueurs = new Joueur[nbJoueursMax];

    }

    public Casino(Casino autre) {
        this(autre.nom, autre.joueurs.length);
        joueursPresents = autre.joueursPresents;
        
        for (int i = 0; i < joueursPresents; i++) {
            this.joueurs[i] = autre.joueurs[i];
        }
    }

    public boolean equals(Casino autre) {
        if (this.nom.equals(autre.nom) && this.jeu.equals(autre.jeu)) {
            return true;
        }
        return false;
    }

    public boolean ajouterJoueur(Joueur joueur) {
        if (joueur.getCapital() >= 100) {
            if (this.joueursPresents >= this.joueurs.length) {
                System.out.println("Désolé " + joueur.getNom() + ", le casino est plein!");
                return false;
            } else {
                this.joueurs[this.joueursPresents] = joueur;
                this.joueursPresents++;
                return true;
            }
        } else {
            System.out.println(joueur.getNom() + ", il faut au moins 100$ pour entrer au casino.");
        }
        return false;
    }

    public void enleverJoueur(Joueur joueur) {

        for (int i = 0; i < (this.joueursPresents); i++) {
            if (this.joueurs[i].equals(joueur)) {
                for (int j = i; j < (this.joueursPresents); j++) {
                    if (j != this.joueursPresents - 1) {
                        this.joueurs[j] = this.joueurs[j + 1];
                    } else {
                        this.joueurs[j] = null;
                    }
                }
                this.joueursPresents--;
                joueur.quitterCasino();
                System.out.println(joueur.getNom() + " a quitté le casino.");
                return;
            }
        }
        System.out.println("Désolé! " + joueur.getNom() + " ne peut pas quitter car il n'est pas dans le casino!");
    }

    public String toString() {
        String listeJoueur = "";
        for (int i = 0; i < joueursPresents; i++) {
            if (i == joueursPresents - 1) {
                listeJoueur += joueurs[i].getNom();
            } else {
                listeJoueur += joueurs[i].getNom() + ", ";
            }
        }

        String chaine;
        if (joueursPresents <= 1) {
            chaine = "Bienvenue au Casino " + this.nom + "!\nIl y a " + joueursPresents + " joueur présent.";
        } else {
            chaine = "Bienvenue au Casino " + this.nom + "!\nIl y a " + joueursPresents + " joueurs présents.";
        }
        if (joueursPresents > 0) {

            chaine += "\nVoici la liste: " + listeJoueur + ".";
        }
        return chaine;
    }

    public void jouer(Joueur joueur, int mise) {

        joueur.setCapital(joueur.getCapital() - mise);
        int gains = jeu.calculerGains(mise);
        joueur.setCapital(joueur.getCapital() + gains);
    }

    public int getJoueursPresents() {
        return joueursPresents;
    }

    public void setJoueursPresents(int joueursPresents) {
        this.joueursPresents = joueursPresents;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(Joueur[] joueurs) {
        this.joueurs = joueurs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
