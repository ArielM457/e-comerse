/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author university
 */
public class History {

    private int idPurchaseDetail;
    private int idPurchase;
    private Product product;
    private int idProduct;
    private int amount;
    private double subtotal;
    
    
    public History(int idPurchaseDetail, int idPurchase, Product product, int idProduct, int amount, double subtotal){
        this.idPurchaseDetail = idPurchaseDetail;
        this.idPurchase = idPurchase;
        this.product = product;
        this.idProduct = idProduct;
        this.amount = amount;
        this.subtotal = subtotal;
    }

    public History() {
    }

    public int getIdPurchaseDetail() {
        return idPurchaseDetail;
    }

    public void setIdPurchaseDetail(int idPurchaseDetail) {
        this.idPurchaseDetail = idPurchaseDetail;
    }

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }


    
}