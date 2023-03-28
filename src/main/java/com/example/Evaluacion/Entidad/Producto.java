package com.example.Evaluacion.Entidad;

public class Producto {
    private int Codigo;
    private String Nombre;
    private String Categoria;
    private int Precio;
    private int Cantidad;
    private int total;
    private int total_iva;
    private int descuento;

    public Producto(int codigo, String nombre, String categoria, int precio, int cantidad) {
        Codigo = codigo;
        Nombre = nombre;
        Categoria = categoria;
        Precio = precio;
        Cantidad = cantidad;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_iva() {
        return total_iva;
    }

    public void setTotal_iva(int total_iva) {
        this.total_iva = total_iva;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Codigo=" + Codigo +
                ", Nombre='" + Nombre + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", Precio=" + Precio +
                ", Cantidad=" + Cantidad +
                '}';
    }
}
