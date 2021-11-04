package application;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import application.Document;
//import AllTheLists.lecturer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class database {
	private Connection connect = null;
	private PreparedStatement statement = null;
	private static database handler = null;
	private Properties props;
	public database(){

		settins();
		createConnection();
		createTable();

	}

	public static database getInstance(){
		if(handler==null){
			handler = new database();

		}return handler;
	}


	private void createConnection(){
		try{
			Class.forName(props.getProperty("jdbc.driver.class")).newInstance();
			connect = DriverManager.getConnection(props.getProperty("jdbc.url"));

		}
		catch(Exception e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("connection failed");
			alert.show();
		}
	}

	private void settins() {
		// TODO Auto-generated method stub

		props= new Properties();
		try(FileInputStream file = new FileInputStream("conf.properties")){

			props.load(file);

		}catch(Exception e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("settings failed");
			alert.show();
		}

	}
	private void createTable() {
		// TODO Auto-generated method stub
		String TABLE_NAME = "Document";
		try{
			statement = connect.prepareStatement("CREATE TABLE"+TABLE_NAME+"("
					+"Id varchar(20),\n"
					+"title varchar(20) primary key,\n"
					+"subject varchar(20) primary key,\n"
					+"Subcontent varchar(20) default 'E'"
					+")");

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("table created");
			alert.show();

			DatabaseMetaData dbm = connect.getMetaData();
			ResultSet tables = dbm.getTables(null,null,TABLE_NAME.toUpperCase(),null);

			/*Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("table created");
			alert.show();*/
		if(!tables.next())	{
			statement.execute();

		}
		}catch(SQLException e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("TABLE CREATION failed");
			alert.show();
		}}



	public ResultSet Select(String query , Document doc){
		ResultSet result;
		try{
			statement = connect.prepareStatement(query);
			if(doc!=null){
				statement.setString(1, doc.getId());
				//statement.setString(2, lectu.getSurname());
			}
			result = statement.executeQuery();
		}catch(SQLException e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("result failed");
			alert.show();
			return null;
		}
		return result;

	}
	public boolean Insert(String query, Document doc){
		try{
			statement = connect.prepareStatement(query);
			statement.setString(1,doc.getId() );
			statement.setString(2,doc.gettitle() );
			statement.setString(3,doc.getsubject() );
			statement.setString(4,doc.getSubcontent() );
			statement.executeUpdate();
			return true;
		}catch(SQLException e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("insert failed");
			alert.show();
			return false;
		}


	}

	public boolean Update(String query, Document doc){
		try{
			statement = connect.prepareStatement(query);
			statement.setString(1,doc.getId());
			statement.executeUpdate();
			return true;
		}catch(SQLException e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("update failed");
			alert.show();
			return false;
		}
	}

	public void closeSession(){
		try{
			if(statement!=null)statement.close();
			if(connect!=null)connect.close();
		}
		catch(SQLException e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("closing failed");
			alert.show();

		}
	}

}
