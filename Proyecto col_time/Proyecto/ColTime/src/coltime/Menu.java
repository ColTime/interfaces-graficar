package coltime;

import Controlador.ConexionPS;
import Controlador.DetalleProyecto;
import Controlador.FE_TE_IN;
import Controlador.Proyecto;
import Controlador.generarXlsx;
import Vistas.CambiarContraseña;
import Vistas.ControlDelTiempo;
import Vistas.Producciones;
import Vistas.Inicio;
import Vistas.Procesos;
import Vistas.Usuarios1;
import Vistas.proyecto;
import Vistas.proyecto1;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import javax.sql.rowset.CachedRowSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import paneles.CambiaPanel;
import rojerusan.RSNotifyAnimated;

public class Menu extends javax.swing.JFrame implements Runnable {

    public Color cor = new Color(189, 189, 189);
    public Color corF = new Color(219, 219, 219);
    public static Producciones bp = null;
    private int longitudByte;
    int cont = 0;
    static int soloUnaVez = 0;
    ConexionPS CPS = null;

    public Menu(int cargo) {
        initComponents();
        this.cargo = cargo;
        Animacion.Animacion.mover_derecha(935, 1135, 0, 2, jPanel3);
        new CambiaPanel(jPContenido, new Inicio());
        btn1.setColorHover(cor);
        btn1.setColorNormal(cor);
        btn1.setColorPressed(cor);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenesEmpresa/favicon.png")).getImage());
        this.setLocationRelativeTo(null);
        funcionalidades(cargo);
        EnCasodeFallaDeLuz();
        InformacionAreasProduccion();
        new rojerusan.RSNotifyAnimated("Bienvenido", "Nombre del empleado", 6, RSNotifyAnimated.PositionNotify.BottomLeft, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
        soloUnaVez++;
        //Toma de tiempos automatica
        if (cargo == 2 || cargo == 3) {
            if (soloUnaVez == 1) {
                Thread tomaTiempo = new Thread(this);
                tomaTiempo.start();
            }
        }
        //Fin de toma de tiempos automatica
    }

    public Menu() {

    }
    //Variables en uso de la clase
    private int posX = 0;
    private int posY = 0;
    private FileInputStream strem;//Sirve para convertir la images a bit's
    public static int cargo = 0;
    public static ControlDelTiempo producF = null;
    public static ControlDelTiempo producT = null;
    public static ControlDelTiempo producE = null;
    int px = 0, cantidad = 0, unidad = 13;
    int py = 0, filas = 1;
    CachedRowSet crs = null;
    CambiarContraseña obj = null;
    public static PrintStream myPS;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPSuperior = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDocumento = new javax.swing.JLabel();
        jDocumento1 = new javax.swing.JLabel();
        jDocumento2 = new javax.swing.JLabel();
        jPMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rSUsuario = new rojerusan.RSFotoCircle();
        btn2 = new rsbuttom.RSButtonMetro();
        btn1 = new rsbuttom.RSButtonMetro();
        btn4 = new rsbuttom.RSButtonMetro();
        btn3 = new rsbuttom.RSButtonMetro();
        btn5 = new rsbuttom.RSButtonMetro();
        btn6 = new rsbuttom.RSButtonMetro();
        jPContenido = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        FIngresadosHoy = new javax.swing.JLabel();
        FTerminadosHoy = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        FEjecucion = new javax.swing.JLabel();
        FPorIniciar = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TIngresadosHoy = new javax.swing.JLabel();
        TTerminadosHoy = new javax.swing.JLabel();
        TEjecucion = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        TPorIniciar = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        EIngresadosHoy = new javax.swing.JLabel();
        ETerminadosHoy = new javax.swing.JLabel();
        EEjecucion = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        EPorIniciar = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        AIngresadosHoy = new javax.swing.JLabel();
        ATerminadosHoy = new javax.swing.JLabel();
        Ajecucion = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenuItem3.setText("Actualizar");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(1140, 700));
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(138, 138, 138)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPSuperior.setBackground(new java.awt.Color(63, 179, 255));
        jPSuperior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPSuperiorMouseDragged(evt);
            }
        });
        jPSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPSuperiorMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPSuperiorMouseReleased(evt);
            }
        });

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        btnMenu.setBorderPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.setFocusPainted(false);
        btnMenu.setRequestFocusEnabled(false);
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus1.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jDocumento.setText("jLabel1");

        jDocumento1.setText("Linea");

        jDocumento2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDocumento2.setText(".");

        javax.swing.GroupLayout jPSuperiorLayout = new javax.swing.GroupLayout(jPSuperior);
        jPSuperior.setLayout(jPSuperiorLayout);
        jPSuperiorLayout.setHorizontalGroup(
            jPSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSuperiorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPSuperiorLayout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jDocumento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPSuperiorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDocumento2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDocumento1)))
                .addGap(209, 209, 209))
        );
        jPSuperiorLayout.setVerticalGroup(
            jPSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSuperiorLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPSuperiorLayout.createSequentialGroup()
                        .addGroup(jPSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jDocumento)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jDocumento1)
                            .addComponent(jDocumento2)))))
        );

        jPMenu.setBackground(new java.awt.Color(219, 219, 219));
        jPMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(219, 219, 219));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSUsuario.setColorBordePopu(new java.awt.Color(204, 204, 204));
        rSUsuario.setColorButtonOptions(new java.awt.Color(128, 128, 131));
        rSUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSUsuarioMouseClicked(evt);
            }
        });
        jPanel4.add(rSUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, 110, 100));

        jPMenu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 110));

        btn2.setForeground(new java.awt.Color(128, 128, 131));
        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/market.png"))); // NOI18N
        btn2.setText("PROYECTOS");
        btn2.setBorderPainted(false);
        btn2.setColorHover(new java.awt.Color(189, 189, 189));
        btn2.setColorNormal(new java.awt.Color(219, 219, 219));
        btn2.setColorPressed(new java.awt.Color(189, 189, 189));
        btn2.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn2.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn2.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn2.setFocusable(false);
        btn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPMenu.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 152, 190, 42));

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        btn1.setText(" INICIO");
        btn1.setAutoscrolls(true);
        btn1.setBorderPainted(false);
        btn1.setColorHover(new java.awt.Color(189, 189, 189));
        btn1.setColorNormal(new java.awt.Color(219, 219, 219));
        btn1.setColorPressed(new java.awt.Color(189, 189, 189));
        btn1.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn1.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn1.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn1.setDefaultCapable(false);
        btn1.setFocusable(false);
        btn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPMenu.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 190, 42));

        btn4.setForeground(new java.awt.Color(128, 128, 131));
        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/collection.png"))); // NOI18N
        btn4.setText("PRODUCCIÓN");
        btn4.setBorderPainted(false);
        btn4.setColorHover(new java.awt.Color(189, 189, 189));
        btn4.setColorNormal(new java.awt.Color(219, 219, 219));
        btn4.setColorPressed(new java.awt.Color(189, 189, 189));
        btn4.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn4.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn4.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn4.setFocusable(false);
        btn4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPMenu.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 236, 190, 42));

        btn3.setForeground(new java.awt.Color(128, 128, 131));
        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconmonstr-user-8-32.png"))); // NOI18N
        btn3.setText("USUARIOS");
        btn3.setBorderPainted(false);
        btn3.setColorHover(new java.awt.Color(189, 189, 189));
        btn3.setColorNormal(new java.awt.Color(219, 219, 219));
        btn3.setColorPressed(new java.awt.Color(189, 189, 189));
        btn3.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn3.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn3.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn3.setFocusable(false);
        btn3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPMenu.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 194, 190, 42));

        btn5.setForeground(new java.awt.Color(128, 128, 131));
        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes.png"))); // NOI18N
        btn5.setText("REPORTES");
        btn5.setBorderPainted(false);
        btn5.setColorHover(new java.awt.Color(189, 189, 189));
        btn5.setColorNormal(new java.awt.Color(219, 219, 219));
        btn5.setColorPressed(new java.awt.Color(189, 189, 189));
        btn5.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn5.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn5.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn5.setFocusable(false);
        btn5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPMenu.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 190, 42));

        btn6.setForeground(new java.awt.Color(128, 128, 131));
        btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes.png"))); // NOI18N
        btn6.setText("PROCESOS");
        btn6.setBorderPainted(false);
        btn6.setColorHover(new java.awt.Color(189, 189, 189));
        btn6.setColorNormal(new java.awt.Color(219, 219, 219));
        btn6.setColorPressed(new java.awt.Color(189, 189, 189));
        btn6.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn6.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn6.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn6.setFocusable(false);
        btn6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPMenu.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 278, 190, 42));

        jPContenido.setLayout(new javax.swing.BoxLayout(jPContenido, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setName("holaa"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        jPContenido.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(219, 219, 219));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel3MouseReleased(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(63, 179, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel6MouseReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Formato Estándar");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel3MouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("P.ingresados hoy:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("P. Terminados hoy:");

        jLabel10.setText("---------------------------------");

        FIngresadosHoy.setText("0");

        FTerminadosHoy.setText("0");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setText("P. Ejecucion:");

        FEjecucion.setText("0");

        FPorIniciar.setText("0");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel26.setText("P. por iniciar:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FTerminadosHoy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(FIngresadosHoy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel10))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FPorIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(FIngresadosHoy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(FTerminadosHoy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(FEjecucion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(FPorIniciar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Teclados");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("P.ingresados hoy:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setText("P. Terminados hoy:");

        jLabel11.setText("---------------------------------");

        TIngresadosHoy.setText("0");

        TTerminadosHoy.setText("0");

        TEjecucion.setText("0");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel22.setText("P. Ejecucion:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel27.setText("P. por iniciar:");

        TPorIniciar.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TIngresadosHoy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TTerminadosHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TPorIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TIngresadosHoy))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TTerminadosHoy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(TEjecucion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(TPorIniciar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ensamble");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel7MouseReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("P.ingresados hoy:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setText("P. Terminados hoy:");

        jLabel12.setText("---------------------------------");

        EIngresadosHoy.setText("0");

        ETerminadosHoy.setText("0");

        EEjecucion.setText("0");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel24.setText("P. Ejecucion:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel29.setText("P. por iniciar:");

        EPorIniciar.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EIngresadosHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ETerminadosHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EPorIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(EIngresadosHoy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ETerminadosHoy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(EEjecucion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(EPorIniciar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Almacen");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel18MouseReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel19.setText("P.ingresados hoy:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel20.setText("P. Terminados hoy:");

        jLabel21.setText("---------------------------------");

        AIngresadosHoy.setText("0");

        ATerminadosHoy.setText("0");

        Ajecucion.setText("0");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel25.setText("P. Ejecucion:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AIngresadosHoy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ATerminadosHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Ajecucion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(AIngresadosHoy))
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(ATerminadosHoy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(Ajecucion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        getContentPane().add(jPanel1, "card2");

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setForeground(new java.awt.Color(153, 153, 153));

        jMenu1.setText("Cuenta");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/password.png"))); // NOI18N
        jMenuItem1.setText("Cambiar contraseña");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Configuración");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuracion.png"))); // NOI18N
        jMenuItem4.setText("Puertos COM");
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Salir");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/season.png"))); // NOI18N
        jMenuItem2.setText("Cerrar sesión");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnCasodeFallaDeLuz() {
        //Es metodo se hace con la finalidad de saber que proyectos no pausaron/terminaron el tiempo satisfactoriamente antes de que sucediera la falla de energia.
        //Solo se le realizara esta acción a los cargos de encargado ensamble, encargado de FE y TE 
        FE_TE_IN obj = new FE_TE_IN();
        if (cargo == 2) {
            try {
                //Buscamos los proyectos de FE que estan en ejecucion.
                crs = obj.consultarProyectosEnEjecucion(1);
                while (crs.next()) {
                    if (producF == null) {
                        producF = new ControlDelTiempo();
                        producF.setName("FE");
                        producF.setTitle("Formato estandar");
                        producF.setVisible(true);
                        producF.negocioFE = 1;
                    }
                    producF.agregarBotones(producF, Integer.parseInt(crs.getString(1)));
                }

                //Buscamos los proyectos de TE que estan en ejecucion.
                crs = obj.consultarProyectosEnEjecucion(2);
                while (crs.next()) {
                    if (producT == null) {
                        producT = new ControlDelTiempo();
                        producT.setName("TE");
                        producT.setTitle("Teclados");
                        producT.setVisible(true);
                        producT.negocioTE = 2;
                    }
                    producT.agregarBotones(producT, Integer.parseInt(crs.getString(1)));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error!!" + e);
            }
        } else if (cargo == 3) {
            try {
                crs = obj.consultarProyectosEnEjecucion(3);
                while (crs.next()) {
                    if (producE == null) {
                        producE = new ControlDelTiempo();
                        producE.setName("IN");
                        producE.setTitle("Ensamble");
                        producE.setVisible(true);
                        producE.negocioIN = 3;
                    }
                    producE.agregarBotones(producE, Integer.parseInt(crs.getString(1)));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error!!" + e);
            }
        }
    }

    private void funcionalidades(int cargo) {
        switch (cargo) {
            case 1:
                //Gestor comercial
                this.setTitle("Gestor Comercial");
                btn3.setEnabled(false);
                break;
            case 2:
                //Encargado FE y TE
                this.setTitle("Encargado FE y TE");
                btn3.setEnabled(false);
                break;
            case 3:
                //Encargado de EN
                this.setTitle("Encargado EN");
                btn3.setEnabled(false);
                break;
            default:
                this.setTitle("Administrador");
                break;
        }
    }

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        btnMenu.setEnabled(false);
        if (!btn2.isSelected()) {
            btn1.setColorHover(cor);
            btn1.setColorNormal(corF);
            btn1.setColorPressed(cor);

            btn2.setColorHover(cor);
            btn2.setColorNormal(cor);
            btn2.setColorPressed(cor);

            btn3.setColorHover(cor);
            btn3.setColorNormal(corF);
            btn3.setColorPressed(cor);

            btn4.setColorHover(cor);
            btn4.setColorNormal(corF);
            btn4.setColorPressed(cor);

            btn6.setColorHover(cor);
            btn6.setColorNormal(corF);
            btn6.setColorPressed(cor);
        } else {
            btn2.setColorHover(cor);
            btn2.setColorNormal(cor);
            btn2.setColorPressed(cor);
        }
        switch (cargo) {
            case 1:
            case 4:
                cambiarpanelProyecto("proyectos");
                break;
            case 2:
                proyecto1.cargo = cargo;
                cambiarpanelProyecto("proyectos1");
                break;
            case 3:
                proyecto1.cargo = cargo;
                cambiarpanelProyecto("proyectos2");
                break;
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        btnMenu.setEnabled(false);
        if (!btn4.isSelected()) {
            btn1.setColorHover(cor);
            btn1.setColorNormal(corF);
            btn1.setColorPressed(cor);

            btn2.setColorHover(cor);
            btn2.setColorNormal(corF);
            btn2.setColorPressed(cor);

            btn3.setColorHover(cor);
            btn3.setColorNormal(corF);
            btn3.setColorPressed(cor);

            btn4.setColorHover(cor);
            btn4.setColorNormal(cor);
            btn4.setColorPressed(cor);

            btn6.setColorHover(cor);
            btn6.setColorNormal(corF);
            btn6.setColorPressed(cor);

        } else {
            btn3.setColorHover(cor);
            btn3.setColorNormal(cor);
            btn3.setColorPressed(cor);
        }
        if (bp == null) {
            bp = new Producciones();
            bp.setVisible(true);
        } else {
            bp.isFocusableWindow();
        }

    }//GEN-LAST:event_btn4ActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        int posicionX = jPMenu.getX();
        if (posicionX > -1) {
            Animacion.Animacion.mover_izquierda(0, -542, 1, 2, jPMenu);
            Animacion.Animacion.mover_izquierda(202, 10, 1, 2, jPContenido);
            Animacion.Animacion.mover_izquierda(1135, 934, 1, 2, jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-542, 0, 1, 2, jPMenu);
            Animacion.Animacion.mover_derecha(10, 202, 1, 2, jPContenido);
            Animacion.Animacion.mover_derecha(934, 1135, 1, 2, jPanel3);
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        btnMenu.setEnabled(true);
        if (!btn1.isSelected()) {
            btn1.setColorHover(cor);
            btn1.setColorNormal(cor);
            btn1.setColorPressed(cor);

            btn2.setColorHover(cor);
            btn2.setColorNormal(corF);
            btn2.setColorPressed(cor);

            btn3.setColorHover(cor);
            btn3.setColorNormal(corF);
            btn3.setColorPressed(cor);

            btn4.setColorHover(cor);
            btn4.setColorNormal(corF);
            btn4.setColorPressed(cor);

            btn6.setColorHover(cor);
            btn6.setColorNormal(corF);
            btn6.setColorPressed(cor);

        } else {
            btn1.setColorHover(cor);
            btn1.setColorNormal(cor);
            btn1.setColorPressed(cor);
        }
        if (!jPContenido.getComponent(0).getName().equals("inicio")) {
            new CambiaPanel(jPContenido, new Inicio());
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        btnMenu.setEnabled(false);
        if (!btn3.isSelected()) {
            btn1.setColorHover(cor);
            btn1.setColorNormal(corF);
            btn1.setColorPressed(cor);

            btn2.setColorHover(cor);
            btn2.setColorNormal(corF);
            btn2.setColorPressed(cor);

            btn3.setColorHover(cor);
            btn3.setColorNormal(cor);
            btn3.setColorPressed(cor);

            btn4.setColorHover(cor);
            btn4.setColorNormal(corF);
            btn4.setColorPressed(cor);

            btn6.setColorHover(cor);
            btn6.setColorNormal(corF);
            btn6.setColorPressed(cor);
        } else {
            btn3.setColorHover(cor);
            btn3.setColorNormal(cor);
            btn3.setColorPressed(cor);
        }
        if (!jPContenido.getComponent(0).getName().equals("usuarios")) {
            new CambiaPanel(jPContenido, new Usuarios1());
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
//            System.out.print("Hola");
    }//GEN-LAST:event_formWindowDeactivated

    private void jPSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPSuperiorMousePressed

        posX = evt.getX();
        posY = evt.getY();

    }//GEN-LAST:event_jPSuperiorMousePressed

    private void jPSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPSuperiorMouseDragged

        this.setLocation((evt.getXOnScreen() - posX), (evt.getYOnScreen() - posY - 25));

    }//GEN-LAST:event_jPSuperiorMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

    }//GEN-LAST:event_formMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (producE == null && producF == null && producT == null) {
            sesion(0, jDocumento.getText());
            System.exit(0);
        } else {
            new rojerusan.RSNotifyAnimated("¡Alerta!", "No puedes cerrar la aplicacion mientras un producto en ejecución.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rSUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSUsuarioMouseClicked

    }//GEN-LAST:event_rSUsuarioMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (obj == null) {
            obj = new CambiarContraseña();
            obj.setVisible(true);
        } else {
            obj.setFocusCycleRoot(true);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (producE == null && producF == null && producT == null) {
            if (JOptionPane.showOptionDialog(null, "¿Seguro desea cerrar la sesión?",
                    "seleccione...", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                    new Object[]{"SI", "NO"}, "SI") == 0) {
                //Cierra el menu y abre el login
                if (bp != null) {
                    bp.jBSalir.doClick();//La vista de produccion tiene que cerrarce cuando se salga de la aplicación.
                }
                this.dispose();
                if (obj != null) {
                    obj.btnClose.doClick();
                }
                try {
                    sesion(0, jDocumento.getText());
                    Thread.sleep(290);
                    new Login().setVisible(true);
                } catch (Exception e) {
                }
            }
        } else {
            new rojerusan.RSNotifyAnimated("¡Alerta!", "No puedes cerrar la aplicacion mientras un producto en ejecución.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        sesion(0, jDocumento.getText());
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed

    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed

    }//GEN-LAST:event_jPanel6MousePressed

    private void jPanel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jPanel3MouseReleased

    private void jPanel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseReleased

    }//GEN-LAST:event_jPanel6MouseReleased

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
        InformacionAreasProduccion();
    }//GEN-LAST:event_jMenuItem3MousePressed

    private void jPSuperiorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPSuperiorMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jPSuperiorMouseReleased

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        //Los reportes estan pendientes------
        int seleccion = JOptionPane.showOptionDialog(null, "¿Qué reporte desea generar?",
                "seleccione...", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"Tiempos de producción", "General"}, "");
        if (seleccion != -1) {
            if (seleccion == 0) {
                //Reporte de tiempos 
                //Cuerpo del algoritmo esta pendiente.
                //...
            } else {
                //Reporte general Excel.
                DetalleProyecto obj = new DetalleProyecto();
                crs = obj.generar_Reportes();
                //Ruta de guardado del archivo
                JFileChooser Chocer = new JFileChooser();
                Chocer.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                Chocer.setLocation(500, 500);
                Chocer.showOpenDialog(this);
                File guardar = Chocer.getSelectedFile();
                //Generar archivo .xlsx
                generarXlsx excel = new generarXlsx();
                if (excel.generarExcel(crs, String.valueOf(guardar))) {
                    //Documento creado correctamente
                    new rojerusan.RSNotifyAnimated("Listo!", "El reporte General de producción fue creado exitosamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                } else {
                    //Error al crear el documento
                    new rojerusan.RSNotifyAnimated("¡Error!", "No puedo crear el reporte General.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        btnMenu.setEnabled(false);
        if (!btn4.isSelected()) {
            btn1.setColorHover(cor);
            btn1.setColorNormal(corF);
            btn1.setColorPressed(cor);

            btn2.setColorHover(cor);
            btn2.setColorNormal(corF);
            btn2.setColorPressed(cor);

            btn3.setColorHover(cor);
            btn3.setColorNormal(corF);
            btn3.setColorPressed(cor);

            btn4.setColorHover(cor);
            btn4.setColorNormal(corF);
            btn4.setColorPressed(cor);

            btn6.setColorHover(cor);
            btn6.setColorNormal(cor);
            btn6.setColorPressed(cor);
        } else {
            btn6.setColorHover(cor);
            btn6.setColorNormal(cor);
            btn6.setColorPressed(cor);
        }
        if (!jPContenido.getComponent(0).getName().equals("Procesos")) {
            new CambiaPanel(jPContenido, new Procesos());
        }
    }//GEN-LAST:event_btn6ActionPerformed

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setForeground(new Color(63, 179, 255));

    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        jLabel3.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseReleased
        jLabel3.setForeground(new Color(63, 179, 255));
    }//GEN-LAST:event_jLabel3MouseReleased

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setForeground(new Color(63, 179, 255));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        jLabel4.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
        jLabel4.setForeground(new Color(63, 179, 255));
    }//GEN-LAST:event_jLabel4MouseReleased

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setForeground(new Color(63, 179, 255));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseReleased
        jLabel7.setForeground(new Color(63, 179, 255));
    }//GEN-LAST:event_jLabel7MouseReleased

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        jLabel7.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jLabel18.setForeground(new Color(63, 179, 255));
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseReleased
        jLabel18.setForeground(new Color(63, 179, 255));
    }//GEN-LAST:event_jLabel18MouseReleased

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        jLabel18.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MousePressed
        jLabel18.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel18MousePressed
//Metodos de la clase menu----------------------------------------------------->

    public void LecturaCodigoQR(String codigo) {
        String infoP[] = codigo.split(";");
        Proyecto validar = new Proyecto();
        if (validar.validarEliminacion(Integer.parseInt(infoP[0]))) {//Valido si la orden esta eliminada o no
            if (validar.validarEjecucionOParada(Integer.parseInt(infoP[0]))) {//Valida que la orden no este parada
                //#--------------------------------------------------------------------------------------------------
                switch (Integer.parseInt(infoP[2])) {
                    //Se tiene que validar el estado del proyecto a ver si permite o no registrar la toma de tiempo.
                    case 1:
                        if (producF == null) {
                            producF = new ControlDelTiempo();
                            producF.setName("FE");
                            producF.setTitle("Formato estandar");
                            producF.setVisible(true);
                        }
                        producF.RegistrarTomaTiempoNegocio(infoP, cargo, producF, myPS);
                        break;
                    case 2:
                        if (producT == null) {
                            producT = new ControlDelTiempo();
                            producT.setName("TE");
                            producT.setTitle("Teclados");
                            producT.setVisible(true);
                        }
                        producT.RegistrarTomaTiempoNegocio(infoP, cargo, producT, myPS);
                        break;
                    case 3:
                        if (producE == null) {
                            producE = new ControlDelTiempo();
                            producE.setName("IN");
                            producE.setTitle("Ensamble");
                            producE.setVisible(true);
                        }
                        producE.RegistrarTomaTiempoNegocio(infoP, cargo, producE, myPS);
                        break;
                }
                //#--------------------------------------------------------------------------------------------------
            } else {
                //El proyecto no puede realizar la toma de tiempo porque esta parada.
//                enviarMensajeCelular("¡Alerta!" + "n/" + "Esta orden esta parada, no puedes realizar la toma de tiempo de esta orden.");
                new rojerusan.RSNotifyAnimated("¡Alerta!", "Esta orden esta parada, no puedes realizar la toma de tiempo de esta orden.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            }
        } else {
            //Este mensaje se retornara al dispositivo móvil.
            //El proyecto no existe - Esta eliminado
//            enviarMensajeCelular("¡Alerta!" + "n/" + "Este numero de orden no existe.");
            new rojerusan.RSNotifyAnimated("¡Alerta!", "Este numero de orden no existe.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
        }
    }

    public void limpiarInformacionAreas() {
        FIngresadosHoy.setText("0");
        FEjecucion.setText("0");
        FTerminadosHoy.setText("0");
        FPorIniciar.setText("0");
        TIngresadosHoy.setText("0");
        TEjecucion.setText("0");
        TTerminadosHoy.setText("0");
        TPorIniciar.setText("0");
        EIngresadosHoy.setText("0");
        EEjecucion.setText("0");
        ETerminadosHoy.setText("0");
        EPorIniciar.setText("0");
    }
//Toma de tiempo automatica---------------------------------------------------->

    @Override
    public void run() {
        CPS = new ConexionPS();//Establecemos la conecion con el puerto serial(COM)
        while (true) {
            CPS.enlacePuertos();//Si detecta algo en el puerto COM va a tomar o detener el tiempo!!
        }
    }

//Fien de toma de tiempo automatica-------------------------------------------->
    public void InformacionAreasProduccion() {
        Proyecto obj = new Proyecto();
        int accion = 1;
        limpiarInformacionAreas();
        try {
            while (accion <= 4) {
                crs = obj.InformacionAreasProduccion(accion);
                switch (accion) {
                    case 1:
                        //proyectos ingresados hoy--------------------------------->
                        while (crs.next()) {
                            if (crs.getInt(2) == 1) {//<Formato estandar>
                                FIngresadosHoy.setText(crs.getString(1));
                            } else if (crs.getInt(2) == 2) {//<Teclados>
                                TIngresadosHoy.setText(crs.getString(1));
                            } else if (crs.getInt(2) == 3) {//<Ensamble>
                                EIngresadosHoy.setText(crs.getString(1));
                            } else {
                                AIngresadosHoy.setText(crs.getString(1));
                            }
                        }
                        crs.close();
                        //proyectos ingresados hoy--------------------------------->
                        break;
                    case 2:
                        //Proyectos terminados hoy por area------------------------>
                        crs.next();
                        FTerminadosHoy.setText(crs.getString(1));
                        TTerminadosHoy.setText(crs.getString(2));
                        ETerminadosHoy.setText(crs.getString(3));
                        ATerminadosHoy.setText(crs.getString(4));
                        crs.close();
                        //Proyectos terminados hoy por area------------------------>
                        break;
                    case 3:
                        //Proyectos que se encuentran en estado de ejecución------->
                        while (crs.next()) {
                            if (crs.getInt(2) == 1) {//<Formato estandar>
                                FEjecucion.setText(crs.getString(1));
                            } else if (crs.getInt(2) == 2) {//<Teclados>
                                TEjecucion.setText(crs.getString(1));
                            } else if (crs.getInt(2) == 3) {//<Ensamble>
                                EEjecucion.setText(crs.getString(1));
                            } else {
                                Ajecucion.setText(crs.getString(1));
                            }
                        }
                        crs.close();
                        //Proyectos que se encuentran en estado de ejecución------->
                        break;
                    case 4:
                        //Proyectos que se encuentran en estado por iniciar-------->
                        while (crs.next()) {
                            if (crs.getInt(2) == 1) {//<Formato estandar>
                                FPorIniciar.setText(crs.getString(1));
                            } else if (crs.getInt(2) == 2) {//<Teclados>
                                TPorIniciar.setText(crs.getString(1));
                            } else if (crs.getInt(2) == 3) {//<Ensamble>
                                EPorIniciar.setText(crs.getString(1));
                            }
                        }
                        crs.close();
                        //Proyectos que se encuentran en estado por iniciar-------->
                        break;
                }
                accion++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!" + e);
        }
    }

    //Este procedimiento es para validar quienes tienen permiso de utilizar el lector (Encargados FE-TE-EN)
//    public void permisoUtilizarLector() {
//        if (cargo != 1 || cargo != 4) {
//            jTLector.setEnabled(false);
//            jTLector.setVisible(false);
//        }
//    }
    public void sesion(int sec, String doc) {
        Controlador.Usuario obj = new Controlador.Usuario();
        obj.sesion(sec, doc);
    }

    public void cambiarpanelProyecto(String name) {
        if (!jPContenido.getComponent(0).getName().equals(name)) {
            switch (cargo) {
                case 1:
                case 4:
                    new CambiaPanel(jPContenido, new proyecto(1));
                    break;
                case 2:
                    new CambiaPanel(jPContenido, new proyecto1(1));
                    break;
                case 3:
                    new CambiaPanel(jPContenido, new proyecto1(1));
                    break;
            }
        }
    }

    //La parte de capturar y gusrdadr la imagen de perfil no se a realizado.
    public void CapturaImagen() {
        File obj = new File(rSUsuario.image.toString());
    }

    public void traerimagen() {//Esta parte del proyecto esta en espera
        ImageIcon obj = new ImageIcon(rSUsuario.image);
        try {
            strem = new FileInputStream(rSUsuario.getName());
//            longitudByte=rSUsuario.;
        } catch (Exception e) {
        }
    }

    public void prueba() {
        JFileChooser se = new JFileChooser();
        se.setFileSelectionMode((int) se.getSelectedFile().length());
        int estado = se.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                strem = new FileInputStream(se.getSelectedFile());
            } catch (Exception e) {
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
//                try {
//                    UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, e);
//                }
                new Menu(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel AIngresadosHoy;
    public javax.swing.JLabel ATerminadosHoy;
    public javax.swing.JLabel Ajecucion;
    public javax.swing.JLabel EEjecucion;
    public javax.swing.JLabel EIngresadosHoy;
    public javax.swing.JLabel EPorIniciar;
    public javax.swing.JLabel ETerminadosHoy;
    public javax.swing.JLabel FEjecucion;
    public javax.swing.JLabel FIngresadosHoy;
    public javax.swing.JLabel FPorIniciar;
    public javax.swing.JLabel FTerminadosHoy;
    public javax.swing.JLabel TEjecucion;
    public javax.swing.JLabel TIngresadosHoy;
    public javax.swing.JLabel TPorIniciar;
    public javax.swing.JLabel TTerminadosHoy;
    public rsbuttom.RSButtonMetro btn1;
    public rsbuttom.RSButtonMetro btn2;
    public rsbuttom.RSButtonMetro btn3;
    public rsbuttom.RSButtonMetro btn4;
    public rsbuttom.RSButtonMetro btn5;
    public rsbuttom.RSButtonMetro btn6;
    public javax.swing.JButton btnMenu;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public static javax.swing.JLabel jDocumento;
    public static javax.swing.JLabel jDocumento1;
    public static javax.swing.JLabel jDocumento2;
    public javax.swing.JInternalFrame jInternalFrame1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    public javax.swing.JLabel jLabel24;
    public javax.swing.JLabel jLabel25;
    public javax.swing.JLabel jLabel26;
    public javax.swing.JLabel jLabel27;
    public javax.swing.JLabel jLabel29;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenu jMenu3;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JMenuItem jMenuItem3;
    public javax.swing.JMenuItem jMenuItem4;
    public javax.swing.JPanel jPContenido;
    public javax.swing.JPanel jPMenu;
    public javax.swing.JPanel jPSuperior;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel10;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JPopupMenu jPopupMenu1;
    public rojerusan.RSFotoCircle rSUsuario;
    // End of variables declaration//GEN-END:variables
    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
