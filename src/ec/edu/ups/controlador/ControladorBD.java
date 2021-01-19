/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author NANCY
 */
public class ControladorBD {
    
    public static Connection conectar(){
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/PracticaClase", "postgres", "Raaf2001");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static void Desconectar(Connection con){
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
