package com.techlab.productos.model;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;

    public Categoria(){}

    public Categoria(int id, String nombre, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //GETTER
    public int getID(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    //SETTER
    public void setID(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;    
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

     @Override
    public String toString() {
        return "Producto [" +
                "ID: " + id +
                ", nombre: '" + nombre + '\'' +
                ", descripcion: " + descripcion +
                ']';
    }
}
