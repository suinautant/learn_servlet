package org.iot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeptDAO {

	// DB - Mysql
	String db_driver = "com.mysql.jdbc.Driver";
	String db_url    = "jdbc:mysql://localhost:3306/iot";
	String db_user   = "root";
	String db_passwd = "12345";

	Connection        conn  = null;
	PreparedStatement pstmt = null;
	ResultSet         rs    = null;
	String            sql   = "";

	public DeptDAO() {
		try {
			Class.forName(db_driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DeptDTO> select() {
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();

//		Connection        conn  = null;
//		PreparedStatement pstmt = null;
//		ResultSet         rs    = null;
		sql = "SELECT * FROM dept";

		try {
			Class.forName(db_driver);
			conn  = DriverManager.getConnection(db_url, db_user, db_passwd);
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();

			while (rs.next()) {
				int    deptno = rs.getInt("deptno");
				String dname  = rs.getString("dname");
				String loc    = rs.getString("loc");

				DeptDTO deptDTO = new DeptDTO();
				deptDTO.setDeptno(deptno);
				deptDTO.setDname(dname);
				deptDTO.setLoc(loc);
				list.add(deptDTO);
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

	public void insert(DeptDTO deptDTO) {
//		Connection        conn  = null;
//		PreparedStatement pstmt = null;
		sql = "INSERT INTO dept VALUES (?, ?, ?);";

		try {
			Class.forName(db_driver);
			conn  = DriverManager.getConnection(db_url, db_user, db_passwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptDTO.getDeptno());
			pstmt.setString(2, deptDTO.getDname());
			pstmt.setString(3, deptDTO.getLoc());
			int result = pstmt.executeUpdate();
			System.out.println("********* insert result is " + result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
