package mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ProductDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import bean.Product;
import conn.DBConnection;

/**
 * Servlet implementation class ProductDeleteController
 */
@WebServlet("/deleteProduct")
public class ProductDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		String idpr=(String) request.getParameter("idpr");
		int id=0;
		try {
            id = Integer.parseInt(idpr);
        } catch (Exception e) {
        }
		
		Product exist=new Product();
		try {
			exist=ProductDB.findProduct(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String err=null;
		try {
			ProductDB.deleteMonHoc(conn, id);
		}catch(SQLException e) {
            e.printStackTrace();
            err = e.getMessage();
        } 
		
		String s1=new String("phone     ");
		String s2=new String("accessory ");
		if(exist.getCategory().equals(s1))
		{
			response.sendRedirect(request.getContextPath() +"/admin");
		}
		else if(exist.getCategory().equals(s2)) {
			response.sendRedirect(request.getContextPath() +"/accessoryList");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
