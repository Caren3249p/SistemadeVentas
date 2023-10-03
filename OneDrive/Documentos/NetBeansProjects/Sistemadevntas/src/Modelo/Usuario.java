
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author caren
 */
public class Usuario {
    //atributos
    private  int idUsuario;
    private  String nombre;
    private  String apellido;
    private  String usuario;
    private final  int password;
    private  String telefono;
    private  int estado;
    
    
   public Usuario() {
        this.password = 12345;
    // Deja el constructor vacío o inicializa los atributos si es necesario
}



    // set-get

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPassword() {
        return password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setPassword(String contrasenaTexto) {
        int password1 = this.password;
    }
    
    
    
}
