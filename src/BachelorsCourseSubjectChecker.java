
public class BachelorsCourseSubjectChecker implements CourseSubjectChecker {
    @Override
    public boolean allSubjectsPassed(Student student) {
        for (double grade : student.getGrades()) {
            if (grade < 6.0) return false;
        }

        return true;
    }
}