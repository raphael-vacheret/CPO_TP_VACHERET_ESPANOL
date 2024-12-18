package miniprojet;
import java.util.Random;
import javax.swing.JPanel;
import miniprojet.Cellule;
import miniprojet.fenetrePrincipale;
/**
 *
 * @author Administrateur
 */
public class GrilleDeJeu {
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;
    private boolean victoire;
    private int nbVie;
   
    public Cellule[][] matrice /*= new Cellule[nbLignes][nbColonnes]*/;

    GrilleDeJeu(int nbLignes, int nbColonnes, int nbBombes,int nbVie) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nbBombes = nbBombes;
        this.nbVie = nbVie;
        
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

    public void setVictoire(boolean victoire) {
        this.victoire = victoire;
    }

    public boolean getVictoire() {
        return victoire;
    }

    public int getNbVie() {
        return nbVie;
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
            int h= random.nextInt(nbLignes);
            int l= random.nextInt(nbColonnes);
            if (matrice[h][l].isPresenceBombe()) {
                i--;
            }
            else {
                matrice[h][l].placerBombe();
            }
        }
    }
    public void calculerBombesAdjacentes() {
        
        for (int i=0;i<nbLignes;i++) {
            for (int j=0;j<nbColonnes;j++) {
                int BombesAdjacentes=0;
                if(matrice[i][j].isPresenceBombe()==false) {
                    for (int h=i-1;h<=1+i;h++) {
                        for (int l=j-1;l<=j+1;l++) {
                            if (h>=0 && h<nbLignes && l>=0 && l<nbColonnes) {
                                    if (matrice[h][l].isPresenceBombe()==true) {
                                        BombesAdjacentes++;
                                    }
                                
                            }
                        }
                    }
                }
            matrice[i][j].setNbBombesAdjacentes(BombesAdjacentes);
            }
        }
        
    }
    public void revelCellule(int ligne, int colonne) {
        if (matrice[ligne][colonne].isDevoilee()){           
            return;
        
        }
        matrice[ligne][colonne].revelerCellule();
        
        /*CelluleGraphique bouton_cellule = (CelluleGraphique) PanneauGrille.getComponentAt(colonne* bouton_cellule.getWidth(), ligne*bouton_cellule.getHeight());
        bouton_cellule.repaint();*/
        
        if(matrice[ligne][colonne].isPresenceBombe()==true) {
            //victoire=1;
            nbVie=nbVie-1;
        }
        
            if (matrice[ligne][colonne].getNbBombesAdjacentes()==0) {
                
                for (int l=colonne-1;l<=colonne+1;l++) {
                    for (int h=ligne-1;h<=ligne+1;h++) {
                        if (h>=0 && h<nbLignes && l>=0 && l<nbColonnes) {
                            if (!matrice[h][l].isDevoilee()){
                                revelCellule(h, l);                                
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
        for (int i=0;i<nbLignes;i++) {
            for (int j=0;j<nbColonnes;j++) {
                if (matrice[i][j].isPresenceBombe() || matrice[i][j].isDevoilee()) {
                    victoire=true;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cellule[] matrice1 : matrice) {
            for (Cellule matrice11 : matrice1) {
                sb.append(matrice11.toString()).append(" ");
            }
            sb.append("\n"); // Nouvelle ligne après chaque ligne de la matrice
        }
        return sb.toString();
    }

    
}
