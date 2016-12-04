package code;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
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
		ArrayList<String> selectedCourseIds = new ArrayList<String>();
		Semester semester = new Semester();
		
		semester.addCourse(getCourseById("LST_101"));
		semester.addCourse(getCourseById("WSM_101"));
		selectedCourseIds.add("LST_101");
		selectedCourseIds.add("WSM_101");
		
		for(int i=0;i<requirements.size();i++){
			Requirement r = requirements.get(i);
			if(r.getReqCourseCount() > 0){
				
				List<String> commonCourses = ListUtils.intersection(r.getCourseIds(), selectedCourseIds);
				
				if(commonCourses.size() < r.getReqCourseCount()){
					
					List<String> difference = ListUtils.subtract(r.getCourseIds(), commonCourses);
					
					for(int j= 0;j<r.getReqCourseCount() - commonCourses.size();j++ ){
						Course course = getCourseById(difference.get(j));
						if(semester.getTotalCredits()+course.getCredits() > 19){
							semesters.add(semester);
							semester = new Semester();
						}
						semester.addCourse(course);
						selectedCourseIds.add(course.getCourseId());
					}
				}
			}
		}
		semesters.add(semester);
	}
	
	public ArrayList<Course> getAllCourses(){
		ArrayList<Course> courses = new ArrayList<Course>();
		for(Semester semester: semesters){
			courses.addAll(semester.getCourses());
		}
		return courses;
	}
	
	public ArrayList<String> getCommonCourses(ArrayList<String> requirementCourseIds, ArrayList<String> selectedCourseIds){
		ArrayList<String> courseIds = new ArrayList<String>();
		for(String courseId : selectedCourseIds){
			if(requirementCourseIds.contains(courseId))
				courseIds.add(courseId);
		}
		return courseIds;
	}
	
//	public ArrayList<String> getAllCourseIds(){
//		ArrayList<String> courseIds = new ArrayList<String>();
//		for(Semester semester: semesters){
//			for(Course course: semester.getCourses())
//				courseIds.add(course.getCourseId());
//		}
//		return courseIds;
//	}
	
	
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
