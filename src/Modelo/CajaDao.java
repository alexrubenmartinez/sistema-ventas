/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class CajaDao {
    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public Caja obtenerUltimaCajaAbierta() {
        Caja caja = null;
        String sql = "SELECT * FROM caja WHERE estado = 'abierta' ORDER BY fecha_apertura DESC LIMIT 1";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) { 
                caja = new Caja();
                caja.setId(rs.getInt("id"));
                caja.setUsuarioId(rs.getInt("usuario_id"));
                caja.setMontoInicial(rs.getBigDecimal("monto_inicial"));
                caja.setMontoFinal(rs.getBigDecimal("monto_final"));
                
                // Convertir Timestamp a LocalDateTime
                Timestamp fechaApertura = rs.getTimestamp("fecha_apertura");
                if (fechaApertura != null) {
                    caja.setFechaApertura(fechaApertura.toLocalDateTime());
                }
                
                Timestamp fechaCierre = rs.getTimestamp("fecha_cierre");
                if (fechaCierre != null) {
                    caja.setFechaCierre(fechaCierre.toLocalDateTime());
                }
                
                caja.setEstado(Caja.EstadoCaja.valueOf(rs.getString("estado").toUpperCase()));
                caja.setTotalVentas(rs.getBigDecimal("total_ventas"));
                caja.setObservaciones(rs.getString("observaciones"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener la última caja abierta: " + e.toString());
        } finally {
            cerrarRecursos();
        }
        
        return caja;
    }
    
     public Caja obtenerUltimaCaja() {
        Caja caja = null;
        String sql = "SELECT * FROM caja ORDER BY fecha_apertura DESC LIMIT 1";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                caja = mapearCaja(rs);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la última caja registrada: " + e.toString());
        } finally {
            cerrarRecursos();
        }

        return caja;
    }

      private Caja mapearCaja(ResultSet rs) throws SQLException {
        Caja caja = new Caja();
        caja.setId(rs.getInt("id"));
        caja.setUsuarioId(rs.getInt("usuario_id"));
        caja.setMontoInicial(rs.getBigDecimal("monto_inicial"));
        caja.setMontoFinal(rs.getBigDecimal("monto_final"));

        // Convertir Timestamp a LocalDateTime
        Timestamp fechaApertura = rs.getTimestamp("fecha_apertura");
        if (fechaApertura != null) {
            caja.setFechaApertura(fechaApertura.toLocalDateTime());
        }

        Timestamp fechaCierre = rs.getTimestamp("fecha_cierre");
        if (fechaCierre != null) {
            caja.setFechaCierre(fechaCierre.toLocalDateTime());
        }

        caja.setEstado(Caja.EstadoCaja.valueOf(rs.getString("estado").toUpperCase()));
        caja.setTotalVentas(rs.getBigDecimal("total_ventas"));
        caja.setObservaciones(rs.getString("observaciones"));

        return caja;
    }
      private void cerrarRecursos() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexiones: " + e.toString());
        }
    }
}
