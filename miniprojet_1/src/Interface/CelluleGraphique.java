package Interface;


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
public class CelluleGraphique extends JButton{
    int x;
    int y;
    Cellule celluleassocié;

    public CelluleGraphique(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        setText("?");
    }
    
    
}
