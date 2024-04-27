package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import config.Connect;
import service.ProductService;


@WebServlet("/insert")
public class InsertProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("insert.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insert here");
		String name = request.getParameter("nameProduct");
		double price = Double.parseDouble(request.getParameter("priceProduct"));
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		ProductService.save(product);
		ProductService.afterInsert();
		response.sendRedirect("demo");
	}
	

	


}