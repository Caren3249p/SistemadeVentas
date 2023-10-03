package Conecxion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author caren
 */
public class Conecxion {
    
public static Connection conectar() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/bd_Sistema_Ventas?useSSL=false", "root", "Caren200505.");
        } catch (SQLException e) {
            System.out.println("Error de la conexion");
        }
        return null;
    }

}
