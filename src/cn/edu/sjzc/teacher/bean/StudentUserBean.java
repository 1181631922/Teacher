package cn.edu.sjzc.teacher.bean;

public class StudentUserBean implements java.lang.Comparable{

	private String userName;
	private String phoneNum;
	
	private String py;
	
	
	
	public StudentUserBean(String userName, String phoneNum,String py) {
		super();
		this.userName = userName;
		this.phoneNum = phoneNum;
	
		this.py=py;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPy() {
		return py;
	}
	public void setPy(String py) {
		this.py = py;
	}
	@Override
	public String toString() {
		return "StudentUserBean [userName=" + userName + ", phoneNum=" + phoneNum
				+ ", py=" + py + "]";
	}
	@Override
	public int compareTo(Object another) {
		// TODO Auto-generated method stub
		
		StudentUserBean s = (StudentUserBean) another;
		return 0;
	}
	
	
	
	
}
