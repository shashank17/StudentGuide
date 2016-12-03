package code;

import java.util.ArrayList;

public class Scheduler {
	
	private ArrayList<Semester> semesters;
	private ArrayList<Requirement> requirements;
	private ArrayList<Course> courses;
	public Scheduler(ArrayList<Course> courses, ArrayList<Requirement> requirements){
		this.courses = courses;
		this.requirements = requirements;
		this.semesters = new ArrayList<Semester>();
	}
	
	public ArrayList<Semester> getSchedule(){
		generateInitialSchedule();
		validateSchedule();
		return semesters;
	}
	
	private void generateInitialSchedule(){
//generate array of semesters, if not already generated.
		//add in LST 101 and WSM 101 in first semester
		//put CSC 327, 350 and 351 either in Jr or Sr Fall semester (randomly pick)
		//add in CS elective to randomly picked semester mentioned above
		//starting with first semester
		//while total credit hours < 122
			//grab random course
			//if course is correct level
				//while course not added
					//if current semester hours + new course < 19 and semester course total < 5
						//add course, update semester hours and total hours
					//else move to next semester
		// greedy assignment of courses to semesters
		Semester semester = new Semester();
		for(int i=0;i<requirements.size();i++){
			Requirement r= requirements.get(i);
			while(!r.isSatisfied(getAllCourses())){
				if(r.getReqCourseCount() != 0){
					semester.addCourse(course);
				}
			}
		}
		for(int j=0;j<requirements.size();j++){
			for(int i=0;i<semesters.size();i++){
				Semester semester = semesters.get(i);
				while(semester.getTotalCredits()<20){
					
				}
			}
		}
	}
	
	public ArrayList<Course> getAllCourses(){
		ArrayList<Course> courses = new ArrayList<Course>();
		for(Semester semester: semesters){
			courses.addAll(semester.getCourses());
		}
		return courses;
	}
	
	private Course getCourseById(String id){
		for(Course course:courses){
			if(course.getCourseId().equals(id))
				return course;
		}
		return null;
	}
	
	public void validateSchedule(){
		// use simulated annealing to make the schedule valid
	}
}
