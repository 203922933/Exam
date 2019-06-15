package bean;

public class Subject {
	private int id;					//记录主键
	private String subjectname;		//科目名称
	private int singleper;			//单选分值
	private int singlenumber;		//单选个数
	private int testtime;			//考试时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public int getSingleper() {
		return singleper;
	}
	public void setSingleper(int singleper) {
		this.singleper = singleper;
	}
	public int getSinglenumber() {
		return singlenumber;
	}
	public void setSinglenumber(int singlenumber) {
		this.singlenumber = singlenumber;
	}
	public int getTesttime() {
		return testtime;
	}
	public void setTesttime(int testtime) {
		this.testtime = testtime;
	}
}
