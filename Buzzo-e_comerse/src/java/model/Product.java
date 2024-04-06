/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Product {
    private int idProduct;
    private int idCategory;
    private String description;
    private Double price;
    private int stock;
    private String image;

    public Product() {
    }
    
    
    public Product(int idProduct, int idCategory, String description, Double price, int stock, String image){
        this.idProduct = idProduct;
        this.idCategory = idCategory;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
    }
    
    public int getIdProduct(){
        return idProduct;
    }
    
    public void setIdProduct(int idProduct){
        this.idProduct = idProduct;
    }
    
    public int getIdCategory(){
        return idCategory;
    }
    
    public void setIdCategory(int idCategory){
        this.idCategory = idCategory;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public Double getPrice(){
        return price;
    }
    
    public void setPrice(Double price){
        this.price = price;
    }
    
    public int getStock(){
        return stock;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
