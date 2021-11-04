package application;


import java.io.File;
import java.sql.*;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//import AllTheLists.lecturer;
import application.database;
import application.Document;
import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.IOException;

public class Books
{
    @FXML
    private TextArea contentTextArea;
    @FXML
    private TextField openTextField;
    @FXML
    private Button Load;

    @FXML
    private ToggleGroup cryptoGroup;
    private FileChooser fileChooser; // file dialog box
    private String path; // path of file selected
    private Scanner input; //use to read a text file
    @FXML
    private AnchorPane rootPane;

    //filecontent
    String content;

    @FXML
    private JFXButton Done;

    @FXML
    void OK(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void openUpload(ActionEvent event)
    {
        final String DATABASE_URL = "jdbc:mysql://localhost/School_Record";
        final String USERNAME = "root";
        final String PASSWORD = "LisaNT97";
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        Connection conn;
        ResultSet result = null;
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(// filters the files...
                new ExtensionFilter("Text Files", "*.txt"),		        // new ExtensionFilter("Pdf files ", "*.pdf"),
                new ExtensionFilter("Word Files", "*.docx"));
        File file = fileChooser.showOpenDialog(null);
        if(file != null)
        {
            path = file.getAbsolutePath();
            openTextField.setText(file.getAbsolutePath());
            try{
                //Files.lines(file.toPath()).forEach(System.out::println);
//				String content;
                Files.lines(file.toPath())
                        .forEach(line -> {
                            content +=line.toString() + System.lineSeparator();
                        });
//				 Document(String Id, String title,String subject, String Subcontent)
                //store in the db
                //insertDB(null);
                //Document newDocument= new Document("1",file.getName(),"Math",content);
                String name = file.getName();
                int DocID = 5;
                Random randomNumbers = new Random();
                DocID = randomNumbers.nextInt(100);
                System.out.println(name);
                System.out.println(content);
                System.out.println("Hi Phelisa");
                Class.forName(JDBC_DRIVER);
                conn =  DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
                String query = "insert into Books_Math (DocID, Filenames, Context)" + " values(?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, DocID);//number
                statement.setString(2, name);
                statement.setString(3, content);
                statement.execute();
                System.out.println("Connection Established.......LOADED");
                fillTextArea();
            }
            catch(IOException | SQLException | ClassNotFoundException ex)
            {
                Logger.getLogger(application.TutQuizUploads.class.getName()).log(Level.SEVERE, null,ex);
            }
        }else{/*do nothing*/}
    }
    private void fillTextArea()
    {
        openFile();
        //contentTextArea.setText("");
        while(input.hasNext())
        {
            contentTextArea.appendText(input.nextLine() + "\n");
        }
        closeFile();
    }

    private void openFile()
    {
        try
        {
            input = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Open File Failure");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    /**
     * This methods closes the file by means of Scanner's object
     */
    private void closeFile(){
        if (input != null)
            input.close();
    }

    }/*
	public void insertInto(){
		Connection conn;
	     ResultSet result = null;
	     File file = fileChooser.showOpenDialog(null);

	     PreparedStatement statement = null;
		try {
			conn = DriverManager.getConnection(
					 "jdbc:ucanaccess://C:\\Users\\sizwen\\workspace\\Login\\src\\application\\Database11.accdb");
			System.out.println("Connecting to the selected database...");
		     String url = "jdbc:odbc:instanceDNS";
		   Statement s = conn.createStatement();


		   String query = "insert into  Tutorials where type=Tutorial2";
		  // Files.lines(file.toPath()).forEach(query);
		   System.out.println("Connection Established.......");
		   statement = conn.prepareStatement(query);

		   System.out.println("Connection Established.......");

	} catch (Exception e) {
 		// TODO Auto-generated catch block
   	 Alert alert = new Alert(AlertType.ERROR);
   	   alert.setTitle("INFO");
   	   alert.setHeaderText("sorry !!");
   	   alert.setContentText("Access denied");

   	   alert.showAndWait();
   	 //System.out.println("Access denied");
	}



}
	/* public void insertDB(List<lecturer> listl){

	    	list.stream()
	    	.forEach(lec -> loadLec(lec));

	    }

		private void insertDB(Document doc) {
			// TODO Auto-generated method stub
			String query = "INSERT INTO Document" + "(Id,title,subject,Subcontent)" + "VALUES(?,?)";
			//database.Insert(query, doc);


		}
*/


