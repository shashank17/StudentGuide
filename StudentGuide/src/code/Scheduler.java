package code;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
public class Scheduler {

	private ArrayList<Semester> semesters;
	private ArrayList<Requirement> requirements;
	private ArrayList<Course> courses;
	private int MAX = 2000;
	private double TEMP = 500;
	
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
						if(semester.getTotalCredits() > 14 && semesters.size()<7){
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
	
	private Course getCourseById(String id){
		for(Course course:courses){
			if(course.getCourseId().equals(id))
				return course;
		}
		return null;
	}
	
	public ArrayList<Semester> generateNeighbor(){
		ArrayList<Semester> copy = new ArrayList<Semester>();
		for(Semester semester:this.semesters){
			try {
				copy.add((Semester) semester.clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// randomly choose two semester and exchange 2 courses from those semesters
		int rand1 = (int) (Math.random()*(copy.size()-1));
		int rand2 = rand1;
		while(rand1 == rand2)
			rand2 = (int) (Math.random()*(copy.size()-1));
		Semester semester1 =  copy.get(rand1);
		Semester semester2 = copy.get(rand2);
		rand1 = (int)(Math.random()*(semester1.getCourses().size()-1));
		rand2 = (int)(Math.random()*(semester2.getCourses().size()-1));
		Course course1 = semester1.removeCourse(rand1);
		Course course2 = semester2.removeCourse(rand2);

		semester2.addCourse(course1);
		semester1.addCourse(course2);
		return copy;
	}
	
	public void validateSchedule(){
		// use simulated annealing to make the schedule valid
		ArrayList<Semester> neighbor;
		ConstraintChecker check = new ConstraintChecker();
		// calculate the score of the neighbor, reject or accept based on the score
		//pseudocode
		//current state = s_0
		int energy1 = check.runAll(semesters);
		if (!(energy1==check.getConstraintsTotal())){
			for(int k= 0; k < MAX; k++){
				//t = temperature(k/k_MAX)
				//pick a random neighbor]
				neighbor = generateNeighbor();
				//if p(E(s), E(s_new), T) > rand(0,1)
				int energy2 = check.runAll(neighbor);
				int totalConstraints = check.getConstraintsTotal();
				if (energy2==check.getConstraintsTotal()) {
					semesters = neighbor;//state = neighbor
					break;
				}
				//stop at a threshold for temperature
				if(energy2 > energy1){//if new state is better
					semesters = neighbor;//state = neighbor
					energy1 = energy2;
//					System.out.println((totalConstraints - energy2)*100/totalConstraints + "    "+TEMP);
				}
				else if(boltzmann(energy1, energy2, TEMP) > Math.random()){
					semesters = neighbor;//state = neighbor
					energy1 = energy2;
//					System.out.println((totalConstraints - energy2)*100.0/totalConstraints + "    "+TEMP);
				}
				TEMP *= 0.99;
//				System.out.println(TEMP);
			}
			System.out.println(check.runAll(semesters));
			System.out.println(check.getConstraintsTotal());
			
		}
	}
	
	private double boltzmann(int energy1, int energy2, double tmp){
//		double k = 1.3806*Math.pow(10, -23);
		return Math.exp((energy2-energy1)/(tmp));
	}
}
