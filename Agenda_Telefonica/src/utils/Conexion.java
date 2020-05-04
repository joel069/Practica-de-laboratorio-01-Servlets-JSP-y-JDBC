package utils;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class Conexion {
		
		
		public static void main(String[] args) throws SQLException {
			Connection conexion = null;
			Statement sentencia = null;
			ResultSet result = null;
			
			String url ="jdbc:mysql://localhost:3306/Agenda?serverTimezone=UTC";
			String user = "root";
			String pass = "root";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion = DriverManager.getConnection(url, user, pass);
				sentencia = conexion.createStatement();
			}catch(ClassNotFoundException e) {
				System.out.println("Imposible Conectar:" + e.getMessage());
			}
			try {
				sentencia.executeUpdate("DROP TABLE IF EXISTS tabla1");
				sentencia.executeUpdate("CREATE TABLE tabla1 (id1 INT PRIMARY KEY ,nombre CHAR(20) DEFAULT 's/n')");
			}catch(SQLException e) {
				System.out.println("Creacion de tabla fallida...!!!" + e.getMessage());
			}
			try {
				sentencia.executeUpdate("INSERT tabla1 (id1) VALUES (3)");
				sentencia.executeUpdate("INSERT tabla1  VALUES (4, 'Jesus')");
				sentencia.executeUpdate("INSERT tabla1  VALUES (5, 'Juan')");	
			}catch(SQLException e) {
				System.out.println("Insercion de datos fallida....!!!!!	" + e.getMessage());
			}
			try {
				result = sentencia.executeQuery("SELECT * FROM tabla1");
				while (result.next())
					System.out.println("id1: " + result.getLong("id1") + ", nombre:" +result.getString("nombre"));	
			} catch(SQLException e) {
				System.out.println("Consulta no se a podido realizar...!!" + e.getMessage());
		 }
	   } 
	}



