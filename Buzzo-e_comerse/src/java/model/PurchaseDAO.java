/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author university*/
 
import connection.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO {
    public List<PurchaseDetail> cargarHistorialCompras(int idConsumidor) throws SQLException {
        List<PurchaseDetail> historialCompras = new ArrayList<>();

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CompraVenta WHERE IDConsumidor = ?")) {
            preparedStatement.setInt(1, idConsumidor);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PurchaseDetail purchase = new PurchaseDetail();
                // Configura los datos de la compra según tu modelo CompraVenta
                purchase.setIdPurchaseDetail(resultSet.getInt("idPurchaseDetail"));
                purchase.setIdProduct(resultSet.getInt("idPurchase"));
                purchase.setIdProduct(resultSet.getInt("idProduct"));
                purchase.setAmount(resultSet.getInt("Cantidad"));
                purchase.setSubtotal(resultSet.getInt("Subtotal"));


                historialCompras.add(purchase);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return historialCompras;
    }
    
        
    public void insertPurchase(Purchase purchase) {
            try (Connection connection = ConexionDB.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "INSERT INTO CompraVenta (IDVendedor, IDConsumidor, IDTipoPago, Fecha, MontoTotal, EstadoPago) VALUES (?, ?, ?, ?, ?, ?)")) {
                java.util.Date date=new java.util.Date();
                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                
                preparedStatement.setInt(1, purchase.getIdSeller());
                preparedStatement.setInt(2, purchase.getIdConsumer());
                preparedStatement.setInt(3, purchase.getPaymentType());
                preparedStatement.setDate(4, sqlDate);
                preparedStatement.setDouble(5, purchase.getTotalAmount());
                preparedStatement.setString(6, purchase.getPaymentStatus());
    
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public int getIdPurchase() {
        int idPurchase = 0;
        try (Connection connection = ConexionDB.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "SELECT MAX(IDCompraVenta) FROM CompraVenta" )) {
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                
                idPurchase = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idPurchase;
    }
}
