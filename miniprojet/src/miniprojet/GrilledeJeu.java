/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;

/**
 *
 * @author bapti
 */
public class GrilledeJeu {
    
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;
    private Cellule[][] matrice = new Cellule[nbLignes][nbColonnes];

    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbBombes() {
        return nbBombes;
    }
    
    public void placerBombesAleatoirement(){
        
    }
}
