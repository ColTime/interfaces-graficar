package Controlador;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Locale;
import javax.sql.rowset.CachedRowSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Diagramas {
//Graficas de la cantidad de proyectos que tiene cada area
//Variables...

    CachedRowSet crs = null;

    public Diagramas() {

    }

    public ImageIcon graficaCantidad(int tipoGrafica, int vista, String inicio, String fin) {
        ImageIcon iconG = null;
        try {
            Proyecto obj = new Proyecto();
            //Cantidad de proyectos por areas /FE/TE/IN
            int v[] = cantidadArea(obj.diagrama(inicio, fin));
            JFreeChart jf = null;
            if (tipoGrafica == 1 || tipoGrafica == 2) {
                DefaultCategoryDataset ds = new DefaultCategoryDataset();
                ds.addValue(v[0], "Proyectos", "Formato estandar");
                ds.addValue(v[1], "Proyectos", "Teclados");
                ds.addValue(v[2], "Proyectos", "Ensamble");
                ds.addValue(v[3], "Proyectos", "Almacen");

                if (tipoGrafica == 1) {
                    //Diagrama de barras vertical
                    jf = ChartFactory.createBarChart3D("Cantidad de proyectos por area", "Áreas", "Cantidades", ds, PlotOrientation.VERTICAL, false, true, false);
                    CategoryPlot plot = jf.getCategoryPlot();
                    BarRenderer render = (BarRenderer) plot.getRenderer();
                    render.setSeriesPaint(0, Color.DARK_GRAY);
                    jf.setBackgroundPaint(Color.WHITE);

                    iconG = new ImageIcon(jf.createBufferedImage(859, 366));
                } else if (tipoGrafica == 2) {
                    //Diagrama de barras Horizontales
                    jf = ChartFactory.createBarChart3D("Cantidad de proyectos por area", "Áreas", "Cantidades", ds, PlotOrientation.HORIZONTAL, true, true, true);
                    CategoryPlot plot = jf.getCategoryPlot();
                    BarRenderer render = (BarRenderer) plot.getRenderer();
                    render.setSeriesPaint(0, Color.DARK_GRAY);
                    jf.setBackgroundPaint(Color.WHITE);

                    iconG = new ImageIcon(jf.createBufferedImage(859, 366));
                }
            } else if (tipoGrafica == 3) {
                DefaultPieDataset porciones = new DefaultPieDataset();
                porciones.setValue("FE: " + v[0], v[0]);//Formato estandar
                porciones.setValue("TE: " + v[1], v[1]);//Teclado
                porciones.setValue("EN: " + v[2], v[2]);//Ensamble
                porciones.setValue("AL: " + v[3], v[3]);//Almacen
                //Torta
                jf = ChartFactory.createPieChart3D("Produccion", porciones, true, true, Locale.ITALY);
                jf.setBackgroundPaint(Color.WHITE);
                iconG = new ImageIcon(jf.createBufferedImage(859, 366));
            }

            if (vista == 1) {
                ChartFrame f = new ChartFrame("Proyectos", jf);
                f.setSize(1000, 600);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
//            ChartFrame f = new ChartFrame("Edades", jf);
//            f.setSize(1000, 600);
//            f.setLocationRelativeTo(null);
//            f.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return iconG;
    }

    public ImageIcon EnrutamientoProceso(int diseño, int busqueda, String inicio, String fin) {
        ImageIcon diagrama = null;
        //Cuerpo del la función
        if (busqueda == 1) {
            //Cantidad de productos por área
            if (diseño == 1) {
                graficaCantidad(1, 1, inicio, fin);
            } else if (diseño == 2) {
                graficaCantidad(2, 1, inicio, fin);
            } else {
                graficaCantidad(3, 1, inicio, fin);
            }
            //----------------------------------
        } else if (busqueda == 2) {
            //Procesos FE
            graficaProyectoFE(diseño);
        } else if (busqueda == 3) {
            //Procesos TE
            graficaProyectoTE(diseño);
        } else if (busqueda == 4) {
            //Procesos EN
            graficaProyectoEN(diseño);
        }
        return diagrama;
    }

    public void graficaProyectoFE(int diseño) {
        try {
            Proyecto obj = new Proyecto();
            //Cantidad de proyectos por area FE
            //Variables necesarias...
            crs = obj.consutalarProcesosArea(1);
            ArrayList<FE_TE_IN> fe = new ArrayList();
            //Clasificacion de la información...
            for (int i = 0; i < 10; i++) {//Ingresamos todos los procesos...
                FE_TE_IN produccion = new FE_TE_IN();
                fe.add(produccion);
            }
            while (crs.next()) {//Esto es lo pendiente que hay que corregir en todas las áreas.
                if (crs.getInt(1) == 1) {//Proceso Perforado.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(0).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(0).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(0).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 2) {//Proceso Químicos.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(1).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(1).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(1).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 3) {//Proceso Caminos.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(2).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(2).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(2).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 4) {//Proceso Quemado.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(3).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(3).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(3).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 5) {//Proceso C.C.TH.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(4).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(4).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(4).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 6) {//Proceso Screen.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(5).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(5).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(5).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 7) {//Proceso Estañado.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(6).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(6).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(6).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 8) {//Proceso C.C.2.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(7).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(7).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(7).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 9) {//Proceso Ruteo.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(8).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(8).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(8).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 10) {//Proceso Maquinas.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(9).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(9).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(9).ejecucion = crs.getInt(2);
                    }
                }
            }
            crs.close();

            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            ds.addValue(fe.get(0).porIniciar, "por iniciar", "Perforado");
            ds.addValue(fe.get(0).pausa, "Pausado", "Perforado");
            ds.addValue(fe.get(0).ejecucion, "Ejecucion", "Perforado");

            ds.addValue(fe.get(1).porIniciar, "por iniciar", "Quimicos");
            ds.addValue(fe.get(1).pausa, "Pausado", "Quimicos");
            ds.addValue(fe.get(1).ejecucion, "Ejecucion", "Quimicos");

            ds.addValue(fe.get(2).porIniciar, "por iniciar", "Caminos");
            ds.addValue(fe.get(2).pausa, "Pausado", "Caminos");
            ds.addValue(fe.get(2).ejecucion, "Ejecucion", "Caminos");

            ds.addValue(fe.get(3).porIniciar, "por iniciar", "Quemado");
            ds.addValue(fe.get(3).pausa, "Pausado", "Quemado");
            ds.addValue(fe.get(3).ejecucion, "Ejecucion", "Quemado");

            ds.addValue(fe.get(4).porIniciar, "por iniciar", "C.C.TH");
            ds.addValue(fe.get(4).pausa, "Pausado", "C.C.TH");
            ds.addValue(fe.get(4).ejecucion, "Ejecucion", "C.C.TH");

            ds.addValue(fe.get(5).porIniciar, "por iniciar", "Screen");
            ds.addValue(fe.get(5).pausa, "Pausado", "Screen");
            ds.addValue(fe.get(5).ejecucion, "Ejecucion", "Screen");

            ds.addValue(fe.get(6).porIniciar, "por iniciar", "Estañado");
            ds.addValue(fe.get(6).pausa, "Pausado", "Estañado");
            ds.addValue(fe.get(6).ejecucion, "Ejecucion", "Estañado");

            ds.addValue(fe.get(7).porIniciar, "por iniciar", "C.C2");
            ds.addValue(fe.get(7).pausa, "Pausado", "C.C2");
            ds.addValue(fe.get(7).ejecucion, "Ejecucion", "C.C2");

            ds.addValue(fe.get(8).porIniciar, "por iniciar", "Ruteo");
            ds.addValue(fe.get(8).pausa, "Pausado", "Ruteo");
            ds.addValue(fe.get(8).ejecucion, "Ejecucion", "Ruteo");

            ds.addValue(fe.get(9).porIniciar, "por iniciar", "Maquinas");
            ds.addValue(fe.get(9).pausa, "Pausado", "Maquinas");
            ds.addValue(fe.get(9).ejecucion, "Ejecucion", "Maquinas");

            fe.clear();

            if (diseño == 1) {
                //Diagrama de barras vertical
                JFreeChart jf = ChartFactory.createBarChart3D("Procesos de FE", "Procesos", "Estados", ds, PlotOrientation.VERTICAL, false, true, false);
//                CategoryPlot plot = jf.getCategoryPlot();
//                BarRenderer render = (BarRenderer) plot.getRenderer();
//                render.setSeriesPaint(0, Color.DARK_GRAY);
//                jf.setBackgroundPaint(Color.WHITE);
                ChartFrame f = new ChartFrame("Formato estándar", jf);
                f.setSize(1000, 600);
                f.setLocationRelativeTo(null);
                f.setVisible(true);

            } else if (diseño == 2) {
                //Diagrama de barras Horizontales
                JFreeChart jf = ChartFactory.createBarChart3D("Procesos de FE", "Procesos", "Estados", ds, PlotOrientation.HORIZONTAL, true, true, true);
//                CategoryPlot plot = jf.getCategoryPlot();
//                BarRenderer render = (BarRenderer) plot.getRenderer();
//                render.setSeriesPaint(0, Color.DARK_GRAY);
//                jf.setBackgroundPaint(Color.WHITE);

                ChartFrame f = new ChartFrame("Formato estándar", jf);
                f.setSize(1000, 600);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
//            ChartFrame f = new ChartFrame("Edades", jf);
//            f.setSize(1000, 600);
//            f.setLocationRelativeTo(null);
//            f.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
    }

    public void graficaProyectoTE(int diseño) {
        try {
            Proyecto obj = new Proyecto();
            //Cantidad de proyectos por area FE
            //Variables necesarias...
            crs = obj.consutalarProcesosArea(2);
            ArrayList<FE_TE_IN> fe = new ArrayList();
            //Clasificacion de la información...
            for (int i = 0; i < 4; i++) {//Ingresamos todos los procesos...
                FE_TE_IN produccion = new FE_TE_IN();
                fe.add(produccion);
            }
            while (crs.next()) {
                if (crs.getInt(1) == 11) {//Proceso Perforado.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(0).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(0).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(0).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 12) {//Proceso Químicos.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(1).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(1).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(1).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 13) {//Proceso Caminos.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(2).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(2).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(2).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 14) {//Proceso Quemado.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(3).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(3).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(3).ejecucion = crs.getInt(2);
                    }
                }
            }
            crs.close();

            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            ds.addValue(fe.get(0).porIniciar, "por iniciar", "Correas y conversor");
            ds.addValue(fe.get(0).pausa, "Pausado", "Correas y conversor");
            ds.addValue(fe.get(0).ejecucion, "Ejecucion", "Correas y conversor");

            ds.addValue(fe.get(1).porIniciar, "por iniciar", "Lexan");
            ds.addValue(fe.get(1).pausa, "Pausado", "Lexan");
            ds.addValue(fe.get(1).ejecucion, "Ejecucion", "Lexan");

            ds.addValue(fe.get(2).porIniciar, "por iniciar", "Acople");
            ds.addValue(fe.get(2).pausa, "Pausado", "Acople");
            ds.addValue(fe.get(2).ejecucion, "Ejecucion", "Acople");

            ds.addValue(fe.get(3).porIniciar, "por iniciar", "Control calidad");
            ds.addValue(fe.get(3).pausa, "Pausado", "Control calidad");
            ds.addValue(fe.get(3).ejecucion, "Ejecucion", "Control calidad");

            fe.clear();

            if (diseño == 1) {
                //Diagrama de barras vertical
                JFreeChart jf = ChartFactory.createBarChart3D("Procesos de TE", "Procesos", "Estados", ds, PlotOrientation.VERTICAL, false, true, false);
//                CategoryPlot plot = jf.getCategoryPlot();
//                BarRenderer render = (BarRenderer) plot.getRenderer();
//                render.setSeriesPaint(0, Color.DARK_GRAY);
//                jf.setBackgroundPaint(Color.WHITE);
                ChartFrame f = new ChartFrame("Teclados", jf);
                f.setSize(1000, 600);
                f.setLocationRelativeTo(null);
                f.setVisible(true);

            } else if (diseño == 2) {
                //Diagrama de barras Horizontales
                JFreeChart jf = ChartFactory.createBarChart3D("Procesos de TE", "Procesos", "Estados", ds, PlotOrientation.HORIZONTAL, true, true, true);
//                CategoryPlot plot = jf.getCategoryPlot();
//                BarRenderer render = (BarRenderer) plot.getRenderer();
//                render.setSeriesPaint(0, Color.DARK_GRAY);
//                jf.setBackgroundPaint(Color.WHITE);

                ChartFrame f = new ChartFrame("Teclados", jf);
                f.setSize(1000, 600);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
//            ChartFrame f = new ChartFrame("Edades", jf);
//            f.setSize(1000, 600);
//            f.setLocationRelativeTo(null);
//            f.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
    }

    public void graficaProyectoEN(int diseño) {
        try {
            Proyecto obj = new Proyecto();
            //Cantidad de proyectos por area FE
            //Variables necesarias...
            crs = obj.consutalarProcesosArea(3);
            ArrayList<FE_TE_IN> fe = new ArrayList();
            //Clasificacion de la información...
            for (int i = 0; i < 7; i++) {//Ingresamos todos los procesos...
                FE_TE_IN produccion = new FE_TE_IN();
                fe.add(produccion);
            }
            while (crs.next()) {
                if (crs.getInt(1) == 15) {//Proceso Manual.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(0).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(0).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(0).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 16) {//Proceso Limpieza.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(1).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(1).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(1).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 17) {//Proceso Control calidad.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(2).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(2).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(2).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 18) {//Proceso Empaque.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(3).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(3).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(3).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 19) {//Proceso Stencil.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(4).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(4).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(4).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 20) {//Proceso Linea.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(5).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(5).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(5).ejecucion = crs.getInt(2);
                    }
                } else if (crs.getInt(1) == 21) {//Proceso Arnes.
                    if (crs.getInt(3) == 1) {//estado por iniciar.
                        fe.get(6).porIniciar = crs.getInt(2);
                    } else if (crs.getInt(3) == 2) {//Estado pausado
                        fe.get(6).pausa = crs.getInt(2);
                    } else if (crs.getInt(3) == 4) {//Estado Ejecucion
                        fe.get(6).ejecucion = crs.getInt(2);
                    }
                }
            }
            crs.close();

            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            ds.addValue(fe.get(0).porIniciar, "por iniciar", "Manual");
            ds.addValue(fe.get(0).pausa, "Pausado", "Manual");
            ds.addValue(fe.get(0).ejecucion, "Ejecucion", "Manual");

            ds.addValue(fe.get(1).porIniciar, "por iniciar", "Limpieza");
            ds.addValue(fe.get(1).pausa, "Pausado", "Limpieza");
            ds.addValue(fe.get(1).ejecucion, "Ejecucion", "Limpieza");

            ds.addValue(fe.get(2).porIniciar, "por iniciar", "Control calidad");
            ds.addValue(fe.get(2).pausa, "Pausado", "Control calidad");
            ds.addValue(fe.get(2).ejecucion, "Ejecucion", "Control calidad");

            ds.addValue(fe.get(3).porIniciar, "por iniciar", "Empaque");
            ds.addValue(fe.get(3).pausa, "Pausado", "Empaque");
            ds.addValue(fe.get(3).ejecucion, "Ejecucion", "Empaque");

            ds.addValue(fe.get(4).porIniciar, "por iniciar", "Stencil");
            ds.addValue(fe.get(4).pausa, "Pausado", "Stencil");
            ds.addValue(fe.get(4).ejecucion, "Ejecucion", "Stencil");

            ds.addValue(fe.get(5).porIniciar, "por iniciar", "Linea");
            ds.addValue(fe.get(5).pausa, "Pausado", "Linea");
            ds.addValue(fe.get(5).ejecucion, "Ejecucion", "Linea");

            ds.addValue(fe.get(6).porIniciar, "por iniciar", "Arnes");
            ds.addValue(fe.get(6).pausa, "Pausado", "Arnes");
            ds.addValue(fe.get(6).ejecucion, "Ejecucion", "Arnes");

            fe.clear();

            if (diseño == 1) {
                //Diagrama de barras vertical
                JFreeChart jf = ChartFactory.createBarChart3D("Procesos de TE", "Procesos", "Estados", ds, PlotOrientation.VERTICAL, false, true, false);
//                CategoryPlot plot = jf.getCategoryPlot();
//                BarRenderer render = (BarRenderer) plot.getRenderer();
//                render.setSeriesPaint(0, Color.DARK_GRAY);
//                jf.setBackgroundPaint(Color.WHITE);
                ChartFrame f = new ChartFrame("Teclados", jf);
                f.setSize(1000, 600);
                f.setLocationRelativeTo(null);
                f.setVisible(true);

            } else if (diseño == 2) {
                //Diagrama de barras Horizontales
                JFreeChart jf = ChartFactory.createBarChart3D("Procesos de TE", "Procesos", "Estados", ds, PlotOrientation.HORIZONTAL, true, true, true);
//                CategoryPlot plot = jf.getCategoryPlot();
//                BarRenderer render = (BarRenderer) plot.getRenderer();
//                render.setSeriesPaint(0, Color.DARK_GRAY);
//                jf.setBackgroundPaint(Color.WHITE);

                ChartFrame f = new ChartFrame("Teclados", jf);
                f.setSize(1000, 600);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
//            ChartFrame f = new ChartFrame("Edades", jf);
//            f.setSize(1000, 600);
//            f.setLocationRelativeTo(null);
//            f.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
    }

    public int[] cantidadArea(CachedRowSet crs) {
        int v[] = {0, 0, 0, 0};
        try {
            while (crs.next()) {
                if (crs.getInt(2) == 1) {//Formato estandar
                    v[0] = crs.getInt(1);
                }
                if (crs.getInt(2) == 2) {//Teclados
                    v[1] = crs.getInt(1);
                }
                if (crs.getInt(2) == 3) {//Ensamble
                    v[2] = crs.getInt(1);
                }
                if (crs.getInt(2) == 4) {//Almacen
                    v[3] = crs.getInt(1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return v;
    }
}
