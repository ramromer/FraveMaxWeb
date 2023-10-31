package FraveMax.FraveMaxWeb;

import java.time.LocalDate;
import java.util.Date;

public class Usuario {
    private int idUsuario;
    private Rol rol;
    private int dni;
    private String nombre;
    private String apellido;
    private Date fechaIngreso;
    private String usuario;
    private String pass, salt, tel, domicilio, email;

    public Usuario() {
    }

    public Usuario(Rol rol, int dni, String nombre, String apellido, Date fechaIngreso, String usuario, String pass, String salt, String tel, String domicilio, String email) {
        this.rol = rol;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaIngreso = fechaIngreso;
        this.usuario = usuario;
        this.pass = pass;
        this.salt = salt;
        this.tel = tel;
        this.domicilio = domicilio;
        this.email = email;
    }

    public Usuario(int idUsuario, Rol rol, int dni, String nombre, String apellido, Date fechaIngreso, String usuario, String salt,String pass, String tel, String domicilio, String email) {
        this.idUsuario = idUsuario;
        this.rol = rol;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaIngreso = fechaIngreso;
        this.usuario = usuario;
        this.pass = pass;
        this.salt = salt;
        this.tel = tel;
        this.domicilio = domicilio;
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
            
}
