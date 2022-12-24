package mvc;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.CartDB;
import utils.ProductDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.Cart;
import bean.Product;
import conn.DBConnection;

/**
 * Servlet implementation class CartController
 */
@WebServlet(name="CartList",urlPatterns={"/cart"})
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String idsp=(String)request.getParameter("idpr");

		String tenpr=(String)request.getParameter("tenpr");
		String slsp=(String)request.getParameter("slpr");
		String costsp=(String)request.getParameter("cost");
		String username=(String)request.getParameter("username");
		String h=(String) request.getParameter("hinh");
		int idpr=0;
		int slpr=0;
		int cost=0;
		try {
			idpr = Integer.parseInt(idsp);
			slpr = Integer.parseInt(slsp);
			cost = Integer.parseInt(costsp);
		} catch (Exception e) {
		}
		System.out.println(idpr);
		System.out.println(slpr);
		String err=null;
		Cart exist=new Cart();
		try {
			exist=CartDB.findCart(conn, idpr, username);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(exist!=null) {
			RequestDispatcher dis=request.getServletContext()
					.getRequestDispatcher("home");
			dis.forward(request,response);
		}else {
			Cart crt=new Cart(idpr,tenpr,slpr,cost,username,h);
			try {
				CartDB.addCart(conn,crt);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
				response.sendRedirect("cart?username="+username);
			
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String username=(String)request.getParameter("username");
		
		List<Cart> list=null;
		try {
			list=CartDB.listCart(conn,username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("CartList", list);	
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/views/cart.jsp");
		dispatcher.forward(request, response);

	}

}
