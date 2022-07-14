package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.daos.ProductoDAO;
import ar.com.codoacodo.dto.Producto;

@WebServlet("/api/ListadoController")
public class ListadoController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Crear la instancia DE ProductoDAO
		ProductoDAO dao = new ProductoDAO();
		
		// Invocar al metodo listarProductos()
		List<Producto> listado = dao.listarProductos();
		
		// Grabar el listado en el request para que lo vea la siguiente pagina
		req.setAttribute("listado", listado);
		
		// Ir a la siguiente pagina
		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
}
