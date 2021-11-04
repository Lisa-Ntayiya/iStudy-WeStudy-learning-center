package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.LearnerController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;

import application.mainPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminView {
	//define Locations here
	private double xLocation = 0;
	private double yLocation = 0;
    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton login;

    @FXML
    private JFXButton FPass;

    @FXML
	void OnFPass(ActionEvent event) {
	}

	@FXML
	void onBack(ActionEvent event)
	{
		try {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			//Load FXML file
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("FXML Files/UserChooser.fxml"));
			//Set Stage and Scene of the File
			Scene scene = new Scene(fxmlLoader.load(), 407, 430);
			stage.setScene(scene);
			LearnerController controller = fxmlLoader.getController();
			stage.setScene(scene);
			stage.show();
		}catch (Exception e)
		{

		}
	}
	@FXML
	void minimize(ActionEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setIconified(true);//get Stage and Minimize Window
	}
	@FXML
	void close(ActionEvent event) {
		System.exit(0);
	}
	public void grabWindow(MouseEvent event) {
		//Grab window here
		xLocation = event.getSceneX();
		yLocation = event.getSceneY();
	}

	public void moveWindow(MouseEvent event) {
		//move around here
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setX(event.getScreenX() - xLocation);
		stage.setY(event.getScreenY() - yLocation);
	}
    @FXML
    void onLogin(ActionEvent event) {
    	final String DATABASE_URL = "jdbc:mysql://localhost/School_Record";
	    final String USERNAME = "root";
	    final String PASSWORD = "LisaNT97";
	    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String pass = null;
		Connection conn;
		ResultSet result = null;
		PreparedStatement statement = null;
     try{
    	 String user = "Admin";
    	 pass = password.getText();
  		 String Palavra_pass = new String(pass);
        if(Palavra_pass.isEmpty())
        {
             System.out.println(" Please Enter Admin Password to Login");
        }else
        {
     		Class.forName(JDBC_DRIVER);
     		conn =  DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
     		Statement s = conn.createStatement();
     		String query = "SELECT password from Admin  where Username=? and Password=? ";
     		System.out.println("Connection Established.......");
     		statement = conn.prepareStatement(query);

     		System.out.println("Connection Established.......");
     		statement.setString(1, user);
     		statement.setString(2, Palavra_pass);
     		result =  statement.executeQuery();
            if (result.next())
            {
         	   Alert alert = new Alert(AlertType.INFORMATION);
         	   alert.setTitle("INFO");
         	   alert.setHeaderText("HELLO");
         	   alert.setContentText("WELCOME");
         	  // alert.showAndWait();
                //System.out.println("WELCOME");
         	   try{
				   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				   //Load FXML file
				   FXMLLoader fxmlLoader = new FXMLLoader();
				   fxmlLoader.setLocation(getClass().getResource("FXML Files/MainPage.fxml"));
				   mainPage controller = fxmlLoader.getController();
				   //Set Stage and Scene of the File
				   Scene scene = new Scene(fxmlLoader.load(), 800, 545);
				   stage.setScene(scene);
				   stage.setScene(scene);
				   stage.show();
    			}
    			catch(IOException e){

    				e.printStackTrace();
    			}
             }else
            {

             	Alert alert = new Alert(AlertType.WARNING);
          	   alert.setTitle("INFO");
          	   alert.setHeaderText("sorry !!");
          	   alert.setContentText("Invalid Username or Password");

          	   alert.showAndWait();
             	//System.out.println("Invalid Username or Password");
            }
       }
}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		Alert alert = new Alert(AlertType.ERROR);
 	   alert.setTitle("INFO");
 	   alert.setHeaderText("No Database Connection");
 	   alert.setContentText("Cannot Find/Connect to Database");

 	   alert.showAndWait();
		//System.out.println("Empty fields");
	}
     }
}

