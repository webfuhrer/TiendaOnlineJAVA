/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author Mañanas
 */
public class AccesoBD {

    static ArrayList<Producto> recuperarProductos() {
        ArrayList<Producto> lista=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://10.2.130.13:3306/lista_compra?serverTimezone=UTC", "root", "");
            Statement stmt=c.createStatement();
            String query="SELECT * FROM productos";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                String nombre=rs.getString("nombre");
                int precio=rs.getInt("precio");
                int id=rs.getInt("id");
                int stock=rs.getInt("stock");
                Producto p=new Producto(id, nombre, precio, stock);
                lista.add(p);
            }
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
          return lista;
    }

    static ArrayList<Producto> recuperarProductosPorID(ArrayList<Integer> productos_comprados) {
        ArrayList<Producto> obj_productos_comprados=new ArrayList<>();
        String lista_comas="";
        for(int id: productos_comprados)
        {
            lista_comas+=id+",";
        }
        lista_comas=lista_comas.substring(0, lista_comas.length()-1);
        String query="select * from productos where id in("+lista_comas+")";
        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:mysql://10.2.130.13:3306/lista_compra?serverTimezone=UTC", "root", "");
            Statement stmt=c.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                String nombre=rs.getString("nombre");
                int precio=rs.getInt("precio");
                int id=rs.getInt("id");
                int stock=rs.getInt("stock");
                Producto p=new Producto(id, nombre, precio, stock);
                obj_productos_comprados.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return obj_productos_comprados;
    }
    
}
