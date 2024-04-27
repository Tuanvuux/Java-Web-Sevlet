package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductService;


/**
 * Servlet implementation class detail
 */
@WebServlet("/detail")
public class detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = ProductService.findById(id);
		request.setAttribute("product", product);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
		dispatcher.forward(request, response);
	}


	
		
	

	
}

