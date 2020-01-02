package vo;

public class Reportt {
	private int reportId;
	private Member member;
	private String reportDate;
	private int count;
	private int timer;
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTimer() {
		return timer;
	}
	public void setTimer(int timer) {
		this.timer = timer;
	}
	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", meberId=" + member + ", report_date=" + reportDate + ", count="
				+ count + ", timer=" + timer + "]";
	}
	
}
