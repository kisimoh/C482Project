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

public class Product {

    // variable
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();;
    private int productID;
    private string name;
    private double price;
    private int inStock;
    private int min;
    private int max;

    // method
    public void turnOn() {
        isOn = true;

    }
