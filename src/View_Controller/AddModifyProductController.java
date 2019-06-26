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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AddModifyProductController {

    @FXML
    private TextField productID;

    @FXML
    private TextField productName;

    @FXML
    private TextField productInventory;

    @FXML
    private TextField productPrice;

    @FXML
    private TextField productMin;

    @FXML
    private TextField productMax;

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
    
    private final ObservableList<Part> ProductParts = FXCollections.observableArrayList();
    
    private final Product currentModProduct;
    
    public AddModifyProductController() {
        this.currentModProduct = getModifiedProduct();
    }

    @FXML
    void addPartToProductHandler(ActionEvent event) throws IOException {

    }

    @FXML
    void cancelProductHandler(ActionEvent event) throws IOException {

    }

    @FXML
    void deletePartFromProductHandler(ActionEvent event) throws IOException {

    }

    @FXML
    void saveProductHandler(ActionEvent event) throws IOException {

    }

    @FXML
    void searchPartsButtonHandler(ActionEvent event) throws IOException {

    }

}
