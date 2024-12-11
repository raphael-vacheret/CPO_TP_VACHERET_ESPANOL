/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

import java.util.Scanner;

public class Partie {
    private final Scanner sc = new Scanner(System.in);
    private GrilleDeJeu grille;

    public void initialiserPartie(int n) {
        int nbLignes=0, nbColonnes=0, nbBombes=0;

        if (n < 1 || n > 3) {
            System.out.println("Erreur : difficulté invalide !");
            return;
        }

        switch (n) {
            case 1 -> { // Facile
                nbLignes = 9;
                nbColonnes = 9;
                nbBombes = 10;
            }
            case 2 -> { // Moyenne
                nbLignes = 16;
                nbColonnes = 16;
                nbBombes = 40;
            }
            case 3 -> { // Difficile
                nbLignes = 20;
                nbColonnes = 20;
                nbBombes = 99;
            }
        }

        // Initialisation de la grille avec les paramètres
        this.grille = new GrilleDeJeu(nbLignes, nbColonnes, nbBombes);
        this.grille.placerBombesAleatoirement();
        this.grille.calculerBombesAdjacentes();

        System.out.println("Grille initialisée avec succès !");
    }

    public void tourDeJeu(int ligne, int colonne) {
        if (grille == null) {
            System.out.println("La partie n'a pas été initialisée. Veuillez choisir une difficulté.");
            return;
        }

        if (ligne < 0 || ligne >= grille.getNbLignes() || colonne < 0 || colonne >= grille.getNbColonnes()) {
            System.out.println("Coordonnées invalides, veuillez réessayer.");
            return;
        }

        grille.revelerCellule(ligne, colonne);

        // Vérification si une bombe a été révélée
        if (grille.getPresenceBombe(ligne, colonne)) {
            System.out.println("BOOM ! Vous avez perdu.");
            grille.setVictoire(1); // Marque la partie comme perdue
        } else if (grille.toutesCellulesRevelees()) {
            System.out.println("Félicitations, vous avez gagné !");
            grille.setVictoire(2); // Marque la partie comme gagnée
        }
    }

    public boolean verifierVictoire() {
        
        if (grille.getVictoire() == 2) { // Partie gagnée
            System.out.println("Vous avez déjà gagné !");
            return true;
        }

        if (grille.getVictoire() == 1) { // Partie perdue
            System.out.println("Vous avez déjà perdu !");
            return true;
        }

        return false;
    }

    public void demarrerPartie() {
        System.out.println("Bonjour, bienvenue sur le super démineur !");
        System.out.println("Quelle difficulté voulez-vous choisir ?");
        System.out.println("1 : Facile");
        System.out.println("2 : Moyenne");
        System.out.println("3 : Difficile");

        int difficulte = sc.nextInt();
        this.initialiserPartie(difficulte);

        if (grille == null) {
            System.out.println("La partie n'a pas pu être initialisée.");
            return;
        }

        while (!verifierVictoire()) {
            System.out.println(grille); // Affiche la grille actuelle
            System.out.println("Veuillez entrer une case à dévoiler (ligne puis colonne) :");
            int ligne = sc.nextInt();
            int colonne = sc.nextInt();

            this.tourDeJeu(ligne, colonne);
        }

        System.out.println("Merci d'avoir joué !");
                   System.out.println(grille);
    }
}

