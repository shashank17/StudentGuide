package code;

import java.util.ArrayList;

public class StandardRequirement implements Requirement {
	private ReqType type;
	private int reqCourseCount = 0;
	private int reqCreditCount = 0;
	private ArrayList<String> courseIds = new ArrayList<String>();
	private boolean isFulfilled = false;
	
	public StandardRequirement(ReqType type,int reqCourseCount,int reqCreditCount,ArrayList<String> courseIds){
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

	@Override
	public boolean isSatisfied(ArrayList<Semester> semesters) {
		return false;
	}

}
