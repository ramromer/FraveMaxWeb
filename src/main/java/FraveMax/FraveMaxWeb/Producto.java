package FraveMax.FraveMaxWeb;


public class Producto {
    private int idProducto;
    private int stock;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private double precio;
    private int enOferta;
    private boolean estado;

    public Producto() {
    }

    public Producto(int stock, String nombre, String descripcion, Categoria categoria, double precio, int enOferta, boolean estado) {
        this.stock = stock;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.enOferta = enOferta;
        this.estado = estado;
    }

    public Producto(int idProducto, int stock, String nombre, String descripcion, Categoria categoria, double precio, int enOferta, boolean estado) {
        this.idProducto = idProducto;
        this.stock = stock;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.enOferta = enOferta;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }
 
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEnOferta() {
        return enOferta;
    }

    public void setEnOferta(int enOferta) {
        this.enOferta = enOferta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", stock=" + stock + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria + ", precio=" + precio + ", enOferta=" + enOferta + '}';
    }
    
    
    
    
    
    
    
}
