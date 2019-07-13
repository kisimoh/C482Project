package View_Controller;

import Model.InhousePart;
import static Model.Inventory.addPart;
import Model.OutsourcedPart;
import Model.Part;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.xml.bind.ValidationException;
        



public class AddPartController implements Initializable {

    @FXML
    private Label screenLabel;

    @FXML
    private RadioButton inhousePartSelect;

    @FXML
    private RadioButton outsourcedPartSelect;

    @FXML
    private Label partsFlexFieldLabel;

    @FXML
    private Button addPartSave;

    @FXML
    private TextField partIdField;

    @FXML
    private TextField partNameField;

    @FXML
    private TextField partInventoryField;

    @FXML
    private TextField partPriceField;

    @FXML
    private TextField partMinField;

    @FXML
    private TextField partMaxField;

    @FXML
    private TextField partFlexField;

    private boolean isInHouse;
    
    private int newPartID;               
  
    @FXML
    void inhousePartSelectHandler(ActionEvent event) {
        isInHouse = true;
        partsFlexFieldLabel.setText("Machine ID");
    }
    
    @FXML
    void outsourcedPartSelectHandler(ActionEvent event) {
        isInHouse = false;
        partsFlexFieldLabel.setText("Company Name");
   }

    @FXML
    void partCancelHandler(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Cancel Modifcation of Part");
        alert.setHeaderText("Confirm cancellation");
        alert.setContentText("Please confirm that you want to cancel adding or modifying part " + partNameField.getText() + "?");
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK) {
            Parent loader = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }
        
    }
    
    @FXML
    void addPartSaveHandler(ActionEvent event) throws IOException {
        String partID = partIdField.getText();
        String partName = partNameField.getText();
        String partInv = partInventoryField.getText();
        String partPrice = partPriceField.getText();
        String partMin = partMinField.getText();
        String partMax = partMaxField.getText();
        String partFlex = partFlexField.getText();
        
        if ("".equals(partInv)) {
            partInv = "0";
        }
        
           if (isInHouse) {
           InhousePart newPart = new InhousePart();
           newPart.setPartID(newPartID);
           newPart.setName(partName);
           newPart.setPrice(Double.parseDouble(partPrice));
           newPart.setInStock(Integer.parseInt(partInv));
           newPart.setMin(Integer.parseInt(partMin));
           newPart.setMax(Integer.parseInt(partMax));
           newPart.setMachineID(Integer.parseInt(partFlex));

           try {
               newPart.isValid();
               
               if (newPart.isValid() == true) {
                   addPart(newPart);
               }
             
                  Parent loader = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
               
            } catch (ValidationException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error Validating Part!");
                alert.setHeaderText("Part not valid");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
                }  
            } 
        else {
           OutsourcedPart newPart = new OutsourcedPart();
           newPart.setPartID(newPartID);
           newPart.setName(partName);
           newPart.setPrice(Double.parseDouble(partPrice));
           newPart.setInStock(Integer.parseInt(partInv));
           newPart.setMin(Integer.parseInt(partMin));
           newPart.setMax(Integer.parseInt(partMax));
           newPart.setCompanyName(partFlex);

           try {
               newPart.isValid();
               if (newPart.isValid() == true) {
                   addPart(newPart);
               }
               
                  Parent loader = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
            
             
           } catch (ValidationException e) {
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error Validating Part!");
               alert.setHeaderText("Part not valid");
               alert.setContentText(e.getMessage());
               alert.showAndWait();
               }  
        
    }
        }
 
            
 @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }   
}
