/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import java.util.Locale;
import javax.sql.rowset.CachedRowSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Aprendiz
 */
public class Diagramas {
//Graficas de la cantidad de proyectos que tiene cada area

    public Diagramas() {

    }

    public ImageIcon graficaCantidad(int tipoGrafica) {
        ImageIcon iconG = null;
        try {
            Proyecto obj = new Proyecto();
            //Cantidad de proyectos por areas /FE/TE/IN
            int v[] = cantidadArea(obj.diagrama());

            if (tipoGrafica == 1 || tipoGrafica == 2) {
                DefaultCategoryDataset ds = new DefaultCategoryDataset();
                ds.addValue(v[0], "Proyectos", "Formato estandar");
                ds.addValue(v[1], "Proyectos", "Teclados");
                ds.addValue(v[2], "Proyectos", "Ensamble");

                if (tipoGrafica == 1) {
                    //Diagrama de barras vertical
                    JFreeChart jf = ChartFactory.createBarChart3D("Cantidad de proyectos por area", "Áreas", "Cantidades", ds, PlotOrientation.VERTICAL, false, true, false);
                    CategoryPlot plot = jf.getCategoryPlot();
                    BarRenderer render = (BarRenderer) plot.getRenderer();
                    render.setSeriesPaint(0,Color.DARK_GRAY);
                    jf.setBackgroundPaint(Color.WHITE);

                    iconG = new ImageIcon(jf.createBufferedImage(859, 366));
                } else if (tipoGrafica == 2) {
                    //Diagrama de barras Horizontales
                    JFreeChart jf = ChartFactory.createBarChart3D("Cantidad de proyectos por area", "Áreas", "Cantidades", ds, PlotOrientation.HORIZONTAL, true, true, true);
                    CategoryPlot plot = jf.getCategoryPlot();
                    BarRenderer render = (BarRenderer) plot.getRenderer();
                    render.setSeriesPaint(0,Color.DARK_GRAY);
                    jf.setBackgroundPaint(Color.WHITE);

                    iconG = new ImageIcon(jf.createBufferedImage(859, 366));
                }
            } else if (tipoGrafica == 3) {
                DefaultPieDataset porciones = new DefaultPieDataset();
                porciones.setValue("FE: " + v[0], v[0]);//Formato estandar
                porciones.setValue("TE: " + v[1], v[1]);//Teclado
                porciones.setValue("EN: " + v[2], v[2]);//Ensamble
                //Torta
                JFreeChart jf1 = ChartFactory.createPieChart3D("Produccion", porciones, true, true, Locale.ITALY);
                jf1.setBackgroundPaint(Color.WHITE);
                iconG = new ImageIcon(jf1.createBufferedImage(859, 366));
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

    public int[] cantidadArea(CachedRowSet crs) {
        int v[] = {0, 0, 0};
        try {
            while (crs.next()) {
                //Formato estandar
                if (crs.getInt(2) == 1) {
                    v[0] = crs.getInt(1);
                }
                //Teclados
                if (crs.getInt(2) == 2) {
                    v[1] = crs.getInt(1);
                }
                //Ensamble
                if (crs.getInt(2) == 3) {
                    v[2] = crs.getInt(1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        return v;
    }
}
