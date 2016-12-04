package code;

import java.util.ArrayList;

public class ConstraintChecker {

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
		
		return true;
	}
	//Req GENED_TIER1_MAT - first or second semester
	//Req GENED_TIER1_FLG - first or second semester
	public boolean freshman(ArrayList<Semester>semester){
		return true;
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
