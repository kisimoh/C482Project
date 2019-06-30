package View_Controller;

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
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddModifyProductController implements Initializable {

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
    
    private final ObservableList<Part> productParts = FXCollections.observableArrayList();
    
    private final Product currentModProduct;
    
    public AddModifyProductController() {
        this.currentModProduct = getModifiedProduct();
    }

    @FXML
    void addPartToProductHandler(ActionEvent event) throws IOException {
        Part part = addPartTable.getSelectionModel().getSelectedItem();
        productParts.add(part);
        populatePartsContainedTable();
    }

    @FXML
    void cancelProductHandler(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Cancel Modifying Product");
        alert.setHeaderText("Please confirm cancelling modifying product.");
        alert.setContentText("Please confirm you want to cancel update to product " + ProductNameField.getText() + ".");
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
    void saveProductHandler(ActionEvent event) throws IOException {
        String productName = productNameField.getText();
        String productInventory = productInventoryField.getText();
        String productPrice = productPriceField.getText();
        String productMin = productMinField.getText();
        String productMax = productMaxField.getText();
        
        Product newProduct = new Product();
        newProduct.setName(productName);
        newProduct.setPrice(Double.parseDouble(productPrice));
        newProduct.setInStock(Integer.parseInt(productInventory));
        newProduct.setMin(Integer.parseInt(productMin));
        newProduct.setMax(Integer.parseInt(productMax));
        
        if (currentModProduct != null) {
            currentModProduct.
        }
    }

    @FXML
    void searchPartsButtonHandler(ActionEvent event) throws IOException {

    }

}