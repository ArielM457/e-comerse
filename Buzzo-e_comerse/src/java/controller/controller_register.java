/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.ConexionDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import model.Consumer;

@WebServlet(name = "controller_register", urlPatterns = {"/controller_register"})
public class controller_register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("txtnombre");
        String email = request.getParameter("txtemail");
        String direccion = request.getParameter("txtadress");
        String password = request.getParameter("txtpassword");

        if (!(nombre.isEmpty() && email.isEmpty() && password.isEmpty())) {
            try {
                Connection connection = ConexionDB.getConnection();

                PreparedStatement statement = connection.prepareStatement("INSERT INTO Consumidor (Nombre, CorreoElectronico, Direccion, Contrasena) VALUES (?, ?, ?, ?)");
                statement.setString(1, nombre);
                statement.setString(2, email);
                statement.setString(3, direccion);
                statement.setString(4, password);

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    // Registro exitoso
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    // Error en el registro
                    request.setAttribute("msg", "Error en el registro.");
                    RequestDispatcher rd = request.getRequestDispatcher("/singUpCo.jsp");
                    rd.forward(request, response);
                }

            } catch (ServletException | IOException | SQLException e) {
                e.printStackTrace();
                request.setAttribute("msg", "No se pudo conectar con la base de datos.");
                request.getRequestDispatcher("/singUpCo.jsp").forward(request, response);
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}