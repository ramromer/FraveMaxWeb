package FraveMax.FraveMaxWeb;


public class Cliente {
    private int idCliente;
    private int dni;
    private String apellido;
    private String nombre;
    private String domicilio;
    private String tel;
    private String email; 

    public Cliente() {
    }

    public Cliente(int dni, String apellido, String nombre, String domicilio, String tel,String email) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.tel=tel;
        this.email = email;
    }

    public Cliente(int idCliente, int dni, String apellido, String nombre, String domicilio,String tel, String email) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.tel=tel;
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", domicilio=" + domicilio + ", email=" + email + '}';
    }
    
    
    
    
}
