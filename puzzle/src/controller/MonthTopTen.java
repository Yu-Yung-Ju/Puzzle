package controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ReportService;
import vo.Reportt;

@WebServlet("/MonthTopTen")
public class MonthTopTen extends HttpServlet {
private ReportService reportService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset-UTF-8");
		reportService = new ReportService();
		Reportt report = new Reportt();
		
		List<Reportt> list = new ArrayList<>();
		
		list = reportService.selectToMonthTopTenList(report);
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.getWriter().write(json);
	}

}
