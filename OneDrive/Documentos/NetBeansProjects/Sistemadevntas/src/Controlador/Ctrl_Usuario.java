package Controlador;

import java.sql.PreparedStatement;

import java.sql.Statement;
import Conecxion.Conecxion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author caren
 */
public class Ctrl_Usuario {

    // metodo para iniciar sesion
    public boolean loginUser(Usuario objeto) throws SQLException {
        boolean respuesta = false;
        try (Connection cn = Conecxion.conectar()) {
        String sql = "SELECT usuario, password FROM tb_usuario WHERE usuario = ? AND password = ?";

            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                // Establecer los valores de los parámetros
                ps.setString(1, objeto.getUsuario()); // El primer parámetro
                ps.setInt(2, objeto.getPassword()); // El segundo parámetro

                // Procesar el resultado
                try (ResultSet rs = ps.executeQuery()) {
                    // Procesar el resultado
                    if (rs.next()) {
                        respuesta =  true;
                    }
                }
            }
            // El primer parámetro // El primer parámetro
            catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());

        }

        return respuesta;
    }

}
}
