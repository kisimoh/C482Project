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

public class Inventory {
  //variables
    
private final static ObservableList<Part> allParts = FXCollections.observableArrayList();
    
private final static ObservableList<Product> products = FXCollections.observableArrayList();

public Inventory() {
    }
//methods
    
    public static void addProduct(Product newProduct) {
        products.add(newProduct);
    }
    
    public static boolean canDeleteProduct(Product product) {
        return product.getAssociatedPartsCount() == 0;
    }
    
    //Named method deleteProduct for naming consistency, instead of removeProduct.
    
    public static boolean deleteProduct(int productID){
            for (Product g: products){
                if (g.getProductID() == productID) {
                    products.remove(g);
                    return true;
                }
            }
            return false;
    }
    
    public static ObservableList<Product> getProduct(){
        return products;
    }
    
    public static int getProductCount(){
        return products.size();
    }
    
    public static void updateProduct(Product updatedProduct) {
          for (int i = 0; i < products.size(); i++) {
       if (products.get(i).getProductID() == updatedProduct.productID) {
           products.set(i, updatedProduct);
           break;
       }
    }
    }
    
    public static Product lookupProduct (int productID) {
        for (Product e: products) {
            if (e.getProductID() == productID) {
                return e;
            }
        }
        return null;
    }
    
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }
    
    public static boolean deletePart(int PartID) {
        for (Part f: allParts) {
            if (f.getPartID() == PartID) {
                allParts.remove(f);
                return true;
            }
        }
        return false;
    }
    
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }
    
    public static int getPartsCount() {
        return allParts.size();
    }
    
   public static void updatePart(Part updatedPart) {
        for (int i = 0; i < allParts.size(); i++) {
       if (allParts.get(i).getPartID() == updatedPart.partID) {
           allParts.set(i, updatedPart);
           break;
       }
   }
    }
    
    public static Part lookupPart (int partID) {
        for (Part d: allParts) {
            if (d.getPartID() == partID) {
                return d;
            }
        }
        return null;
    }
    
    
    
}
