package mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.CartDB;
import utils.DBUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import conn.DBConnection;

/**
 * Servlet implementation class DeleteCartController
 */
@WebServlet("/deleteCart")
public class DeleteCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartController() {
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
		String user=(String)request.getParameter("username");
		String idpr=(String)request.getParameter("idpr");
		int id=0;
		try {
            id = Integer.parseInt(idpr);
        } catch (Exception e) {
        }
		
		String err=null;
		try {
			CartDB.deleteCart(conn, id, user);
		}catch(SQLException e) {
            e.printStackTrace();
            err = e.getMessage();
        }
		response.sendRedirect(request.getContextPath() +"/cart?username="+user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
