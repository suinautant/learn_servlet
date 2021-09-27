package org.iot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.dp")
public class FrontDeptController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI  = req.getRequestURI();
		String contextPath = req.getContextPath();
		String org         = requestURI.substring(contextPath.length());

		DeptListCommand   command           = null;
		DeptInsertCommand deptInsertCommand = null;
		String            nextPage          = "";

		System.out.println("doPost");

		if (org.equals("/list.dp")) {
			command = new DeptListCommand();
			command.execute(req, resp);
			nextPage = "list_dp.jsp";
		}
		
		if (org.equals("/insertui.dp"))  {
			nextPage = "dept_form.jsp";
		}

		if (org.equals("/insert.dp")) {
			deptInsertCommand = new DeptInsertCommand();
			deptInsertCommand.execute(req, resp);
			nextPage = "list.dp";
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(nextPage);
		requestDispatcher.forward(req, resp);
	}
}
