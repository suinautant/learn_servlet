package org.iot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeptInsertCommand implements DeptCommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		DeptDTO deptDTO = new DeptDTO();
		deptDTO.setDeptno(Integer.parseInt(req.getParameter("deptno")));
		deptDTO.setDname(req.getParameter("dname"));
		deptDTO.setLoc(req.getParameter("loc"));
		
		DeptDAO deptDAO = new DeptDAO();
		deptDAO.insert(deptDTO);
	}
	

}
