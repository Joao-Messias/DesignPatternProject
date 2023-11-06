public class MastersCourseSubjectChecker implements CourseSubjectChecker {
    @Override
    public boolean allSubjectsPassed(Student student) {
        for (String concept : student.getConcepts()) {
            if ("D".equals(concept)) return false;
        }

        return true;
    }
}
