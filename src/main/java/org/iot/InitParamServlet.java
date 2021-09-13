package org.iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextParam")
public class InitParamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -683906980860939249L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// initparam
		String dirPath = this.getInitParameter("dirPath");
		String userid = this.getInitParameter("userid");
		String user2 = this.getInitParameter("user2");

		// context param
		String driver = this.getServletContext().getInitParameter("driver");
		
		// access file
		String testFile = "/WEB-INF/testfile.txt";
		InputStream is = getServletContext().getResourceAsStream(testFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		// session
		String name="hong";
		int age=20;
		getServletContext().setAttribute("name", name);
		getServletContext().setAttribute("age", age);

		// 출력
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<HTML><BODY>");

		out.print("경로 : " + dirPath + "<BR />");
		out.print("아이디 : " + userid + "<BR />");
		out.print("드라이버 : " + driver + "<BR />");

		String str = reader.readLine();
		while (str != null) {
			out.print(str + "<BR />");
			str = reader.readLine();
		}

		out.print("</BODY></HTML>");
	}

}
