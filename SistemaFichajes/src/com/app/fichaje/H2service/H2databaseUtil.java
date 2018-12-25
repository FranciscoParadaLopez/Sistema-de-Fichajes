/**
 * 
 */
package com.app.fichaje.H2service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 * @author franp
 *
 */
public class H2databaseUtil {
		
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";

	static final String USER = "sa";
	static final String PASS = "";
	
	static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static ResultSet resulSet = null;

	public static void connectH2() {
					
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Conectando a la base da datos H2...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (ClassNotFoundException e) {
			System.out.println("error en el driver H2");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al intentar conectar con la BD- H2");
			e.printStackTrace();
		}
 
	}
	
	public static void closeH2() {
			
		try {
			conn.close();
			System.out.println("cerrando conexión...");
		} catch (SQLException e) {
			System.out.println("Error al intentar cerrar la conexión");
			e.printStackTrace();
		}

		System.out.println("conexión cerrada");
	}
	
	public static void executeUpdateSQL(String sql) {
					
		try {
			connectH2();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.commit();
			closeH2();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static ResultSet executeSelect(String sql) {

		try {
			connectH2();
			stmt = conn.createStatement();
			resulSet = stmt.executeQuery(sql);			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resulSet;	
	
	}
	
	
	public static PreparedStatement executeStatement(String sql) {

		try {
			connectH2();
			pstmt = conn.prepareStatement(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;	
	
	}

	

}
