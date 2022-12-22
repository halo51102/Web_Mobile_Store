package mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ProductDB;
import utils.VoucherDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import bean.Product;
import bean.Voucher;
import conn.DBConnection;

/**
 * Servlet implementation class ProductDeleteController
 */
@WebServlet("/deleteVoucher")
public class VoucherDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoucherDeleteController() {
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
		
		String idv=(String) request.getParameter("idv");
		int id=0;
		try {
            id = Integer.parseInt(idv);
        } catch (Exception e) {
        }
//		Voucher vc= new Voucher();
		String err=null;
//		try {
//			vc= VoucherDB.findVoucher(conn, id);
//		}catch(SQLException e) {
//            e.printStackTrace();
//            err = e.getMessage();
//        }	 

		try {
			VoucherDB.deleteVoucher(conn, id);
		}catch(SQLException e) {
            e.printStackTrace();
            err = e.getMessage();
        } 
		response.sendRedirect(request.getContextPath() +"/voucherList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
