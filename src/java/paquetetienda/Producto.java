/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetienda;

/**
 *
 * @author Mañanas
 */
public class Producto {
    private int id;
    private String nombre;
    private int precio;
    private int stock;

    //Este constructor se usará para recuperar los datos de la tabla
    public Producto(int id, String nombre, int precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    //Este constructor se usará para insertar productos en la tabla de la tienda. Esto lo hará el administrador
    public Producto(String nombre, int precio, int stock) {
        
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
    
    
}
