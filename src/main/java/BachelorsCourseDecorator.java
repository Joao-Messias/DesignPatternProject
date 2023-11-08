public class BachelorsCourseDecorator implements CourseSubjectChecker {
    private CourseSubjectChecker checker;

    public BachelorsCourseDecorator(CourseSubjectChecker checker) {
        this.checker = checker;
    }

    @Override
    public boolean allSubjectsPassed(Student student) {
        if (student.getGrades() != null) {
            for (double grade : student.getGrades()) {
                if (grade < 6.0) {
                    return false; // Se alguma nota for inferior a 6.0, o estudante é reprovado naquela disciplina
                }
            }
        }
        return true; // Se todas as notas forem iguais ou superiores a 6.0, o estudante é aprovado em todas as disciplinas
    }
}