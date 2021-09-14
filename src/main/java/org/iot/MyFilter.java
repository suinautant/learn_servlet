package org.iot;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class MyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("***** 마이필터 요청필터");
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		System.out.println("***** 마이필터 응답필터");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("***** 필터 초기화");
	}

	@Override
	public void destroy() {
		System.out.println("***** 필터 제거");
	}
}
