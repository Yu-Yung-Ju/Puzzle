package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import service.MemberService;
import vo.Member;

@WebServlet("/Login")
public class Login extends HttpServlet {
private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member member = new Member();
		memberService = new MemberService();
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberPw : " + memberPw);
		
		member.setMemberId(memberId);//member vo 안에있는 값에 request한 값을 저장
		member.setMemberPw(memberPw);//member vo 안에있는 값에 request한 값을 저장
		
		String sessionMemberId = memberService.login(member);
		System.out.println("sessionMemberId : " + sessionMemberId);
		HttpSession session = request.getSession();
		session.setAttribute("sessionInfo", sessionMemberId);
		
		Gson gson = new Gson();
		String json = gson.toJson(null);
		response.getWriter().write(json);
				
	}

}
