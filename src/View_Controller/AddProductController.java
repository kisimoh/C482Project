package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import static View_Controller.MainScreenController.getModifiedProduct;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.xml.bind.ValidationException;

public class AddProductController implements Initializable {
    
    @FXML
    private Label ProductPageLabel;

    @FXML
    private TextField productIDField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productInventoryField;

    @FXML
    private TextField productPriceField;

    @FXML
    private TextField productMinField;

    @FXML
    private TextField productMaxField;

    @FXML
    private Button saveProduct;

    @FXML
    private Button cancelProduct;

    @FXML
    private TableView<Part> addPartTable;

    @FXML
    private TableColumn<Part, Integer> addPartPartIDColumn;

    @FXML
    private TableColumn<Part, String> addPartNameColumn;

    @FXML
    private TableColumn<Part,Integer> addPartInventoryColumn;

    @FXML
    private TableColumn<Part, Double> addPartPriceColumn;

    @FXML
    private TableView<Part> partsContainedTable;

    @FXML
    private TableColumn<Part, Integer> partsContainedPartIDColumn;

    @FXML
    private TableColumn<Part, String> partsContainedPartNameColumn;

    @FXML
    private TableColumn<Part, Integer> partsContainedInventoryColumn;

    @FXML
    private TableColumn<Part, Double> partsContainedPriceColumn;

    @FXML
    private Button addPartToProduct;

    @FXML
    private Button deletePartFromProduct;

    @FXML
    private Button searchPartsButton;

    @FXML
    private TextField searchPartsField;
    
    private ObservableList<Part> productParts = FXCollections.observableArrayList();
    
    private final Product currentModProduct;
    
    private int newProductID;
    
    public AddProductController() {
        this.currentModProduct = getModifiedProduct();
    }
    
    //public void populateAvailablePartsTable() {
    //    addPartTable.setItems(productParts);
    //}

    public void populateCurrentPartsTable() {
        partsContainedTable.setItems(productParts);
    }
    
    @FXML
    void addPartToProductHandler(ActionEvent event) throws IOException {
   
       
       
        ObservableList<Part> selectedParts = addPartTable.getItems();
        Part chosenPart = partsContainedTable.getSelectionModel().getSelectedItem();
        selectedParts.add(chosenPart);
        partsContainedTable.setItems(selectedParts);
        
    }
    

    @FXML
    void cancelProductHandler(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Cancel Adding Product");
        alert.setHeaderText("Please confirm cancelling Adding product.");
        alert.setContentText("Please confirm you want to cancel adding " + productNameField.getText() + ".");
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
    void deletePartFromProductHandler(ActionEvent event) throws IOException {
        if (productParts.size() > 1) {
            Part part = partsContainedTable.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initModality(Modality.NONE);
            alert.setTitle("Part Removal");
            alert.setHeaderText("Please confirm removal of part from product.");
            alert.setContentText("Are you sure you want to remove " + part.getName() + "?");
            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.OK) {
                productParts.remove(part);
            }          
        }
        
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error deleting part!");
            alert.setHeaderText("Products require a minimum of one part.");
            alert.setContentText("All products must have a minimum of one part. Removing this part will result in less than one part.");
            alert.showAndWait();     
        }
    }

    @FXML
    void saveProductHandler(ActionEvent event) throws IOException, ValidationException {
        String productID = productIDField.getText();
        String productName = productNameField.getText();
        String productInventory = productInventoryField.getText();
        String productPrice = productPriceField.getText();
        String productMin = productMinField.getText();
        String productMax = productMaxField.getText();
        
        Product newProduct = new Product();
        newProduct.setProductID(newProductID);
        newProduct.setName(productName);
        newProduct.setPrice(Double.parseDouble(productPrice));
        newProduct.setInStock(Integer.parseInt(productInventory));
        newProduct.setMin(Integer.parseInt(productMin));
        newProduct.setMax(Integer.parseInt(productMax));
        
        if (currentModProduct != null) {
            currentModProduct.removeAllAssociatedParts();
        }
        
        for (Part h: productParts) {
            newProduct.addAssociatedParts(h);
        }
        
        try {
            newProduct.isValid();
        
        
            if (currentModProduct == null) {
                newProduct.setProductID(Inventory.getProductCount());
                Inventory.addProduct(newProduct);
            }
            else {
                newProduct.setProductID(currentModProduct.getProductID());
                Inventory.updateProduct(newProduct);
            }
            
            Parent loader = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
            
        }
            catch (ValidationException i) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error Validating Product");
                alert.setHeaderText("Product not valid");
                alert.setContentText(i.getMessage());
                alert.showAndWait();
        }   
    }

    @FXML
    void searchPartsButtonHandler (ActionEvent event) throws IOException {
        String partsSearchIDString = searchPartsField.getText();
        Part searchedPart = Inventory.lookupPart(Integer.parseInt(partsSearchIDString));
        
        if (searchedPart != null) {
            ObservableList<Part> filteredPartsList = FXCollections.observableArrayList();
            filteredPartsList.add(searchedPart);
            addPartTable.setItems(filteredPartsList);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Searching");
            alert.setHeaderText("Part not found in inventory.");
            alert.setContentText("The part searched for does not match any current part in Inventory!");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productIDField.setText("Auto Gen - Disabled");
        productIDField.setDisable(true);
        addPartPartIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        addPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        addPartInventoryColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("inStock"));
        addPartPriceColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        
        partsContainedPartIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        partsContainedPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        partsContainedInventoryColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("inStock"));
        partsContainedPriceColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        
       
        //populateAvailablePartsTable();
        populateCurrentPartsTable();
        
      
    }

    
}

