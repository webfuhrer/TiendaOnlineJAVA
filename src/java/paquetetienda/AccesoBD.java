/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetienda;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class AccesoBD {

    static ArrayList<Producto> recuperarProductos() {
        
        Producto p1=new Producto(1, "Patatas", 2, 20);
        Producto p2=new Producto(2, "Tomates", 3, 15);
        Producto p3=new Producto(3, "Leche", 1, 30);
        Producto p4=new Producto(4, "Café", 4, 10);
        ArrayList<Producto> lista=new ArrayList<>();
        lista.add(p4);
        lista.add(p3);
        lista.add(p2);
        lista.add(p1);
        return lista;
    }

    static ArrayList<Producto> recuperarProductosPorID(ArrayList<Integer> productos_comprados) {
        ArrayList<Producto> obj_productos_comprados=new ArrayList<>();
        for (Integer id : productos_comprados) {
            switch (id)
            {
                case 1:
                    Producto p1=new Producto(1, "Patatas", 2, 20);
                    obj_productos_comprados.add(p1);
                    break;
                case 2:
                    Producto p2=new Producto(2, "Tomates", 3, 15);
                    obj_productos_comprados.add(p2);
                    break;
                case 3:
                    Producto p3=new Producto(3, "Leche", 1, 30);
                    obj_productos_comprados.add(p3);
                    break;
                case 4:
                    Producto p4=new Producto(4, "Café", 4, 10);
                    obj_productos_comprados.add(p4);
                    break;
            }
        }
       return obj_productos_comprados;
    }
    
}
