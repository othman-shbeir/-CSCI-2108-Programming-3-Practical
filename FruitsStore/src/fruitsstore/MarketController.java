package fruitsstore;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MarketController implements Initializable {
    
    @FXML
    private TextField searchTextField;
    @FXML
    private Button searchBtn;
    @FXML
    private Button addToCartButton;
    @FXML
    private VBox chosenCard;
    @FXML
    private Label fruitNameLabel;
    @FXML
    private Label fruitPriceLabel;
    @FXML
    private ImageView fruitImageView;
    
    List<Fruit> fruits;
    @FXML
    private GridPane grid;
    Image image;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fruits = new ArrayList<>(getData());
        if (!fruits.isEmpty()) {
            setChosenFruit(fruits.get(0));
        }
        
        int cols = 0;
        int rows = 1;
        
        try {
            for (int i = 0; i < fruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(fruits.get(i));
                itemController.setMarketController(this);
               
                
                if (cols == 3) {
                    cols = 0;
                    rows++;
                }

                // set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                // set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                this.grid.add(anchorPane, cols++, rows);
                
                GridPane.setMargin(grid, new Insets(10));
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(MarketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void searchBtnHandler(ActionEvent event) {
    }
    
    @FXML
    private void addToCartButtonHandler(ActionEvent event) {
    }
    
    public void setChosenFruit(Fruit fruit) {
        fruitNameLabel.setText(fruit.getName());
        this.fruitPriceLabel.setText("$" + fruit.getPrice());
        image = new Image(getClass()
                .getResourceAsStream(fruit.getImgSrc()));
        this.chosenCard.setStyle("-fx-background-color:#"
                + fruit.getColor() + ";\n"
                + "-fx-background-radius: 30px;");
        
        this.fruitImageView.setImage(image);
        
    }
    
    private List<Fruit> getData() {
        List<Fruit> fruits = new ArrayList<>();
        Fruit fruit;
        
        fruit = new Fruit();
        fruit.setName("Kiwi");
        fruit.setPrice(2.99);
        fruit.setImgSrc("/fruitsstore/img/kiwi.png");
        fruit.setColor("6A7324");
        fruits.add(fruit);
        
        fruit = new Fruit();
        fruit.setName("Coconut");
        fruit.setPrice(3.99);
        fruit.setImgSrc("/fruitsstore/img/coconut.png");
        fruit.setColor("A7745B");
        fruits.add(fruit);
        
        fruit = new Fruit();
        fruit.setName("Peach");
        fruit.setPrice(1.50);
        fruit.setImgSrc("/fruitsstore/img/peach.png");
        fruit.setColor("F16C31");
        fruits.add(fruit);
        
        fruit = new Fruit();
        fruit.setName("Grapes");
        fruit.setPrice(0.99);
        fruit.setImgSrc("/fruitsstore/img/grapes.png");
        fruit.setColor("291D36");
        fruits.add(fruit);
        
        fruit = new Fruit();
        fruit.setName("Watermelon");
        fruit.setPrice(4.99);
        fruit.setImgSrc("/fruitsstore/img/watermelon.png");
        fruit.setColor("22371D");
        fruits.add(fruit);
        
        fruit = new Fruit();
        fruit.setName("Orange");
        fruit.setPrice(2.99);
        fruit.setImgSrc("/fruitsstore/img/orange.png");
        fruit.setColor("FB5D03");
        fruits.add(fruit);
        
        fruit = new Fruit();
        fruit.setName("StrawBerry");
        fruit.setPrice(0.99);
        fruit.setImgSrc("/fruitsstore/img/strawberry.png");
        fruit.setColor("80080C");
        fruits.add(fruit);
        
        fruit = new Fruit();
        fruit.setName("Mango");
        fruit.setPrice(0.99);
        fruit.setImgSrc("/fruitsstore/img/mango.png");
        fruit.setColor("FFB605");
        fruits.add(fruit);
        
        fruit = new Fruit();
        fruit.setName("Cherry");
        fruit.setPrice(0.99);
        fruit.setImgSrc("/fruitsstore/img/cherry.png");
        fruit.setColor("5F060E");
        fruits.add(fruit);
        
        fruit = new Fruit();
        fruit.setName("Banana");
        fruit.setPrice(1.99);
        fruit.setImgSrc("/fruitsstore/img/banana.png");
        fruit.setColor("E7C00F");
        fruits.add(fruit);
        
        return fruits;
        
    }
}
