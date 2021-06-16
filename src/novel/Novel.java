package novel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Christiana
 * 
 * Date created: 2021-06-15
 */
public class Novel extends Application {


    public static void main(String[] args) {
        
        launch(args);
    }
 
    /**
     *Overriding the abstract method from Application to set the stage for JavaFX.
     * 
     * 
     * @param stage the stage object with which we create the scene
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLNovel.fxml"));
        stage.setTitle("Novel");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
    
    

