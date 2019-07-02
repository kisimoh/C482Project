package View_Controller;

import Extras.AppLoader;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import Model.Part;
import Model.Product;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static Model.Inventory.getAllParts;
import static Model.Inventory.getProduct;
import static Model.Inventory.canDeleteProduct;
import static Model.Inventory.deletePart;
import static Model.Inventory.deleteProduct;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;

public class MainScreenController implements Initializable {

    @FXML
    private Button searchParts;

    @FXML
    private Button addPartMain;

    @FXML
    private Button modifyPartMain;

    @FXML
    private Button deletePart;

    @FXML
    private TableView<Part> mainPartsTable;

    @FXML
    private TableColumn<Part, Integer> mainPartIDColumn;

    @FXML
    private TableColumn<Part, String> mainPartNameColumn;

    @FXML
    private TableColumn<Part, Integer> mainPartInventoryColumn;

    @FXML
    private TableColumn<Part, Double> mainPartPriceColumn;

    @FXML
    private TextField partsSearchBox;

    @FXML
    private Button addProductMain;

    @FXML
    private Button modifyProductMain;

    @FXML
    private Button deleteProduct;

    @FXML
    private TableView<Product> mainProductTable;

    @FXML
    private TableColumn<Product, Integer> mainProductIDColumn;

    @FXML
    private TableColumn<Product, String> mainProductNameColumn;

    @FXML
    private TableColumn<Product, Integer> mainProductInventoryColumn;

    @FXML
    private TableColumn<Product, Double> mainProductPriceColumn;

    @FXML
    private Button searchProducts;

    @FXML
    private TextField productSearchBox;

    @FXML
    private Button exitApplication;
    
   
    private static Part currentModPart;
    
    private static Product currentModProduct;

    @FXML
    void addPartMainHandler(ActionEvent event) throws IOException  {
        openPartScreen(event);
    }

    @FXML
    void addProductMainHandler(ActionEvent event) throws IOException  {
        openProductScreen(event);
    }

    @FXML
    void deletePartHandler(ActionEvent event) throws IOException  {
        Part part = mainPartsTable.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Delete Part");
        alert.setHeaderText("Please Confirm Deletion");
        alert.setContentText("Are you sure you want to delete " + part.getName() + "?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            deletePart(part.getPartID());
            populatePartsTable();
    }
}
    
    @FXML
    void deleteProductHandler(ActionEvent event) throws IOException  {
        Product product = mainProductTable.getSelectionModel().getSelectedItem();

        if (!canDeleteProduct(product)) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("ERROR IN DELETING PRODUCT");
            alert.setHeaderText("This product cannot be removed");
            alert.setContentText("This product has associated parts. Please disassociate those parts or delete those parts, then try again.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.initModality(Modality.NONE);
            alert.setTitle("DELETING PRODUCT");
            alert.setHeaderText("Please confirm deletion.");
            alert.setContentText("Are you sure you want to delete " + product.getName() + "?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                deleteProduct(product.getProductID());
                populatePartsTable();
    }
}

}
    
    @FXML
    void exitApplicationHandler(ActionEvent event) throws IOException  {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Exiting Confirmation");
        alert.setHeaderText("Please confirm that you want to exit!");
        alert.setContentText("Are you sure you want to exit?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            System.exit(0);
        }   
            
    }

    @FXML
    void mainModifyProductHandler(ActionEvent event) throws IOException  {
        currentModPart = mainPartsTable.getSelectionModel().getSelectedItem();
        setModifiedPart(currentModPart);
        openPartScreen(event);
    }

    @FXML
    void modifyPartMainHandler(ActionEvent event) throws IOException  {
        currentModProduct = mainProductTable.getSelectionModel().getSelectedItem();
        setModifiedProduct(currentModProduct);
        openProductScreen(event);
            
    }

    @FXML
    void searchPartsHandler(ActionEvent event) throws IOException  {
        
    }

    @FXML
    void searchProductsHandler(ActionEvent event) throws IOException  {

    }
    
    public MainScreenController(){
    }
 
     public void openPartScreen(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("AddModifyPart.fxml"));
        Scene scene = new Scene(loader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
     }
   
    
     public void openProductScreen(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("AddModifyProduct.fxml"));
        Scene scene = new Scene(loader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
     }
    
    public static Part getModPart() {
        return currentModPart;
    }

    
    public void setModifiedPart(Part modifyPart) {
        View_Controller.MainScreenController.currentModPart = modifyPart;
    }
    

    public static Product getModifiedProduct() {
        return currentModProduct;
    }
  
    public void setModifiedProduct(Product modifiedProduct) {
        MainScreenController.currentModProduct = modifiedProduct;
    }
    
    public void populatePartsTable(){
        mainPartsTable.setItems(getAllParts());
    }
   
    public void populateProductTable(){
        mainProductTable.setItems(getProduct());
    }
    
    public void setApp(AppLoader mainApp){
        populatePartsTable();
       populateProductTable();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        setModifiedPart(null);
        setModifiedProduct(null);
        
        mainPartIDColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPartID()).asObject());
        mainPartNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        mainPartInventoryColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getInStock()).asObject());
        mainPartPriceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
        
        mainProductIDColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getProductID()).asObject());
        mainProductNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        mainProductInventoryColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getInStock()).asObject());
        mainProductPriceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
        
        populatePartsTable();
        populateProductTable();   
        
        
    }
   
}
    

