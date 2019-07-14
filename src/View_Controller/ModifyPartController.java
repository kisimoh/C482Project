package View_Controller;

import Model.InhousePart;
import Model.Inventory;
import static Model.Inventory.addPart;
import Model.OutsourcedPart;
import Model.Part;
import static View_Controller.MainScreenController.getModPart;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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

public class ModifyPartController implements Initializable {

    @FXML
    private Label screenLabel;

    @FXML
    private RadioButton inhousePartSelect;

    @FXML
    private RadioButton outsourcedPartSelect;

    @FXML
    private Label partsFlexFieldLabel;

    @FXML
    private Button modPartSave;

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
    
    //private int newPartID; 
    
    private final Part modifyPart;
    
      public ModifyPartController() {
        this.modifyPart = getModPart();
    }
    
    
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
    void partCancel(ActionEvent event) throws IOException{

    }

    @FXML
    void partCancelHandler(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Cancel Modifcation of Part");
        alert.setHeaderText("Confirm cancellation");
        alert.setContentText("Please confirm that you want to cancel modifying part " + partNameField.getText() + "?");
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
    void modPartSaveHandler(ActionEvent event) throws IOException {
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
           InhousePart modifyPart = new InhousePart();
           modifyPart.setPartID(Integer.parseInt(partID));
           modifyPart.setName(partName);
           modifyPart.setPrice(Double.parseDouble(partPrice));
           modifyPart.setInStock(Integer.parseInt(partInv));
           modifyPart.setMin(Integer.parseInt(partMin));
           modifyPart.setMax(Integer.parseInt(partMax));
           modifyPart.setMachineID(Integer.parseInt(partFlex));

           try {
               modifyPart.isValid();
               
               if (modifyPart.isValid() == true) {
                    Inventory.updatePart(modifyPart);                 
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
           OutsourcedPart modifyPart = new OutsourcedPart();
           modifyPart.setPartID(Integer.parseInt(partID));
           modifyPart.setName(partName);
           modifyPart.setPrice(Double.parseDouble(partPrice));
           modifyPart.setInStock(Integer.parseInt(partInv));
           modifyPart.setMin(Integer.parseInt(partMin));
           modifyPart.setMax(Integer.parseInt(partMax));
           modifyPart.setCompanyName(partFlex);

           try {
               modifyPart.isValid();
               if (modifyPart.isValid() == true) {
                   Inventory.updatePart(modifyPart);
        
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
        public void initialize(URL location, ResourceBundle resources) {
           
            partIdField.setDisable(true);
            partIdField.setText(Integer.toString(modifyPart.getPartID()));
            partNameField.setText(modifyPart.getName());
            partInventoryField.setText(Integer.toString(modifyPart.getInStock()));
            partPriceField.setText(Double.toString(modifyPart.getPrice()));
            partMinField.setText(Integer.toString(modifyPart.getMin()));
            partMaxField.setText(Integer.toString(modifyPart.getMax()));
            
          if (modifyPart instanceof InhousePart) {
                partFlexField.setText(Integer.toString(((InhousePart) modifyPart).getMachineID()));
                
                partsFlexFieldLabel.setText("Machine ID");
                inhousePartSelect.setSelected(true);

            } else {
                partFlexField.setText(((OutsourcedPart) modifyPart).getCompanyName());
                partsFlexFieldLabel.setText("Company Name");
                outsourcedPartSelect.setSelected(true);
            
            }
        }
}
    

