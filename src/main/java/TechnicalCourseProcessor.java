public class TechnicalCourseProcessor implements StudentProcessor {
    private CourseSubjectChecker checker;

    public TechnicalCourseProcessor() {
        this.checker = new TechnicalCourseSubjectChecker();
    }

    @Override
    public void processStudent(Student student) {
        if (checker.allSubjectsPassed(student)) {
            System.out.println(student.getName() + " foi aprovado no Curso Técnico.");
        } else {
            System.out.println(student.getName() + " foi reprovado no Curso Técnico.");
        }
    }
}
