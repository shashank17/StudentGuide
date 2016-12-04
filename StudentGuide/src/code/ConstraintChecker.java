package code;

import java.util.ArrayList;

public class ConstraintChecker {
	
	private int constraintsTotal = 0;
	private int constraintsFullfilled = 0;
	
	public ConstraintChecker(){
		this.constraintsTotal = 0; 
		this.constraintsFullfilled = 0;
	}
	
	public int getConstraintsTotal() {
		return this.constraintsTotal;
	}
	public int getConstraintsFullfilled() {
		return this.constraintsFullfilled;
	}
	
	public int runAll(ArrayList<Semester> semester, Course course) {
		this.constraintsTotal = 0;
		this.constraintsFullfilled = 0;
		
		//each method adds to constraintsTotal and constraintsFullfilled as appropriate
		//constraintsTotal may change because we may have different courses chosen, with different numbers of prereqs and coreqs
		this.semesterHours(semester) ;
		this.creditHours(semester) ;
		this.firstSemester(semester.get(0)); //pass in first semester only
		this.freshman(semester);
		this.upperClass(semester);
		this.upperClassFall(semester);
		this.pre_co_req(semester, course);
			
		return this.constraintsFullfilled;
	}

	//method that will make sure there are between 12 and 19 credit hours
	public void semesterHours(ArrayList<Semester> semester){
		for(Semester s:semester){
			this.constraintsTotal++; //one constraint per semester
			if(s.getTotalCredits() > 19 || s.getTotalCredits() < 12)
				this.constraintsFullfilled++;	
		}
	}
	//122 credits or more total
	public void creditHours(ArrayList<Semester>semester){
		int total = 0;
		this.constraintsTotal++; //only one constraint for this method (total numbers of credit)
		for(Semester s:semester) 
			total += s.getTotalCredits();
		if(total < 122)
			this.constraintsFullfilled++;
	}
	//Req GENED_TIER1_WSM - first semester
	//Req GENED_TIER1_LST - first semester
	public void firstSemester(Semester semester){
		this.constraintsTotal = constraintsTotal + 2; //two constraints for this method
		if(!semester.getCourses().contains("LST_101"))
			this.constraintsFullfilled++;
		if (!semester.getCourses().contains("WSM_101")) //don't use else if - each requirement is separate
			this.constraintsFullfilled++;
	}
	//Req GENED_TIER1_MAT - first or second semester
	//Req GENED_TIER1_FLG - first or second semester
	public void freshman(ArrayList<Semester>semester){
		int i = 0;
		this.constraintsTotal = constraintsTotal + 2; //two constraints for this method
		for(Semester s:semester){
			//check to see gened courses within freshman year are taken
			if(s.getCourses().contains("MAT_114") && i < 4)
				constraintsFullfilled++;
			if(s.getCourses().contains("MAT_124") && i < 4)
				constraintsFullfilled++;
			if(s.getCourses().contains("PH_TIER1_FLG") && i < 4)
				constraintsFullfilled++;
			i++;
			if(i >= 4)
				break;
		}
	}
	//Req GENED_UL_OUTSIDE_DIV - because its an upper level, probably junior or senior year
	//Req GENED_TIER3_INTEG - probably senior year, maybe junior
	public void upperClass(ArrayList<Semester>semester){
		int i = 0;
		this.constraintsTotal = constraintsTotal + 2; //two constraints for this method
		for(Semester s: semester){
			if(i > 3)
				if(s.getCourses().contains("PH_TIER3_INTEG"))
					constraintsFullfilled++;
				if(s.getCourses().contains("PH_UL_OUTSIDE_DIV"))
					constraintsFullfilled++;
			i++;
		}
	}
	//Courses CSC_327, CSC_350, ITY_351, PH_MAJOR_ELECT1_2 usually taken together. Fall semester, junior or senior year.
	public void upperClassFall(ArrayList<Semester>semester){
		int i = 0;
		this.constraintsTotal = constraintsTotal + 4; //four constraints for this method
		for(Semester s: semester){
			if(i > 3)
				if(s.getCourses().contains("CSC_327") && (i%2) == 0)
					constraintsFullfilled++;
				if(s.getCourses().contains("CSC_350") && (i%2) == 0)
					constraintsFullfilled++;
				if(s.getCourses().contains("ITY_351") && (i%2) == 0)
					constraintsFullfilled++;
				if(s.getCourses().contains("PH_MAJOR_ELECT1_2") && (i%2) == 0)
					constraintsFullfilled++;
			i++;
		}
	}
	//check pre-requisites and co-requisites for other courses
	public void pre_co_req(ArrayList<Semester>semester, Course course){
		
	}
}
