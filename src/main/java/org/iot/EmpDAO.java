package org.iot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpDAO {

	// DB - Mysql
	String db_driver = "com.mysql.jdbc.Driver";
	String db_url    = "jdbc:mysql://localhost:3306/iot";
	String db_user   = "root";
	String db_passwd = "12345";

	public EmpDAO() {
		try {
			Class.forName(db_driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<EmpDTO> select() {
		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();

		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String            sql   = "SELECT * FROM emp";

		try {
			Class.forName(db_driver);
			conn  = DriverManager.getConnection(db_url, db_user, db_passwd);
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();

			while (rs.next()) {
				int    empno    = rs.getInt("empno");
				String ename    = rs.getString("ename");
				String job      = rs.getString("job");
				int    mgr      = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				int    sal      = rs.getInt("sal");
				int    comm     = rs.getInt("comm");
				int    deptno   = rs.getInt("deptno");

				EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
