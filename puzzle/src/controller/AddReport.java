package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import service.ReportService;
import vo.Member;
import vo.Reportt;

@WebServlet("/AddReport")
public class AddReport extends HttpServlet {
private ReportService reportService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset-UTF-8");
		HttpSession session = request.getSession();
		
		
		String sessionInfo = (String)session.getAttribute("sessionInfo");	
		int timer = Integer.parseInt(request.getParameter("timer"));
		int count = Integer.parseInt(request.getParameter("count"));
		
		
		
		
		
		System.out.println("timer : "+ timer);
		System.out.println("count : "+ count);
		System.out.println("session : "+ sessionInfo);
		
		Reportt report = new Reportt();
		report.setMember(new Member());
		report.getMember().setMemberId(sessionInfo);
		report.setCount(count);
		report.setTimer(timer);
		
		reportService = new ReportService();
		
		reportService.insertTimerCount(report);
		
		Gson gson = new Gson();
		String json = gson.toJson(report);
		response.getWriter().write(json);
	}

}
