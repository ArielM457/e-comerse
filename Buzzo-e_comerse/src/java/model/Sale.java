/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Sale {
    private int idSale;
    private Seller idSeller;
    private Consumer idConsumer;
    private PaymentType name;
    private Double totalAmount;
    private String paymentStatus;
    
    public Sale(int idSale, Seller idSeller, Consumer idConsumer, PaymentType name, Double totalAmount, String paymentStatus){
        this.idSale = idSale;
        this.idSeller = idSeller;
        this.idConsumer = idConsumer;
        this.name = name;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }
    
    public int getIdSale(){
        return idSale;
    }
    
    public void setIdSale(int idSale){
        this.idSale = idSale;
    }
    
    public Seller getIdSeller(){
        return idSeller;
    }
    
    public void setIdSeller(Seller idPurchase){
        this.idSeller = idSeller;
    }
    
    public Consumer getIdConsumer(){
        return idConsumer;
    }
    
    public void setIdConsumer(Consumer idConsumer){
        this.idConsumer = idConsumer;
    }
    
    public PaymentType getName(){
        return name;
    }
    
    public void setName(PaymentType name){
        this.name = name;
    }
    
    public Double getTotalAmount(){
        return totalAmount;
    }
    
    public void setTotalAmount(Double totalAmount){
        this.totalAmount = totalAmount;
    }
    
    public String getPaymentStatus(){
        return paymentStatus;
    }
    
    public void setPaymentStatus(String paymentStatus){
        this.paymentStatus = paymentStatus;
    }
}
