/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class SaleDetail {
    private int idSaleDetail;
    private Sale idSale;
    private Product idProduct;
    private int amount;
    private Double subtotal;
    
    public SaleDetail(int idSaleDetail, Sale idSale, Product idProduct, int amount, Double subtotal){
        this.idSaleDetail = idSaleDetail;
        this.idSale = idSale;
        this.idProduct = idProduct;
        this.amount = amount;
        this.subtotal = subtotal;
    }
    
    public int getIdSaleDetail(){
        return idSaleDetail;
    }
    
    public void setIdSaleDetail(int idSaleDetail){
        this.idSaleDetail = idSaleDetail;
    }
    
    public Sale getIdSale(){
        return idSale;
    }
    
    public void setIdSale(Sale idSale){
        this.idSale = idSale;
    }
    
    public Product getIdProduct(){
        return idProduct;
    }
    
    public void setIdProduct(Product idProduct){
        this.idProduct = idProduct;
    }
    
    public int getAmount(){
        return amount;
    }
    
    public void setAmount(int amount){
        this.amount = amount;
    }
    
    public Double getSubtotal(){
        return subtotal;
    }
    
    public void setSubtotal(Double subtotal){
        this.subtotal = subtotal;
    }
}
