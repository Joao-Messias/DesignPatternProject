public class BachelorsCourseProcessor implements StudentProcessor {
    private static BachelorsCourseProcessor instance;

    private BachelorsCourseProcessor() {
        // Construtor privado para evitar a criação de instâncias adicionais.
    }

    public static BachelorsCourseProcessor getInstance() {
        if (instance == null) {
            instance = new BachelorsCourseProcessor();
        }
        return instance;
    }

    @Override
    public void processStudent(Student student) {
        for (double grade : student.getGrades()) {
            if (grade >= 6.0) {
                System.out.println(student.getName() + " foi aprovado na disciplina com nota: " + grade);
            } else {
                System.out.println(student.getName() + " foi reprovado na disciplina com nota: " + grade);
            }
        }
    }
}