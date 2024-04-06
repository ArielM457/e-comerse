package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author university
 */

import connection.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
public class CategoryDAO {

 
    public int getCategoryByName(String categoryId) {
        String query = "SELECT IDCategoria FROM Categoria WHERE Nombre = ?";
        int idCategory = 0;
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
 
            statement.setString(1, categoryId);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {  
                idCategory = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
 
        return idCategory;
    }

}


