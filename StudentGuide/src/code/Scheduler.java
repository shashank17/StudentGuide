package code;

import java.util.ArrayList;

public class Scheduler {
	
	private ArrayList<Semester> semesters;
	
	public Scheduler(){
		semesters = new ArrayList<Semester>();
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
	}
	
	public void validateSchedule(){
		// use simulated annealing to make the schedule valid
	}
}
