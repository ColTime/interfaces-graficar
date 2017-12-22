package Vistas;

import Controlador.DetalleProyecto;
import coltime.Menu;
import java.awt.Color;
import java.awt.Dimension;
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
    public detalleProduccion(java.awt.Frame parent, boolean modal, int orden, int negocio, int vistaC) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenesEmpresa/favicon.png")).getImage());
        this.orden = orden;
        this.negocio = negocio;
        this.vistaC = vistaC;
        if (vistaC == 1) {
            //Detalles del proyecto
            this.setTitle(String.valueOf(orden));
        } else if (vistaC == 2) {
            //Productos no conformes
            this.setTitle(String.valueOf(orden) + " - PNC");
        } else if (vistaC == 4) {
            //Proyecto en produccion
            this.setTitle(String.valueOf(orden) + " - Terminado");
        }
        consultarDetalleProyectoProduccion(vistaC);
    }
    //Variables
    static int orden = 0, negocio = 0;
    static CachedRowSet crs = null;
    int x = 0, y = 0, cantidad = 1;
    static boolean res = false;
    static int vistaC = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jDetalle = new javax.swing.JPanel();
        btnPNC = new elaprendiz.gui.button.ButtonColoredAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(632, 276));
        setMinimumSize(new java.awt.Dimension(632, 276));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jDetalle.setBackground(new java.awt.Color(255, 255, 255));
        jDetalle.setMaximumSize(new java.awt.Dimension(632, 276));
        jDetalle.setMinimumSize(new java.awt.Dimension(632, 276));
        jDetalle.setPreferredSize(new java.awt.Dimension(656, 263));

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
                .addContainerGap(510, Short.MAX_VALUE)
                .addComponent(btnPNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jDetalleLayout.setVerticalGroup(
            jDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDetalleLayout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(btnPNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jDetalle);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPNCActionPerformed
        Producciones obj1 = new Producciones();
        res = false;
        detalleProduccion obj = new detalleProduccion(obj1, true, orden, negocio, 2);
        if (res) {
            obj.btnPNC.setVisible(false);
            obj.setLocationRelativeTo(null);
            obj.setVisible(true);
        }
    }//GEN-LAST:event_btnPNCActionPerformed

    //Metodos
    private void consultarDetalleProyectoProduccion(int vistaC) {
        try {
            DetalleProyecto obj = new DetalleProyecto();
            crs = obj.consultarDetalleProyectoProduccion(orden, negocio, vistaC);
            agregarBotones(crs, vistaC);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!" + e);
        }
    }

    private void agregarBotones(CachedRowSet crs, int vistaC) {
        try {
            while (crs.next()) {
                res = true;
                JButton detalle = new JButton(crs.getString(2));
                detalle.setBounds(x, y, 126, 100);
                detalle.addActionListener(this);
                //Icono del boton
                ImageIcon icono = null;
                //No se esta utilizando la columna del tipo de producto
                switch (crs.getInt(3)) {
                    case 1:
                        //Por iniciar
                        icono = new ImageIcon("src\\produccion\\DetalleBegin.png");
                        break;
                    case 2:
                        //Pausado
                        icono = new ImageIcon("src\\produccion\\DetallePause.png");
                        break;
                    case 3:
                        //Terminado
                        icono = new ImageIcon("src\\produccion\\DetalleCheck.png");
                        break;
                    case 4:
                        //Ejecucion
                        icono = new ImageIcon("src\\produccion\\DetalleTime.png");
                        break;
                    default:
                        break;
                }
                Icon imagen = new ImageIcon(icono.getImage().getScaledInstance(detalle.getWidth() - 3, detalle.getHeight() - 3, Image.SCALE_DEFAULT));
                detalle.setIcon(imagen);
                //Texto del boton
                detalle.setActionCommand(crs.getString(1) + "-" + crs.getInt(4));
                detalle.setHorizontalTextPosition(JButton.CENTER);
                detalle.setFont(new Font("Tahoma", 1, 14));
                detalle.setForeground(Color.black);
                detalle.setContentAreaFilled(false);
                detalle.setBackground(Color.white);
                jDetalle.add(detalle);
                if (cantidad == 5) {//////////////////////////////////////////
                    y = 99;
                    x = 0;
                    jDetalle.setPreferredSize(new Dimension(633, jDetalle.getHeight() + x));
                } else {
                    x += 127;
                }
                cantidad += 1;
            }
            if (vistaC == 2 && res == false) {
                JOptionPane.showMessageDialog(null, " Este proyecto no tiene PNC ");
            } else {
                jDetalle.updateUI();
            }
            crs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!" + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String detalle[] = e.getActionCommand().split("-");
        int id = Integer.parseInt(detalle[0]);
        int negocio = Integer.parseInt(detalle[1]);
        Producciones obj1 = new Producciones();
        int permiso;
        if ((Menu.cargo == 3 || Menu.cargo == 2)) {
            permiso = 1;
        } else {
            if (this.vistaC != 4) {
                permiso = 0;
            } else {
                permiso = 1;
            }
        }
        detalleProyecto obj = new detalleProyecto(obj1, true, id, negocio, String.valueOf(orden), permiso);
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
                detalleProduccion dialog = new detalleProduccion(new javax.swing.JFrame(), true, 0, 0, 0);
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
    public static javax.swing.JPanel jDetalle;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
@Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
