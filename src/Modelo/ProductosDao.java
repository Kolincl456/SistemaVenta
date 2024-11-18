package Modelo;

/**
 *
 * @author USUARIO
 */
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class ProductosDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProducto(Productos pro){
        String sql = "INSERT INTO productos (Codigo, Nombre, Proveedor, Stock, Precio) VALUES (?, ?, ?, ?, ?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    public void ConsultarProveedor(JComboBox proveedor){
        String sql = "SELECT nombre FROM proveedor";
        try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               proveedor.addItem(rs.getString("Nombre"));
           }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    public List ListarProductos(){
        List<Productos> Listapro = new ArrayList();
        String sql  = "SELECT * FROM productos";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos pro = new Productos();
                pro.setId(rs.getInt("Id"));
                pro.setCodigo(rs.getNString("Codigo"));
                pro.setNombre(rs.getString("Nombre"));
                pro.setProveedor(rs.getString("Proveedor"));
                pro.setStock(rs.getInt("Stock"));
                pro.setPrecio(rs.getInt("Precio"));
                Listapro.add(pro);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return Listapro;
    }
     public boolean EliminarProductos(int id){
        String sql = "DELETE FROM productos WHERE Id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
}
