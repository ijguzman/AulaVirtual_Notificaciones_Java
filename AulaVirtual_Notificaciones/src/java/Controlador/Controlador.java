/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Consultas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author CORE I7
 */
@Named(value = "Controlador")
@RequestScoped
/**
 *
 * @author CORE I7
 */
public class Controlador {
    Consultas consultas=new Consultas();
    ArrayList<String> lista_rol=new ArrayList<String>();
    ArrayList<String> lista_usuario=new ArrayList<String>();
    public void Asignar_Rol(){
        try {
            while(consultas.Escoger_Rol().next()){
                lista_rol.add(consultas.Escoger_Rol().getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(consultas.Escoger_Rol().next()){
                lista_usuario.add(consultas.Escoger_Rol().getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<String> GetRoles(){
        Asignar_Rol();
        return lista_rol;
    }
    public  ArrayList<String> GetUsuario(){
        Asignar_Rol();
        return lista_usuario;
    }
}
