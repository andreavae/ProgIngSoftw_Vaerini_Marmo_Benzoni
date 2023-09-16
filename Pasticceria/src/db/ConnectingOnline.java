package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectingOnline {
	private String pathDB;
	private Connection connection = null;
	private Statement statement = null;

	public ConnectingOnline(String path) {
		pathDB = path;

	}

	public String getPathDB() {
		return pathDB;
	}

	public void setPathDB(String pathDB) {
		this.pathDB = pathDB;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql:" + pathDB, "root", ""); // //127.0.0.1:3306/test
			statement = connection.createStatement();
			System.out.println("Connection to " + pathDB + " " + "successful");

		} catch (ClassNotFoundException notFoundException) {
			notFoundException.printStackTrace();
			System.out.println("Connection Error!");

		} catch (SQLException sqlException) {

			sqlException.printStackTrace();
			System.out.println("Connection Error!");
		}

	}

	public void close() {
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
