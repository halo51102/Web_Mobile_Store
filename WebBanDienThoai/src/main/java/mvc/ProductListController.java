package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.Product;
import conn.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtils;
import utils.ProductDB;


/**
 * Servlet implementation class MonHocListServlet
 */
@WebServlet(name="ProductList",urlPatterns= {"/productList"})
public class ProductListController extends HttpServlet{
	private static final long serialVersionUID=1L;	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductListController() {
		super();
		//TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request,HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{		
		Connection conn=null;
		try {
			conn=DBConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Product> list=null;
		try {
			list=ProductDB.listProduct(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("ProductList", list);		
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher=request.getServletContext()
				.getRequestDispatcher("/views/managerProduct.jsp");
		dispatcher.forward(request, response);
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		//TODO Auto-generated method stub
		doGet(request,response);
	}
}
