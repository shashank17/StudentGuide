package code;

import java.util.ArrayList;

public class Requirement {
	private ReqType type;
	private int reqCourseCount = 0;
	private int reqCreditCount = 0;
	private ArrayList<String> courseIds = new ArrayList<String>();
	private boolean isFulfilled = false;
	
	public Requirement(ReqType type,int reqCourseCount,int reqCreditCount,ArrayList<String> courseIds){
		this.type = type;
		this.reqCourseCount = reqCourseCount;
		this.reqCreditCount = reqCreditCount;
		this.courseIds = courseIds;
	}
	
	public ReqType getType() {
		return type;
	}

	public int getReqCourseCount() {
		return reqCourseCount;
	}

	public int getReqCreditCount() {
		return reqCreditCount;
	}

	public ArrayList<String> getCourseIds() {
		return courseIds;
	}
	
	public boolean isSatisfied(ArrayList<Course> courses) {
		// find the intersection of chosen courses and the courses available for the requirement
		// see if the intersection satisfies req course count or req credit count
		
		return false;
		
	}

}
