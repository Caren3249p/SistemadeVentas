package Modelo;

/**
 *
 * @author caren
 */
public class Categoria {

    private int idCtegoria;
    private String descripcion;
    private int estado;

    public Categoria() {
        this.idCtegoria = 0;
        this.descripcion = "";
        this.estado = 0;
    }

    public Categoria(int idCtegoria, String descripcion, int estado) {
        this.idCtegoria = idCtegoria;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdCtegoria() {
        return idCtegoria;
    }

    public void setIdCtegoria(int idCtegoria) {
        this.idCtegoria = idCtegoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
