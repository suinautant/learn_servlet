package org.iot;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeptListCommand implements DeptCommand {
		DeptDAO deptDAO = new DeptDAO();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
//		DeptDAO deptDAO = new DeptDAO();
		ArrayList<DeptDTO> list = deptDAO.select();
		req.setAttribute("list", list);
	}
	

}
