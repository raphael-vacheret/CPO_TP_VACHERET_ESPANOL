/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet;
import java.util.Random;
import miniprojet.Cellule;
/**
 *
 * @author Administrateur
 */
public class GrilleDeJeu {
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
        Random random= new Random();
        for (int i=0;i<nbBombes;i++) {   
            int h= random.nextInt(nbColonnes);
            int l= random.nextInt(nbLignes);
            if (matrice[h][l].isPresenceBombe()==true) {
                i--;
            }
            else {
                matrice[h][l].placerBombe();
            }
        }
    }
    public void calculerBombesAdjacentes() {
        int BombesAdjacentes=0;
        for (int i=0;i<nbColonnes;i++) {
            for (int j=0;j<nbLignes;j++) {
                if(matrice[i][j].isPresenceBombe()==false) {
                    for (int h=i-1;h<i+1;h++) {
                        for (int l=j-1;l<j+1;l++) {
                            if (h>0) {
                                if (l>0) {
                                    if (matrice[i][j].isPresenceBombe()==true) {
                                        BombesAdjacentes++;
                                    }
                                }
                            }
                        }
                    }    
                }
            matrice[i][j].setNbBombesAdjacentes(BombesAdjacentes);
            }
        }
        
    }
    public void revelerCellule(int ligne, int colonne) {
        matrice[ligne][colonne].revelerCellule();
        if(matrice[ligne][colonne].isPresenceBombe()==true) {
            //fin de la partie
        }
        else {
            if (matrice[ligne][colonne].getNbBombesAdjacentes()==0) {
                for (int h=ligne-1;h<ligne+1;h++) {
                    for (int l=colonne-1;l<colonne+1;l++) {
                        matrice[ligne][colonne].revelerCellule();                           
                    }
                }                    
            }
        }
    }
}
