package ar.com.codoacodo.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones { //ctrl + space
	
	public static Connection  getConnection() {
 		String url = "jdbc:mysql://127.0.0.1:3306/codo-a-codo?serverTimeZone=UTC&userSSL=false";
		String username = "root";
		String password = "root";
		
		String driverName = "com.mysql.cj.jdbc.Driver"; //mySQL | postgres}
		
		// control errores
		Connection con = null;
		try {
			Class.forName(driverName); //Carga en memoria el driver
			con = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();// Se que paso y porque fallo
		}
		return con; 
	}
	
	public static void main(String[] args) {
		Connection con = AdministradorDeConexiones.getConnection();
		if(con != null) {
			System.out.println("Conexion ok");
		} else {
			System.out.println("Conexion fail");
		}
	}
}
