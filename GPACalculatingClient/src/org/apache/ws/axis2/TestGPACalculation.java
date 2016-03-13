package org.apache.ws.axis2;

import org.apache.ws.axis2.GPACalculatorStub.CalculateGPA;
import org.apache.ws.axis2.GPACalculatorStub.SetCourse;
import org.apache.ws.axis2.GPACalculatorStub.InitializeCourses;

public class TestGPACalculation{
	
	public static void main(String args[]) throws Exception {
		// Create a stub object for using the services offered by the web server
		GPACalculatorStub serviceStub = new GPACalculatorStub();
		
		// Number of Courses
		int noOfCourses = 6;
		
		/*
		 * Subject names
		 */
		String subjectNames[] = {"DSP", "CSS", "AI", "SC", "BE Project", "NTAL"};
		
		/* Order for marks:
		 *  Theory Credits, Term Work and Practical Credits,
		 *  End Semester Marks, CA Marks, Practical/Oral Marks Scored
		 *  Practical/Oral Total Marks, Term Work Marks Scored, 
		 *  Term Work Total Marks
		 */
		int subjectDetails[][] = { {4, 1, 81, 37,  0,  0, 23, 25},
								   {4, 1, 70, 31, 22, 25, 24, 25},
								   {4, 1, 83, 33, 24, 25, 24, 25},
								   {4, 1, 72, 36, 23, 25, 23, 25},
								   {0, 3,  0,  0, 48, 50, 47, 50},
								   {0, 2,  0,  0, 45, 50, 20, 25} };
		
		/*
		 * Initialize the server to start recording course data
		 */
		InitializeCourses ic = new InitializeCourses();
		ic.setNoOfCourses(noOfCourses);
		serviceStub.initializeCourses(ic);
		
		/*
		 * Use the web service function getCourse() to record each course data
		 * on the server
		 */
		SetCourse sc;
		int counter;
		for(int i=0; i<noOfCourses; i++) {
			counter = 0;
			sc = new SetCourse();
			sc.setCourseName(subjectNames[i]);
			sc.setTheoryCredits(subjectDetails[i][counter++]);
			sc.setTermWorkPracticalCredits(subjectDetails[i][counter++]);
			sc.setEndSemesterMarks(subjectDetails[i][counter++]);
			sc.setContinuousAssessment(subjectDetails[i][counter++]);
			sc.setPracticalOralMarksScored(subjectDetails[i][counter++]);
			sc.setPracticalOralTotalMarks(subjectDetails[i][counter++]);
			sc.setTermWorkMarksScored(subjectDetails[i][counter++]);
			sc.setTermWorkTotalMarks(subjectDetails[i][counter++]);
			serviceStub.setCourse(sc);		
		}
		
		/*
		 * Calculate the GPA using the function provided by the server calculateGPA()
		 * 
		 */
		CalculateGPA CGPA = new CalculateGPA();
		double res = serviceStub.calculateGPA(CGPA).get_return();
		System.out.printf("Calculated GPA = %.2f", res);
		
	}
}
