package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.MemberService;
import vo.Member;

@WebServlet("/EditMember")
public class EditMember extends HttpServlet {
private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset-UTF-8");
		
		memberService = new MemberService();
		Member member = new Member();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
		String changePw = request.getParameter("changePw");
		
		System.out.println("memberId : "+ member.getMemberId());
		System.out.println("memberPw : "+ member.getMemberPw());
		System.out.println("changePw : "+ changePw);
		
		int val = memberService.updateMember(member, changePw);
		System.out.println("service" + val);
		Gson gson = new Gson();
		String json = gson.toJson(val);
		response.getWriter().write(json);

	}

}
