/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miniprojet;

import java.util.Scanner;

/**
 *
 * @author Administrateur
 */
public class Miniprojet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        partie jeu=null;
        System.out.println("Bonjour, bienvenue sur le super demineur quelle difficulté voulez-vous choisir ?");
        System.out.println("1:difficulte facile");
        System.out.println("2:difficulte moyenne");
        System.out.println("3:difficulte difficile");
        Scanner sc = new Scanner(System.in);
        int str = sc.nextInt();
        System.out.println("Vous avez saisi la difficulte numero "+str);
        jeu.initialiserPartie(str);
        while (jeu.verifierVictoire()==false) {
            while (jeu.grille.getVictoire()==0) {
                System.out.println("veuillez choisir une case (colonne puis ligne)");
                int x = sc.nextInt();
                int y = sc.nextInt();
                jeu.grille.revelerCellule(y, x);
            }
        }
    }
    
}
