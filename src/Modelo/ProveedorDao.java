package Modelo;
/**
 *
 * @author SrKolin
 */

import java.sql.*;

public class ProveedorDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    public boolean RegistrarProveedor(Proveedor pr){
        String sql = "INSERT INTO proveedor(RUC, Nombre, Telefono, Direccion, Razon)";
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
}
