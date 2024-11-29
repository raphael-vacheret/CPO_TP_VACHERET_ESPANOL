/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

/**
 *
 * @author Administrateur
 */
public class partie {
    GrilleDeJeu grille;
    public void initialiserPartie(int n) {
        if (n<1 || n>3) {
            System.out.print("erreur 404");
        }
        else switch (n) {
            case 1 -> {
                grille.setNbBombes(10);
                grille.setNbColonnes(10);
                grille.setNbLignes(8);
            }
            case 2 -> {
                grille.setNbBombes(40);
                grille.setNbColonnes(18);
                grille.setNbLignes(14);
            }
            case 3 -> {
                grille.setNbBombes(99);
                grille.setNbColonnes(20);
                grille.setNbLignes(20);
            }
            
        }
    }
    public void tourDeJeu(int ligne, int colonne) {
        
    }
    public void verifierVictoire() {
        if (grille.toutesCellulesRevelees()) {
            System.out.print("vous avez gagne bien joue");
        }
        
    }
    public void demarrerPartie() {
        
    }
}
