package View_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private TableView<?> addPartTable;

    @FXML
    private TableColumn<?, ?> addPartTablePartID;

    @FXML
    private TableColumn<?, ?> addPartTablePartName;

    @FXML
    private TableColumn<?, ?> addPartTableInventoryLevel;

    @FXML
    private TableColumn<?, ?> addPartTablePrice;

    @FXML
    private TableView<?> partDeleteTable;

    @FXML
    private TableColumn<?, ?> partDeleteTablePartID;

    @FXML
    private TableColumn<?, ?> partDeleteTablePartName;

    @FXML
    private TableColumn<?, ?> partDeleteTableInventoryLevel;

    @FXML
    private TableColumn<?, ?> partDeleteTablePrice;

    @FXML
    private Button addPartToProduct;

    @FXML
    private Button deletePartFromProduct;

    @FXML
    private Button searchPartsButton;

    @FXML
    private TextField searchPartsField;

    @FXML
    void addPartToProductHandler(MouseEvent event) {

    }

    @FXML
    void cancelProductHandler(MouseEvent event) {

    }

    @FXML
    void deletePartFromProductHandler(MouseEvent event) {

    }

    @FXML
    void saveProductHandler(MouseEvent event) {

    }

    @FXML
    void searchPartsButtonHandler(MouseEvent event) {

    }

}
