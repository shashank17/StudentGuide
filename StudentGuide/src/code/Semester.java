package code;

import java.util.ArrayList;

public class Semester implements Cloneable {
	private ArrayList<Course> courses = new ArrayList<Course>();
	private int totalCredits = 0;
	
	public void addCourse(Course course){
		this.courses.add(course);
		totalCredits += course.getCredits();
	}
	
	public Course removeCourse(String courseId){
//		Course course = courses.remove(o)
		return null;
	}
	
	public boolean isFull(){
		return totalCredits > 19;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public int getTotalCredits() {
		return totalCredits;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Semester semester = new Semester();
		for(Course course:this.courses){
			semester.addCourse(course);
		}
		return semester;
	}

}
