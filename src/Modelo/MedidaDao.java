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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lexss
 */
public class MedidaDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
   public List ListarMedidas() {
    List<Medida> listaMedidas = new ArrayList<>();
    String sql = "SELECT * FROM medida";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Medida med = new Medida();
            med.setId(rs.getInt("id"));
            med.setNombre(rs.getString("nombre"));
            med.setNombre_corto(rs.getString("nombre_corto"));
            listaMedidas.add(med);
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
    return listaMedidas;
} 
    
}
