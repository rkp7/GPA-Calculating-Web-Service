# GPA-Caluclating-Web-Service
A web service for calculating GPA based on provided course information

Four services are implemented:

1. initializeCourses(int noOfCourses) : Obtain a clean slate and provide the number of courses to create objects for coruse information

2. setCourse(String courseName, int theoryCredits, int termWorkPracticalCredits,     int endSemesterMarks, int continuousAssessment, int     termWorkMarksScored,     int termWorkTotalMarks, int practicalOralMarksScored, int practicalOralTotalMarks) : records the data for a     specific course.

    Note: Keep the values zero if there is no particular score assigned for a specific field in a particular course.
    
3. assignGradePoint(double marksScored, int totalMarks) : Provides grade point score based on a specific grading scheme. 

    Note: You can change this function as per your requirement or grading scheme.

4. calculateGPA() : Calculates the GPA based on recorded course information


  

  
