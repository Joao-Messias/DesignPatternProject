public class MastersCourseProcessor implements StudentProcessor {
    @Override
    public void processStudent(Student student) {
        for (String concept : student.getConcepts()) {
            if ("D".equals(concept)) {
                System.out.println(student.getName() + " foi descredenciado do Curso de Mestrado devido ao conceito D.");
                return;
            }
        }
        System.out.println(student.getName() + " foi mantido no programa de Mestrado.");
    }
}