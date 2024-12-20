package miniprojet;

import miniprojet.CelluleGraphique;
import miniprojet.Cellule;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JButton;
import miniprojet.GrilleDeJeu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author bapti
 */
public class fenetrePrincipale extends javax.swing.JFrame {
    private final Scanner sc = new Scanner(System.in);
    private GrilleDeJeu grille;

    /**
     * Creates new form fenetrePrincipale
     */
    public fenetrePrincipale() {
        initComponents();
        int nbLignes = 8;
        int nbColonnes =10;
        /*PanneauGrille = new javax.swing.JPanel();*/ 
        int nbBombes= 10;
        int nbVie=3;
        this.grille = new GrilleDeJeu(nbLignes, nbColonnes, nbBombes, nbVie);
        
        initialiserPartie();
        
        
        PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));
        
            for (int i=0; i < nbLignes; i++) {
                for (int j=0; j < nbColonnes; j++ ) {
                    final int l = i;
                    final int k = j;
                    CelluleGraphique bouton_cellule = new CelluleGraphique(i,j,grille.matrice[i][j]); // création d'un bouton
                    PanneauGrille.add(bouton_cellule); // ajout au Jpanel PanneauGrille
                
                
                    bouton_cellule.addActionListener(evt -> {
                   
                        grille.revelCellule(l,k);
                        PanneauGrille.repaint();
                    
                        if (bouton_cellule.celluleassocié.isPresenceBombe()) {
                            
                            System.out.println("Bombe ! vous perdez une vie.");
                        } else {
                            System.out.println("Cellule sûre : " + bouton_cellule.celluleassocié.getNbBombesAdjacentes() + " bombes adjacentes.");
                        }
                        
                        // Vérifie si la partie est terminée ou si la victoire est atteinte
                        if (grille.getNbVie() <= 0) {
                            Perdue();
                        } else if (grille.toutesCellulesRevelees()) {
                            MessageDeVictoire ();
                            
                        }
                    });
                }
            }
            PanneauGrille.revalidate();
            PanneauGrille.repaint();
    }
    public void initialiserPartie() {
        grille.placerBombesAleatoirement();
        grille.calculerBombesAdjacentes();
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 400, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new fenetrePrincipale().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauGrille;
    // End of variables declaration//GEN-END:variables

    public void MessageDeVictoire (){
        MessageVictoire M= new MessageVictoire();
        M.setVisible(true);
        dispose();
    }
    public void Perdue (){
        Perdue P= new Perdue();
        P.setVisible(true);
        dispose();
    }

}






