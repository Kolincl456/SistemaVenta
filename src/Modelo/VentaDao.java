package Modelo;
/**
 *
 * @author Kolin
 */

import java.sql.*;

public class VentaDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public int IdVenta(){
        int id = 0;
        String sql = "SELECT MAX(Id) FROM ventas";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }    
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return id;
    }
    public int RegistrarVenta(Venta v){
        String sql = "INSERT INTO ventas(Cliente, Vendedor, Total) VALUES(?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setString(2, v.getVendedor());
            ps.setDouble(3, v.getTotal());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return r;
    }
    public int RegistrarDetalle(Detalle Dv){
        String sql = "INSERT INTO detalle(Cod_pro, Cantidad, Precio, Id_venta) VALUES(?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, Dv.getCod_pro());
            ps.setInt(2, Dv.getCantidad());
            ps.setDouble(3, Dv.getPrecio());
            ps.setInt(4, Dv.getId());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return r;
    }
    public boolean ActualizarStock(int cant, String cod){
        String sql = "UPDATE productos SET Stock = ? WHERE Codigo = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
}
