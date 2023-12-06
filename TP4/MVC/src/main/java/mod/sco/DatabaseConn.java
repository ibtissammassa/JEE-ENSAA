package mod.sco;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConn {
	private final String URL = "jdbc:mysql://localhost:3306/scolarité";
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private Connection conn;
	public DatabaseConn() {
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(Exception e){
			System.out.println("Error While connecting to db");
			e.printStackTrace();
		}
	}
	public Connection getConn() {
		return conn;
	}
	
}
