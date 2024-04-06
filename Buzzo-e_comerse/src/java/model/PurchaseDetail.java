/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class PurchaseDetail {
    private int idPurchaseDetail;
    private int idPurchase;
    private int idProduct;
    private int amount;
    private double subtotal;
    
    
    public PurchaseDetail(int idPurchaseDetail, int idPurchase, int idProduct, int amount, double subtotal){
        this.idPurchaseDetail = idPurchaseDetail;
        this.idPurchase = idPurchase;
        this.idProduct = idProduct;
        this.amount = amount;
        this.subtotal = subtotal;
    }

    public PurchaseDetail() {
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
