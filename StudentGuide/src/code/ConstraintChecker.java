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
		return constraintsTotal;
	}
	public int getConstraintsFullfilled() {
		return constraintsFullfilled;
	}
	
	public int runAll(ArrayList<Semester> semester, Course course) {
		int constraintsTotal = 0;
		int constraintsFullfilled = 0;
		
		//each method adds to constraintsTotal and constraintsFullfilled as appropriate
		//constraintsTotal may change because we may have different courses chosen, with different numbers of prereqs and coreqs
		this.semesterHours(semester) ;
		this.creditHours(semester) ;
		this.firstSemester(semester.get(0)); //pass in first semester only
		this.freshman(semester);
		this.upperClass(semester);
		this.upperClassFall(semester);
		this.pre_co_req(semester, course);
			
		return constraintsFullfilled;
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
		else if (!semester.getCourses().contains("WSM_101"))
			this.constraintsFullfilled++;
	}
	//Req GENED_TIER1_MAT - first or second semester
	//Req GENED_TIER1_FLG - first or second semester
	public void freshman(ArrayList<Semester>semester){
//		for(int i=0; i<2; i++)
			
//		return true;
	}
	//Req GENED_UL_OUTSIDE_DIV - because its an upper level, probably junior or senior year
	//Req GENED_TIER3_INTEG - probably senior year, maybe junior
	public boolean upperClass(ArrayList<Semester>semester){
		return true;
	}
	//Courses CSC_327, CSC_350, ITY_351, PH_MAJOR_ELECT1_2 usually taken together. Fall semester, junior or senior year.
	public boolean upperClassFall(ArrayList<Semester>semester){
		return true;
	}
	//check pre-requisites and co-requisites for other courses
	public boolean pre_co_req(ArrayList<Semester>semester, Course course){
		return true;
	}
}
