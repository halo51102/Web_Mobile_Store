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

import bean.Product;
import conn.DBConnection;

/**
 * Servlet implementation class ProductEditController
 */
@WebServlet("/editProduct")
public class ProductEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEditController() {
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
		
		int id = 0;
		try {
            id = Integer.parseInt(idpr);
        } catch (Exception e) {
        }
		Product pr=null;
		String err=null;
		try {
			pr=ProductDB.findProduct(conn, id);
		}catch(SQLException e) {
            e.printStackTrace();
            err = e.getMessage();
        }	 
		if(err!=null&&pr==null) {
			response.sendRedirect(request.getServletPath()+"productList");
			return;
		}
		request.setAttribute("err", err);
		request.setAttribute("editpr", pr);
		
		RequestDispatcher dis=request.getServletContext()
				.getRequestDispatcher("/views/editProduct.jsp");
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

		String idpr=(String)request.getParameter("idpr");
		String namepr=(String)request.getParameter("namepr");
		String typepr=(String)request.getParameter("typepr");
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
		String categorypr=null;
		if(exist!=null)
		{
			categorypr=exist.getCategory();
		}
		
		Product pr=new Product(id,namepr,typepr,categorypr,cost,amount,p1,p2,p3,p4,despr);
		String err=null;
		try {
			ProductDB.editProduct(conn, pr);
		}catch(SQLException e) {
			e.printStackTrace();
			err=e.getMessage();
			
		}
		request.setAttribute("err", err);
		request.setAttribute("editpr", pr);
		
		if(err!=null) {
			RequestDispatcher dis=request.getServletContext()
					.getRequestDispatcher("/editProduct");
			dis.forward(request,response);
		}else {
			String s1=new String("phone     ");
			String s2=new String("accessory ");
			if(pr.getCategory().equals(s1))
			{
				response.sendRedirect("admin");
			}
			else if(pr.getCategory().equals(s2)) {
				response.sendRedirect("accessoryList");
			}
		}
		
	}

}
;