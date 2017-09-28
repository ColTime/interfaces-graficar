package Vistas;

import java.awt.Color;

public class proyecto extends javax.swing.JPanel {

    public proyecto() {
        initComponents();
        cambiarEstadoFalso();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPInformacion = new javax.swing.JPanel();
        jTNorden = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel3 = new javax.swing.JLabel();
        jTNombreCliente = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTNombreProyecto = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPDetalles1 = new javax.swing.JPanel();
        jTLexan = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jCLexan = new javax.swing.JCheckBox();
        jTConversor = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jTTroquel = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jTRepujado = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jTStencil = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jCConversor = new javax.swing.JCheckBox();
        jTPCBFE = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jCRepujado = new javax.swing.JCheckBox();
        jTPCBTE = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel8 = new javax.swing.JLabel();
        jCTroquel = new javax.swing.JCheckBox();
        jCPCBFE = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jCPCBTE = new javax.swing.JCheckBox();
        jCStencil = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cbMaterialPCBFE = new elaprendiz.gui.comboBox.ComboBoxRound();
        cbMaterialPCBTE = new elaprendiz.gui.comboBox.ComboBoxRound();
        jPDetalles = new javax.swing.JPanel();
        jDentrega = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jDIngreso = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jCAntisolder = new javax.swing.JCheckBox();
        jCRuteo = new javax.swing.JCheckBox();
        cbNegocio = new elaprendiz.gui.comboBox.ComboBoxRound();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbTipo = new elaprendiz.gui.comboBox.ComboBoxRound();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(219, 219, 219));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setName("proyectos"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(128, 128, 131)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Proyecto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(128, 128, 131))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPInformacion.setBackground(new java.awt.Color(255, 255, 255));
        jPInformacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Información filtraria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        jTNorden.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNorden.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setText(" Orden °N:");

        jTNombreCliente.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNombreCliente.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(128, 128, 131));
        jLabel5.setText("Nombre del cliente:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("*");

        jTNombreProyecto.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNombreProyecto.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(128, 128, 131));
        jLabel4.setText("Nombre del proyecto:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("*");

        javax.swing.GroupLayout jPInformacionLayout = new javax.swing.GroupLayout(jPInformacion);
        jPInformacion.setLayout(jPInformacionLayout);
        jPInformacionLayout.setHorizontalGroup(
            jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTNorden, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPInformacionLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPInformacionLayout.setVerticalGroup(
            jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNorden, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.add(jPInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 430, 180));

        jPDetalles1.setBackground(new java.awt.Color(255, 255, 255));
        jPDetalles1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        jTLexan.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTLexan.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jCLexan.setBackground(new java.awt.Color(255, 255, 255));
        jCLexan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCLexan.setForeground(new java.awt.Color(102, 102, 102));
        jCLexan.setText("Lexan");

        jTConversor.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTConversor.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jTTroquel.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTTroquel.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jTRepujado.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTRepujado.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jTStencil.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTStencil.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jCConversor.setBackground(new java.awt.Color(255, 255, 255));
        jCConversor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCConversor.setForeground(new java.awt.Color(102, 102, 102));
        jCConversor.setText("Conversor");

        jTPCBFE.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTPCBFE.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jCRepujado.setBackground(new java.awt.Color(255, 255, 255));
        jCRepujado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCRepujado.setForeground(new java.awt.Color(102, 102, 102));
        jCRepujado.setText("Repujado");

        jTPCBTE.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTPCBTE.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(128, 128, 131));
        jLabel8.setText("Cantidades:");

        jCTroquel.setBackground(new java.awt.Color(255, 255, 255));
        jCTroquel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTroquel.setForeground(new java.awt.Color(102, 102, 102));
        jCTroquel.setText("Troquel");

        jCPCBFE.setBackground(new java.awt.Color(255, 255, 255));
        jCPCBFE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCPCBFE.setForeground(new java.awt.Color(102, 102, 102));
        jCPCBFE.setText("PCB FE");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(128, 128, 131));
        jLabel9.setText("Otras ordenes:");

        jCPCBTE.setBackground(new java.awt.Color(255, 255, 255));
        jCPCBTE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCPCBTE.setForeground(new java.awt.Color(102, 102, 102));
        jCPCBTE.setText("PCB TE");

        jCStencil.setBackground(new java.awt.Color(255, 255, 255));
        jCStencil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCStencil.setForeground(new java.awt.Color(102, 102, 102));
        jCStencil.setText("Stencil");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(128, 128, 131));
        jLabel22.setText("Material de la PCB TE:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(128, 128, 131));
        jLabel23.setText("Material de la PCB FE:");

        cbMaterialPCBFE.setForeground(new java.awt.Color(102, 102, 102));
        cbMaterialPCBFE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "TH", "FV" }));
        cbMaterialPCBFE.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbMaterialPCBFE.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        cbMaterialPCBTE.setForeground(new java.awt.Color(102, 102, 102));
        cbMaterialPCBTE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "TH", "FV" }));
        cbMaterialPCBTE.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbMaterialPCBTE.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPDetalles1Layout = new javax.swing.GroupLayout(jPDetalles1);
        jPDetalles1.setLayout(jPDetalles1Layout);
        jPDetalles1Layout.setHorizontalGroup(
            jPDetalles1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDetalles1Layout.createSequentialGroup()
                .addGap(0, 74, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbMaterialPCBFE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(cbMaterialPCBTE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(jPDetalles1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPDetalles1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDetalles1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(10, 10, 10)
                        .addComponent(jCConversor)
                        .addGap(11, 11, 11)
                        .addComponent(jCTroquel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCRepujado)
                        .addGap(3, 3, 3)
                        .addComponent(jCStencil)
                        .addGap(19, 19, 19)
                        .addComponent(jCPCBFE)
                        .addGap(17, 17, 17)
                        .addComponent(jCPCBTE)
                        .addGap(15, 15, 15)
                        .addComponent(jCLexan))
                    .addGroup(jPDetalles1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addGap(8, 8, 8)
                        .addComponent(jTConversor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jTTroquel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jTRepujado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jTStencil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jTPCBFE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jTPCBTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jTLexan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPDetalles1Layout.setVerticalGroup(
            jPDetalles1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDetalles1Layout.createSequentialGroup()
                .addGroup(jPDetalles1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDetalles1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9))
                    .addComponent(jCConversor)
                    .addComponent(jCTroquel)
                    .addComponent(jCRepujado)
                    .addComponent(jCStencil)
                    .addComponent(jCPCBFE)
                    .addComponent(jCPCBTE)
                    .addComponent(jCLexan))
                .addGap(5, 5, 5)
                .addGroup(jPDetalles1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jTConversor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTTroquel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTRepujado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTStencil, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPCBFE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPCBTE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTLexan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPDetalles1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDetalles1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(cbMaterialPCBFE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPDetalles1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(cbMaterialPCBTE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.add(jPDetalles1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 820, 130));

        jPDetalles.setBackground(new java.awt.Color(255, 255, 255));
        jPDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(128, 128, 131));
        jLabel10.setText("Fecha de entraga:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(128, 128, 131));
        jLabel11.setText("¿Lleva antisolder?");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(128, 128, 131));
        jLabel16.setText("¿Lleva ruteo?");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("*");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(128, 128, 131));
        jLabel18.setText("Fecha de ingreso:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("*");

        jCAntisolder.setBackground(new java.awt.Color(255, 255, 255));
        jCAntisolder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCAntisolder.setForeground(new java.awt.Color(102, 102, 102));
        jCAntisolder.setText("A");

        jCRuteo.setBackground(new java.awt.Color(255, 255, 255));
        jCRuteo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCRuteo.setForeground(new java.awt.Color(102, 102, 102));
        jCRuteo.setText("R");

        cbNegocio.setForeground(new java.awt.Color(102, 102, 102));
        cbNegocio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "FE", "TE", "IN", "FE/TE", "FE/IN", "FE/TE/IN" }));
        cbNegocio.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbNegocio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setText("Negocio:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("*");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setText("*");

        cbTipo.setForeground(new java.awt.Color(102, 102, 102));
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Normal", "RQT", "Quick" }));
        cbTipo.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbTipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(128, 128, 131));
        jLabel21.setText("Tipo de proyecto:");

        javax.swing.GroupLayout jPDetallesLayout = new javax.swing.GroupLayout(jPDetalles);
        jPDetalles.setLayout(jPDetallesLayout);
        jPDetallesLayout.setHorizontalGroup(
            jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDetallesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDetallesLayout.createSequentialGroup()
                        .addComponent(cbNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPDetallesLayout.createSequentialGroup()
                        .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPDetallesLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jCAntisolder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCRuteo))
                            .addGroup(jPDetallesLayout.createSequentialGroup()
                                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPDetallesLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18))
                                    .addGroup(jPDetallesLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPDetallesLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))
                                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPDetallesLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(17, 17, 17))))
        );
        jPDetallesLayout.setVerticalGroup(
            jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDetallesLayout.createSequentialGroup()
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDentrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPDetallesLayout.createSequentialGroup()
                        .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPDetallesLayout.createSequentialGroup()
                        .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCRuteo)
                        .addComponent(jLabel16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCAntisolder)
                        .addComponent(jLabel11))))
        );

        jPanel2.add(jPDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 370, 180));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel5.setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_Proyect.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_prpyect_roll.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(2, 2, 57, 45);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_proyect.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_roll.png"))); // NOI18N
        jPanel5.add(jButton3);
        jButton3.setBounds(59, 0, 57, 45);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_roll.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);
        jButton2.setBounds(118, 2, 57, 45);

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
        jPanel5.add(btnUpdate);
        btnUpdate.setBounds(175, 2, 57, 45);

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
        jPanel5.add(btnActivar);
        btnActivar.setBounds(232, 0, 57, 45);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setFocusPainted(false);
        btnDelete.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete1 (2).png"))); // NOI18N
        jPanel5.add(btnDelete);
        btnDelete.setBounds(232, 0, 57, 45);

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 292, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ConsutaProyecto().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActivarActionPerformed
//Metodos-------------------------------------------------------------------->
    private void cambiarEstadoFalso(){
        jPInformacion.setBackground( new Color(244, 244, 244));
        jPDetalles1.setBackground( new Color(244, 244, 244));
        jPDetalles1.setBackground( new Color(244, 244, 244));
        jTNorden.setEnabled(false);
        jTNombreCliente.setEnabled(false);
        jTNombreProyecto.setEnabled(false);
        jDIngreso.setEnabled(false);
        jDentrega.setEnabled(false);
        cbNegocio.setEnabled(false);
        cbTipo.setEnabled(false);
        jCAntisolder.setEnabled(false);
        jCRuteo.setEnabled(false);
        jCConversor.setEnabled(false);
        jTConversor.setEnabled(false);
        jCTroquel.setEnabled(false);
        jTTroquel.setEnabled(false);
        jCRepujado.setEnabled(false);
        jTRepujado.setEnabled(false);
        jCStencil.setEnabled(false);
        jTStencil.setEnabled(false);
        jCPCBFE.setEnabled(false);
        jTPCBFE.setEnabled(false);
        jCPCBTE.setEnabled(false);
        jTPCBTE.setEnabled(false);
        cbMaterialPCBFE.setEnabled(false);
        cbMaterialPCBTE.setEnabled(false);
        jCLexan.setEnabled(false);
        jTLexan.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private elaprendiz.gui.comboBox.ComboBoxRound cbMaterialPCBFE;
    private elaprendiz.gui.comboBox.ComboBoxRound cbMaterialPCBTE;
    private elaprendiz.gui.comboBox.ComboBoxRound cbNegocio;
    private elaprendiz.gui.comboBox.ComboBoxRound cbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCAntisolder;
    private javax.swing.JCheckBox jCConversor;
    private javax.swing.JCheckBox jCLexan;
    private javax.swing.JCheckBox jCPCBFE;
    private javax.swing.JCheckBox jCPCBTE;
    private javax.swing.JCheckBox jCRepujado;
    private javax.swing.JCheckBox jCRuteo;
    private javax.swing.JCheckBox jCStencil;
    private javax.swing.JCheckBox jCTroquel;
    private com.toedter.calendar.JDateChooser jDIngreso;
    private com.toedter.calendar.JDateChooser jDentrega;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPDetalles;
    private javax.swing.JPanel jPDetalles1;
    private javax.swing.JPanel jPInformacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTConversor;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTLexan;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTNombreCliente;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTNombreProyecto;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTNorden;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTPCBFE;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTPCBTE;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTRepujado;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTStencil;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTTroquel;
    // End of variables declaration//GEN-END:variables
}
