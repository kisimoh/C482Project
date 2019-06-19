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
public abstract class Part {
    
    //variables
    private int partID;
    
    private String name;
    
    private double price;
    
    private int inStock;
    
    private int min;
    
    private int max;
    
    //methods
    
    public void setName(String) {
            this.name = name;
    }
    
    public String getName() {
        return name
    };
    
    public void setPrice(double) {
        this.price = price
    };
    
    public double getPrice() {
        return price
    };
    
    public void setInStock(int) {
        this.inStock = inStock
    };
    
    public int getInStock() {
        return inStock
    };
    
    public void setMin(int) {
        this.min = min
    };
    
    public int getMin() {
        return min
    };
    
    public void setMax(int) {
        this.max = max
    };
    
    public int getMax() {
        return max
    };
    
    public void setPartID(int) {
        this.partID = partID
    };
    
    public int getPartID() {
        return partID
    };
    
    
    
}
