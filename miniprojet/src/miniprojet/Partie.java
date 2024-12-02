/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

import java.util.Scanner;

public class Partie {
    private GrilleDeJeu grille;
    private int vies; // Nombre de vies du joueur
    private final Scanner sc = new Scanner(System.in);

    /**
     * Initialise une nouvelle partie avec la difficulté choisie
     */
    public void initialiserPartie() {
        System.out.println("Bienvenue dans le démineur !");
        System.out.println("Choisissez une difficulté :");
        System.out.println("1 : Facile (10 bombes, 3 vies)");
        System.out.println("2 : Moyenne (40 bombes, 2 vies)");
        System.out.println("3 : Difficile (99 bombes, 1 vie)");

        int choix = sc.nextInt();
        int nbLignes = 0, nbColonnes = 0, nbBombes = 0;

        switch (choix) {
            case 1 -> { // Facile
                nbLignes = 8;
                nbColonnes = 10;
                nbBombes = 10;
                vies = 3;
            }
            case 2 -> { // Moyenne
                nbLignes = 14;
                nbColonnes = 18;
                nbBombes = 40;
                vies = 2;
            }
            case 3 -> { // Difficile
                nbLignes = 20;
                nbColonnes = 20;
                nbBombes = 99;
                vies = 1;
            }
            default -> {
                System.out.println("Difficulté invalide, veuillez relancer le jeu.");
                return;
            }
        }

        // Initialisation de la grille
        grille = new GrilleDeJeu(nbLignes, nbColonnes, nbBombes);
        grille.placerBombesAleatoirement();
        grille.calculerBombesAdjacentes();

        System.out.println("Partie initialisée avec succès !");
    }

    /**
     * Gère un tour de jeu pour une cellule spécifiée
     *
     * @param ligne ligne choisie par le joueur
     * @param colonne colonne choisie par le joueur
     */
    public void tourDeJeu(int ligne, int colonne) {
        if (ligne < 0 || ligne >= grille.getNbLignes() || colonne < 0 || colonne >= grille.getNbColonnes()) {
            System.out.println("Coordonnées invalides, veuillez réessayer.");
            return;
        }

        if (grille.getPresenceBombe(ligne, colonne)) {
            System.out.println("BOOM ! Vous avez touché une bombe.");
            vies--;
            if (vies <= 0) {
                System.out.println("Vous avez perdu toutes vos vies. GAME OVER.");
                grille.setVictoire(1); // Partie perdue
            } else {
                System.out.println("Il vous reste " + vies + " vies.");
            }
        } else {
            grille.revelerCellule(ligne, colonne);
            if (grille.toutesCellulesRevelees()) {
                System.out.println("Félicitations, vous avez gagné !");
                grille.setVictoire(2); // Partie gagnée
            }
        }
    }

    /**
     * Vérifie si le joueur a gagné ou perdu
     *
     * @return vrai si la partie est terminée, faux sinon
     */
    public boolean verifierVictoire() {
        int etat = grille.getVictoire();
        if (etat == 2) {
            System.out.println("Victoire : toutes les cellules sûres ont été révélées !");
            return true;
        } else if (etat == 1) {
            System.out.println("Défaite : vous avez explosé !");
            return true;
        }
        return false;
    }

    /**
     * Boucle principale permettant d'exécuter une partie
     */
    public void demarrerPartie() {
        initialiserPartie();
        if (grille == null) {
            return;
        }

        while (!verifierVictoire()) {
            System.out.println(grille); // Affiche l'état actuel de la grille
            System.out.println("Options :");
            System.out.println("1 : Révéler une cellule");
            System.out.println("2 : Afficher le nombre de vies restantes");
            System.out.print("Votre choix : ");
            int choix = sc.nextInt();

            switch (choix) {
                case 1 -> {
                    System.out.print("Entrez la ligne : ");
                    int ligne = sc.nextInt();
                    System.out.print("Entrez la colonne : ");
                    int colonne = sc.nextInt();
                    tourDeJeu(ligne, colonne);
                }
                case 2 -> System.out.println("Vies restantes : " + vies);
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
        System.out.println("Merci d'avoir joué !");
    }
}

