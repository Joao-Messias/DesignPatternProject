public class BachelorsCourseProcessor implements StudentProcessor {
    private CourseSubjectChecker checker;

    public BachelorsCourseProcessor() {
        BachelorsCourseSubjectChecker.getInstance();
    }
    @Override
    public void processStudent(Student student) {
        if (checker.allSubjectsPassed(student)) {
            System.out.println(student.getName() + " foi aprovado em todas as disciplinas do Curso de Bacharelado.");
        } else {
            System.out.println(student.getName() + " foi reprovado em uma ou mais disciplinas do Curso de Bacharelado.");
        }
    }
}
