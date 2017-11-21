package Vistas;

import Atxy2k.CustomTextField.RestrictedTextField;
import coltime.Menu;
import java.awt.Color;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSNotifyAnimated;

public class Usuarios1 extends javax.swing.JPanel {

    public Usuarios1() {
        initComponents();
        estadoComponentes(false, new Color(244, 244, 244));
        btnGuardar.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        consultarUsuarios("", "", 0);
        btnActivar.setVisible(false);
        limites();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jpUser = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTApellidos = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jTdocumento = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jTNombre = new elaprendiz.gui.textField.TextFieldRoundBackground();
        cbTipo = new elaprendiz.gui.comboBox.ComboBoxRound();
        cBCargo = new elaprendiz.gui.comboBox.ComboBoxRound();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTdocumentoB = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jTNombreApellido = new elaprendiz.gui.textField.TextFieldRoundBackground();
        cBCargoB = new elaprendiz.gui.comboBox.ComboBoxRound();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTUsuario = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setBackground(new java.awt.Color(219, 219, 219));
        setToolTipText("usuarios");
        setName("usuarios"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(128, 128, 131)));

        jPanel2.setBackground(new java.awt.Color(244, 244, 244));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(128, 128, 131))); // NOI18N
        jPanel2.setLayout(new java.awt.CardLayout());

        jpUser.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(128, 128, 131));
        jLabel4.setText("Tipo de documente:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(128, 128, 131));
        jLabel2.setText("Apellidos:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setText("Numero de documento:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(128, 128, 131));
        jLabel5.setText("Cargo:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(128, 128, 131));
        jLabel1.setText("Nombres:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("*");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("*");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("*");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("*");

        jTApellidos.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTApellidos.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTApellidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTApellidosKeyTyped(evt);
            }
        });

        jTdocumento.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTdocumento.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTdocumento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTdocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTdocumentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTdocumentoKeyTyped(evt);
            }
        });

        jTNombre.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNombre.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombreKeyTyped(evt);
            }
        });

        cbTipo.setForeground(new java.awt.Color(102, 102, 102));
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "CE", "CC", "TI", " " }));
        cbTipo.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cBCargo.setForeground(new java.awt.Color(102, 102, 102));
        cBCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Gestor Comercial", "Encargado de FE y TE", "Encargado de EN", "Administrador", " " }));
        cBCargo.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cBCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Imagen");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 220));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setFocusable(false);
        btnNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_roll1.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel7.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 1, 54, 43));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_proyect.png"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_roll.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel7.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 1, 54, 43));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btnUpdate.setBorderPainted(false);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setFocusPainted(false);
        btnUpdate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update1.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel7.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 1, 54, 43));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setFocusPainted(false);
        btnDelete.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete1 (2).png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel7.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 0, 54, 43));
        btnDelete.getAccessibleContext().setAccessibleDescription("");

        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chek-user.png"))); // NOI18N
        btnActivar.setBorderPainted(false);
        btnActivar.setContentAreaFilled(false);
        btnActivar.setFocusPainted(false);
        btnActivar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chek-user1.png"))); // NOI18N
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });
        jPanel7.add(btnActivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 0, 54, 43));

        javax.swing.GroupLayout jpUserLayout = new javax.swing.GroupLayout(jpUser);
        jpUser.setLayout(jpUserLayout);
        jpUserLayout.setHorizontalGroup(
            jpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUserLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpUserLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))))
                .addGap(2, 2, 2)
                .addGroup(jpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpUserLayout.createSequentialGroup()
                        .addGroup(jpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addComponent(jLabel9))
                    .addComponent(jLabel5)
                    .addComponent(cBCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpUserLayout.setVerticalGroup(
            jpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUserLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpUserLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel12)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel11))
                    .addGroup(jpUserLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(jTdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(cBCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addGroup(jpUserLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(jTApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jpUser, "card2");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(128, 128, 131))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(128, 128, 131));
        jLabel6.setText("Nombres y apellidos:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setText("Numero de documento:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(128, 128, 131));
        jLabel8.setText("Cargo:");

        jTdocumentoB.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTdocumentoB.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTdocumentoB.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTdocumentoB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTdocumentoBKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTdocumentoBKeyTyped(evt);
            }
        });

        jTNombreApellido.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNombreApellido.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNombreApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTNombreApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombreApellidoKeyTyped(evt);
            }
        });

        cBCargoB.setForeground(new java.awt.Color(102, 102, 102));
        cBCargoB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccióne...", "Gestor Comercial", "Encargado de FE y TE", "Encargado de EN", "Administrador", "" }));
        cBCargoB.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cBCargoB.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cBCargoB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cBCargoBItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTdocumentoB, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTNombreApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cBCargoB, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTdocumentoB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTNombreApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(31, 31, 31))
                            .addComponent(cBCargoB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))
                            .addGap(31, 31, 31))))
                .addContainerGap())
        );

        jTUsuario = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jTUsuario.setAutoCreateRowSorter(true);
        jTUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTUsuario.setForeground(new java.awt.Color(128, 128, 131));
        jTUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nuero de documento", "Tipo documento", "Nombres", "Apellidos", "Cargo", "Imagen", "Estado"
            }
        ));
        jTUsuario.setFillsViewportHeight(true);
        jTUsuario.setFocusTraversalPolicyProvider(true);
        jTUsuario.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTUsuario.setMinimumSize(new java.awt.Dimension(0, 0));
        jTUsuario.setRequestFocusEnabled(false);
        jTUsuario.setRowHeight(17);
        jTUsuario.setSelectionBackground(new java.awt.Color(63, 179, 255));
        jTUsuario.setSelectionForeground(new java.awt.Color(244, 244, 244));
        jTUsuario.setShowHorizontalLines(false);
        jTUsuario.setShowVerticalLines(false);
        jTUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTUsuarioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTUsuario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        estadoComponentes(true, new Color(255, 255, 255));
        btnGuardar.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnDelete.setVisible(true);
        btnActivar.setVisible(false);
        btnActivar.setEnabled(false);
        btnNuevo.setEnabled(false);
        jTdocumento.setEnabled(true);
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        registrarMdificarUsuario(1, 1);
        consultarUsuarios("", "", 0);
        estadoComponentes(false, new Color(244, 244, 244));
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jTdocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTdocumentoKeyReleased
        if (!jTdocumento.getText().equals("") && jTdocumento.getText().length() >= 8 && jTdocumento.getText().length() <= 13) {
            btnGuardar.setEnabled(true);
            btnNuevo.setEnabled(false);
        } else {
            btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_jTdocumentoKeyReleased

    private void jTUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTUsuarioMouseClicked
        int users = jTUsuario.getRowCount();
        if (users > 0) {
            int fila = jTUsuario.getSelectedRow();
            estadoComponentes(true, new Color(255, 255, 255));
            jTdocumento.setText(jTUsuario.getValueAt(fila, 0).toString());
            cbTipo.setSelectedItem(jTUsuario.getValueAt(fila, 1).toString().toUpperCase());
            jTNombre.setText(jTUsuario.getValueAt(fila, 2).toString());
            jTApellidos.setText(jTUsuario.getValueAt(fila, 3).toString());
            cBCargo.setSelectedItem(jTUsuario.getValueAt(fila, 4).toString());
            if (jTUsuario.getValueAt(fila, 5) != null) {
                //Agregar la imagen al panel!!
            }
            if (jTUsuario.getValueAt(fila, 6).toString().equals("Activo")) {
                btnDelete.setEnabled(true);
                btnDelete.setVisible(true);
                btnActivar.setVisible(false);
                btnActivar.setEnabled(false);
                btnUpdate.setEnabled(true);
                btnUpdate.setVisible(true);
            } else {
                btnDelete.setEnabled(false);
                btnDelete.setVisible(false);
                btnActivar.setVisible(true);
                btnActivar.setEnabled(true);
                btnUpdate.setEnabled(false);
                btnUpdate.setVisible(true);
            }
            jTdocumento.setEnabled(false);
            btnNuevo.setEnabled(true);
        }
    }//GEN-LAST:event_jTUsuarioMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Seguro desea cambiar el estado de esta persona?,"
                + "\n"
                + " si lo cambia el usuario ya no podra interacturar con el sistema.") == 0) {
            Controlador.Usuario obj = new Controlador.Usuario();
            obj.setDocumento(jTdocumento.getText());
            if (obj.validarSiEstaActivo()) {
                new rojerusan.RSNotifyAnimated("Alerta!!", "El usuario esta logiado en el sistema de información.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
            }else{
                //Si el usuario no esta activo se podra cambiar el estado de la session.
                boolean res = obj.cambiar_Estado_Usuario(false);
                new rojerusan.RSNotifyAnimated("Listo!!", "El usuario con el documento:  " + jTdocumento.getText() + " se le cambio el estado a 'inactivo'.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                limpiar();
                btnDelete.setEnabled(false);
                btnUpdate.setEnabled(false);
                consultarUsuarios("", "", 0);
                estadoComponentes(false, new Color(244, 244, 244));
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTdocumentoBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTdocumentoBKeyReleased
        consultarUsuarios(jTdocumentoB.getText(), jTNombreApellido.getText(), cBCargoB.getSelectedIndex());
    }//GEN-LAST:event_jTdocumentoBKeyReleased

    private void jTNombreApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreApellidoKeyReleased
        consultarUsuarios(jTdocumentoB.getText(), jTNombreApellido.getText(), cBCargoB.getSelectedIndex());
    }//GEN-LAST:event_jTNombreApellidoKeyReleased

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Seguro desea volver activar esta persona?,"
                + "\n"
                + " si lo cambia el usuario ya podra interacturar con el sistema.") == 0) {
            Controlador.Usuario obj = new Controlador.Usuario();
            obj.setDocumento(jTdocumento.getText());
            boolean res = obj.cambiar_Estado_Usuario(true);
            new rojerusan.RSNotifyAnimated("Listo!!", "El usuario con el documento:  " + jTdocumento.getText() + " se le cambio el estado a 'Activo'.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            limpiar();
            btnDelete.setEnabled(false);
            btnDelete.setVisible(true);
            btnActivar.setVisible(false);
            btnActivar.setEnabled(false);
            btnUpdate.setEnabled(false);
            consultarUsuarios("", "", 0);
            estadoComponentes(false, new Color(244, 244, 244));
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        registrarMdificarUsuario(2, 1);
        jTdocumento.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        estadoComponentes(false, new Color(244, 244, 244));
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jTdocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTdocumentoKeyTyped
        soloNumero(evt);
    }//GEN-LAST:event_jTdocumentoKeyTyped

    private void jTNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyTyped
        soloLetras(evt);
    }//GEN-LAST:event_jTNombreKeyTyped

    private void jTApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTApellidosKeyTyped
        soloLetras(evt);
    }//GEN-LAST:event_jTApellidosKeyTyped

    private void jTNombreApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreApellidoKeyTyped
        soloLetras(evt);
    }//GEN-LAST:event_jTNombreApellidoKeyTyped

    private void jTdocumentoBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTdocumentoBKeyTyped
        soloNumero(evt);
    }//GEN-LAST:event_jTdocumentoBKeyTyped

    private void cBCargoBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cBCargoBItemStateChanged
        consultarUsuarios(jTdocumentoB.getText(), jTNombreApellido.getText(), cBCargoB.getSelectedIndex());
    }//GEN-LAST:event_cBCargoBItemStateChanged

    public void estadoComponentes(boolean estado, Color es) {
        jTdocumento.setEnabled(estado);
        jTNombre.setEnabled(estado);
        jTApellidos.setEnabled(estado);
        cbTipo.setEnabled(estado);
        cBCargo.setEnabled(estado);
        jpUser.setBackground(es);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnUpdate;
    private elaprendiz.gui.comboBox.ComboBoxRound cBCargo;
    private elaprendiz.gui.comboBox.ComboBoxRound cBCargoB;
    private elaprendiz.gui.comboBox.ComboBoxRound cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTApellidos;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTNombre;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTNombreApellido;
    private javax.swing.JTable jTUsuario;
    private javax.swing.JTable jTable1;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTdocumento;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTdocumentoB;
    private javax.swing.JPanel jpUser;
    // End of variables declaration//GEN-END:variables
 @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
//Metodos---------------------------------------------------------------------------------------------->

    public void registrarMdificarUsuario(int op, int estado) {
        if (cbTipo.getSelectedIndex() != 0 && cBCargo.getSelectedIndex() != 0 && !(jTNombre.getText().equals(""))) {
            Controlador.Usuario obj = new Controlador.Usuario();
            obj.setDocumento(jTdocumento.getText().trim());
            obj.setTipo(cbTipo.getSelectedItem().toString());
            obj.setNombres(jTNombre.getText());
            obj.setApellidos(jTApellidos.getText());
            obj.setCargo(cBCargo.getSelectedIndex());
            Boolean res = obj.registrar_Modificar_Usuario(op, estado);
            if (res) {
                if (op == 1) {
                    new rojerusan.RSNotifyAnimated("Listo!!", "El usuario fue registrado exitosamente", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                } else {
                    new rojerusan.RSNotifyAnimated("Listo!!", "El usuario fue modificado exitosamente", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                }
                limpiar();
                consultarUsuarios("", "", 0);
            } else {
                new rojerusan.RSNotifyAnimated("¡Alerta!", "La persona que intento registrar ya existe", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
            }
        } else {
            new rojerusan.RSNotifyAnimated("¡Error!", "Todos los campos con '*' son obligatorios.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }
    }

    public void limpiar() {
        jTdocumento.setText("");
        cbTipo.setSelectedIndex(0);
        jTNombre.setText("");
        jTApellidos.setText("");
        cBCargo.setSelectedIndex(0);
    }

    public void consultarUsuarios(String doc, String nomape, int cargo) {
        Controlador.Usuario obj = new Controlador.Usuario(doc, nomape, cargo);
        try {
            CachedRowSet crs = obj.consultar_Usuario();
            //Peparación de la tabla(jTUsuario) para insertar valores 
            String names[] = {"Numero de Documento", "Tipo documento", "Nombres", "Apellidos", "Cargo", "Imagen", "Estado"};
            DefaultTableModel ds = new DefaultTableModel(null, names);
            while (crs.next()) {
                //Filas de la tabla
                if (!crs.getString(1).equals(Menu.jDocumento.getText())) {
                    String v[] = new String[7];
                    v[0] = crs.getString(1);
                    v[1] = crs.getString(2);
                    v[2] = crs.getString(3);
                    v[3] = crs.getString(4);
                    v[4] = crs.getString(5);
                    v[5] = crs.getString(6);
                    v[6] = (crs.getString(7).equals("true") ? "Activo" : "Inactivo");
                    ds.addRow(v);
                }
            }
            jTUsuario.setModel(ds);
        } catch (Exception e) {
        }
        modifcarColumnas();
    }

    public void modifcarColumnas() {
        jTUsuario.getColumnModel().getColumn(0).setMinWidth(145);
        jTUsuario.getColumnModel().getColumn(0).setMaxWidth(145);
        jTUsuario.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(145);
        jTUsuario.getTableHeader().getColumnModel().getColumn(0).setMinWidth(145);
        jTUsuario.getColumnModel().getColumn(1).setMinWidth(100);
        jTUsuario.getColumnModel().getColumn(1).setMaxWidth(100);
        jTUsuario.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(100);
        jTUsuario.getTableHeader().getColumnModel().getColumn(1).setMinWidth(100);
        jTUsuario.getColumnModel().getColumn(2).setMinWidth(206);
        jTUsuario.getColumnModel().getColumn(2).setMaxWidth(206);
        jTUsuario.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(206);
        jTUsuario.getTableHeader().getColumnModel().getColumn(2).setMinWidth(206);
        jTUsuario.getColumnModel().getColumn(3).setMinWidth(206);
        jTUsuario.getColumnModel().getColumn(3).setMaxWidth(206);
        jTUsuario.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(206);
        jTUsuario.getTableHeader().getColumnModel().getColumn(3).setMinWidth(206);
        jTUsuario.getColumnModel().getColumn(4).setMinWidth(159);
        jTUsuario.getColumnModel().getColumn(4).setMaxWidth(159);
        jTUsuario.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(159);
        jTUsuario.getTableHeader().getColumnModel().getColumn(4).setMinWidth(159);
        jTUsuario.getColumnModel().getColumn(5).setMinWidth(0);
        jTUsuario.getColumnModel().getColumn(5).setMaxWidth(0);
        jTUsuario.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        jTUsuario.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        jTUsuario.getColumnModel().getColumn(6).setMinWidth(50);
        jTUsuario.getColumnModel().getColumn(6).setMaxWidth(50);
        jTUsuario.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(50);
        jTUsuario.getTableHeader().getColumnModel().getColumn(6).setMinWidth(50);
    }

    public void limites() {
        RestrictedTextField id1 = new RestrictedTextField(jTdocumento);
        id1.setLimit(13);
        RestrictedTextField id2 = new RestrictedTextField(jTdocumentoB);
        id2.setLimit(13);
        RestrictedTextField id3 = new RestrictedTextField(jTdocumento);
        id3.setLimit(30);
        RestrictedTextField id4 = new RestrictedTextField(jTNombre);
        id4.setLimit(30);
        RestrictedTextField id5 = new RestrictedTextField(jTNombre);
        id5.setLimit(30);
        RestrictedTextField id6 = new RestrictedTextField(jTNombreApellido);
        id6.setLimit(30);
    }

    public void soloLetras(java.awt.event.KeyEvent evt) {
        char cara = evt.getKeyChar();
        if (Character.isDigit(cara) || evt.getKeyChar() == '.' || evt.getKeyChar() == '-' || evt.getKeyChar() == '_' || evt.getKeyChar() == ',' || evt.getKeyChar() == '@') {
            evt.consume();
        }
    }

    public void soloNumero(java.awt.event.KeyEvent evt) {
        char cara = evt.getKeyChar();
        if (Character.isLetter(cara) || evt.getKeyChar() == '.' || evt.getKeyChar() == '-' || evt.getKeyChar() == '_' || evt.getKeyChar() == ',' || evt.getKeyChar() == '@') {
            evt.consume();
        }
    }
}
