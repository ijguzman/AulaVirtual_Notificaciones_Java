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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CORE I7
 */
public class Consultas {
    
    public Consultas(){
        miConexion=new DBConexion();
    }
    public ResultSet Escoger_Rol(){
        Connection conecta=miConexion.dameConexion();
        rs=null;
        try {
            ps=conecta.prepareStatement(rol_persona);       
            rs=ps.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println("No");
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet Escoger_Usuario(){
        Connection conecta=miConexion.dameConexion();
        rs=null;
        try {
            ps=conecta.prepareStatement(usuario_persona);       
            rs=ps.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println("No");
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    private DBConexion miConexion;
    private ResultSet rs;
    private PreparedStatement ps;
    private final String rol_persona="SELECT * FROM seg_rol";
    private final String usuario_persona="SELECT * FROM seg_usuario";
    private final String asignar_rol_usuario="INSERT INTO rol_persona VALUES(?,?,'01')";
    
}
