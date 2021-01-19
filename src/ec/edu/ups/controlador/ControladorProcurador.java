/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;
import ec.edu.ups.modelo.Procurador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author NANCY
 */
public class ControladorProcurador {
    private List<Procurador>listadoProcurador;

    public ControladorProcurador() {
        listadoProcurador= new ArrayList<>();
        this.cargardatos();
    }
    
    public boolean insertarAsunto(Procurador procurador){
        Connection con = ControladorBD.conectar();
        try{
            String sql="INSERT INTO PROCURADOR(cedula, nombre, apellido, codigofk) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, procurador.getCedula());
            ps.setString(2, procurador.getNombre());
            ps.setString(3, procurador.getApellido());
            ps.setInt(4, procurador.getCodigofk());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            ControladorBD.Desconectar(con);
        }
        return true;
    }
    
    public void actualizar(){
        Connection con = ControladorBD.conectar();
        try{
            String sql="DELETE FROM ASUNTO WHERE CODIGO = ?";
            PreparedStatement ps = con.prepareStatement(sql);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ControladorBD.Desconectar(con);
        }
    }
    
    public void cargardatos(){

        listadoProcurador.clear();
        Connection con = ControladorBD.conectar();
        try{
            String sql="SELECT * FROM PROCURADOR";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultado= ps.executeQuery();
            while(resultado.next()){
                Procurador p= new Procurador();
                p.setCedula(resultado.getString(1));
                p.setNombre(resultado.getString(2));
                p.setApellido(resultado.getString(3));
                p.setCodigofk(resultado.getInt(4));
                listadoProcurador.add(p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ControladorBD.Desconectar(con);
        }
    }

    public List<Procurador> getListadoProcurador() {
        return listadoProcurador;
    }
    
    public boolean eliminar(String cedula){
        Connection con = ControladorBD.conectar();
        try{
            String sql="DELETE FROM Procurador WHERE CEDULA = ?";
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
