package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.connection.AdministradorDeConexiones;
import ar.com.codoacodo.dto.Producto;

@WebServlet("/api/ConsultarController")
public class ConsultarController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		// Validaciones
		
		String sql = "SELECT * FROM PRODUCTO WHERE ID = " + id;
		
		// Conexion Ok
		Connection con = AdministradorDeConexiones.getConnection();
		
		try {
			// Statement 
			Statement st = con.createStatement();
			
			// Resultset
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {// Hay datos?
				// rs > sacando los datos
				Long idProducto = rs.getLong(1);// Tomar la primer columna
				String nombre = rs.getString(2);
				Float precio = rs.getFloat(3);
				Date fecha = rs.getDate(4);
				String imagen = rs.getString(5);
				String codigo = rs.getString(6);
				
				
				// Campos crear un objeto
				Producto prodFromDb = new Producto(idProducto,nombre,precio,fecha,imagen,codigo);
				
				// Ir a otra pagina y ademas pasarle datos
				
				req.setAttribute("producto", prodFromDb);
			}
			
			getServletContext().getRequestDispatcher("/detalle.jsp").forward(req, resp);
			
			// Cierre de conexion
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

