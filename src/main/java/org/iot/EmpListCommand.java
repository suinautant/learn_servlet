package org.iot;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpListCommand implements EmpConmmand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpDTO> list = dao.select();
		
		req.setAttribute("list", list);
	}

	
}
