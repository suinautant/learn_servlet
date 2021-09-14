package org.iot;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
//		ServletContextListener.super.contextDestroyed(sce);
		System.out.println("=========================== destroyed!!");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
//		ServletContextListener.super.contextInitialized(sce);
		System.out.println("========================== Initialized!!");
	}




}
