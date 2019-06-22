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

public class Inventory {
  //variables
    
   public ArrayList<Product> products;
   
   public ArrayList<Part> allParts;
   
       // Observable list of parts in the inventory
    private final static ObservableList<Part> allParts = FXCollections.observableArrayList();
    
    // Observable list of products in the inventory
    private final static ObservableList<Product> products = FXCollections.observableArrayList();
    
    
 //methods
    
    public void addProduct(product);
    
    public boolean deleteProduct(int);
    
    public product getProduct(int);
    
    public void updateProduct(int);
    
    public void addPart(part);
    
    public boolean deletePart(part);
    
    public part getPart(int);
    
    public void updatePart(int);
    
    
    
}
