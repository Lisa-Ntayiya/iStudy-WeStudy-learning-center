package application;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import application.TutQuizUploads;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class imageView {

    @FXML
    private ImageView imageView;

    @FXML
    private JFXButton button;

    @FXML
    void onButton(ActionEvent event) {

        final String DATABASE_URL = "jdbc:mysql://localhost/School_Record";
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
            //String query = "SELECT * from Documents  where DocID=3 ";
            String query = "SELECT PhotoID, Filename, Caption,SUBSTRING(Photo,1,20) FROM Photos";
            // PreparedStatement statement = conn.prepareStatement(query);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            //statement.execute();
            System.out.println("Connection Established.......LOADED");
            while(rs.next())
            {
               /* String Photo = rs.getString("Photo");
                Image Photo = new Photo(file.toURI().toString());
                //String Context = rs.getString("Context");
                Image Photo = rs.get


                System.out.format("%s\n", Photo);
                imageView.setImage(Photo);
                //Choose.getItems().addAll(Filenames);
               // imageView.setImage(image);*/
            }



        }
        catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(TutQuizUploads.class.getName()).log(Level.SEVERE, null,ex);
        }

    }



}
