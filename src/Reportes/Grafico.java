

package Reportes;

import Modelo.Conexion;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Grafico extends JPanel {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public Grafico() {
        setLayout(null);
        setPreferredSize(new Dimension(800, 500));
        
        // Crear y agregar el gráfico
        ChartPanel chartPanel = new ChartPanel(generarGrafico());
        chartPanel.setBounds(10, 10, 780, 480);
        add(chartPanel);
    }
    
    private JFreeChart generarGrafico() {
        // Crear el dataset con los datos de ventas
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        // Obtener datos de ventas por mes
        Map<String, Double> ventasPorMes = obtenerVentasPorMes();
        
        // Agregar datos al dataset
        for (Map.Entry<String, Double> entry : ventasPorMes.entrySet()) {
            dataset.addValue(entry.getValue(), "Ventas", entry.getKey());
        }
        
        // Crear el gráfico
        JFreeChart chart = ChartFactory.createBarChart(
            "Ventas Mensuales",      // título del gráfico
            "Mes",                   // etiqueta eje X
            "Total Ventas",          // etiqueta eje Y
            dataset,                 // datos
            PlotOrientation.VERTICAL, // orientación
            true,                    // incluir leyenda
            true,                    // incluir tooltips
            false                    // incluir URLs
        );
        
        // Personalizar el gráfico
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);
        
        // Personalizar las barras
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(0, 102, 204));
        renderer.setDrawBarOutline(true);
        renderer.setItemMargin(0.1);
        
        // Personalizar ejes
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(org.jfree.chart.axis.CategoryLabelPositions.UP_45);
        
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        return chart;
    }
    
    private Map<String, Double> obtenerVentasPorMes() {
        Map<String, Double> ventasPorMes = new HashMap<>();
        String sql = "SELECT DATE_FORMAT(STR_TO_DATE(fecha, '%d/%m/%Y'), '%Y-%m') AS mes, " +
                    "SUM(total) AS total_ventas " +
                    "FROM ventas " +
                    "GROUP BY DATE_FORMAT(STR_TO_DATE(fecha, '%d/%m/%Y'), '%Y-%m') " +
                    "ORDER BY mes";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                String mes = formatearMes(rs.getString("mes"));
                Double total = rs.getDouble("total_ventas");
                ventasPorMes.put(mes, total);
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        
        return ventasPorMes;
    }
    
    private String formatearMes(String mesAno) {
        // Convertir formato "2024-01" a "Ene 2024"
        String[] partes = mesAno.split("-");
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", 
                         "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
        int mes = Integer.parseInt(partes[1]) - 1;
        return meses[mes] + " " + partes[0];
    }
}
