
package Controlador;

import Conecxion.Conecxion;
import Modelo.Categoria;
import Modelo.Producto;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author caren
 */
public class Ctrl_Producto {
    //modelo de guarda producto
    public boolean guardar(Producto objeto) {
        boolean respuesta = false;
        Connection cn = Conecxion.conectar();
        try {
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("insert into tb_producto values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getNombres());
            consulta.setInt(3,objeto.getCantidad());
            consulta.setDouble(4, objeto.getPresio());
            consulta.setString(5, objeto.getDescripcion());
            consulta.setInt(6, objeto.getPorcentajeIva());
            consulta.setInt(7, objeto.getIdCategoria());
            consulta.setInt(8, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar producto" + e);
        }
        return respuesta;
    }
// consultar si existe producto

    public boolean existeProducto(String producto) {
        boolean respuesta = false;

        try {
            try (Connection cn = Conecxion.conectar(); java.sql.Statement st = cn.createStatement()) {

                String sql = "select descripcion from tb_producto where descripcion = " + producto + "'";

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
}
