package miniprojet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrateur
 */
public class Cellule {
    private boolean presenceBombe;
    private boolean devoilee;
    private int nbBombesAdjacentes;
    private int revellee;

    public boolean isPresenceBombe() {
        return presenceBombe;
    }

    public boolean isDevoilee() {
        return devoilee;
    }

    public void setDevoilee(boolean devoilee) {
        this.devoilee = devoilee;
    }

    public int getRevellee() {
        return revellee;
    }

    public void setRevellee(int revellee) {
        this.revellee = revellee;
    }
    

    public int getNbBombesAdjacentes() {
        return nbBombesAdjacentes;
    }
    public void placerBombe() {
        presenceBombe=true;
    }
    public void RevelerCellule() {
        devoilee=true;
    }

    public void setNbBombesAdjacentes(int nbBombesAdjacentes) {
        this.nbBombesAdjacentes = nbBombesAdjacentes;
    }

    @Override
    public String toString() {
        
        if (!devoilee) { // Vérifie si la cellule n'est pas dévoilée
            return "?";
        } else {
            if (presenceBombe) { // Vérifie la présence d'une bombe
                return "B";
            } else {
                if (this.nbBombesAdjacentes >0) {
                    return String.valueOf(this.nbBombesAdjacentes);
                }
                else return " ";
               
            }
    }
    
}

    
}
