package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXRadioButton;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

import javafx.scene.Node;


import application.Register;

public class chooseUser implements Initializable {

    @FXML
    private AnchorPane ancho2;

    @FXML
    private JFXRadioButton admin;

    @FXML
    private JFXRadioButton learner;

    @FXML
    private JFXProgressBar load;

    @FXML
    private JFXButton exit;

    @FXML
    private JFXButton ok;

    ToggleGroup group = new ToggleGroup();


	public void buttons(){

		learner.setToggleGroup(group);
		admin.setToggleGroup(group);
		learner.setFocusTraversable(false);
		admin.setFocusTraversable(false);


	}

    @FXML
    void onAdmin(ActionEvent event) {
    	buttons();

    }

    @FXML
    void onContinue(ActionEvent event) {
    	buttons();

    	if(admin.isSelected()){

    		try{
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				//Load FXML file
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("FXML Files/AdminFX.fxml"));
				//Set Stage and Scene of the File
				Scene scene = new Scene(fxmlLoader.load(), 464, 511);
				stage.setScene(scene);
				AdminView controller = fxmlLoader.getController();
				stage.setScene(scene);
				stage.show();
        	}
        	catch (IOException except) {
    			except.printStackTrace();
    		}

		}

		else if(learner.isSelected()){

			try{
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
        	}
        	catch (IOException except)
			{
    			except.printStackTrace();
    		}
		}
    }

    @FXML
    void onExit(ActionEvent event)
	{
    	Stage stage = (Stage)ancho2.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void onLearner(ActionEvent event) throws IOException{

    	buttons();

/*
        	try{
        		FXMLLoader loader = new FXMLLoader();
        		Pane pane  = loader.load(getClass().getResource("/application/Sample.fxml"));
        		SampleController controller = loader.getController();
        		Scene scene  = new Scene(pane);
        		Stage stage = new Stage();
        		stage.setTitle("Learner's View");
        		stage.setScene(scene);
        		stage.initModality(Modality.APPLICATION_MODAL);
        		stage.show();
        		//controller.updateView();

        	}
        	catch (IOException except) {
    			except.printStackTrace();
    		}

*/


    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
