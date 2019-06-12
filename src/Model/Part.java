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
    public int partID;
    
    public String name;
    
    public double price;
    
    public int inStock;
    
    public int min;
    
    public int max;
    
    //methods
    
    public void setName(String);
    
    public String getName();
    
    public void setPrice(double);
    
    public double getPrice;
    
    public void setInStock(int);
    
    public int getInStock();
    
    public void setMin(int);
    
    public int getMin();
    
    public void setMax(int);
    
    public int getMax();
    
    public void setPartID(int);
    
    public int getPartID();
    
    
    
}
