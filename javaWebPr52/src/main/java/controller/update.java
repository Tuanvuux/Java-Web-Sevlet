package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import model.Product;
import service.ProductService;



@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = ProductService.findById(id);
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
		dispatcher.forward(request, response);
	}
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insert here");
		int id = Integer.parseInt(request.getParameter("id")); 
		String name = request.getParameter("nameProduct");
		double price = Double.parseDouble(request.getParameter("priceProduct"));
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		ProductService.update(product);
		System.out.println(name + " " + price +id);
		response.sendRedirect("demo");
	}

}
