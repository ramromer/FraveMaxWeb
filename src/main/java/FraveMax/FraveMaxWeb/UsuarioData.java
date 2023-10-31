package FraveMax.FraveMaxWeb;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioData {
    private Connection con = null;

    public UsuarioData() {
        con = Conexion.getConexion();
    }
    
    public void agregarUsuario(Usuario user) {
        String sql = "INSERT INTO usuario (rol,dni,nombre,apellido,fechaIngreso,usuario,pass,salt,tel,domicilio,email) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getRol().toString());
            ps.setInt(2, user.getDni());
            ps.setString(3, user.getNombre());
            ps.setString(4, user.getApellido());
            ps.setString(5, user.getFechaIngreso().toString());
            ps.setString(6, user.getUsuario());
            ps.setString(7, user.getPass());
            ps.setString(8, user.getSalt());
            ps.setString(9, user.getTel());
            ps.setString(10, user.getDomicilio());
            ps.setString(11, user.getEmail());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                user.setIdUsuario(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Usuario Guardado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Usuario: " + ex.getMessage());

        }
    }

    public void modificarUsuario(Usuario user) {
        String sql = "UPDATE usuario SET rol=?,dni=?,nombre=?,apellido=?,fechaIngreso=?,usuario=?,pass=?,salt=?,tel=?,domicilio=?,email=? WHERE idUsuario=?";
        try {
            System.out.println(user.getSalt()+"base");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getRol().toString());
            ps.setInt(2, user.getDni());
            ps.setString(3, user.getNombre());
            ps.setString(4, user.getApellido());
            ps.setString(5, user.getFechaIngreso().toString());
            System.out.println("Estamo aca: "+user.getFechaIngreso().toString());
            ps.setString(6, user.getUsuario());
            ps.setString(7, user.getPass());
            ps.setString(8, user.getSalt());
            ps.setString(9, user.getTel());
            ps.setString(10, user.getDomicilio());
            ps.setString(11, user.getEmail());
            
            ps.setInt(12, user.getIdUsuario());
            int exito=ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Usuario modificado");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, No se pudo modificar " + ex.getMessage());
            System.out.println(ex.getMessage());
        }

    }

    public void borrarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE idUsuario=" + id;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el Usuario " + ex.getMessage());

        }
    }
public Usuario listarUsuario(String nombreUsuario){
    String sql = "SELECT * FROM usuario WHERE usuario.usuario = '"+nombreUsuario+"'";
    Usuario user = new Usuario();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setRol(Rol.valueOf(rs.getString("rol")));
                user.setDni(rs.getInt("dni"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setFechaIngreso(rs.getDate("fechaIngreso"));
                user.setUsuario(rs.getString("usuario"));
                user.setPass(rs.getString("pass"));
                user.setSalt(rs.getString("salt"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());

        }
        return user;
    }

public Usuario listarUsuario(int dni){
    String sql = "SELECT * FROM usuario WHERE usuario.dni = '"+dni+"'";
    Usuario user = new Usuario();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setRol(Rol.valueOf(rs.getString("rol")));
                user.setDni(rs.getInt("dni"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setFechaIngreso(rs.getDate("fechaIngreso"));
                user.setUsuario(rs.getString("usuario"));
                user.setPass(rs.getString("pass"));
                user.setSalt(rs.getString("salt"));
                user.setTel(rs.getString("tel"));
                user.setDomicilio(rs.getString("domicilio"));
                user.setEmail(rs.getString("email"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());

        }
        return user;
    }



public ArrayList<Usuario> listarClientes(){
    ArrayList<Usuario> lista = new ArrayList<>();
     String sql = "SELECT * FROM usuario WHERE rol = 'Cliente'";
     //-----
try {
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();

           while (rs.next()) {
                
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setRol(Rol.valueOf(rs.getString("rol")));
                usuario.setDni(rs.getInt("dni"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setFechaIngreso(rs.getDate("fechaIngreso"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPass(rs.getString("pass"));
                usuario.setSalt(rs.getString("salt"));
                usuario.setTel(rs.getString("tel"));
                usuario.setDomicilio(rs.getString("domicilio"));
                usuario.setEmail(rs.getString("email"));
                
                lista.add(usuario);
                
            }
ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error. No se encontro " + ex.getMessage());

        }     
//-----
     
    return lista;
}
}
