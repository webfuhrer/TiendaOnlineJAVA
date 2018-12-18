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
public class PintarHTML {
    public static String pintarTabla(ArrayList<Producto> lista)
    {
        String html="";
        int precio_total=0;
        html+="<table border=1>";
        html+="<tr><th>Producto</th><th>Precio</th></tr>";
        for (Producto producto : lista) {
            html+="<tr><td>"+producto.getNombre()+"</td><td>"+producto.getPrecio()+"</td></tr>";
            precio_total+=producto.getPrecio();
        }
        html+="<tr><td>Total:</td><td>"+precio_total+"</td></tr>";   
        html+="</table>";
        return html;
    }
}
