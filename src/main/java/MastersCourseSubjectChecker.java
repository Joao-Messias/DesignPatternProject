public class MastersCourseSubjectChecker implements CourseSubjectChecker {
    @Override
    public boolean allSubjectsPassed(Student student) {
        String[] concepts = student.getConcepts();
        if (concepts == null) {
            return false;
        }
        for (String concept : concepts) {
            if ("D".equals(concept)) return false;
        }
        return true;
    }

}
