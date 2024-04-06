/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Consumer {
    private int idConsumer;
    private String name;
    private String email;
    private String address;
    private String password;

    public Consumer(int idConsumer, String name, String email, String address, String password){
        this.idConsumer = idConsumer;
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public Consumer() {
    }

    
    public int getIdConsumer(){
        return idConsumer;
    }
    
    public void setIdConsumer(int idConsumer){
        this.idConsumer = idConsumer;
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
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}
