/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class PaymentType {
    private int name;
    
    public PaymentType(int name){
        this.name = name;
    }
    
    public int getName(){
        return name;
    }
    
    public void setName(int name){
        this.name = name;
    }
}
