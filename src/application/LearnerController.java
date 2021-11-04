package application;

import java.io.IOException;
import java.sql.*;

import javax.swing.JOptionPane;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.scene.Node;
import application.mainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import application.Register;
import application.mainPage;
//import data.storeData;
import application.RecoveryPass;
//import data.storeData;

public class LearnerController implements Initializable{

	@FXML
    private AnchorPane rootPane;
    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton register;

    @FXML
    private JFXButton FPass;

    @FXML
    private JFXButton login;

    @FXML
    private JFXButton Exit;
    //storeData databaseHandler;

    @FXML
    void OnFPass(ActionEvent event) throws IOException{

    	try{
    		FXMLLoader loader = new FXMLLoader();
    		Pane pane  = loader.load(getClass().getResource("FXML Files/Recovery.fxml"));
    		RecoveryPass controller = loader.getController();
    		Scene scene  = new Scene(pane);
    		Stage stage = new Stage();
    		stage.setTitle("Recovery");
    		stage.setScene(scene);
    		stage.initStyle(StageStyle.UNDECORATED);
    		stage.initModality(Modality.APPLICATION_MODAL);
    		stage.show();
    		//controller.updateView();
    	}
    	catch (IOException except) {
			except.printStackTrace();
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
    @FXML
    void onLogin(ActionEvent event)throws IOException
	{
    	final String DATABASE_URL = "jdbc:mysql://localhost/School_Record";
	    final String USERNAME = "root";
	    final String PASSWORD = "LisaNT97";
	    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    	String user = "";
		String pass = null;
     	Connection conn;
     	ResultSet result = null;
     	PreparedStatement statement = null;
	try {
		user = username.getText();
		pass = password.getText();
		String Palavra_pass = new String(pass);

       if((user.isEmpty())&&(Palavra_pass.isEmpty()))
       {
            System.out.println(" Please enter user name and Password and then press login");
       }else if(user.isEmpty())
       {
            System.out.println(" Please enter username ");
       }
       else if(Palavra_pass.isEmpty())
       {
            System.out.println(" Please enter password ");
       }else
       {
		   Class.forName(JDBC_DRIVER);
		   conn =  DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		   Statement s = conn.createStatement();
		   StringBuilder sb = new StringBuilder();

		   String query = "SELECT * from Learners  where Username=? and Password=? ";
		   System.out.println("Connection Established.......");
		   statement = conn.prepareStatement(query);
		   statement.setString(1, user);
		   statement.setString(2, Palavra_pass);
		   result =  statement.executeQuery();
		   //statement.setString(1, query);
		   if (result.next())
           {
        	   Alert alert = new Alert(AlertType.INFORMATION);
        	   alert.setTitle("INFO");
        	   alert.setHeaderText("HELLO");
        	   alert.setContentText("WELCOME");
        	   alert.showAndWait();
        	   try{
				   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				   //Load FXML file
				   FXMLLoader fxmlLoader = new FXMLLoader();
				   fxmlLoader.setLocation(getClass().getResource("FXML Files/MainView.fxml"));
				   mainView controller = fxmlLoader.getController();
				   //Set Stage and Scene of the File
				   Scene scene = new Scene(fxmlLoader.load(), 800, 545);
				   stage.setScene(scene);
				   stage.setScene(scene);
				   stage.show();
   			}
   			catch(IOException e)
			{
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
	} catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("INFO");
		alert.setHeaderText("No Connection");
		alert.setContentText("Can't Find/ Connect to Database");

		alert.showAndWait();
		//System.out.println("Empty fields");
	}
}
    @FXML
    void returns(ActionEvent event) {

    	Stage stage = (Stage)rootPane.getScene().getWindow();
    	stage.close();

    }

    @FXML
    void onRegister(ActionEvent event) throws IOException
	{
        	try{
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				//Load FXML file
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("FXML Files/RegisterUser.fxml"));
				//Set Stage and Scene of the File
				Scene scene = new Scene(fxmlLoader.load(), 465, 500);
				stage.setScene(scene);
				Register controller = fxmlLoader.getController();
				stage.setScene(scene);
				stage.show();
        	}
        	catch (IOException except) {
    			except.printStackTrace();
    		}
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
    }


