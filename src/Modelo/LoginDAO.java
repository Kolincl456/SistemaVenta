package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                l.setRol(rs.getString("Rol"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return l;
    }
    public boolean Registrar(login reg){
        String sql = "INSERT INTO Usuarios (Nombre, Correo, Password, Rol) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getCorreo());
            ps.setString(3, reg.getPassword());
            ps.setString(4, reg.getRol());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
