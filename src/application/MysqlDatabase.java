package application;
import java.sql.*;

import javax.swing.JOptionPane;

public class MysqlDatabase
{
		static final String DATABASE_URL = "jdbc:mysql://localhost/School_Record";
	    static final String USERNAME = "root";
	    static final String PASSWORD = "LisaNT97";
	    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		// Instances variables declaration
	    private Statement statement;
	    private ResultSet resultSet;
	    private Connection connection = null;
	    private PreparedStatement pstmt = null;

	    public MysqlDatabase(){
	        //initials = i;surname = sn;number = std;balance = b;
	        try
	            {
	                Class.forName(JDBC_DRIVER);
	                connection =  DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	                pstmt = connection.prepareStatement("INSERT INTO Paper_info (ID,Title,Category, Year) values (?,?,?,?)");
	                pstmt.setString(1, "ID24");
	        	    pstmt.setString(2, "Question 2");
	                pstmt.setString(3, "Quiz");
	        	    pstmt.setString(4, "2019");
	                pstmt.execute();

	                pstmt.close();
	                connection.close();

	            }
	            catch(  ClassNotFoundException | SQLException e )
	            {
	                JOptionPane.showMessageDialog(null,e);
	            }
	    }



	}

