/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
import connection.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.HistoryDao;


public class ProductDAO {

    // Se obtiene todos los productos de la base de datos
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = ConexionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Producto")){
            // Consulta SQL para obtener todos los productos de la tabla 'products'
            //String query = "SELECT * FROM Producto";
            ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    // Recupera los datos de cada producto y crea un objeto Product
                    int idProduct = resultSet.getInt(1);
                    int idCategory = resultSet.getInt(2); 
                    String description = resultSet.getString(3);
                    Double price = resultSet.getDouble(4);
                    int stock = resultSet.getInt(5);
                    String image = resultSet.getString(6);

                    Product product = new Product(idProduct, idCategory, description, price, stock,image);
                    products.add(product);
                }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }

        return products;
    }
    

    public Product getProductById(int id) {
        
        Product product = new Product();
        try (Connection connection = ConexionDB.getConnection()){
            
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Producto WHERE IdProducto = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                    
                product.setIdProduct(resultSet.getInt(1));
                product.setIdCategory(resultSet.getInt(2));
                product.setDescription(resultSet.getString(3));
                product.setPrice(resultSet.getDouble(4));
                product.setStock(resultSet.getInt(5));
                product.setImage(resultSet.getString(6));
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }

        return product;
    }
    
    public List<Product> getProductsByCategory (int category){
        
        List<Product> products = new ArrayList<>();

        try (Connection connection = ConexionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Producto WHERE IDCategoria = ?")){
            statement.setInt(1, category);
            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    // Recupera los datos de cada producto y crea un objeto Product
                    int idProduct = resultSet.getInt(1);
                    int idCategory = resultSet.getInt(2); 
                    String description = resultSet.getString(3);
                    Double price = resultSet.getDouble(4);
                    int stock = resultSet.getInt(5);
                    String image = resultSet.getString(6);

                    Product product = new Product(idProduct, idCategory, description, price, stock,image);
                    products.add(product);
                }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }

        return products;
    }
    
    public List<Product> searchProducts(String keyword) {
        List<Product> products = new ArrayList<>();

        try (Connection connection = ConexionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT * FROM Producto WHERE Descripcion LIKE '%"+keyword+"%' ")) {   //Buscar con cualquier letra--

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Creamos objeto product y añadimos los valores de 
                int idProduct = resultSet.getInt(1);
                int idCategory = resultSet.getInt(2);
                String description = resultSet.getString(3);
                Double price = resultSet.getDouble(4);
                int stock = resultSet.getInt(5);
                String image = resultSet.getString(6);

                Product product = new Product(idProduct, idCategory, description, price, stock, image);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    
    // Inserta un nuevo producto en la base de datos
    public void insertProduct(Product product) {
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO products (idCategory, description, price, stock) VALUES (?, ?, ?, ?)")) {

            // Establece los parámetros de la consulta preparada con los datos del nuevo producto
            //preparedStatement.setInt(1, product.getIdCategory().getIdCategory()); // Suponiendo que Category tiene un atributo id
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getStock());

            // Ejecuta la consulta preparada para insertar el nuevo producto en la base de datos
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }

    // Actualiza un producto existente en la base de datos
    public void updateProduct(Product product) {
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE products SET idCategory=?, description=?, price=?, stock=? WHERE idProduct=?")) {

            // Establece los parámetros de la consulta preparada con los nuevos datos del producto
            //preparedStatement.setInt(1, product.getIdCategory().getIdCategory());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getStock());
            preparedStatement.setInt(5, product.getIdProduct());

            // Ejecuta la consulta preparada para actualizar el producto en la base de datos
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }

    // Elimina un producto de la base de datos
    public void deleteProduct(int productId) {
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products WHERE idProduct=?")) {

            // Establece el parámetro de la consulta preparada con el ID del producto a eliminar
            preparedStatement.setInt(1, productId);

            // Ejecuta la consulta preparada para eliminar el producto de la base de datos
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }
    public Product getProductInfo(int idProduct) {
      Product product = null;

      try (Connection connection = ConexionDB.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(
                   "SELECT IDCategoria, Descripcion, Imagen FROM Producto WHERE IDProducto = ?")) {
          preparedStatement.setInt(1, idProduct);
          ResultSet resultSet = preparedStatement.executeQuery();
          if (resultSet.next()) {
              int idCategory = resultSet.getInt(1);
              String description = resultSet.getString(2);
              String image = resultSet.getString(3);

              product = new Product(idProduct, idCategory, description, null, 0, image);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }

      return product;
}
}
