package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectingOnline { // gestione connessione al database online
	private String pathDB; // contiene il percorso del database
	private Connection connection = null; // rappresenta la connessione al database
	private Statement statement = null; // variabile per le query

	public ConnectingOnline(String path) { // costruttore
		pathDB = path;

	}

	public String getPathDB() { // ottiene percorso database
		return pathDB;
	}

	public void setPathDB(String pathDB) { // imposta percorso database
		this.pathDB = pathDB;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() { // ottiene query
		return statement;
	}

	public void setStatement(Statement statement) { // inserire query
		this.statement = statement;
	}

	public void connect() { // stabilire connessione al database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // caricamento driver per la connessione al db
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

	public void close() { // chiudere connessione al database
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
