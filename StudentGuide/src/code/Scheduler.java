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
		//randomly assign courses to semesters
	}
	
	public void validateSchedule(){
		// use simulated annealing to make the schedule valid
	}
}
