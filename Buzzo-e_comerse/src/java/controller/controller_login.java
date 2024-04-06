/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;


import connection.ConexionDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.*;
import model.Consumer;

/**
 *
 * @author university
 */
@WebServlet(name = "controller_login", urlPatterns = {"/controller_login"})
public class controller_login extends HttpServlet {

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
       
        //Obtenemos datos del JSP con su atributo name
        String email = request.getParameter("txtemail");
        String password=request.getParameter("txtpassword");

        if(!(email.isEmpty()&& password.isEmpty())){

            try{

                Connection connection=ConexionDB.getConnection();//Coneccion a la pase de datos
                //PreparedStatement es una consulta con parametros si es una consulta sin parametros usar solo Statement
                PreparedStatement statement = connection.prepareStatement("SELECT IDConsumidor FROM Consumidor WHERE CorreoElectronico=? AND Contrasena=?");
                statement.setString(1, email);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();//Aqui se guarda los datos de la consulta
                //Pregunta si hay datos en el resultado de la consulta si hay nos manda a homepage
                if(resultSet.next()){
                    //Crearmos un objeto almacenar al cosumidor
                    int consumerLogin = resultSet.getInt(1);
                    HttpSession sesionOK=request.getSession();
                    sesionOK.setAttribute("consumerId", consumerLogin); 
                    request.getRequestDispatcher("controller_user?action=login&id="+consumerLogin).forward(request, response);
                }else{
                    request.setAttribute("msg", "Usuario o contraseña incorrecta.");//adjuntamos un mensaje si no se encontro al consumidor
                    request.getRequestDispatcher("").forward(request, response);
                }
            }catch(ServletException | IOException | SQLException e){
                    e.printStackTrace();
                    //request.setAttribute("msg", "No se pudo conectar con la base de datos.");
                    //request.getRequestDispatcher("index.jsp").forward(request, response);
            }
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
        request.setAttribute("products","hola");
		processRequest(request, response);
    }

    /*public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
    
        Category categoryBooks = new Category(1, "Books");
        Category categoryClothes = new Category(2, "Clothes");
        Category categorySchool = new Category(3, "School");
    
        products.add(new Product(1, categoryBooks, "Harry Potter book series", 5000.0, 5));
        products.add(new Product(2, categoryBooks, "Love in times of anger", 50.00, 5));
        products.add(new Product(3, categoryBooks, "Dracula", 50.00, 5));
        products.add(new Product(4, categoryBooks, "Red, white and blood blood", 500.0, 5));
        products.add(new Product(5, categoryBooks, "IT", 50.00, 5));
        products.add(new Product(6, categoryBooks, "Zombie survival guide", 50.00, 5));
    
        products.add(new Product(7, categoryClothes, "Wool sweater", 1500.00, 5));
        products.add(new Product(8, categoryClothes, "Skirt", 1000.00, 5));
        products.add(new Product(9, categoryClothes, "Tshirts", 1500.00, 5));
        products.add(new Product(10, categoryClothes, "Jean pants", 1800.00, 5));
        products.add(new Product(11, categoryClothes, "Jean pants", 1500.00, 5));
        products.add(new Product(12, categoryClothes, "Baseball Jacket", 1500.0, 5));
        products.add(new Product(13, categoryClothes, "Jean pants", 1500.00, 5));
        products.add(new Product(14, categoryClothes, "Wool sweater", 1500.00, 5));
    
        products.add(new Product(15, categorySchool, "Compass Ascona", 800.0, 5));
        return products;
    }*/

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
