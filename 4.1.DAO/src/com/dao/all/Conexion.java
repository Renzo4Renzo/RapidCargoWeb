package com.dao.all;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	public static Connection conectar() throws Exception{
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+
						"databaseName=RapidCargoDBFinal", "sa", "123");
		} catch (Exception e) {
			throw e;
		}
		return connection;
	}
	
}
