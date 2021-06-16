package novel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Christiana
 */
public class FXMLNovelController implements Initializable {

    @FXML
    private TextArea txtBox;
    @FXML
    private Button btnNew;
    @FXML
    private Button btnLeft;
    @FXML
    private Button btnRight;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add(ActionEvent event) {
    }

    @FXML
    private void scroll(ActionEvent event) {
    }
    
}
