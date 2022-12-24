package mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.BillDB;
import utils.VoucherDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.Bill;
import bean.Voucher;
import conn.DBConnection;

/**
 * Servlet implementation class Bill_List_Controller
 */
public class Bill_List_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bill_List_Controller() {
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
		List<Bill> list= null;
		try {
			list = BillDB.listBill(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("BillList", list);		
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher=request.getServletContext()
				.getRequestDispatcher("/views/managerBill.jsp");
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
