package mvc;

import jakarta.servlet.RequestDispatcher;
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
 * Servlet implementation class ProductEditController
 */
@WebServlet("/editVoucher")
public class VoucherEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoucherEditController() {
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
		String idv = (String)request.getParameter("idv");
		
		int id = 0;
		try {
            id = Integer.parseInt(idv);
        } catch (Exception e) {
        }
		Voucher vc= null;
		String err=null;
		try {
			vc= VoucherDB.findVoucher(conn, id);
		}catch(SQLException e) {
            e.printStackTrace();
            err = e.getMessage();
        }	 
		if(err!=null&& vc==null) {
			response.sendRedirect(request.getServletPath()+"voucherList");
			return;
		}
		request.setAttribute("err", err);
		request.setAttribute("editv", vc);
		
		RequestDispatcher dis=request.getServletContext()
				.getRequestDispatcher("/views/EditVoucher.jsp");
		dis.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String Id=(String)request.getParameter("idv");
		String TenVC=(String)request.getParameter("TenVCv");
		String HDSD=(String)request.getParameter("HDSDv");
		String TGBD =(String)request.getParameter("ThoiGianBDv");
		String TGKT= (String)request.getParameter("ThoiGianKTv");
		String TGPT= (String)request.getParameter("TienGiamPTv");
		String TGD=(String)request.getParameter("TienGiamDongv");
		String DK=(String)request.getParameter("DieuKienv");
		String SL= (String)request.getParameter("SoLuongv");
		
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
		
		Voucher exist =new Voucher();
		try {
			exist= VoucherDB.findVoucher(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Voucher vc= new Voucher(id, TenVC, HDSD, TGBD, TGKT, tgpt, tgd, DK, sl);
		String err=null;
		try {
			VoucherDB.editVoucher(conn, vc);
		}catch(SQLException e) {
			e.printStackTrace();
			err=e.getMessage();
			
		}
		request.setAttribute("err", err);
		request.setAttribute("editv",vc);
		
		if(err!=null) {
			RequestDispatcher dis=request.getServletContext()
					.getRequestDispatcher("/editVoucher");
			dis.forward(request,response);
		}else {
				response.sendRedirect("voucherList");
			}
		}
		
	}


