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
public class InhousePart extends Part{
    
    //variables
    
      private int machineID;
      
    //methods
      
       public void setMachineID(int machineID) {
        this.machineID = machineID;
       }    
        
      public int getMachineID() {
        return machineID;
    }

}
