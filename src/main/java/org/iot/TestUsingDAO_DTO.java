package org.iot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class TestUsingDAO_DTO extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDAO            empDAO = new EmpDAO();
		ArrayList<EmpDTO> lists  = empDAO.select();
//		ArrayList<EmpDTO> lists = new ArrayList<EmpDTO>();
//		lists = empDAO.select();

		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<HTML><BODY>");
		out.print("<H1>EmpSelect</H1> <BR />");

		out.print("<H3>Using ArrayList</H3> <BR />");
		for (EmpDTO list : lists) {
			out.print("empno : " + list.empno);
			out.print("ename : " + list.ename);
			out.print("job : " + list.job);
			out.print("mgr : " + list.mgr);
			out.print("hiredate : " + list.hiredate);
			out.print("sal : " + list.sal);
			out.print("comm : " + list.comm);
			out.print("deptno : " + list.deptno);
			out.print("<BR />");
		}

		out.print("<BR />");
		out.print("<BR />");

		out.print("<H3>Using Iterator</H3> <BR />");
		Iterator<EmpDTO> iterator = lists.iterator();
		while (iterator.hasNext()) {
			EmpDTO list = (EmpDTO) iterator.next();
			out.print("empno : " + list.empno);
			out.print("ename : " + list.ename);
			out.print("job : " + list.job);
			out.print("mgr : " + list.mgr);
			out.print("hiredate : " + list.hiredate);
			out.print("sal : " + list.sal);
			out.print("comm : " + list.comm);
			out.print("deptno : " + list.deptno);
			out.print("<BR />");
		}

		out.print("</BODY></HTML>");

	}

}
