package application;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;

import application.AdminView;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import application.mainView;
import application.TutQuizUploads;
import application.ViewBookMath;
import application.ViewDoc;
import application.ViewBooks;
import application.ViewQuest;
import application.ViewTut;


public class mainView implements Initializable {

    @FXML
    private JFXButton TutQuiz;

    @FXML
    private JFXButton QuestP;

    @FXML
    private JFXButton Books;

    @FXML
    private JFXButton Grades;

    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;
	@FXML
	private JFXHamburger hamburger2;
	@FXML
	private JFXDrawer drawer2;

	@FXML
	private JFXButton TutQuiz1;

	@FXML
	private JFXButton QuestP1;

	@FXML
	private JFXButton Books1;

	@FXML
	private JFXButton Grades1;



    @FXML
    void onBooks(ActionEvent event) throws Exception {
		try{
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			//Load FXML file
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("FXML Files/ViewBookMath.fxml"));
			ViewBookMath controller = fxmlLoader.getController();
			//Set Stage and Scene of the File
			Scene scene = new Scene(fxmlLoader.load(), 1280, 700);
			stage.setScene(scene);
			stage.setScene(scene);
			stage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}


	}
	@FXML
	void onBooks1(ActionEvent event) {
		try{
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			//Load FXML file
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("FXML Files/ViewBooks.fxml"));
			ViewBooks controller = fxmlLoader.getController();
			//Set Stage and Scene of the File
			Scene scene = new Scene(fxmlLoader.load(), 1280, 700);
			stage.setScene(scene);
			stage.setScene(scene);
			stage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}


	}
	@FXML
	void onQuest1(ActionEvent event) {

		try{
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			//Load FXML file
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("FXML Files/ViewQuest.fxml"));
			ViewQuest controller = fxmlLoader.getController();
			//Set Stage and Scene of the File
			Scene scene = new Scene(fxmlLoader.load(), 1280, 700);
			stage.setScene(scene);
			stage.setScene(scene);
			stage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}


	}
	@FXML
	void onTut1(ActionEvent event) {
		try{
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			//Load FXML file
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("FXML Files/ViewTut.fxml"));
			ViewTut controller = fxmlLoader.getController();
			//Set Stage and Scene of the File
			Scene scene = new Scene(fxmlLoader.load(), 1280, 700);
			stage.setScene(scene);
			stage.setScene(scene);
			stage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	@FXML
	void onGrades1(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("no quizes done yet, quizes not available");
        alert.showAndWait();

	}
    @FXML
    void onGrades(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("no quizes done yet, quizes not available");
        alert.showAndWait();
    //"SELECT PhotoID, Filename, Caption,SUBSTRING(Photo,1,20) FROM authors"
    }

    @FXML
    void onQuest(ActionEvent event) {
		try{
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			//Load FXML file
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("FXML Files/ViewQuestMath.fxml"));
			ViewDoc controller = fxmlLoader.getController();
			//Set Stage and Scene of the File
			Scene scene = new Scene(fxmlLoader.load(), 1280, 700);
			stage.setScene(scene);
			stage.setScene(scene);
			stage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

    }
    @FXML
	void signOut(ActionEvent event)
	{
		try {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			//Load FXML file
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("FXML Files/learner.fxml"));
			//Set Stage and Scene of the File
			Scene scene = new Scene(fxmlLoader.load(), 464, 511);
			stage.setScene(scene);
			LearnerController controller = fxmlLoader.getController();
			stage.setScene(scene);
			stage.show();
		}catch(Exception e)
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
    @FXML
    void onTut(ActionEvent event) throws IOException
	{
		try{
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			//Load FXML file
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("FXML Files/ViewDocfxml.fxml"));
			ViewDoc controller = fxmlLoader.getController();
			//Set Stage and Scene of the File
			Scene scene = new Scene(fxmlLoader.load(), 1280, 700);
			stage.setScene(scene);
			stage.setScene(scene);
			stage.show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
    	/*FXMLLoader loader = new FXMLLoader();
		Pane pane = FXMLLoader.load(getClass().getResource("/viewDocuments/ViewDocfxml.fxml"));
		ViewDoc controller = loader.getController();
		Scene scene = new Scene(pane);
		Stage stage = new Stage();
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();*/

    	/*final String DATABASE_URL = "jdbc:mysql://localhost/School_Record";
	    final String USERNAME = "root";
	    final String PASSWORD = "LisaNT97";
	    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

		Connection conn;
		ResultSet result = null;


			try{



//				tent);

				 Class.forName(JDBC_DRIVER);
		    	  conn =  DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		    	 // String query = "insert into Documents  values('"+1+"', '"+name+"', '"+content+"')";
		    	 // String query = "LOAD DATA LOCAL INFILE "+content+" INTO TABLE Documents";//VALUES('"+user+"','"+password+"','"+passa+"')";
		    	  //String query = "SELECT Username=?, Password=? from User_Table  where Category=administrator ";
		    	 // String query = "SELECT (Context)FROM Documents" ;
		    	 String query = "SELECT * from Documents  where DocID=3 ";
		    	 // String query = "SELECT Filenames from Documents ";
		    	 // PreparedStatement statement = conn.prepareStatement(query);
		    	 Statement statement = conn.createStatement();
		    	 ResultSet rs = statement.executeQuery(query);

		      	  	//statement.execute();
		      	  System.out.println("Connection Established.......LOADED");
		      	 while(rs.next())
		      	 {
		      		String Filenames = rs.getString("Filenames");
		      		 String Context = rs.getString("Context");


		      		 System.out.format("%s\n", Filenames);
		      		System.out.format("%s\n", Context);
		      	 }



			}
			catch(SQLException | ClassNotFoundException ex){
				 Logger.getLogger(TutQuizUploads.class.getName()).log(Level.SEVERE, null,ex);
			}*/

    }
    public void initialize(URL arg0, ResourceBundle arg1)
	{
		showDrawer();
		showDrawer2();
	}
    private void showDrawer()
    {
        try {
            StackPane menu = FXMLLoader.load(getClass().getResource("FXML Files/tools_fxml.fxml"));
            drawer.setSidePane(menu);
            HamburgerNextArrowBasicTransition burgetTask = new HamburgerNextArrowBasicTransition(hamburger);
          //  HamburgerSlideCloseTransition burgetTask = new HamburgerSlideCloseTransition(hamburger);
            burgetTask.setRate(-1);
            hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) ->
            {
            	 burgetTask.setRate(burgetTask.getRate() * -1);
            	 burgetTask.play();
            	 if(drawer.isShown())
            	 {
					 drawer.close();
            	 }
            	 else {
					 drawer.open();
				 }
            });
        } catch (IOException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	private void showDrawer2()
	{
		try {
			StackPane menu = FXMLLoader.load(getClass().getResource("FXML Files/tools_fxml.fxml"));
			drawer2.setSidePane(menu);
			HamburgerNextArrowBasicTransition burgetTask = new HamburgerNextArrowBasicTransition(hamburger2);
			//  HamburgerSlideCloseTransition burgetTask = new HamburgerSlideCloseTransition(hamburger);
			burgetTask.setRate(-1);
			hamburger2.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) ->
			{
				burgetTask.setRate(burgetTask.getRate() * -1);
				burgetTask.play();
				if(drawer2.isShown())
				{
					drawer2.close();
				}
				else {
					drawer2.open();
				}
			});
		} catch (IOException ex) {
			Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
