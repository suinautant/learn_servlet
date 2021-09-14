package org.iot;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpSelect")
public class EmpSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 4586291950034474586L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<HTML><BODY>");
		out.print("<H1>EmpSelect</H1> <BR />");

		// DB - Mysql
		String db_driver = "com.mysql.jdbc.Driver";
		String db_url    = "jdbc:mysql://localhost:3306/iot";
		String db_user   = "root";
		String db_passwd = "12345";

		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String            sql   = "SELECT * FROM emp";

		try {
			Class.forName(db_driver);
			conn  = DriverManager.getConnection(db_url, db_user, db_passwd);
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();

			// table column
			// empno, ename, job, mgr, hiredate, sal, comm, deptno
			while (rs.next()) {
				String rsEmpno    = rs.getString("empno");
				String rsEname    = rs.getString("ename");
				String rsJob      = rs.getString("job");
				String rsMgr      = rs.getString("mgr");
				String rsHiredate = rs.getString("hiredate");
				String rsSal      = rs.getString("sal");
				String rsComm     = rs.getString("comm");
				String rsDeptno   = rs.getString("deptno");

				out.print("empno : " + rsEmpno + "  ");
				out.print("ename : " + rsEname + "  ");
				out.print("job : " + rsJob + "  ");
				out.print("mgr : " + rsMgr + "  ");
				out.print("hiredate : " + rsHiredate + "  ");
				out.print("sal : " + rsSal + "  ");
				out.print("comm : " + rsComm + "  ");
				out.print("deptno : " + rsDeptno + "  ");
				out.print("<BR />");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		out.print("</BODY></HTML>");
		// End of doPost
	}

	// End of Documnet
}
