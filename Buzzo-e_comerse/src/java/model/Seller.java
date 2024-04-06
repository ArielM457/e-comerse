/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */

public class Seller {
    private int idSeller;
    private String name;
    private String email;
    private int bankAccount;
    private String password;
    
    public Seller(int idSeller, String name, String email, int bankAccount, String password){
        this.idSeller = idSeller;
        this.name = name;
        this.email = email;
        this.bankAccount = bankAccount;
        this.password = password;
    }
    
    public int getIdSeller(){
        return idSeller;
    }
    
    public void setIdseller(int idSeller){
        this.idSeller = idSeller;
    }
    
    public String getName(){
        return name;
    } 
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public int getBankAccount(){
        return bankAccount;
    }
    
    public void setBankAccount(int bankAccount){
        this.bankAccount = bankAccount;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}
