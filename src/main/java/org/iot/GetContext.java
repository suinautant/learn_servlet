package org.iot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetContext")
public class GetContext extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1238077424246552387L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = (String) getServletContext().getAttribute("name");
		int age = (int) getServletContext().getAttribute("age");

		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<HTML><BODY>");
		out.print("이름 : " + name + "<BR />");
		out.print("나이 : " + age + "<BR />");
		out.print("</BODY></HTML>");
	}
	
}
