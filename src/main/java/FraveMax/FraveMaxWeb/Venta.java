package FraveMax.FraveMaxWeb;

import java.util.Date;

public class Venta {

    private int idVenta, idUsuario, idCliente;
    private Date fecha;
    private double total;

    public Venta() {
    }

    public Venta(int idUsuario, Date fecha, double total, int idCliente) {

        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.total = total;
        this.idCliente = idCliente;

    }

    public Venta(int idVenta, int idUsuario, Date fecha, double total, int idCliente) {
        this.idVenta = idVenta;

        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.total = total;
        this.idCliente = idCliente;

    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    

}
