package code;

import java.util.ArrayList;

public class HyperRequirement implements Requirement {
	ArrayList<Requirement> requirements= new ArrayList<Requirement>();
	int no_of_requirements = 0;
	public HyperRequirement(ArrayList<Requirement> requirements,int no_of_requirements){
		this.no_of_requirements = no_of_requirements;
		this.requirements = requirements;
	}
	@Override
	public boolean isSatisfied(ArrayList<Semester> semesters) {
		return false;
	}

}
