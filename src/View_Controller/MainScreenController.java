package View_Controller;

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
import Model.Inventory;
import Model.Inventory.getPart;
import Model.Inventory.getProduct;

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
        showAddPartScreen(event);
    }

    @FXML
    void addProductMainHandler(ActionEvent event) throws IOException  {
        showProductsScreen(event);
    }

    @FXML
    void deletePartHandler(ActionEvent event) throws IOException  {
        Part part = MainPartsTable.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Delete Part");
        alert.setHeaderText("Please Confirm Deletion");
        alert.setContentText("Are you sure you want to delete " + part.getName() + "?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            removePart(part.getPartID());
            populatePartsTable();
    }
}
    
    @FXML
    void deleteProductHandler(ActionEvent event) throws IOException  {
        Product product = MainProductTable.getSelectionModel().getSelectedItem();

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
                removeProduct(product.getProductID());
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
        modifiedPart = MainPartsTable.getSelectionModel().getSelectedItem();
        setModifiedPart(modifiedPart);
        showPartsScreen(event);
    }

    @FXML
    void modifyPartMainHandler(ActionEvent event) throws IOException  {
        modifiedProduct = MainProductTable.getSelectionModel().getSelectedItem();
        setModifiedProduct(modifiedProduct);
        showProductScreen(event);
            
    }

    @FXML
    void searchPartsHandler(ActionEvent event) throws IOException  {
        
    }

    @FXML
    void searchProductsHandler(ActionEvent event) throws IOException  {

    }
//constructor
    
    public MainScreenController(){
    }
 
    public static Part getModPart() {
        return currentModPart;
    }

    
    public void setModifiedPart(Part modifyPart) {
        MainScreenJavaController.currentModPart = modifyPart;
    }
    

    public static Product getModifiedProduct() {
        return currentModProduct;
    }
  
    public void setModifiedProduct(Product modifiedProduct) {
        MainScreenJavaController.currentModProduct = modifiedProduct;
    }
    
    public void populatePartsTable(){
        mainPartsTable.setItems(getPart());
    }
   
    public void populateProductTable(){
        mainProductTable.setItems(getProduct());
    }
    
    public void setApp(Annastasia Gallaher - Inventory System mainApp){
        populatePartsTable();
        populateProductsTable;
    }
   
}
    

