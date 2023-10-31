package FraveMax.FraveMaxWeb;

public class DetalleVenta {
    private int idDetalle,idVenta,idProducto,cantidad;
    private double total;
    private boolean entregado;
    private String detalle;

    public DetalleVenta() {
    }

    public DetalleVenta(int idVenta, int idProducto, int cantidad, double total, boolean entregado,String detalle) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.total = total;
        this.entregado = entregado;
        this.detalle = detalle;
    }

    public DetalleVenta(int idDetalle, int idVenta, int idProducto, int cantidad, double total, boolean entregado,String detalle) {
        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.total = total;
        this.entregado = entregado;
                this.detalle = detalle;

    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
    
    
}
