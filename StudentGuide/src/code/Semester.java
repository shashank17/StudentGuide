package code;

import java.util.ArrayList;

public class Semester {
	private ArrayList<Course> courses = new ArrayList<Course>();
	private int totalCredits = 0;
	
	public void addCourse(Course course){
		
	}
	
	public Course removeCourse(String courseId){
		return null;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public int getTotalCredits() {
		return totalCredits;
	}
	
}
