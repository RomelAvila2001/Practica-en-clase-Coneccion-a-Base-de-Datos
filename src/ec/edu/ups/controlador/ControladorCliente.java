/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;
import ec.edu.ups.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author NANCY
 */
public class ControladorCliente {
    private List<Cliente>listadoCliente;

    public ControladorCliente() {
        listadoCliente= new ArrayList<>();
        this.cargardatos();
    }
    
    public boolean insertarAsunto(Cliente cliente){
        Connection con = ControladorBD.conectar();
        try{
            String sql="INSERT INTO CLIENTE(cedula, nombre, apellido, direccion) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getCedula());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getDireccion());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            ControladorBD.Desconectar(con);
        }
        return true;
    }
    
    public boolean actualizar(Cliente cliente){
        Connection con = ControladorBD.conectar();
        try{
            String sql="UPDATE CLIENTE SET nombre = ?, apellido = ?, direccion= ? WHERE cedula = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getCedula());
            ps.executeUpdate(); 
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            ControladorBD.Desconectar(con);
        }
    }
    
    public void cargardatos(){

        listadoCliente.clear();
        Connection con = ControladorBD.conectar();
        try{
            String sql="SELECT * FROM CLIENTE";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultado= ps.executeQuery();
            while(resultado.next()){
                Cliente c= new Cliente();
                c.setCedula(resultado.getString(1));
                c.setNombre(resultado.getString(2));
                c.setApellido(resultado.getString(3));
                c.setDireccion(resultado.getString(4));
                listadoCliente.add(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ControladorBD.Desconectar(con);
        }
    }

    public List<Cliente> getListadoCliente() {
        return listadoCliente;
    }
    
    public boolean eliminar(String cedula){
        Connection con = ControladorBD.conectar();
        try{
            String sql="DELETE FROM CLIENTE WHERE CEDULA = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            ControladorBD.Desconectar(con);
        }
        
    }
}
