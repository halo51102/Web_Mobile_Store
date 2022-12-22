package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import bean.Product;
import bean.Voucher;
import conn.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtils;
import utils.ProductDB;
import utils.VoucherDB;


@WebServlet(name="VoucherList",urlPatterns= {"/voucherList"})
public class VoucherListController extends HttpServlet{
	private static final long serialVersionUID=1L;	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VoucherListController() {
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
		List<Voucher> list= null;
		try {
			list = VoucherDB.listVoucher(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		for (Voucher v: list)
//		{
//			System.out.println(v.getId() + v.getTenVC()+ v.getHDSD());
//		}
		request.setAttribute("VoucherList", list);		
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher=request.getServletContext()
				.getRequestDispatcher("/views/managerVoucher.jsp");
		dispatcher.forward(request, response);
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		//TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBConnection.getConnection();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		
		String Id=(String)request.getParameter("id");
		String TenVC=(String)request.getParameter("TenVC");
		String HDSD=(String)request.getParameter("HDSD");
		String TGBD =(String)request.getParameter("ThoiGianBD");
		String TGKT= (String)request.getParameter("ThoiGianKT");
		String TGPT= (String)request.getParameter("TienGiamPT");
		String TGD=(String)request.getParameter("TienGiamDong");
		String DK=(String)request.getParameter("DieuKien");
		String SL= (String)request.getParameter("SoLuong");
	
		int id=0;
		int tgpt=0;
		int tgd=0;
		int sl=0;
		
		
		try {
			id= Integer.parseInt(Id);
			tgpt= Integer.parseInt(TGPT);
			tgd= Integer.parseInt(TGD);
			sl= Integer.parseInt(SL);
		}catch(Exception e) {}
		
		Voucher exist=new Voucher();
		try {
			exist= VoucherDB.findVoucher(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		while(exist!=null)
		{
			id=id+1;
			try {
				exist=VoucherDB.findVoucher(conn, id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Voucher vcVoucher = new Voucher(id, TenVC, HDSD, TGBD, TGKT, tgpt, tgd, DK, sl);

		String err=null;
		try {
			VoucherDB.addVoucher(conn, vcVoucher);
		}catch(SQLException e) {
			e.printStackTrace();
			err=e.getMessage();
		}
		
		request.setAttribute("err", err);
		if(err!=null) {
			RequestDispatcher dis=request.getServletContext()
					.getRequestDispatcher("voucherList");
			dis.forward(request,response);
		}else {
			response.sendRedirect("admin");
		}
	}
}
