package novel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    private Label lblNotif;
    @FXML
    private Button save;
    
    File poetryFile = new File("poems.txt"); //create the file object
    ArrayList<String> entryList = new ArrayList();  //Create the array to store each poem as a String
    private PrintWriter fileOut;   
    int pageNumber = 0;   //Create a counter to allow user to move forward and backwards between entries
    
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        /* Use this section to create a new file. Maybe users will be able to start new books, and I can prompt them to enter the title for new books.
        
        
        //Create the file on the local computer that will act as a diary/novel
        
        try {
            fileOut = new PrintWriter(new BufferedWriter(new FileWriter(poetryFile, true)));
        } catch (IOException ex) {
            System.out.println("It's not workin girl, try something else");
        }
        
        */
        
        
        
        Scanner in = null; //Create a null scanner object to avoid errors
        
        try {
            in = new Scanner(new File("poems.txt"));   //Read the text file specified by the user
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        
        // Read through every entry in the file 
        
        String s = ""; //create an empty String to store file text
        String[] fields = null;
        while (in.hasNextLine()) {
            s += in.nextLine() + "\n"; 
            fields = s.split("//");      
            
        }
        
        for (String field : fields) {
            entryList.add(field);
        }
        
        in.close(); //close the fileWriter
        
        
        //Display the current file in the reader 
        
        txtBox.setText(entryList.get(pageNumber)); 
    }    

    @FXML
    private void add(ActionEvent event) {
        
        entryList.add("");   //Add a new entry
        txtBox.setText(entryList.get(pageNumber+1));   //turn to the new blank page
        pageNumber++;    //update the current page number
        lblNotif.setText("Write your entry below then press save.");
 
        
    }

    @FXML
    private void scroll(ActionEvent event) {
        
        //If user scrolls left, move to the previous index of the field array and update the page counter
        if (event.getSource() == btnLeft) {
            try {
                lblNotif.setText(""); //Reset the title
                txtBox.setText(entryList.get(pageNumber-1));
                pageNumber--;
            } catch (Exception ex) {
                lblNotif.setText("You have already reached the beginning.");
            }
        } else {
            try {
                lblNotif.setText("");
                txtBox.setText(entryList.get(pageNumber+1));
                pageNumber++;
            } catch (Exception ex) {
                lblNotif.setText("You have reached the end.");
            }
        }
    }

    @FXML
    private void save(ActionEvent event) throws IOException {
        
        String newEntry = txtBox.getText();
        entryList.add(newEntry);
        
        //open output stream
        fileOut = new PrintWriter(new BufferedWriter(new FileWriter(poetryFile, true)));
        
        fileOut.println(newEntry + "//");
        
        //re-write entire file to include new entry       ***Add random access in future   
        
        /*Iterator<String> it = entryList.iterator();
       
        while (it.hasNext()) {
            fileOut.println("//");
            fileOut.println(it.next());
            
        } */
        
        
        
        //close stream and update user
        
        fileOut.close();
        
        lblNotif.setText("Your new entry has been saved");
        
        
    }
    
}
