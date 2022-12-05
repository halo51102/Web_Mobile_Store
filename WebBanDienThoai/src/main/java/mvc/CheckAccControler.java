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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
/**
 * Servlet implementation class LoginControler
 */
@WebServlet("/checkAcc")
public class CheckAccControler extends HttpServlet {
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
		if(bean==null) {
			RequestDispatcher rd=request.getRequestDispatcher("/views/login-error.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("/views/login-success.jsp");
			rd.forward(request, response);
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		doPost(req,resp);
	}
}