public class TechnicalCourseSubjectChecker implements CourseSubjectChecker {
    @Override
    public boolean allSubjectsPassed(Student student) {
        for (double grade : student.getGrades()) {
            if (grade < 7.0) {
                return false;
            }
        }
        return true;
    }
}