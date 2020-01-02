package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Member;
import vo.Reportt;

public class ReportDao {
	public ReportDao() {
		
	}
	
	public List<Reportt> selectMyRankingList(Connection conn, Reportt report) throws Exception{
		List<Reportt> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT member_id, report_id, report_date, count, timer FROM reportt WHERE member_id = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, report.getMember().getMemberId());
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Reportt report1 = new Reportt();
			report1.setMember(new Member());
			report1.getMember().setMemberId(rs.getString("member_id"));
			report1.setCount(rs.getInt("count"));
			report1.setReportDate(rs.getString("report_date"));
			report1.setReportId(rs.getInt("report_id"));
			report1.setTimer(rs.getInt("timer"));
			list.add(report1);
		}
		stmt.close();
		
		return list;
	}
	
	
	public List<Reportt> selectToMonthTopTenList(Connection conn) throws Exception{
		List<Reportt> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT report_id,member_id,report_date,count,timer FROM reportt WHERE month(report_date) = month(NOW()) AND YEAR(report_date) = YEAR(NOW()) ORDER BY timer limit 10";
		
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()) {
			Reportt report = new Reportt();
			report.setCount(rs.getInt("count"));
			report.setReportDate(rs.getString("report_date"));
			report.setTimer(rs.getInt("timer"));
			report.setReportId(rs.getInt("report_id"));
			report.setMember(new Member());
			report.getMember().setMemberId(rs.getString("member_id"));
			list.add(report);
		}
		stmt.close();
		
		return list;
	}
	
	
	public List<Reportt> selectTodayTopTenList(Connection conn) throws Exception{
		List<Reportt> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT report_id,member_id,report_date,COUNT,timer FROM reportt WHERE DATE(report_date) = DATE(NOW()) and year(report_date) = year(now()) ORDER BY timer limit 10";
		
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()) {
			Reportt report = new Reportt();
			report.setCount(rs.getInt("count"));
			report.setReportDate(rs.getString("report_date"));
			report.setTimer(rs.getInt("timer"));
			report.setReportId(rs.getInt("report_id"));
			report.setMember(new Member());
			report.getMember().setMemberId(rs.getString("member_id"));
			list.add(report);
		}
		stmt.close();
		
		return list;
	}
	
	
	
	public List<Reportt> selectTopTenList(Connection conn) throws Exception{
		List<Reportt> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT report_id, member_id, report_date, count, timer FROM reportt ORDER BY timer ASC limit 10;";
		
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()) {
			Reportt report = new Reportt();
			report.setCount(rs.getInt("count"));
			report.setReportDate(rs.getString("report_date"));
			report.setTimer(rs.getInt("timer"));
			report.setReportId(rs.getInt("report_id"));
			report.setMember(new Member());
			report.getMember().setMemberId(rs.getString("member_id"));
			list.add(report);
		}
		stmt.close();
		
		return list;
	}
	
	
	
	public void insertTimerCount(Connection conn, Reportt report) throws Exception {
		PreparedStatement stmt = null;
		String sql ="insert into reportt(member_id, count, timer,report_date) values (?,?,?,now())";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, report.getMember().getMemberId());
		stmt.setInt(2, report.getCount());
		stmt.setInt(3, report.getTimer());
		stmt.executeUpdate();
		
		System.out.println("Dao : "+report.getMember().getMemberId());
		stmt.close();
	}
}
