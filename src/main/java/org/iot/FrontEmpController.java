package org.iot;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontEmpController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI  = req.getRequestURI();
		String contextPath = req.getContextPath();
		String org         = requestURI.substring(contextPath.length());

		EmpListCommand command = null;
		String nextPage = "";

		if (org.equals("/list.do")) {
			command = new EmpListCommand();
			command.execute(req, resp);
			nextPage = "list.jsp";
		}
		RequestDispatcher dis = req.getRequestDispatcher(nextPage);
		dis.forward(req, resp);
	}

}
