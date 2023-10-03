
package Modelo;

import javax.print.DocFlavor;

/**
 *
 * @author caren
 */
public class Producto {
    private  int idProducto;
    private  String nombres;
    private  int cantidad;
    private double presio;
    private String descripcion;
    private int porcentajeIva;
    private  int idCategoria;
    private int estado;
    
    public  Producto(){
        this.idProducto=0;
        this.nombres="";
        this.cantidad=0;
        this.presio = 0.0;
        this.porcentajeIva=0;
        this.idCategoria=0;
    }
    //recargado
    public Producto(int idProducto, String nombres, int cantidad, double presio, String descripcion, int porcentajeIva, int idCategoria, int estado) {
        this.idProducto = idProducto;
        this.nombres = nombres;
        this.cantidad = cantidad;
        this.presio = presio;
        this.descripcion = descripcion;
        this.porcentajeIva = porcentajeIva;
        this.idCategoria = idCategoria;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPresio() {
        return presio;
    }

    public void setPresio(double presio) {
        this.presio = presio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(int porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
