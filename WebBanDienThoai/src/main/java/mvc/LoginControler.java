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
		Connection conn;
		String errorString="";
		
		try {
			conn=DBConnection.getConnection();
			bean=DBUtils.findUser(conn, name, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("bean",bean);
		HttpSession ssid=request.getSession();
		
		if(bean==null) {
			RequestDispatcher rd=request.getRequestDispatcher("/views/login-error.jsp");
			rd.forward(request, response);
		}else {
			ssid.setAttribute("ssid",bean.getName());
			response.sendRedirect("home");
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