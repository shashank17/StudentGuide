package code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args){
		ArrayList<Requirement> requirements= getRequirements();
		
		Scheduler scheduler = new Scheduler();
		scheduler.getSchedule();
	}
	
	public static ArrayList<Requirement> getRequirements(){
		ArrayList<Requirement> requirements=new ArrayList<Requirement>();
		
		// adding GENED_TIER1 requirements
		requirements.add(
				new StandardRequirement(
						ReqType.GENED_TIER1_ENG,
						1,
						0,
						new ArrayList<String>(Arrays.asList("ENG_103"))
						) );
		
		requirements.add(
				new StandardRequirement(
						ReqType.GENED_WI,
						2,
						0,
						new ArrayList<String>(Arrays.asList("WI_1","WI_2"))
						) );
		requirements.add(
				new StandardRequirement(
						ReqType.GENED_TIER1_MAT,
						1,
						0,
						new ArrayList<String>(Arrays.asList("MAT_114","MAT_124"))
						) );
		
		requirements.add(
				new StandardRequirement(
						ReqType.GENED_TIER1_WSM,
						3,
						0,
						new ArrayList<String>(Arrays.asList("WSM_101","WSM_102","WSM_103"))
						) );
		
		requirements.add(
				new StandardRequirement(
						ReqType.GENED_TIER1_LST,
						1,
						0,
						new ArrayList<String>(Arrays.asList("LST_101"))
						) );
		
		// adding GENED_TIER2 requirements
		
		requirements.add(
				new StandardRequirement(
						ReqType.GENED_TIER2_SCI_INQ,
						2,
						0,
						new ArrayList<String>(Arrays.asList("PH_SCI_INQ_LECT_LAB","PH_SCI_INQ_ANY")) // Create a placeholder course
						) );
		
		requirements.add(
				new StandardRequirement(ReqType.GENED_TIER2_HIST_PERSP, 
						2, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_HIST_PERSP_1","PH_HIST_PRESP_2"))) // create placeholder course
				);
		requirements.add(
				new StandardRequirement(ReqType.GENED_TIER2_FQV, 
						1, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_FQV_1"))));
		
		requirements.add(
				new StandardRequirement(ReqType.GENED_TIER2_ART_LIT, 
						1, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_ART_LIT","PH_ART_ANY")))
				);
		
		requirements.add(
				new StandardRequirement(ReqType.GENED_TIER2_SOC_DISP, 
						3, 
						0, 
						new ArrayList<String>(Arrays.asList("PH_SOC_DISP_1","PH_SOC_DISP_2","PH_SOC_DISP_3")))
				);
		
		return requirements;
	}
}
