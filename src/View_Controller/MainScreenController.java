package View_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
