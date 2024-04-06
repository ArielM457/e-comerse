/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connection.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author university
 */
public class ConsumerDAO {
    
    public Consumer getConsumerById(int id) {
        
        Consumer consumer = new Consumer();
        try (Connection connection = ConexionDB.getConnection()){
            
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT IDConsumidor, Nombre, CorreoElectronico, Direccion FROM Consumidor WHERE IDConsumidor = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                    
                consumer.setIdConsumer(resultSet.getInt(1));
                consumer.setName(resultSet.getString(2));
                consumer.setEmail(resultSet.getString(3));
                consumer.setAddress(resultSet.getString(4));
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }

        return consumer;
    }
    
}
