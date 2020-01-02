package service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ReportDao;
import vo.Reportt;

public class ReportService {
	
	public List<Reportt> selectMyRankingList(Reportt report){
		List<Reportt> list = new ArrayList<>();
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			ReportDao reportDao = new ReportDao();
			conn = dbService.getConnection();
			
			conn.setAutoCommit(false);
			list = reportDao.selectMyRankingList(conn, report);
			
			conn.commit();
			//System.out.println("commit Success");
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
		return list;
	}
	
	public List<Reportt> selectToMonthTopTenList(Reportt report){
		List<Reportt> list = new ArrayList<>();
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			ReportDao reportDao = new ReportDao();
			conn= dbService.getConnection();
			
			conn.setAutoCommit(false);
			list = reportDao.selectToMonthTopTenList(conn);
			
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
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
		
		return list;
	}
	
	
	public List<Reportt> selectTodayTopTenList(Reportt report){
		List<Reportt> list = new ArrayList<>();
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			ReportDao reportDao = new ReportDao();
			conn= dbService.getConnection();
			
			conn.setAutoCommit(false);
			list = reportDao.selectTodayTopTenList(conn);
			
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
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
		
		return list;
	}
	
	
	public List<Reportt> selectTopTenList(Reportt report){
		List<Reportt> list = new ArrayList<>();
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			ReportDao reportDao = new ReportDao();
			conn= dbService.getConnection();
			
			conn.setAutoCommit(false);
			list = reportDao.selectTopTenList(conn);
			
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
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
		
		return list;
	}
	
	
	public void insertTimerCount(Reportt report) {
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			ReportDao reportDao = new ReportDao();

			
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			reportDao.insertTimerCount(conn, report);
			
			conn.commit();
		}catch(Exception e) {
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
	}
}
