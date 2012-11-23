/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import controller.dao.DaoProducto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BeanProducto;

/**
 *
 * @author willy
 */
public class ServletProducto extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String accion = request.getParameter("accion");
        String msg = null;

        if (accion == null) {
            msg = "Ingreso icorrecto!";
        } else if (accion.compareTo("INS") == 0) {
            String descripcion = request.getParameter("descripcion");
            String cantidad = request.getParameter("cantidad");
            String costo = request.getParameter("costo");
            String precio = request.getParameter("precio");
            String fecing = request.getParameter("fecing");

            BeanProducto producto = new BeanProducto();
            producto.setDescripcion(descripcion);
            producto.setCantidad(cantidad);
            producto.setCosto(costo);
            producto.setPrecio(precio);
            producto.setFecing(fecing);

            msg = DaoProducto.insert(producto);
        } else if (accion.compareTo("UPD") == 0) {
            String codigo = request.getParameter("codigo");
            String descripcion = request.getParameter("descripcion");
            String cantidad = request.getParameter("cantidad");
            String costo = request.getParameter("costo");
            String precio = request.getParameter("precio");
            String fecing = request.getParameter("fecing");

            BeanProducto producto = new BeanProducto();
            producto.setCodigo(codigo);
            producto.setDescripcion(descripcion);
            producto.setCantidad(cantidad);
            producto.setCosto(costo);
            producto.setPrecio(precio);
            producto.setFecing(fecing);

            msg = DaoProducto.update(producto);
        } else if (accion.compareTo("DEL") == 0) {
            String codigo = request.getParameter("codigo");

            BeanProducto producto = new BeanProducto();
            producto.setCodigo(codigo);

            msg = DaoProducto.delete(producto);
        } else {
            msg = "Acci&oacute;n desconocida!";
        }

        if (msg == null) {
            msg = "Operaci&oacute;n exitosa!";
        }

        request.getSession().setAttribute("msg", msg);
        response.sendRedirect("jsp/mensaje.jsp");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
