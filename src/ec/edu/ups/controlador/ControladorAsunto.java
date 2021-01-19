/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Asunto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author NANCY
 */
public class ControladorAsunto {
    private List<Asunto>listadoAsunto;

    public ControladorAsunto() {
        listadoAsunto= new ArrayList<>();
        this.cargardatos();
    }
    
    public boolean insertarAsunto(Asunto asunto){
        Connection con = ControladorBD.conectar();
        try{
            String sql="INSERT INTO ASUNTO(codigo, fecha_inicio, fecha_Finalizacion, estado, cedula_clientefk) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, asunto.getCodigo());
            ps.setDate(2, new java.sql.Date(asunto.getFechaInicio().getTime()));
            ps.setDate(3, new java.sql.Date(asunto.getFechaFinalizacion().getTime()));
            ps.setString(4, asunto.getEstado());
            ps.setString(5, asunto.getCedulaClientefk());
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

        listadoAsunto.clear();
        Connection con = ControladorBD.conectar();
        try{
            String sql="SELECT * FROM ASUNTO";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultado= ps.executeQuery();
            while(resultado.next()){
                Asunto a= new Asunto();
                a.setCodigo(resultado.getInt(1));
                a.setFechaInicio(new Date(resultado.getDate(2).getTime()));
                a.setFechaFinalizacion(new Date(resultado.getDate(3).getTime()));
                a.setEstado(resultado.getString(4));
                a.setCedulaClientefk(resultado.getString(5));
                listadoAsunto.add(a);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ControladorBD.Desconectar(con);
        }
    }

    public List<Asunto> getListadoAsunto() {
        return listadoAsunto;
    }
    
    public boolean eliminar(int codigo){
        Connection con = ControladorBD.conectar();
        try{
            String sql="DELETE FROM ASUNTO WHERE CODIGO = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
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
