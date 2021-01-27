package com.cos.bus.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.bus.domain.BusInfo;

//http://localhost:8080/ExpressBus/businfo
@WebServlet("/businfo")
public class BusInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BusInfoController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String cmd = request.getParameter("cmd");
		HttpSession session = request.getSession();
		
		if(cmd.equals("result")) { //
			String arrPlaceNm = request.getParameter("arrTerminalId");
			String depPlaceNm = request.getParameter("depTerminalId");
//			String charge = request.getParameter("content");
//			String depPlandTime = request.getParameter("content");
//			String arrPlandTime = request.getParameter("content");
			
			BusInfo busInfo = new BusInfo();
			busInfo.setArrPlaceNm(arrPlaceNm);
			busInfo.setDepPlaceNm(depPlaceNm);
			
			request.setAttribute("busInfo", busInfo);
			
			RequestDispatcher dis = request.getRequestDispatcher("businfo/result.jsp");
			dis.forward(request, response);
		}
	}
}
