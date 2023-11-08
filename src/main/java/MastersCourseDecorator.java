public class MastersCourseDecorator implements CourseSubjectChecker {
    private CourseSubjectChecker checker;

    public MastersCourseDecorator(CourseSubjectChecker checker) {
        this.checker = checker;
    }

    @Override
    public boolean allSubjectsPassed(Student student) {
        if (student.getConcepts() != null) {
            for (String concept : student.getConcepts()) {
                if ("D".equals(concept)) {
                    return false; // Se algum conceito for D, o estudante é descredenciado do curso
                }
            }
        }
        return true; // Se não houver nenhum conceito D, o estudante é mantido no programa
    }
}
