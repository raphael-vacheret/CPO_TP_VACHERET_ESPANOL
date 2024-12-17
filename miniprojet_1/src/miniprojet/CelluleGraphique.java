package miniprojet;
import java.awt.Graphics;
import javax.swing.JButton;
import miniprojet.Cellule;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bapti
 */
public class CelluleGraphique extends JButton {
    int x;
    int y;
    Cellule celluleassocié;

    
    public CelluleGraphique(int x, int y, Cellule celluleassocié) {
        this.x = x;
        this.y = y;
        this.celluleassocié = celluleassocié;
    }

    /*@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        this.setText("?");
        /*PROBLEME ICI 
    }
    */
    public boolean presenceBombe;
    public boolean devoilee;
    public int nbBombesAdjacentes;

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
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Mise à jour du texte en fonction de l'état de la cellule
    if (!celluleassocié.isDevoilee()) {
        this.setText("..."); // Cellule non dévoilée
    } else if (celluleassocié.isPresenceBombe()) {
        this.setText("B"); // Bombe
    } else {
        int nbBombesAdjacentes = celluleassocié.getNbBombesAdjacentes();
        this.setText(nbBombesAdjacentes == 0 ? "" : String.valueOf(nbBombesAdjacentes));
    }
}
}
    


