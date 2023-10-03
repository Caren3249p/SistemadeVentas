package Controlador;

import java.sql.ResultSet;
import Conecxion.Conecxion;
import java.sql.Connection;
import Modelo.Categoria;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import java.beans.Statement;

/**
 *
 * @author caren
 */
public class Ctrl_Categoria {

    //metodo de registro de categorias
    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        Connection cn = Conecxion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("insert into tb_categoria values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar categoria" + e);
        }
        return respuesta;
    }
// consultar si existe categoria

    public boolean existeCategoria(String categoria) {
        boolean respuesta = false;

        try {
            try (Connection cn = Conecxion.conectar(); java.sql.Statement st = cn.createStatement()) {

                String sql = "select descripcion from tb_categoria where descripcion = " + categoria + "'";

                try (ResultSet rs = st.executeQuery(sql)) {
                    if (rs.next()) {
                        int count = rs.getInt(1);
                        respuesta = (count > 0);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar categoría: " + e);
        }
        return respuesta;
    }

    public boolean actualizar(Categoria objeto, int idCategoria) {
        boolean respuesta = false;
        Connection cn = Conecxion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update tb_categoria set descripcion = ? where idCategoria=" + idCategoria + "");
            consulta.setString(1, objeto.getDescripcion());
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al acrualizar categoria" + e);
        }
        return respuesta;
    }

    public boolean eliminar(int idCategoria) {
        boolean respuesta = false;
        Connection cn = Conecxion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("delete from tb_caregoria where idCategoria=" + idCategoria + "");
            consulta.executeUpdate();
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar categoria" + e);
        }
        return respuesta;
    }

}
