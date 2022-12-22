package mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtils;
import utils.ProductDB;
import utils.VoucherDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.Login;
import bean.Product;
import bean.Voucher;
import conn.DBConnection;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		List<Product> list=null;
		try {
			list=ProductDB.listProduct(conn);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Product> list2=null;
		try {
			list2=ProductDB.listAccessory(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Login> list3=null;
		try {
			list3=DBUtils.listUser(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Voucher> list4= null;
		try {
			list4 = VoucherDB.listVoucher(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("VoucherList", list4);
		request.setAttribute("UserList", list3);
		request.setAttribute("AccessoryList", list2);
		request.setAttribute("ProductList", list);		
		response.setContentType("text/html;charset=UTF-8");
		
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/views/admin.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
