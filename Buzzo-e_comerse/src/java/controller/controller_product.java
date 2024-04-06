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
import java.util.ArrayList;
import java.util.List;
import model.CategoryDAO;
import model.Consumer;
import model.ConsumerDAO;
import model.Product;
import model.ProductDAO;
import model.History;
import model.HistoryDao;
/**
 *
 * @author university
 */
@WebServlet(name = "controller_product", urlPatterns = {"/controller_product"})
public class controller_product extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ProductDAO productDao = new ProductDAO();
    CategoryDAO categoryDao = new CategoryDAO();
    List<Product> products = new ArrayList<>();
    HistoryDao historyDao = new HistoryDao();    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.
                getParameter("action");
        
        switch(action){
            case "home":
                request.getRequestDispatcher("homepage.jsp").forward(request, response);
                break;
            case "allproducts":
                products = productDao.getAllProducts();
                request.setAttribute("products", products);
                request.getRequestDispatcher("AllProducts.jsp").forward(request, response);
                break;
            case "search":
                String searchKeyword = request.getParameter("searchKeyword");
                products = productDao.searchProducts(searchKeyword);
                request.setAttribute("products", products);
                request.getRequestDispatcher("SearchResults.jsp").forward(request, response);
                break;
            case "historialButton":
               int consumerId = (int) request.getSession().getAttribute("consumerId");
                ConsumerDAO consumerDAO = new ConsumerDAO();
                    Consumer consumer = consumerDAO.getConsumerById(consumerId);
                List<History> historyIn = historyDao.getPurchaseDetailsByConsumerId(consumer.getIdConsumer());
                request.setAttribute("historyIn", historyIn);
                request.getRequestDispatcher("historial.jsp").forward(request, response);
                break;
            case "category":
                String name = request.getParameter("name");
                int idCategory = categoryDao.getCategoryByName(name);
                products = productDao.getProductsByCategory(idCategory);
                request.setAttribute("products", products);
                if(name.equals("Books")){
                    request.getRequestDispatcher("categoryBooks.jsp").forward(request, response);
                }else if(name.equals("Clothes")){
                    request.getRequestDispatcher("categoryClothes.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("categorySchool.jsp").forward(request, response);
                }
                
                break;
            default:
                products = productDao.getAllProducts();
                request.setAttribute("products", products);
                request.getRequestDispatcher("homepage.jsp").forward(request, response);
                break;
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
