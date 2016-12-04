{
	'Requirements':[{
		'Requirement':{
			'type': 2, // these type should match with the enum values from requirement type
			'reqCourseCount': 1,
			'reqCreditCount': 9,
			'courseIds':['MAT_114','MAT_124'],
		}
	},{
		'Requirement':{
			'type': 7,
			'reqCourseCount': 2,
			'reqCreditCount': 6,
			'courseIds':['CLA_227','CLA_228','HIS_101','HIS_102','HIS_103','HIS_104','HIS_105','HIS_106','HIS_109','HIS_110'],
		}
	},{
		'Requirement':{
			'type': 6,
			'reqCourseCount': 2,
			'reqCreditCount': , // do not specify credit count when the requirement is the number of courses
			'courseIds':[['BIO_100',['BIO_107','BIO_108'],'BIO_124','BIO_114','CHM_105','CHM_115','CHM_125','GEO_108','GEO_110','GEO_116','GEO_118','PHY_201','PHY_212'],'AST_211','BIO_105','BIO_211','ENV_105','ITY_177','PHY_105','CHM_105','CHM_114','CHM_124'],
		}
	}],
	'Courses':[{
		'Course':{
			'courseId':'MAT_114',
			'credits': 3,
			'prereqs': [],
			'coreqs' : []
		}
	},{
		'Course':{
			'courseId':'MAT_114',
			'credits': 3,
			'prereqs': [],
			'coreqs' : []
		}
	}]
}




private String courseId;
	private int credits;
	private OfferedSemester offeredSemester;
	private ArrayList<String> prereqs = new ArrayList<String>();
	private ArrayList<String> coreqs = new ArrayList<String>();


	private ReqType type;
	private int reqCourseCount = 0;
	private int reqCreditCount = 0;
	private ArrayList<String> courses = new ArrayList<String>();
	private boolean isFulfilled = false;

public enum ReqType {
	GENED_TIER1 = 1,
	GENED_TIER1_MAT = 2,
	GENED_TIER1_WSM = 3,
	GENED_TIER1_LST = 4,
	GENED_TIER1_FLG = 5,
	GENED_TIER2_SCI_ENQ = 6,
	GENED_TIER2_HIST_PERSP = 7,
	GENED_TIER2_FQV = 8,
	GENED_TIER2_ART_LIT = 9,
	GENED_TIER2_SOC_DISP1 = 10,
	GENED_TIER2_SOC_DISP2 = 11,
	GENED_TIER2_SOC_DISP3 = 12,
	GENED_TIER2_CULT_FLG = 13,
	GENED_TIER2_CULT_NONWEST = 14,
	GENED_TIER3_INTEG = 15,
	MAJOR_CSC = 16,
	MAJOR_CSC_ELECT1 = 17,
	MAJOR_CSC_ELECT2 = 18,
	MAJOR_CSC_ELECT3 = 19,
}