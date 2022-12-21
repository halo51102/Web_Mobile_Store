package mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ProductDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.Product;
import conn.DBConnection;

/**
 * Servlet implementation class AccessoryListController
 */

@WebServlet(name="AccessoryList",urlPatterns= {"/accessoryList"})
public class AccessoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessoryListController() {
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
			list=ProductDB.listAccessory(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("AccessoryList", list);	
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher=request.getServletContext()
				.getRequestDispatcher("/views/managerAccessory.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBConnection.getConnection();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		
		String idpr=(String)request.getParameter("idpr");
		String namepr=(String)request.getParameter("namepr");
		String typepr=(String)request.getParameter("typepr");
		String categorypr="accessory";
		String costpr=(String)request.getParameter("costpr");
		String amountpr=(String)request.getParameter("amountpr");
		String p1=(String)request.getParameter("prp1");
		String p2=(String)request.getParameter("prp2");
		String p3=(String)request.getParameter("prp3");
		String p4=(String)request.getParameter("prp4");
		String despr=(String)request.getParameter("despr");
		
		int id=0;
		int cost=0;
		int amount=0;
		
		try {
			id=Integer.parseInt(idpr);
			cost=Integer.parseInt(costpr);
			amount=Integer.parseInt(amountpr);
		}catch(Exception e) {}
		
		Product exist=new Product();
		try {
			exist=ProductDB.findProduct(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		while(exist!=null)
		{
			id=id+1;
			try {
				exist=ProductDB.findProduct(conn, id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		Product pr=new Product(id,namepr,typepr,categorypr,cost,amount,p1,p2,p3,p4,despr);
		String err=null;
		try {
			ProductDB.addProduct(conn, pr);
		}catch(SQLException e) {
			e.printStackTrace();
			err=e.getMessage();
		}
		
		request.setAttribute("err", err);
		if(err!=null) {
			RequestDispatcher dis=request.getServletContext()
					.getRequestDispatcher("accessoryList");
			dis.forward(request,response);
		}else {
			response.sendRedirect("accessoryList");
		}
	}

}
