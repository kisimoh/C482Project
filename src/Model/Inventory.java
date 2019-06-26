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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Part.*;
import Model.Product.*;

public class Inventory {
  //variables
    
private final static ObservableList<Part> partsList = FXCollections.observableArrayList();
    
private final static ObservableList<Product> productList = FXCollections.observableArrayList();

//methods
    
    public static void addProduct(Product newProduct) {
        productList.add(newProduct);
    }
    
    public boolean canDeleteProduct(Product product) {
        return product.getProductPartsCount() == 0;
    }
    
    public static boolean deleteProduct(int productID){
            for (Product g: productList){
                if (g.getProductID() == productID) {
                    productList.remove(g);
                    return true;
                }
            }
            return false;
    }
    
    public static ObservableList<Product> getProduct(){
        return productList;
    }
    
    public static int getProductCount(){
        return productList.size();
    }
    
    public void updateProduct(Product updatedProduct) {
        productList.set(updatedProduct.getProductID(), updatedProduct);
    }
    
    public static Product lookupProduct (int productID) {
        for (Product e: productList) {
            if (e.getProductID() == productID) {
                return e;
            }
        }
        return null;
    }
    
    public void addPart(Part newPart) {
        partsList.add(newPart);
    }
    
    public static boolean deletePart(int PartID) {
        for (Part f: partsList) {
            if (f.getPartID() == partID) {
                partsList.remove(f);
                return true;
            }
        }
        return false;
    }
    
    public static ObservableList<Part> getAllParts() {
        return partsList;
    }
    
    public static int getPartsCount() {
        return partsList.size();
    }
    
    public static void updatePart(Part updatedPart) {
        partsList.set(updatedPart.getPartID(), updatedPart);
    }
    
    public static Part lookupPart (int partID) {
        for (Part d: partsList) {
            if (d.getPartID() == partID) {
                return d;
            }
        }
        return null;
    }
    
    
    
}
