package Modelo;
/**
 *
 * @author SrKolin
 */

import java.sql.*;
import java.util.*;

public class ProveedorDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    public boolean RegistrarProveedor(Proveedor pr){
        String sql = "INSERT INTO proveedor(RUC, Nombre, Telefono, Direccion, Razon) VALUES (?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getRuc());
            ps.setString(2, pr.getNombre());
            ps.setInt(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getRazon());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println(e.toString());
            }
        }
    }
    
    public List ListaProveedor(){
        List<Proveedor> Listapr = new ArrayList();
        String sql = "SELECT * FROM proveedor";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Proveedor pr = new Proveedor();
                pr.setId(rs.getInt("Id"));
                pr.setRuc(rs.getInt("RUC"));
                pr.setNombre(rs.getString("Nombre"));
                pr.setTelefono(rs.getInt("Telefono"));
                pr.setDireccion(rs.getString("Direccion"));
                pr.setRazon(rs.getString("Razon"));
                Listapr.add(pr);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return Listapr;
    }
}
