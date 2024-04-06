/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Category {
    private int idCategory;
    private String name;
    
    public Category(int idCategory, String name){
        this.idCategory = idCategory;
        this.name = name;
    }
    
    public int getIdCategory(){
        return idCategory;
    }
    
    public void setIdCategory(int idCategory){
        this.idCategory = idCategory;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
}
