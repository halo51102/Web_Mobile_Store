package mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import bean.Login;
import conn.DBConnection;
import utils.DBUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
/**
 * Servlet implementation class LoginControler
 */
@WebServlet("/login" )
public class LoginControler extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		Login bean=new Login();
		Login bean2=new Login();
		Connection conn;
		String errorString="";
		
		try {
			conn=DBConnection.getConnection();
			bean=DBUtils.findUser(conn, name, password);
			bean2=DBUtils.findUserForSignUp(conn, name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("bean",bean);
		HttpSession ssid=request.getSession();
		HttpSession ssid2=request.getSession();
		if(bean==null) {
			RequestDispatcher rd=request.getRequestDispatcher("/views/login-error.jsp");
			rd.forward(request, response);
		}else {
			
			String s1=new String("admin     ");
			String s2=new String("customer  ");
			if(bean2.getType().equals(s2)) {
				ssid.setAttribute("ssid",bean2.getName());
				response.sendRedirect("home");
			}else {
				ssid.setAttribute("ssid2",bean2.getName());
				response.sendRedirect("admin");
			}
		}
		
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/views/login.jsp");
        dispatcher.forward(request, response);
        HttpSession ssid=request.getSession();
		ssid.removeAttribute("newlg");
	}
}