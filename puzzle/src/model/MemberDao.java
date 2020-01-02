package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class MemberDao {
	public MemberDao() {
		
	}
	
	public int updateMember (Connection conn, Member member, String changePw) throws Exception {
		int val = 0; //확인용 변수 값이 넘어가서 실행되면 1, 아니면 0
		PreparedStatement stmt = null;
		String sql = "update member set member_pw =? WHERE member_id =? and member_pw =?";
		stmt =conn.prepareStatement(sql);
		stmt.setString(1, changePw);
		stmt.setString(2, member.getMemberId());
		stmt.setString(3, member.getMemberPw());
		
		val = stmt.executeUpdate();
		System.out.println(val);
		stmt.close();
		
		return val;
	}
	
	
	public int deleteMember(Connection conn , Member member) throws Exception {
		int val = 0;
		PreparedStatement stmt = null;
		String sql ="DELETE FROM member WHERE member_id =? and member_pw =?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());

		val = stmt.executeUpdate();
		System.out.println(val);
		stmt.close();
		
		return val;
	}
	
	
	
	//회원가입
	public void insertPuzzle(Connection conn, Member member) throws Exception{
		PreparedStatement stmt = null;
		String sql = "insert into member(member_id, member_pw, member_level) values (?,?,'Y')";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//로그인 확인
	public Member login(Connection conn, Member member) throws Exception{
		Member returnMember = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		System.out.println("login Dao : " + member.getMemberId());
		
		String sql ="select member_id from member where  member_id = ? and member_pw =? and member_level = 'Y'";	
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs = stmt.executeQuery();
			if(rs.next()) {
				returnMember = new Member();
				returnMember.setMemberId(rs.getString("member_id"));
				
			}
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnMember;
	}
}
