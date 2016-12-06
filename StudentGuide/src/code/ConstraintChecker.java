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
	
	public int runAll(ArrayList<Semester> semester) {
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
		this.pre_co_req(semester);
			
		return this.constraintsFullfilled;
	}

	//method that will make sure there are between 12 and 19 credit hours
	public void semesterHours(ArrayList<Semester> semester){
		for(Semester s:semester){
			this.constraintsTotal++; //one constraint per semester
			if(s.getTotalCredits() <= 19 && s.getTotalCredits() >= 12)
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
		if(semester.containsClass("LST_101"))
			this.constraintsFullfilled++;
		if(semester.containsClass("WSM_101")) //don't use else if - each requirement is separate
			this.constraintsFullfilled++;
	}
	//Req GENED_TIER1_MAT - first or second semester
	//Req GENED_TIER1_FLG - first or second semester
	public void freshman(ArrayList<Semester>semester){
		int i = 0;
		this.constraintsTotal = constraintsTotal + 2; //two constraints for this method
		for(Semester s:semester){
			//check to see gened courses within freshman year are taken
			if(s.containsClass("MAT_114") && i < 4)
				constraintsFullfilled++;
			if(s.containsClass("MAT_124") && i < 4)
				constraintsFullfilled++;
			if(s.containsClass("PH_TIER1_FLG") && i < 4)
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
				if(s.containsClass("PH_TIER3_INTEG"))
					constraintsFullfilled++;
				if(s.containsClass("PH_UL_OUTSIDE_DIV"))
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
				if(s.containsClass("CSC_327") && (i%2) == 0)
					constraintsFullfilled++;
				if(s.containsClass("CSC_350") && (i%2) == 0)
					constraintsFullfilled++;
				if(s.containsClass("ITY_351") && (i%2) == 0)
					constraintsFullfilled++;
				if(s.containsClass("PH_MAJOR_ELECT1_2") && (i%2) == 0)
					constraintsFullfilled++;
			i++;
		}
	}
	//check pre-requisites and co-requisites for other courses
	public void pre_co_req(ArrayList<Semester>semester){
		//need to check every course in every semester
		//use index for the semester so we can know which semesters to look at for prereqs and coreqs
		for (int i=0; i < semester.size(); i++ ){   
			Semester s = semester.get(i);
			//iterate through each course in the semester
			for (Course c: s.getCourses()){
				//get the prereqs and coreqs for this course
				ArrayList<String> prereqs = c.getPrereqs();
				ArrayList<String> coreqs = c.getCoreqs();
				//in our simplified version, we do not have OR requirements - only AND
				//check prereqs first, if there are any
				if (!prereqs.isEmpty()){
					//prereqs is a list of strings that are course IDs
					for (String p: prereqs){
						constraintsTotal++; //we have a prereq to count as a constraint in the total
						boolean found = false;
						//for each pre-req, see if a semester contains it
						for (int j = 0; j < i; j++){
							Semester earlierSemester = semester.get(j);
							if (earlierSemester.containsClass(p)) {
								constraintsFullfilled++;
								break; //break out of Semester loop and look at next prereq
							}
						}
					}
				}
				//then check coreqs, if there are any
				if (!coreqs.isEmpty()){
					for (String cr : coreqs) {
						constraintsTotal++; //we have a coreq to count as a constraint in the total
						if(s.containsClass(cr))
						{
							constraintsFullfilled++; 
						}
					}
					
				}
			}
		}
		
	}
}
