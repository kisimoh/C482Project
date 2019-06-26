/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author annagallaher
 */

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.ValidationException;

public class Product {

    // variable
    private ObservableList<Part> productParts = FXCollections.observableArrayList();;
    private int productID;
    private String name;
    private double price;
    private int inStock;
    private int min;
    private int max;

  
    public Product() {
    }
    
  // methods
    
    public int getInStock()  {
        return inStock;
    }
    
    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
    
    public int getMin() {
        return min;
    }
    
    public void setMin(int min){
        this.min = min;
    }
    
    public int getMax() {
        return max;
    }
    
    public void setMax(int max){
        this.max = max;
    }
    
    public double getPrice() {
        return price;
}
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getName() {
        return name;
}
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getProductID() {
        return productID;
    }
    
    public void setProductID(int productID){
        this.productID = productID;
    }
    
     public ObservableList<Part> getProductParts() {
        return productParts;
    }
    
    public void addProductParts(Part productParts) {
        this.productParts.add(productParts);
    }
    
    public int getProductPartsCount() {
        return productParts.size();
    }
    
    public Part lookupProductParts(int partID) {
        for (Part a: productParts) {
            if (a.getPartID() == partID) {
                return a;
            }
        }
            return null;
    }
    
    public void removeAllProductParts() {
        productParts = FXCollections.observableArrayList();
    }
    
    public boolean removeProductParts(int partID) {
        for (Part b: productParts) {
            if (b.getPartID() == partID) {
                productParts.remove(b);
                return true;
            }
        }
        return false;
    }
    
    public boolean isValid() throws ValidationException {
        
        double totalPartsPrice = 0.00;
        
        for (Part c: getProductParts()){
            totalPartsPrice += c.getPrice();
        }
        
        if (totalPartsPrice > getPrice()) {
            throw new ValidationException("Product price must be greater than total combined cost of all parts assigned to the product. Please validate prices.");
        }
        
        if (getName().equals("")) {
            throw new ValidationException("The name field is required. Please enter a product name."); 
        }
        
        if (getInStock() < 0) {
            throw new ValidationException("Inventory must be greater than 0. Please enter a valid amount.");
        }
        
        if (getPrice() < 0) {
            throw new ValidationException("Price must be greater than $0. Please enter a valid price.");
        }
        
        if (getMin() < 0) {
            throw new ValidationException("Minimum inventory must be greater than zero. Please enter a valid amount.");
        }
        
        if (getMin() > getMax()) {
            throw new ValidationException("Minimum inventory cannot exceed maximum. Please enter a valid minimum inventory level.");
        }
        
        if getProductParts() < 1 {
            throw new ValidaqtionException("Products must contain a minimum of 1 part. Please add a part.")
        }
        
        if (getInStock() < getMin() || getInStock() > getMax()) {
            throw new ValidationException("Current inventory must be between the minimum and maximum inventory level. Please enter a valid inventory between those values.");
        }
         
     return true;   
    }
    
    
    
    
    
    
}
