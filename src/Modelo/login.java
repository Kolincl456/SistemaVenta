package Modelo;
/**
 *
 * @author Kolin
 */
public class login {
    private int Id;
    private String nombre;
    private String correo;
    private String password;
    
    public login(){
    }
    
    public login(int Id, String nombre, String correo, String password) {
        this.Id = Id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
