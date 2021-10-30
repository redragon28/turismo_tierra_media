package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection("jdbc:sqlite:turismo-tierra-media-db.db");
		}
		
		return connection;
	}
 
	//"jdbc:sqlite:TurismoTierraMedia.db" esto depende del nombre que le pongamos al SQL
}


