/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mañanas
 */
@WebServlet(name = "ServletTienda", urlPatterns = {"/ServletTienda"})
public class ServletTienda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        HttpSession session=request.getSession();
        if (accion.equals("entrar"))
        {
            //1-Recuperar los productos de la tienda
            ArrayList<Producto> productos_tienda=AccesoBD.recuperarProductos();
            request.setAttribute("productos_tienda", productos_tienda);
            //2-Poner en session el arraylist de productos comprados
            ArrayList<Compra> productos_comprados=new ArrayList<>();
            session.setAttribute("productos_comprados", productos_comprados);
            //3-Mandarle a verproductos.jsp
            request.getRequestDispatcher("verproductos.jsp").forward(request, response);
        }else if (accion.equals("comprar"))
        {
            //-Veo que producto quiere comprar
            String id_producto=request.getParameter("id_producto");
            int id=Integer.parseInt(id_producto);
            
            //2-Recupero de la session productos_comprados
            ArrayList<Compra> productos_comprados=(ArrayList<Compra>)session.getAttribute("productos_comprados");
            productos_comprados=actualizarCantidad(productos_comprados, id);
            //Modificar el stock
            session.setAttribute("productos_comprados", productos_comprados);
            //relleno el request con los productos y ñle mando a verproductos.jsp
            AccesoBD.actualizarStock(id);//UPDATE productos SET stock=stock-1 WHERE id=id //restamos 1 al stock
            ArrayList<Producto> productos_tienda=AccesoBD.recuperarProductos();
            request.setAttribute("productos_tienda", productos_tienda);
            request.getRequestDispatcher("verproductos.jsp").forward(request, response);
            
        }else if(accion.equals("vercompra"))
        {
            ArrayList<Compra> productos_comprados=(ArrayList<Compra>)session.getAttribute("productos_comprados");
            ArrayList<Producto> objetos_productos=AccesoBD.recuperarProductosPorID(productos_comprados);
            request.setAttribute("objetos_productos", objetos_productos);
            request.getRequestDispatcher("vercompra.jsp").forward(request, response);
        }else if(accion.equals("seguircomprando"))
        {
            ArrayList<Producto> productos_tienda=AccesoBD.recuperarProductos();
            request.setAttribute("productos_tienda", productos_tienda);
            request.getRequestDispatcher("verproductos.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private ArrayList<Compra> actualizarCantidad(ArrayList<Compra> productos_comprados, int id) {
        for (Compra compra : productos_comprados) {
            int id_comprado=compra.getId_producto();
            if(id_comprado==id)//Si entro, este producto ya se había comprado. Aumento la cantidad
            {
                int nueva_cantidad=compra.getCantidad()+1;
                compra.setCantidad(nueva_cantidad);
                return productos_comprados;//Al hacer el return ya estoy fuera
            }
        }
        //Producto no coprado previamente
        Compra c=new Compra(id, 1);
        productos_comprados.add(c);
        return productos_comprados;
        
    }

}
