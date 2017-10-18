/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.DetalleProyecto;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sql.rowset.CachedRowSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Aprendiz
 */
public class detalleProduccion extends javax.swing.JDialog implements ActionListener {

    /**
     * Creates new form detalleProduccion
     */
    public detalleProduccion(java.awt.Frame parent, boolean modal, int orden, int negocio) {
        super(parent, modal);
        initComponents();
        this.orden = orden;
        this.negocio = negocio;
        consultarDetalleProyectoProduccion();
    }
    //Variables
    static int orden = 0, negocio = 0;
    static CachedRowSet crs = null;
    int x = 0, y = 0, cantidad = 0;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDetalle = new javax.swing.JPanel();
        btnPNC = new elaprendiz.gui.button.ButtonColoredAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(635, 254));

        jDetalle.setBackground(new java.awt.Color(255, 255, 255));

        btnPNC.setText("PNC");
        btnPNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPNCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDetalleLayout = new javax.swing.GroupLayout(jDetalle);
        jDetalle.setLayout(jDetalleLayout);
        jDetalleLayout.setHorizontalGroup(
            jDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDetalleLayout.createSequentialGroup()
                .addContainerGap(509, Short.MAX_VALUE)
                .addComponent(btnPNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDetalleLayout.setVerticalGroup(
            jDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDetalleLayout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addComponent(btnPNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPNCActionPerformed
      
    }//GEN-LAST:event_btnPNCActionPerformed

    //Metodos
    private void consultarDetalleProyectoProduccion() {
        try {
            DetalleProyecto obj = new DetalleProyecto();
            crs = obj.consultarDetalleProyectoProduccion(orden, negocio);
            agregarBotones(crs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!" + e);
        }
    }

    private void agregarBotones(CachedRowSet crs) {
        try {
            while (crs.next()) {
                JButton detalle = new JButton(crs.getString(2));
                detalle.setName(String.valueOf(crs.getInt(1)));
                detalle.setBounds(x, y, 110, 98);
                detalle.addActionListener(this);
                //Icono del boton
                ImageIcon icono = new ImageIcon("src\\img\\detalle.png");
                Icon imagen = new ImageIcon(icono.getImage().getScaledInstance(detalle.getWidth() - 5, detalle.getHeight() - 5, Image.SCALE_DEFAULT));
                detalle.setIcon(imagen);
                //Texto del boton
                detalle.setActionCommand(crs.getString(1));
                detalle.setHorizontalTextPosition(JButton.CENTER);
                detalle.setFont(new Font("Tahoma", 1, 14));
                detalle.setForeground(Color.black);
                detalle.setContentAreaFilled(false);
                detalle.setBackground(Color.white);
                jDetalle.add(detalle);
                jDetalle.updateUI();
                if (cantidad == 8) {
                    y = 99;
                    x = 0;
                } else {
                    x += 111;
                }
                cantidad += 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error!"+ e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int detalle=Integer.parseInt(e.getActionCommand());
        Producciones obj1=new Producciones();
        detalleProyecto obj=new detalleProyecto(obj1, true,detalle , negocio);
        obj.setVisible(true);
        obj.setLocationRelativeTo(this);
    }

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
            java.util.logging.Logger.getLogger(detalleProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detalleProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detalleProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detalleProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                detalleProduccion dialog = new detalleProduccion(new javax.swing.JFrame(), true, 0, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static elaprendiz.gui.button.ButtonColoredAction btnPNC;
    private javax.swing.JPanel jDetalle;
    // End of variables declaration//GEN-END:variables

}
