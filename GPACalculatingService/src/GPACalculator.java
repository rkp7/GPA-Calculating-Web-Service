public class GPACalculator {
	/*
	 * Initialize default values for class variables
	 */
	static int courseCount = 0;
	static Course courses[];
	double GPA = 0;
	
	/*
	 *  Function for calculating GPA
	 *  Requirement - Course data to be already recorded using getCourse() Method
	 */
	public double calculateGPA() {
		
		int endSemCATotalMarks = 100;
		
		GPA = 0;
		int totalCredits = 0;
		int totalCxG = 0;
		
		/*
		 *  For each of the course, calculate the CxG
		 *  where C - credits and 
		 *  G - grade points earned for the course
		 */
		for(int i=0; i<courseCount; i++) {
			
			/*
			 *  Calculate the theory score as 
			 *  End Semester Score * 0.6 + Continuous Assessment Score
			 */
			double endSemCAScore = courses[i].endSemesterMarks*0.6 + 
					courses[i].continuousAssessment;
			
			/*
			 *  Based on the theory score, calculate the respective grade point obtained for the course
			 */
			courses[i].endSemCAGradePoint = assignGradePoint(endSemCAScore, endSemCATotalMarks);
			courses[i].endSemCACxG = courses[i].endSemCAGradePoint*courses[i].theoryCredits;
			
			/*
			 * 	Add the Term work and Practical/Oral Score
			 */
			double pracsTWScore = (double)courses[i].practicalOralMarksScored + 
					(double)courses[i].termWorkMarksScored;
			int pracsTWTotalMarks = courses[i].practicalOralTotalMarks + 
					courses[i].termWorkTotalMarks;
			
			/*
			 *  Based on the TW and Practical/Oral score, calculate the respective grade point obtained for the course
			 */
			courses[i].termWorkPracticalGradePoint = assignGradePoint(pracsTWScore, pracsTWTotalMarks);
			courses[i].termWorkPracticalCxG = courses[i].termWorkPracticalGradePoint * 
					courses[i].termWorkPracticalCredits;
			
			/*
			 *  Sum up the total credits taken and total CxG scored 
			 */
			totalCxG += courses[i].termWorkPracticalCxG + courses[i].endSemCACxG;
			totalCredits += courses[i].termWorkPracticalCredits + courses[i].theoryCredits;
			
		}

		/*
		 * Final GPA is the division of CxG by Total Credits
		 */
		GPA = (double)totalCxG/(double)totalCredits;
		
		return GPA;
	}
	
	/*
	 * Function to assign grade point for particular score
	 */
	public int assignGradePoint(double marksScored, int totalMarks) {
		
		/*
		 *  Denotes the grading scheme followed by KJSCE
		 * 
		 */
		double percentage = marksScored/(double)totalMarks;
		
		if(percentage >= 0.85)
			return 10;
		else if(percentage >= 0.75)
			return 9;
		else if(percentage >= 0.70) 
			return 8;
		else if(percentage >= 0.60) 
			return 7;
		else if(percentage >= 0.55) 
			return 6;
		else if(percentage >= 0.50) 
			return 5;
		else if(percentage >= 0.45) 
			return 4;
		
		return 0;
		
	}
	
	/*
	 *  Method to add details of a specific course to the recorded data
	 *  Requirement - Initialization using initializeCourses() method
	 */
	public String setCourse(String courseName, int theoryCredits, int termWorkPracticalCredits, 
			int endSemesterMarks, int continuousAssessment, int termWorkMarksScored, 
			int termWorkTotalMarks, int practicalOralMarksScored, int practicalOralTotalMarks) {
		
		/*
		 * Restrain from adding courses more than indicated while initialization
		 */
		if(courseCount >= courses.length) {
			return "More courses cannot be added";
		}
		
		/*
		 *  Call constructor to record course data
		 */
		Course c = new Course(courseName, theoryCredits, termWorkPracticalCredits, 
				endSemesterMarks, continuousAssessment, termWorkMarksScored, 
				termWorkTotalMarks, practicalOralMarksScored, practicalOralTotalMarks);
		
		courses[courseCount] = c;
		
		/*
		 * Increment the count of courses
		 */
		courseCount++;
		
		/*
		 *  Return suitable message
		 */
		return "Added subject " + courseName + ".";
		
	}
	
	/*
	 *  Initialization in order to start recording course data
	 */
	public void initializeCourses(int noOfCourses) {
		courseCount = 0;
		courses = new Course[noOfCourses];
	}
	
}

class Course {
	/*
	 * Attributes to store course details provided by client
	 */
	String courseName;
	int theoryCredits;
	int termWorkPracticalCredits;
	int endSemesterMarks;
	int continuousAssessment;
	int termWorkMarksScored; 
	int termWorkTotalMarks; 
	int practicalOralMarksScored;
	int practicalOralTotalMarks;
	
	/*
	 * Attributes to store calculated results
	 */
	int endSemCAGradePoint;
	int endSemCACxG;
	int termWorkPracticalGradePoint;
	int termWorkPracticalCxG;
	
	/*
	 * Constructor for initializing course information
	 */
	Course(String cn, int tc, int twpc, int es, int ca, int tws, int twt, int pracs, int pracst) {
		this.courseName = cn;
		this.theoryCredits = tc;
		this.termWorkPracticalCredits = twpc;
		this.endSemesterMarks = es;
		this.continuousAssessment = ca;
		this.termWorkMarksScored = tws;
		this.termWorkTotalMarks = twt;
		this.practicalOralTotalMarks = pracst;
		this.practicalOralMarksScored = pracs;
	}
	
	
}
