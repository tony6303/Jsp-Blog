package com.cos.blog.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	public static void back(HttpServletResponse resp, String msg) throws IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html; charset=utf-8"); //utf-8로 응답하겠다
		out.println("<script>");
		out.println("alert('"+msg+"');");
		out.println("history.back();");
		out.println("</script>");
		out.flush();
	}
}
