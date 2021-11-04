package application;

import java.io.IOException;

import application.TutUploads;
import application.BooksUploads;
import application.QuestUploads;
import application.AdminView;
import com.jfoenix.controls.JFXButton;

import application.RecoveryPass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import application.TutQuizUploads;



    public class mainPage {
        @FXML
        private MenuItem back;

        @FXML
        private MenuItem About;


        @FXML
        private JFXButton TutQuiz;

        @FXML
        private JFXButton QuestP;

        @FXML
        private JFXButton Books;

        @FXML
        private JFXButton Grades;

        @FXML
        private JFXButton TutQuiz1;

        @FXML
        private JFXButton QuestP1;

        @FXML
        private JFXButton Books1;

        @FXML
        private JFXButton Grades1;

        @FXML
        void onAbout(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText(null);
            alert.setContentText("Copyright (c) 2018, P. Ntayiya. \nAll rights reserved and exclusive. Welcome admin, please you can do your uploads here in this page" );
            alert.showAndWait();

        }

        @FXML
        void onBack(ActionEvent event) {
            System.exit(0);;

           /* try {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                //Load FXML file
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXML Files/AdminFX.fxml"));
                //Set Stage and Scene of the File
                Scene scene = new Scene(fxmlLoader.load(), 407, 430);
                stage.setScene(scene);
                AdminView controller = fxmlLoader.getController();
                stage.setScene(scene);
                stage.show();
            }catch (Exception e)
            {

            }*/


        }


        @FXML
        void onBooks(ActionEvent event) {

            try{
                FXMLLoader loader = new FXMLLoader();
                Pane pane  = loader.load(getClass().getResource("FXML Files/MathsBooksUploads.fxml"));
                TutQuizUploads controller = loader.getController();
                Scene scene  = new Scene(pane);
                Stage stage = new Stage();
              //  stage.setTitle();
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();

                System.out.println("tutorials");
                //controller.updateView();

            }
            catch (IOException except) {
                except.printStackTrace();
            }

        }
        @FXML
        void onBooks1(ActionEvent event) {

            try{
                FXMLLoader loader = new FXMLLoader();
                Pane pane  = loader.load(getClass().getResource("FXML Files/PhysicsBooksUploads.fxml"));
                BooksUploads controller = loader.getController();
                Scene scene  = new Scene(pane);
                Stage stage = new Stage();
                stage.setTitle("");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();

                System.out.println("tutorials");
                //controller.updateView();

            }
            catch (IOException except) {
                except.printStackTrace();
            }



        }

        @FXML
        void onGrades(ActionEvent event) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText(null);
            alert.setContentText("no quizes done yet, quizes not available");
            alert.showAndWait();

        }

        @FXML
        void onQuest(ActionEvent event) {
            try{
                FXMLLoader loader = new FXMLLoader();
                Pane pane  = loader.load(getClass().getResource("FXML Files/Quest.fxml"));
                TutQuizUploads controller = loader.getController();
                Scene scene  = new Scene(pane);
                Stage stage = new Stage();
                stage.setTitle("");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();

                System.out.println("tutorials");


                //controller.updateView();

            }
            catch (IOException except) {
                except.printStackTrace();
            }




        }
        @FXML
        void onQuest1(ActionEvent event) {
            try{
                FXMLLoader loader = new FXMLLoader();
                Pane pane  = loader.load(getClass().getResource("FXML Files/QuestUploads.fxml"));
                QuestUploads controller = loader.getController();
                Scene scene  = new Scene(pane);
                Stage stage = new Stage();
                stage.setTitle("");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();

                System.out.println("tutorials");
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
        void onTut(ActionEvent event) {
        try{
        		FXMLLoader loader = new FXMLLoader();
        		Pane pane  = loader.load(getClass().getResource("FXML Files/TutQuiz.fxml"));
        		TutQuizUploads controller = loader.getController();
        		Scene scene  = new Scene(pane);
        		Stage stage = new Stage();
        		stage.setTitle("");
        		stage.setScene(scene);
        		stage.initModality(Modality.APPLICATION_MODAL);
        		stage.show();

        		System.out.println("tutorials");
        		//controller.updateView();

        	}
        	catch (IOException except) {
    			except.printStackTrace();
    		}
        }
        @FXML
        void onTut1(ActionEvent event) {

            try{
                FXMLLoader loader = new FXMLLoader();
                Pane pane  = loader.load(getClass().getResource("FXML Files/TutUploads.fxml"));
                TutUploads controller = loader.getController();
                Scene scene  = new Scene(pane);
                Stage stage = new Stage();
                stage.setTitle("");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();

                System.out.println("tutorials");
                //controller.updateView();

            }
            catch (IOException except) {
                except.printStackTrace();
            }

        }
        @FXML
        void signOut(ActionEvent event)

        {

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

    }



