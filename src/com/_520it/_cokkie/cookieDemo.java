package com._520it._cokkie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class cookieDemo extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    req.setCharacterEncoding("UTF-8");
			System.out.println("cookieDemo.service()");
			String name=req.getParameter("username");
			System.out.println(name+"===");
			
//			注意，这边不能使用中文
			name=URLEncoder.encode(name, "UTF-8");
			String value=req.getParameter("password");
			Cookie cookie=new Cookie(name,value);
			String ret=URLDecoder.decode(cookie.getName(), "UTF-8");
			System.out.println(name);
			System.out.println(URLDecoder.decode(name, "UTF-8"));
			System.out.println("======");
			System.out.println(cookie.getValue());
	}
}
