package org.iot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface EmpConmmand {

	public void execute(HttpServletRequest req, HttpServletResponse resp);
		
}
