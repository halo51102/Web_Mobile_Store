package mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.DBUtils;
import utils.ProductDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import bean.Login;
import conn.DBConnection;

/**
 * Servlet implementation class SignupController
 */

@WebServlet(urlPatterns = { "/sign-up" })
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/views/sign-up.jsp");
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
		
		String name=(String)request.getParameter("username");
		String pass=(String)request.getParameter("password");
		String gender=(String)request.getParameter("gender");
		String sdt=(String)request.getParameter("sdt");
		String address=(String)request.getParameter("address");
		String type="customer";
		
		Login exist=new Login();
		try {
			exist=DBUtils.findUserForSignUp(conn,name);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		int id=0;
		String newname=name;
		while(exist!=null) {
			String ids=Integer.toString(id);
			newname=name+ids;
			try {
				exist=DBUtils.findUserForSignUp(conn,newname);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			id=id+1;
		}
		
		Login lg=new Login(newname,pass,gender,type,sdt,address);
		String err=null;
		
		try {
			DBUtils.addUser(conn, lg);
		}catch(SQLException e) {
			e.printStackTrace();
			err=e.getMessage();
		}
		request.setAttribute("newlg", lg);
		
		HttpSession newlogin=request.getSession();
		request.setAttribute("err", err);
		if(err!=null) {
			RequestDispatcher dis=request.getServletContext()
					.getRequestDispatcher("sign-up");
			dis.forward(request,response);
		}else {
			newlogin.setAttribute("newlg", lg);
			response.sendRedirect("login");
		}
		
	}

}
