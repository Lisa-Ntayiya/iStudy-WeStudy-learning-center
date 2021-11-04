    package application;

    import java.awt.Dimension;
    import java.awt.Toolkit;
    import java.io.File;
    import java.net.MalformedURLException;
    import java.util.List;

import javafx.application.Application;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.scene.Scene;
    import javafx.scene.control.Alert;
    import javafx.scene.control.Alert.AlertType;
    import javafx.scene.control.Menu;
    import javafx.scene.control.MenuBar;
    import javafx.scene.control.MenuItem;
    import javafx.scene.control.ScrollPane;
    import javafx.scene.control.Tab;
    import javafx.scene.control.TabPane;
    import javafx.scene.image.Image;
    import javafx.scene.layout.VBox;
    import javafx.stage.FileChooser;
    import javafx.stage.FileChooser.ExtensionFilter;
import application.PDFView;
import javafx.stage.Stage;


       public class MainUpload extends Application {

	  public TabPane tpane;
	  private Stage savedStage;
	  public File [] sFiles;
	  public Tab tab;
	  public ScrollPane s1;
 	  public int u=0;
	  public String choosedName;

	 @Override
	 public void start(Stage primaryStage) {

		MenuBar menuBar = new MenuBar();
		Menu file = new Menu("File");
		Menu more=new Menu("More");

		menuBar.getMenus().addAll(file,more);

		MenuItem open = new MenuItem("Open file..");
		open.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle (ActionEvent e){
				try {
					open();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		MenuItem close=new MenuItem("Exit");
		close.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle (ActionEvent e){
				System.exit(0);
			}
		});

		MenuItem help=new MenuItem("Help");
		help.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle (ActionEvent e){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Help");
				alert.setHeaderText("Welcome to FView application");
				alert.setContentText("With FView you can open and view PDF, Doc, Dox, Xls, Xlsx, Ppt, Pptx, Png, Jpg, Jpeg files"
						+"\n \nTo be able to view files, first you need to click on File in menu"
						+" then click on Open file/s.. When you choose which file/s you want to open"
						+" just click on open and all seleted files will be open in new tabs.");
				alert.showAndWait();
			}
		});

		MenuItem about=new MenuItem("About");
		about.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle (ActionEvent e){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("About");
				alert.setHeaderText(null);
				alert.setContentText("Copyright (c) 2016, A. Adamou. \nAll rights reserved and exclusive.");
				alert.showAndWait();
			}
		});

		file.getItems().addAll(open,close);
		more.getItems().addAll(help,about);

		VBox pane=new VBox();

		tpane=new TabPane();
		pane.getChildren().addAll(menuBar,tpane);

		Scene scena=new Scene(pane);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		primaryStage.setTitle("FView");
		primaryStage.setWidth(width*2/3);
		primaryStage.setHeight(height*2/3);
		primaryStage.setMinHeight(height*7/12);
		primaryStage.setMinWidth(width*7/12);
		primaryStage.getIcons().add(new Image("http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/256/Apps-graphics-viewer-document-icon.png"));
		primaryStage.setScene(scena);
        primaryStage.show();

        savedStage=primaryStage;


	}

	public void open() throws MalformedURLException{

		FileChooser chooseFile=new FileChooser();

		chooseFile.setTitle("Select file/s");
		chooseFile.getExtensionFilters().addAll(
				new ExtensionFilter("All","*.*"),
				new ExtensionFilter("PDF Files","*.pdf"),
				new ExtensionFilter("Word Files","*.doc","*.docx"),
				new ExtensionFilter("Excel Files","*.xls","*.xlsx"),
				new ExtensionFilter("Power Point Files","*.ppt","*.pptx"),
				new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

		List<File>selectedFiles=chooseFile.showOpenMultipleDialog(savedStage);
		int fileNumber=selectedFiles.size();

		sFiles=new File[fileNumber];
		for(int i = 0; i < fileNumber; i++) {
			sFiles[i] = selectedFiles.get(i);
		}

		for(int i=0;i<fileNumber;i++){

			choosedName=sFiles[i].getName();
			String ext=choosedName.substring(choosedName.lastIndexOf(".") + 1);

			switch (ext) {
            case "pdf":

            	pdf();

                     break;
            case "jpg":

            	img();

                    break;
            case "jpeg":

            	img();

            		break;
            case "png":

            	img();

    				break;
            default:
                     break;
			}

			if(i==fileNumber-1){
				u=0;
			}else{
				u++;
			}

		}

	}

	public void img(){
		tab = new Tab();
        tab.setText(choosedName);
        s1=new ScrollPane();
        tab.setContent(s1);
       // s1.setContent(ImgView.setImg(sFiles[u]));
        tpane.getTabs().add(tab);


	}

	public void pdf() throws MalformedURLException{

		tab = new Tab();
		tab.setText(choosedName);
		s1=new ScrollPane();
		tab.setContent(s1);
		s1.setContent(PDFView.showPDF(sFiles[u]));
		tpane.getTabs().add(tab);

	}
		   public void INSERT(){



		   }


		   public static void main(String[] args) {
		launch(args);
	    }
        }



