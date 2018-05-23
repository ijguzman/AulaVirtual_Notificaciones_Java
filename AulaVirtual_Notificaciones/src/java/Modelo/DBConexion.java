/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author CORE I7
 */
public class DBConexion {
    Connection miConexion = null;
    
    public DBConexion(){
        
    }
    
    public Connection dameConexion(){
        try{
            
            miConexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/AulaVirtual_Notificaciones","root","Inrikingjc1107.");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return miConexion;
    }
    
}
