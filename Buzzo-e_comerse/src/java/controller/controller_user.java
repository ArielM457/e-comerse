/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Consumer;
import model.ConsumerDAO;
import model.Purchase;
import model.PurchaseDAO;
import model.PurchaseDetail;
import model.PurchaseDetailDAO;
import model.ShoppingCart;

/**
 *
 * @author university
 */
@WebServlet(name = "controller_user", urlPatterns = {"/controller_user"})
public class controller_user extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Consumer consumer = new Consumer();
    ConsumerDAO consumerDao = new ConsumerDAO();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String action = request.getParameter("action");
        switch(action){
            case "login":
                request.setAttribute("counter", 0);
                int id = Integer.parseInt(request.getParameter("id"));
                consumer = consumerDao.getConsumerById(id);
                request.getRequestDispatcher("controller_product?action=home").forward(request, response);
                break;
            case "profile":
                request.setAttribute("user", consumer);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            case "buyNow":
                request.getRequestDispatcher("controller_shoppingCart?action=buyNow&idConsumer="+consumer.getIdConsumer()).forward(request, response);
                break;
            default:
                request.setAttribute("counter", 0);
                request.setAttribute("user", consumer);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
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

}
