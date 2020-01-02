package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.MemberDao;
import service.MemberService;
import vo.Member;


@WebServlet("/AddMember")
public class AddMember extends HttpServlet {
private MemberDao memberDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset-UTF-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		System.out.println("memberId : "+memberId + "memberPw : "+memberPw);
		Member member = new Member();
		
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		MemberService mem = new MemberService();
		mem.insertPuzzle(member);
		
		Gson gson = new Gson();
		String json = gson.toJson(member);
		response.getWriter().write(json);
	}

}
