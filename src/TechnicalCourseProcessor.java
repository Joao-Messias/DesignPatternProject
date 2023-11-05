public class TechnicalCourseProcessor implements StudentProcessor {
    @Override
    public void processStudent(Student student) {
        double sum = 0;
        for (double grade : student.getGrades()) {
            sum += grade;
        }
        double average = sum / student.getGrades().length;

        if (average >= 7.0) {
            System.out.println(student.getName() + " foi aprovado no Curso Técnico com média: " + average);
        } else {
            System.out.println(student.getName() + " foi reprovado no Curso Técnico com média: " + average);
        }

    }

}