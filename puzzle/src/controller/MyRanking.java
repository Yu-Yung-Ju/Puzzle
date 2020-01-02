package controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/MyRanking")
public class MyRanking extends HttpServlet {
private ReportService reportService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset-UTF-8");
		HttpSession session = request.getSession();
		List<Reportt> list = new ArrayList<>();
		reportService = new ReportService();
		Reportt report = new Reportt();
		
		String sessionInfo = (String)session.getAttribute("sessionInfo");
		
		report.setMember(new Member());
		report.getMember().setMemberId(sessionInfo);
		System.out.println(report.getMember().getMemberId());
		list = reportService.selectMyRankingList(report);
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		response.getWriter().write(json);
	}

}
