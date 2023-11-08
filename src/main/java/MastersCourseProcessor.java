public class MastersCourseProcessor implements StudentProcessor {
    private CourseSubjectChecker checker;

    @Override
    public void processStudent(Student student) {
        if (checker.allSubjectsPassed(student)) {
            System.out.println(student.getName() + " foi mantido no programa de Mestrado.");
        } else {
            System.out.println(student.getName() + " foi descredenciado do Curso de Mestrado devido ao conceito D.");
        }
    }
}
