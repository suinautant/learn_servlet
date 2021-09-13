package org.iot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	String userid;
	String password;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userid = req.getParameter("userid");
		password = req.getParameter("userpassword");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		out.print("아이디값 : " + userid + "<br />");
		out.print("패스워드 : " + password + "<br />");
		out.print("</body></html>");
		
	}

}
