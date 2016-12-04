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
		this.firstSemester(semester.get(1));
		this.freshman(semester);
		this.upperClass(semester);
		this.upperClassFall(semester);
		this.pre_co_req(semester, course);
			
		return constraintsFullfilled;
	}

	//method that will make sure there are between 12 and 19 credit hours
	public boolean semesterHours(ArrayList<Semester> semester){
		for(Semester s:semester){
			if(s.getTotalCredits() > 19 || s.getTotalCredits() < 12)
				return false;
		}
		return true;
	}
	//122 credits or more total
	public boolean creditHours(ArrayList<Semester>semester){
		int total = 0;
		for(Semester s:semester)
			total += s.getTotalCredits();
		if(total < 122)
			return false;
		return true;
	}
	//Req GENED_TIER1_WSM - first semester
	//Req GENED_TIER1_LST - first semester
	public boolean firstSemester(Semester semester){
		if(!semester.getCourses().contains("LST_101"))
			return false;
		else if (!semester.getCourses().contains("WSM_101"))
			return false;
		return true;
	}
	//Req GENED_TIER1_MAT - first or second semester
	//Req GENED_TIER1_FLG - first or second semester
	public void freshman(ArrayList<Semester>semester){
		int i = 0;
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
		
	}
	//check pre-requisites and co-requisites for other courses
	public void pre_co_req(ArrayList<Semester>semester, Course course){
		
	}
}
