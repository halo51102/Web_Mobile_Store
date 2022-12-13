package mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.DBUtils;
import utils.ProductDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import bean.Login;
import bean.Product;
import conn.DBConnection;

/**
 * Servlet implementation class ProductDetailController
 */
@WebServlet(name="ProductDetail", urlPatterns= {"/productdetail"})
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idproduct=request.getParameter("productid");
		int id=0;
		try {
            id = Integer.parseInt(idproduct);
        } catch (Exception e) {
        }
		Product pr=new Product();
		Connection conn;
		String errorString="";
		
		try {
			conn=DBConnection.getConnection();
			pr=ProductDB.findProduct(conn, id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("product", pr);
		RequestDispatcher rd=request.getRequestDispatcher("/views/prodetails.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
