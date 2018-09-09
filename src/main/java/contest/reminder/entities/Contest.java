package contest.reminder.entities;

public class Contest {

	String code;
	String name;
	String startDate;
	String endDate;
	String freezingTime;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getFreezingTime() {
		return freezingTime;
	}
	public void setFreezingTime(String freezingTime) {
		this.freezingTime = freezingTime;
	}
	public Contest(String code, String name, String startDate, String endDate, String freezingTime) {
		super();
		this.code = code;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.freezingTime = freezingTime;
	}
	public Contest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
