package fruitsstore;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ItemController implements Initializable {

    @FXML
    private Label fruitNameLabel;
    @FXML
    private Label fruitPrice;
    @FXML
    private ImageView fruitImageView;

    private Fruit fruit;

    private MarketController marketController;
    
    public void setMarketController(MarketController marketController){
        this.marketController = marketController;
    }

 

    public void setData(Fruit fruit) {
        this.fruit = fruit;

        this.fruitNameLabel.setText(this.fruit.getName());
        this.fruitPrice.setText("" + this.fruit.getPrice());
        Image image = new Image(getClass()
                .getResourceAsStream(this.fruit.getImgSrc()));
        this.fruitImageView.setImage(image);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void fruitCardPressedHandler(MouseEvent event) {
        if(marketController != null){
            marketController.setChosenFruit(fruit);
        }
       
    }

}
