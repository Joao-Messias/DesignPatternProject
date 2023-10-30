// Class to process students based on their courses and results
public class CourseProcessor {
    private Database database;

    // Constructor
    public CourseProcessor(Database database) {
        this.database = database;
    }


    // Process a student based on their course type and results
    public void processStudent(Student student) {
        switch (student.getCourseType()) {
            case TECHNICAL:
                processTechnicalCourse(student);
                break;
            case BACHELORS:
                processBachelorsCourse(student);
                break;
            case MASTERS:
                processMastersCourse(student);
                break;
        }
        if (allSubjectsPassed(student)) {
            student.promoteCourseType();
            System.out.println(student.getName() + " foi promovido para " + student.getCourseType());
        }
        database.saveStudentResult(student);
    }
    // Check if all subjects were passed
    private boolean allSubjectsPassed(Student student) {
        if (student.getCourseType() == CourseType.TECHNICAL) {
            for (double grade : student.getGrades()) {
                if (grade < 7.0) return false;
            }
        } else if (student.getCourseType() == CourseType.BACHELORS) {
            for (double grade : student.getGrades()) {
                if (grade < 6.0) return false;
            }
        } else if (student.getCourseType() == CourseType.MASTERS) {
            for (String concept : student.getConcepts()) {
                if ("D".equals(concept)) return false;
            }
        }
        return true;
    }

    // Process a technical course student
    private void processTechnicalCourse(Student student) {
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

    // Process a bachelor's degree student
    private void processBachelorsCourse(Student student) {
        for (double grade : student.getGrades()) {
            if (grade >= 6.0) {
                System.out.println(student.getName() + " foi aprovado na disciplina com nota: " + grade);
            } else {
                System.out.println(student.getName() + " foi reprovado na disciplina com nota: " + grade);
            }
        }
    }

    // Process a master's degree student
    private void processMastersCourse(Student student) {
        for (String concept : student.getConcepts()) {
            if ("D".equals(concept)) {
                System.out.println(student.getName() + " foi descredenciado do Curso de Mestrado devido ao conceito D.");
                return;
            }
        }
        System.out.println(student.getName() + " foi mantido no programa de Mestrado.");
    }
}
