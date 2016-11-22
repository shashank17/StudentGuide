package code;

import java.util.ArrayList;

public class Course {
	private String courseId;
	private int credits;
	private OfferedSemester offeredSemester;
	private ArrayList<String> prereqs = new ArrayList<String>();
	private ArrayList<String> coreqs = new ArrayList<String>();
	
	public Course(String courseId, OfferedSemester semesterOffered, ArrayList<String> prereqs, ArrayList<String> coreqs){
		this.courseId = courseId;
		this.offeredSemester = semesterOffered;
		this.prereqs = prereqs;
		this.coreqs = coreqs;
	}
	
	public String getCourseId() {
		return courseId;
	}

	public OfferedSemester getOfferedSemester() {
		return offeredSemester;
	}

	public int getCredits() {
		return credits;
	}

	public ArrayList<String> getPrereqs() {
		return prereqs;
	}

	public ArrayList<String> getCoreqs() {
		return coreqs;
	}
	
}
