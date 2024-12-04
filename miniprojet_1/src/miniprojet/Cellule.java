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

    public boolean isPresenceBombe() {
        return presenceBombe;
    }

    public boolean isDevoilee() {
        return devoilee;
    }
    

    public int getNbBombesAdjacentes() {
        return nbBombesAdjacentes;
    }
    public void placerBombe() {
        presenceBombe=true;
    }
    public void revelerCellule() {
        devoilee=true;
    }

    public void setNbBombesAdjacentes(int nbBombesAdjacentes) {
        this.nbBombesAdjacentes = nbBombesAdjacentes;
    }

    @Override
    public String toString() {
        String texte = "";
        if (!devoilee) { // Vérifie si la cellule n'est pas dévoilée
            texte = "?";
        } else {
            if (presenceBombe) { // Vérifie la présence d'une bombe
                texte = "B";
            } else {
                if (nbBombesAdjacentes == 0) {
                    texte =" ";
                }
                else texte =""+nbBombesAdjacentes+"";
               
            }
    }
    return texte;
}

    
}
