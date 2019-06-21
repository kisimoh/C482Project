package View_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainScreenController {

    @FXML
    private Button searchParts;

    @FXML
    private Button addPartMain;

    @FXML
    private Button modifyPartMain;

    @FXML
    private Button deletePart;

    @FXML
    private TableView<?> partsTable;

    @FXML
    private TableColumn<?, ?> partIDColumn;

    @FXML
    private TableColumn<?, ?> partNameColumn;

    @FXML
    private TableColumn<?, ?> partInventoryColumn;

    @FXML
    private TableColumn<?, ?> partPriceColumn;

    @FXML
    private TextField partsSearchBox;

    @FXML
    private Button addProductMain;

    @FXML
    private Button modifyProductMain;

    @FXML
    private Button deleteProduct;

    @FXML
    private TableView<?> productsTable;

    @FXML
    private TableColumn<?, ?> productIDColumn;

    @FXML
    private TableColumn<?, ?> productNameColumn;

    @FXML
    private TableColumn<?, ?> productInventoryColumn;

    @FXML
    private TableColumn<?, ?> productPriceColumn;

    @FXML
    private Button searchProducts;

    @FXML
    private TextField productSearchBox;

    @FXML
    private Button exitApplication;

    @FXML
    void addPartMainHandler(MouseEvent event) {

    }

    @FXML
    void addProductMainHandler(MouseEvent event) {

    }

    @FXML
    void deletePartHandler(MouseEvent event) {

    }

    @FXML
    void deleteProductHandler(MouseEvent event) {

    }

    @FXML
    void exitApplicationHandler(MouseEvent event) {

    }

    @FXML
    void mainModifyProductHandler(MouseEvent event) {

    }

    @FXML
    void modifyPartMainHandler(MouseEvent event) {

    }

    @FXML
    void searchPartsHandler(MouseEvent event) {

    }

    @FXML
    void searchProductsHandler(MouseEvent event) {

    }

}
