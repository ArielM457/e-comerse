package model;

import connection.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PurchaseDetailDAO {
    // Obtener todos los detalles de compra de la base de datos
    public List<PurchaseDetail> getAllPurchaseDetails() {
        List<PurchaseDetail> purchaseDetails = new ArrayList<>();

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DetalleCompra")) {

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idPurchaseDetail = resultSet.getInt(1);
                    int idPurchase = resultSet.getInt(2); 
                    int idProduct = resultSet.getInt(3); 
                    int amount = resultSet.getInt(4);
                    Double subtotal = resultSet.getDouble(5);
                    PurchaseDetail purchaseDetail = new PurchaseDetail(idPurchaseDetail, idPurchase, idProduct, amount, subtotal);
                    purchaseDetails.add(purchaseDetail);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
            return purchaseDetails;
        }
    

            // Obtener un detalle de compra por su ID
    public PurchaseDetail getPurchaseDetailById(int id) {
        PurchaseDetail purchaseDetail = new PurchaseDetail();

        try (Connection connection = ConexionDB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM CompraDetalle WHERE IdDetalleCompra = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idPurchaseDetail = resultSet.getInt(1);
                int idPurchase = resultSet.getInt(2); 
                int idProduct = resultSet.getInt(3); 
                int amount = resultSet.getInt(4);
                Double subtotal = resultSet.getDouble(5);
                purchaseDetail = new PurchaseDetail(idPurchaseDetail, idPurchase, idProduct, amount, subtotal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchaseDetail;
    }

        // Insertar un nuevo detalle de compra en la base de datos
        public void insertPurchaseDetail(List<PurchaseDetail> purchaseDetail) {
            try (Connection connection = ConexionDB.getConnection()){
                for(int i = 0; i < purchaseDetail.size();i++){
                    
                    PreparedStatement preparedStatement = connection.prepareStatement(
                             "INSERT INTO CompraVentaDetalle (IDCompraVenta, IDProducto, Cantidad, Subtotal) VALUES (?, ?, ?, ?)");

                    preparedStatement.setInt(1, purchaseDetail.get(i).getIdPurchase());
                    preparedStatement.setInt(2, purchaseDetail.get(i).getIdProduct());
                    preparedStatement.setInt(3, purchaseDetail.get(i).getAmount());
                    preparedStatement.setDouble(4, purchaseDetail.get(i).getSubtotal());

                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    

            // Eliminar un detalle de compra de la base de datos
    public void deletePurchaseDetail(int idPurchaseDetail) {
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM CompraDetalle WHERE idCompraDetalle=?")) {

            preparedStatement.setInt(1, idPurchaseDetail);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
}
    

