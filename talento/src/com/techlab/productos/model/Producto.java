package com.techlab.productos.model;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private Categoria categoria;

    public Producto(){}

    public Producto(int id, String nombre, double precio, Categoria categoria){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    //GETTER
    public int getID(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public double getPrecio(){
        return this.precio;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    //SETTER
    public void setID(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;    
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

     @Override
    public String toString() {
        return "Producto - " +
                "ID: " + id +
                ", nombre: '" + nombre + '\'' +
                ", precio: $" + precio +
                ", categoría: '" + categoria.getNombre() + '\'';
    }
}
