package model;
import connection.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.History;


public class HistoryDao {
        ProductDAO productDao = new ProductDAO();     
     public List<History> getPurchaseDetailsByConsumerId(int idConsumer) {
        List<History> historyIn = new ArrayList<>();
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT CD.* FROM CompraVentaDetalle CD JOIN CompraVenta CV ON CD.IDCompraVenta = CV.IDCompraVenta WHERE CV.IDConsumidor = ?")) {
            preparedStatement.setInt(1, idConsumer);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idPurchaseDetail = resultSet.getInt("IDCompraVentaDetalle");
                int idPurchase = resultSet.getInt("IDCompraVenta");
                int idProduct = resultSet.getInt("IDProducto");
                int amount = resultSet.getInt("Cantidad");
                Double subtotal = resultSet.getDouble("Subtotal");
                Product productInfo = productDao.getProductInfo(idProduct);
                History history = new History(idPurchaseDetail, idPurchase, productInfo, idProduct, amount, subtotal);
                historyIn.add(history);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historyIn;
    }

}
    
