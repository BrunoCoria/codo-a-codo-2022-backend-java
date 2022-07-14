package ar.com.codoacodo.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.codoacodo.connection.AdministradorDeConexiones;
import ar.com.codoacodo.dto.Producto;

public class ProductoDAO {

	// Metodos del crud
	public Producto obtenerPorId(Long id) {
		String sql = "SELECT * FROM PRODUCTO WHERE ID="+id;
		
		// Connection
		Connection con = AdministradorDeConexiones.getConnection();
	
		Producto prodFromDb = null;
		
		// Statement
		try {
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			
			// VIENE UN SOLO REGISTRO
			
			if(rs.next()) {//si existe, hay uno solo
				// rs > sacando los datos
				Long idProducto = rs.getLong(1);// tomar la primer columna
				String nombre = rs.getString(2);
				Float precio = rs.getFloat(3);
				Date fecha = rs.getDate(4);
				String imagen = rs.getString(5);
				String codigo = rs.getString(6);
				
				// Campos crear un objeto
				prodFromDb = new Producto(idProducto,nombre,precio,fecha,imagen,codigo);
			}			
		} catch (SQLException e) {
			// Errores
			e.printStackTrace();
		}
		return prodFromDb;
	}
	
	// 
	

	// Metodos del crud
	// LISTAR PRODUCTO
	public List<Producto> listarProductos() {
		String sql = "SELECT * FROM PRODUCTO ";
		
		// Connection
		Connection con = AdministradorDeConexiones.getConnection();
	
		List<Producto> list = new ArrayList<>();
		
		// Statement
		try {
			Statement st = con.createStatement();
			
			// Resultset
			ResultSet rs = st.executeQuery(sql);
			
			// VIENE UN SOLO REGISTRO
			
			while(rs.next()) {//
				// rs > sacando los datos
				Long idProducto = rs.getLong(1);// Tomar la primer columna
				String nombre = rs.getString(2);
				Float precio = rs.getFloat(3);
				Date fecha = rs.getDate(4);
				String imagen = rs.getString(5);
				String codigo = rs.getString(6);
				
				// Campos crear un objeto
				Producto prodFromDb = new Producto(idProducto,nombre,precio,fecha,imagen,codigo);
				
				// Agrego a la lista 
				list.add(prodFromDb);
			}			
			
			// Cierro la conexion
			con.close();
		} catch (SQLException e) {
			// Errores
			e.printStackTrace();
		}
		return list;
	}

	// CREATE CONTROLLER
	public void crearProducto(String nombre, Float precio, String imagen, String codigo) {
		
		Connection con = AdministradorDeConexiones.getConnection();
		
		if(con != null) { 
			// Insert en la db > SQL: INSERT INTO....
			String sql = "INSERT INTO PRODUCTO (nombre, precio,fecha_creacion,imagen,codigo) ";
			sql += "VALUES('"+nombre+"',"+precio+",	CURRENT_DATE,'"+imagen+"','"+codigo+"')";
			
			// Control de errores
			try {
				Statement st = con.createStatement();			
				st.execute(sql);
				
				// Cierre de conexion
				con.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void actualizarProducto(String codigo, String nombre, String precio) {
		Connection con = AdministradorDeConexiones.getConnection();
		if(con != null) { 
			String sql = "UPDATE PRODUCTO "
					+ " set nombre='"+nombre+"',"
					+ " precio='"+precio+"'"
					+ " WHERE codigo = '"+codigo+"'"; 			
		
			try {
				Statement st = con.createStatement();			
				st.executeUpdate(sql);
				
				con.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// Metodos del crud
	// BUSCAR PRODUCTO
	public List<Producto> buscar(String clave) {
		String sql = "SELECT * FROM PRODUCTO WHERE nombre LIKE '%"+clave+"%' ";
		
		// Connection
		Connection con = AdministradorDeConexiones.getConnection();
	
		List<Producto> listado = new ArrayList<Producto>();
		
		// Statement
		try {
			Statement st = con.createStatement();
			
			// Resultset
			ResultSet rs = st.executeQuery(sql);
			
			// VIENE UN SOLO REGISTRO
			
			if(rs.next()) {// Si existe, hay uno solo
				// rs > sacando los datos
				Long idProducto = rs.getLong(1);// Tomar la primer columna
				String nombre = rs.getString(2);
				Float precio = rs.getFloat(3);
				Date fecha = rs.getDate(4);
				String imagen = rs.getString(5);
				String codigo = rs.getString(6);
				
				// campos crear un objeto
				Producto prodFromDb = new Producto(idProducto,nombre,precio,fecha,imagen,codigo);
				
				listado.add(prodFromDb);
			}			
		} catch (SQLException e) {
			// Errores
			e.printStackTrace();
		}
		
		return listado;
	}
}