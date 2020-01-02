package service;

import java.sql.Connection;
import java.sql.SQLException;

import model.MemberDao;
import vo.Member;

public class MemberService {
	
	public int updateMember(Member member, String changePw) {
		int val = 0;
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			MemberDao memberDao = new MemberDao();
			conn = dbService.getConnection();
			
			conn.setAutoCommit(false);
			
			val = memberDao.updateMember(conn, member, changePw);
			
			conn.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return val;
	}
	
	
	public int deleteMember(Member member) {
		int val = 0;
		Connection conn = null;
		try {
			DBService db = new DBService();
			MemberDao memberDao = new MemberDao();
			conn = db.getConnection();
					
			conn.setAutoCommit(false);
			
			val = memberDao.deleteMember(conn, member);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return val;
	}
	
	
	public void insertPuzzle(Member member) {
		Connection conn = null;
		try {
			DBService db = new DBService();
			MemberDao memberDao = new MemberDao();
			conn = db.getConnection();
			memberDao.insertPuzzle(conn, member);
			
			conn.setAutoCommit(false);
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public String login(Member member) {
		Member returnMember = null;
		Connection conn = null;
		
		System.out.println(member.getMemberId());
		
		try {
			//before Dao호출 전
			DBService db = new DBService();
			MemberDao memberDao = new MemberDao();
			
			conn = db.getConnection();
			conn.setAutoCommit(false);
			
			//after Dao 호출 후
			returnMember = memberDao.login(conn, member);
			conn.commit();
		}catch (Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnMember.getMemberId();
	}
}
