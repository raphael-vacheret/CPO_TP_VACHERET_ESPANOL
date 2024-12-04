package miniprojet;
import java.util.Random;
/**
 *
 * @author Administrateur
 */
public class GrilleDeJeu {
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;
    private int victoire=0;
    private Cellule[][] matrice = new Cellule[nbLignes][nbColonnes];

    GrilleDeJeu(int nbLignes, int nbColonnes, int nbBombes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nbBombes = nbBombes;
        this.matrice = new Cellule[nbLignes][nbColonnes];
        
        // Initialisation des cellules
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matrice[i][j] = new Cellule();
            }
        }
    }

    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbBombes() {
        return nbBombes;
    }

    public void setVictoire(int victoire) {
        this.victoire = victoire;
    }

    public int getVictoire() {
        return victoire;
    }
    
    

    public void setNbLignes(int nbLignes) {
        this.nbLignes = nbLignes;
    }

    public void setNbColonnes(int nbColonnes) {
        this.nbColonnes = nbColonnes;
    }

    public void setNbBombes(int nbBombes) {
        this.nbBombes = nbBombes;
    }
    
    
    public void placerBombesAleatoirement(){
        Random random= new Random();
        for (int i=0;i<nbBombes;i++) {   
            int h= random.nextInt(nbColonnes);
            int l= random.nextInt(nbLignes);
            if (matrice[h][l].isPresenceBombe()) {
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
                            if (h>0 && h<nbLignes) {
                                if (l>0 && l<nbColonnes) {
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
        if (matrice[ligne][colonne].isDevoilee()) {
            System.out.println("vous avez deja devoillee cette case veuillez en choisir une autre ");
            return;
        }
        matrice[ligne][colonne].revelerCellule();
        if(matrice[ligne][colonne].isPresenceBombe()==true) {
            victoire=1;
        }
        else {
            if (matrice[ligne][colonne].getNbBombesAdjacentes()==0) {
                for (int h=ligne-1;h<ligne+1;h++) {
                    for (int l=colonne-1;l<colonne+1;l++) {
                        if (l>=0 && l<nbColonnes) {
                            if (h>=0 && h<nbLignes) {
                                this.revelerCellule(h,l);
                                
                            }
                        }
                           
                    }
                } 
            }
            
        }
    }
    public boolean getPresenceBombe(int i, int j)  {
        return matrice[i][j].isPresenceBombe()==true;
    }
    public boolean toutesCellulesRevelees() {
        for (int i=0;i<nbColonnes;i++) {
            for (int j=0;j<nbLignes;j++) {
                if (matrice[i][j].isPresenceBombe()==false || matrice[i][j].isDevoilee()==false) {
                    return false;
                }
            }
        }
        victoire=2;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                sb.append(matrice[i][j].toString()).append(" ");
           }
            sb.append("\n"); // Nouvelle ligne après chaque ligne de la matrice
        }
        return sb.toString();
    }

    
}
