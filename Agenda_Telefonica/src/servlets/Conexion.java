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
			
			
			String url ="jdbc:mysql://localhost:3306/Agenda?serverTimezone=UTC";
			String user = "root";
			String pass = "root";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion = DriverManager.getConnection(url, user, pass);
				sentencia = conexion.createStatement();
			}catch(ClassNotFoundException e) {
				System.out.println("Error de Conexion....@!!!:" + e.getMessage());
			}
			
	   } 
	}



