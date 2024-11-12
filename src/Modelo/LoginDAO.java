package Modelo;

import java.sql.*;

/**
 *
 * @author Kolin
 */
public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public login log(String correo, String password){
        login l = new login();
        String sql = "SELECT * FROM usuarios WHERE Correo = ? AND Password = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                l.setId(rs.getInt("Id"));
                l.setNombre(rs.getString("Nombre"));
                l.setCorreo(rs.getString("Correo"));
                l.setPassword(rs.getString("Password"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return l;
    }
}
