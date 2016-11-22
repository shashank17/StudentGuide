package code;

import java.util.ArrayList;

public class Requirement {
	private ReqType type;
	private int reqCourseCount = 0;
	private int reqCreditCount = 0;
	private ArrayList<String> courses = new ArrayList<String>();
	private boolean isFulfilled = false;
	
	public ReqType getType() {
		return type;
	}

	public int getReqCourseCount() {
		return reqCourseCount;
	}

	public int getReqCreditCount() {
		return reqCreditCount;
	}

	public ArrayList<String> getCourses() {
		return courses;
	}

	public boolean isFulfilled() {
		return isFulfilled;
	}

}
