package code;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		ArrayList<Requirement> requirements= getRequirements();
		ArrayList<Course> courses = getCourses();
		Scheduler scheduler = new Scheduler(courses,requirements);
		double start = System.currentTimeMillis();
		ArrayList<Semester> semesters = scheduler.getSchedule();
		double stop = System.currentTimeMillis();
		for(int i=0;i<semesters.size();i++){
			System.out.println("***** Semester "+(i+1)+" *****");
			Semester s = semesters.get(i);
			ArrayList<Course> sem_courses = s.getCourses();
			for(int j=0;j<sem_courses.size();j++){
				Course  course = sem_courses.get(j);
				System.out.println(course.getCourseId());
			}
			System.out.println("Total credits "+s.getTotalCredits());
			System.out.println("================");
			System.out.println("Execution time: "+ (stop-start) + " ms.");
		}
//		int sum = 0;
//		for(Course course:courses){
//			sum = sum+course.getCredits();
//		}
//		System.out.println("Total credits:"+sum);
	}
	
	private static ArrayList<Course> getCourses() {
		ArrayList<Course> courses = new ArrayList<Course>();
		
		
		// adding major required courses
		courses.add(new Course("CSC_104",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("CSC_111",3,OfferedSemester.EVERY_FALL,new ArrayList<String>(Arrays.asList("CSC_104")),new ArrayList<String>()));
		courses.add(new Course("CSC_178",3,OfferedSemester.EVERY_SPRING,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("CSC_211",3,OfferedSemester.EVERY_SPRING,new ArrayList<String>(Arrays.asList("CSC_111")),new ArrayList<String>()));
		courses.add(new Course("CSC_327",3,OfferedSemester.EVERY_FALL,new ArrayList<String>(Arrays.asList("ITY_177","CSC_178")),new ArrayList<String>(Arrays.asList("ITY_351"))));
		courses.add(new Course("CSC_350",3,OfferedSemester.EVERY_FALL,new ArrayList<String>(Arrays.asList("CSC_104","CSC_178","ITY_177")),new ArrayList<String>(Arrays.asList("ITY_351"))));
		courses.add(new Course("ITY_177",3,OfferedSemester.EVERY_FALL,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("ITY_181",3,OfferedSemester.EVERY_FALL,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("ITY_351",3,OfferedSemester.EVERY_FALL,new ArrayList<String>(Arrays.asList("CSC_104","CSC_178","ITY_177","ITY_181")),new ArrayList<String>(Arrays.asList("CSC_327"))));
		courses.add(new Course("MAT_124",5,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
//		courses.add(new Course("ITY_250",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
//		courses.add(new Course("ITY_234",1,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		
		// adding major electives' place holders
		courses.add(new Course("PH_MAJOR_ELECT1_1",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_MAJOR_ELECT1_2",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_MAJOR_ELECT2_1",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_MAJOR_ELECT2_2",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_MAJOR_ELECT3_1",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_MAJOR_ELECT3_2",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		
		// adding gen ed required courses
		courses.add(new Course("PE",1,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("WI_1",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("WI_2",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_UL_OUTSIDE_DIV",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("ENG_103",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("MAT_114",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("WSM_101",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("LST_101",1,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		
		//adding gen ed elective' placeholders
		courses.add(new Course("PH_TIER1_FLG",4,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_SCI_INQ_LECT_LAB",4,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_SCI_INQ_ANY",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_HIST_PERSP_1",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_HIST_PRESP_2",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_FQV_1",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_ART_LIT",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_ART_ANY",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_SOC_DISP_1",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_SOC_DISP_2",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_SOC_DISP_3",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_CULT_FLG",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(Arrays.asList("PH_TIER1_FLG")),new ArrayList<String>()));
		courses.add(new Course("PH_CULT_NONWEST",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_TIER3_INTEG",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		
		//general elective
		courses.add(new Course("PH_Elective_1",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_Elective_2",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));
		courses.add(new Course("PH_Elective_3",3,OfferedSemester.EVERY_SEMESTER,new ArrayList<String>(),new ArrayList<String>()));

		return courses;
	}

	public static ArrayList<Requirement> getRequirements(){
		ArrayList<Requirement> requirements=new ArrayList<Requirement>();
		
		//adding general graduation requirements
		requirements.add(
				new Requirement(
						ReqType.GENED_PE,
						1,
						0,
						new ArrayList<String>(Arrays.asList("PE"))
						) );
		requirements.add(
				new Requirement(
						ReqType.GENED_WI,
						2,
						0,
						new ArrayList<String>(Arrays.asList("WI_1","WI_2"))
						) );
		requirements.add(
				new Requirement(
						ReqType.GENED_UL_OUTSIDE_DIV,
						1,
						0,
						new ArrayList<String>(Arrays.asList("PH_UL_OUTSIDE_DIV"))
						) );
		
		// adding GENED Tier 1 requirements
		requirements.add(
				new Requirement(
						ReqType.GENED_TIER1_WSM,
						1,
						0,
						new ArrayList<String>(Arrays.asList("WSM_101"))
						) );
		
		requirements.add(
				new Requirement(
						ReqType.GENED_TIER1_LST,
						1,
						0,
						new ArrayList<String>(Arrays.asList("LST_101"))
						) );
		requirements.add(
				new Requirement(
						ReqType.GENED_TIER1_ENG,
						1,
						0,
						new ArrayList<String>(Arrays.asList("ENG_103"))
						) );
		requirements.add(
				new Requirement(
						ReqType.GENED_TIER1_MAT,
						1,
						0,
						new ArrayList<String>(Arrays.asList("MAT_114","MAT_124"))
						) );
		requirements.add(
				new Requirement(
						ReqType.GENED_TIER1_FLG,
						1,
						0,
						new ArrayList<String>(Arrays.asList("PH_TIER1_FLG"))
						) );
		
		
		// adding GENED_TIER2 requirements	
		requirements.add(
				new Requirement(
						ReqType.GENED_TIER2_SCI_INQ,
						2,
						0,
						new ArrayList<String>(Arrays.asList("PH_SCI_INQ_LECT_LAB","PH_SCI_INQ_ANY")) // Create a placeholder course
						) );
		
		requirements.add(
				new Requirement(ReqType.GENED_TIER2_HIST_PERSP, 
						2, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_HIST_PERSP_1","PH_HIST_PRESP_2"))) // create placeholder course
				);
		requirements.add(
				new Requirement(ReqType.GENED_TIER2_FQV, 
						1, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_FQV_1"))));
		
		requirements.add(
				new Requirement(ReqType.GENED_TIER2_ART_LIT, 
						2, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_ART_LIT","PH_ART_ANY")))
				);
		
		requirements.add(
				new Requirement(ReqType.GENED_TIER2_SOC_DISP, 
						3, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_SOC_DISP_1","PH_SOC_DISP_2","PH_SOC_DISP_3")))
				);
		
		requirements.add(
				new Requirement(ReqType.GENED_TIER2_CULT_DIV_GLO_IND, 
						2, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_CULT_FLG","PH_CULT_NONWEST")))
				);
		
		//adding tier 3 requirement
		requirements.add(
				new Requirement(ReqType.GENED_TIER3_INTEG, 
						1, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_TIER3_INTEG")))
				);
		
		// adding major requirements
		
		requirements.add(
				new Requirement(ReqType.MAJOR_CSC, 
						10, 
						0, 
						new ArrayList<String>(Arrays.asList("CSC_104","CSC_111","CSC_178","CSC_211","CSC_327","CSC_350","ITY_177","ITY_181","ITY_351","MAT_124")))
				);
		
		requirements.add(
				new Requirement(ReqType.MAJOR_CSC_ELECT1, 
						2, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_MAJOR_ELECT1_1","PH_MAJOR_ELECT1_2")))
				);
		
		requirements.add(
				new Requirement(ReqType.MAJOR_CSC_ELECT2, 
						2, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_MAJOR_ELECT2_1","PH_MAJOR_ELECT2_2")))
				);
		
		requirements.add(
				new Requirement(ReqType.MAJOR_CSC_ELECT3, 
						2, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_MAJOR_ELECT3_1","PH_MAJOR_ELECT3_2")))
				);
		requirements.add(
				new Requirement(ReqType.ELECTIVE, 
						3, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_Elective_1","PH_Elective_2","PH_Elective_3")))
				);
		
		
		
		
		return requirements;
	}
}
