package FraveMax.FraveMaxWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author emanuel y sus amigos
 */
public class Conexion {
    private static final String PORT= "3306";//System.getProperty("PORT");
    private static String URL = "jdbc:mariadb://localhost:";
    private static final String DB="/Prueba";
    private static final String USUARIO="root";//System.getProperty("USER");
    private static final String PASSWORD="r00tr00t";//System.getProperty("PASS");;
    private static Connection connection;

    private Conexion(){}
    public static Connection getConexion(){

        if (connection==null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                System.out.println("Conectando a: "+URL+PORT+DB);
                connection= DriverManager.getConnection(URL+PORT+DB,USUARIO,PASSWORD);
                System.out.println("Conectado!");

            } catch (ClassNotFoundException ex) {
                System.out.println("Error al cargar los Driver: "+ ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Error al conectar con la base de datos"+ex.getMessage());

            }


        }
        return connection;
    }


}