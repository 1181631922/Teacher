package cn.edu.sjzc.teacher.bean;

public class TeacherRankingBean implements java.lang.Comparable{
	int color;
	int pencent;
	String knowledgename;



	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getPencent() {
		return pencent;
	}

	public void setPencent(int pencent) {
		this.pencent = pencent;
	}

	public String getKnowledgename() {
		return knowledgename;
	}

	public void setKnowledgename(String knowledgename) {
		this.knowledgename = knowledgename;
	}

	@Override
	public int compareTo(Object another) {
		// TODO Auto-generated method stub
		return 0;
	}

}
