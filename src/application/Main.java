package application;
import application.MysqlDatabase;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage) {
		try {
			Image icon = new Image(getClass().getResourceAsStream("iStudy.png"));
			primaryStage.getIcons().add(icon);
			Parent root = FXMLLoader.load(getClass().getResource("FXML Files/UserChooser.fxml"));
			Scene scene = new Scene(root,407,430);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		//MysqlDatabase b = new MysqlDatabase();
	}
}
