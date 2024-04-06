/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Store {
    private int idStore;
    private Seller idSeller;
    private String name;
    private String address;
    
    public Store(int idStore, Seller idSeller, String name, String address){
        this.idStore = idStore;
        this.idSeller = idSeller;
        this.name = name;
        this.address = address;
    }
    
    public int getIdStore(){
        return idStore;
    }
    
    public void setIdStore(int idStore){
        this.idStore = idStore;
    }
    
    public Seller getIdSeller(){
        return idSeller;
    }
    
    public void setIdSeller(Seller idSeller){
        this.idSeller = idSeller;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
}
