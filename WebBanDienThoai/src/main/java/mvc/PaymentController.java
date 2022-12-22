package mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.BillDB;
import utils.CartDB;
import utils.DBUtils;
import utils.ProductDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import bean.Bill;
import bean.Cart;
import bean.Login;
import conn.DBConnection;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/payment")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
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
		
		String username=(String)request.getParameter("username");
		String idsp=(String)request.getParameter("idpr");
		String status="New Order";
		
		int idpr=0;
		int slpr=0;
		int sumpaid=0;
		try {
			idpr=Integer.parseInt(idsp);
		}catch(Exception e) {}
		
		Cart crt=new Cart();
		try {
			crt=CartDB.findCart(conn, idpr,username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String tenpr=crt.getTenpr();
		slpr=crt.getSlpr();
		sumpaid=crt.getCost();
		String pattern = "MM/dd/yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();   
		String date = df.format(today);
		
		int idbill=0;
		Bill exist=new Bill();
		try {
			exist=BillDB.findBill(conn, idbill);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while(exist!=null)
		{
			idbill=idbill+1;
			try {
				exist=BillDB.findBill(conn, idbill);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Login user=new Login();
		try {
			user=DBUtils.findUserForSignUp(conn, username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Bill bill=new Bill(idbill,username,idpr,tenpr,slpr,sumpaid,date,status,user.getName(),user.sdt,user.getAddress());
		String err=null;
		try {
			BillDB.addBill(conn, bill);
		}catch(SQLException e) {
			e.printStackTrace();
			err=e.getMessage();
		}
		request.setAttribute("err", err);
		if(err!=null) {
			RequestDispatcher dis=request.getServletContext()
					.getRequestDispatcher("/views/cart.jsp");
			dis.forward(request,response);
		}else {
			request.setAttribute("NewBill", bill);
			RequestDispatcher rd=request.getRequestDispatcher("/views/PayEx.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
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
		String idbill=(String)request.getParameter("idb");
		String tenkh=(String)request.getParameter("tenkh");
		System.out.print(tenkh);
		String sdt=(String)request.getParameter("sdt");
		String address=(String)request.getParameter("address");
		String status="Paid";
		int idb=0;
		try {
			idb=Integer.parseInt(idbill);
		}catch(Exception e) {
			
		}
		String err=null;

		Bill fB=new Bill();
		try {
			BillDB.updateInfoBill(conn,idb,status,tenkh,sdt,address);
			
			fB=BillDB.findBill(conn,idb);
			CartDB.deleteCart(conn, fB.getIdpr(), fB.getUsername());
			
		}catch(SQLException e) {
			e.printStackTrace();
			err=e.getMessage();
		}
		request.setAttribute("err", err);
		if(err!=null) {
			RequestDispatcher dis=request.getServletContext()
					.getRequestDispatcher("/home");
			dis.forward(request,response);
		}else {
			response.sendRedirect("cart?username="+fB.getUsername());
		}
	}

}
