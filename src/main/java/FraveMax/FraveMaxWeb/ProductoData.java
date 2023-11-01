package FraveMax.FraveMaxWeb;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProductoData {

    private Connection con = null;

    public ProductoData() {
        con = Conexion.getConexion();

    }

    public void agregarProducto(Producto producto) {
        String sql = "INSERT INTO producto (stock,nombre,descripcion,categoria,precio,estado,enOferta,imagen) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, producto.getStock());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setString(4, producto.getCategoria().toString());
            ps.setDouble(5, producto.getPrecio());
            ps.setBoolean(6, producto.isEstado());
            ps.setInt(7, producto.getEnOferta());
            ps.setString(8, producto.getImagen());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto Guardado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar producto" + ex.getMessage());

        }

    }

    public void modificarProducto(Producto producto) {
        String sql = "UPDATE producto SET stock=?,nombre=?,descripcion=?,categoria=?,precio=?,estado=?,enOferta=?,imagen=? WHERE idProducto=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getStock());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setString(4, producto.getCategoria().toString());
            ps.setDouble(5, producto.getPrecio());
            ps.setBoolean(6, producto.isEstado());
            ps.setInt(7, producto.getEnOferta());
            ps.setInt(8, producto.getIdProducto());
            ps.setString(9, producto.getImagen());
            int exito = ps.executeUpdate();
            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Producto modificado");
                System.out.println("Producto Modificado");
            }
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error, No se pudo modificar " + ex.getMessage());
            System.out.println(ex.getMessage());
        }

    }

    public void borrarProducto(int id) {
        String sql = "DELETE FROM producto WHERE idProducto=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int exito = ps.executeUpdate();
            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Producto eliminado");
                System.out.println("Producto Eliminado");
            }
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto " + ex.getMessage());
            System.out.println("Algo salio mal: "+ex.getSQLState()+"/n/n/n ..O sino: " + ex.getMessage());
        }
    }

    public ArrayList<Producto> listarProductos() {
        String sql = "SELECT * FROM producto";
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setStock(rs.getInt("stock"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                producto.setPrecio(rs.getInt("precio"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setEnOferta(rs.getInt("enOferta"));
                producto.setImagen(rs.getString("imagen"));
                productos.add(producto);
            }

        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "ERROR " + ex.getMessage());
            System.out.println("Algo salio mal: "+ ex.getMessage());
        }
        return productos;
    }
    public Producto listarProducto(int id){
        String sql = "SELECT * FROM producto WHERE idProducto="+id;
        Producto producto = new Producto();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setStock(rs.getInt("stock"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                producto.setPrecio(rs.getInt("precio"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setEnOferta(rs.getInt("enOferta"));
                producto.setImagen(rs.getString("imagen"));

            }

        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
            System.out.println("Algo salio mal:" + ex.getMessage());
        }
        return producto;
    }
    public List<Producto> buscarProductos(String busqueda, String categoria){
//       String sql="SELECT DISTINCT * FROM producto WHERE nombre LIKE '"+busqueda+"'% or descripcion LIKE '"+busqueda+"'%";
        String sql ="SELECT * FROM producto WHERE (nombre LIKE ? OR descripcion LIKE ?) AND (categoria = ?)";
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, busqueda+ "%");
            ps.setString(2, busqueda+ "%");
            ps.setString(3, categoria);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setStock(rs.getInt("stock"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                producto.setPrecio(rs.getInt("precio"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setEnOferta(rs.getInt("enOferta"));
                producto.setImagen(rs.getString("imagen"));
                productos.add(producto);

            }
            ps.close();
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error. No se encontro " + ex.getMessage());
            System.out.println("error: "+ex.getMessage());
        }
        return productos;
    }

    public List<Producto> buscarProductos(String busqueda){
//       String sql="SELECT DISTINCT * FROM producto WHERE nombre LIKE '"+busqueda+"'% or descripcion LIKE '"+busqueda+"'%";
        String sql ="SELECT * FROM producto WHERE nombre LIKE ? OR descripcion LIKE ?";
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, busqueda+ "%");
            ps.setString(2, busqueda+ "%");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setStock(rs.getInt("stock"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                producto.setPrecio(rs.getInt("precio"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setEnOferta(rs.getInt("enOferta"));
                producto.setImagen(rs.getString("imagen"));
                productos.add(producto);

            }
            ps.close();
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error. No se encontro " + ex.getMessage());
            System.out.println("error: "+ex.getMessage());
        }
        return productos;
    }
}

