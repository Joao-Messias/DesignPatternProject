public class BachelorsCourseSubjectChecker implements CourseSubjectChecker {
    private static BachelorsCourseSubjectChecker instance;

    private BachelorsCourseSubjectChecker() {
        // Construtor privado para evitar a criação de instâncias adicionais.
    }

    public static BachelorsCourseSubjectChecker getInstance() {
        if (instance == null) {
            instance = new BachelorsCourseSubjectChecker();
        }
        return instance;
    }

    @Override
    public boolean allSubjectsPassed(Student student) {
        for (double grade : student.getGrades()) {
            if (grade < 6.0) return false;
        }

        return true;
    }
}