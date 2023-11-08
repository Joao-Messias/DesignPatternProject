public class TechnicalCourseDecorator implements CourseSubjectChecker {
    private CourseSubjectChecker checker;

    public TechnicalCourseDecorator(CourseSubjectChecker checker) {
        this.checker = checker;
    }

    @Override
    public boolean allSubjectsPassed(Student student) {
        // O estudante é aprovado se obtiver média igual ou superior a 7.0 em todas as disciplinas
        if (student.getGrades() != null) {
            for (double grade : student.getGrades()) {
                if (grade < 7.0) {
                    return false; // Se alguma nota for inferior a 7.0, o estudante é reprovado
                }
            }
        }
        return true; // Se todas as notas forem iguais ou superiores a 7.0, o estudante é aprovado
    }
}
