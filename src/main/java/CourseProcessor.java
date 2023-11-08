public class CourseProcessor {
    StudentProcessor studentProcessor;
    IDatabase database;

    public CourseProcessor(IDatabase database, StudentProcessor studentProcessor) {
        this.database = database;

        // Decorando o studentProcessor com a funcionalidade de log
        this.studentProcessor = new LoggingStudentProcessorDecorator(studentProcessor);
    }

    // Process a student based on their course type and results
    public void processStudent(Student student) {
        studentProcessor.processStudent(student);
        // Salva o resultado no banco de dados antes de promover o estudante
        database.saveStudentResult(student);

        var courseTypeBefore = student.getCourseType();
        if (allSubjectsPassed(student)) {
            student.promoteCourseType();
            if (courseTypeBefore == student.getCourseType()) {
                System.out.println(student.getName() + " já está no último nível de estudos!");
            } else if (student.getCourseType() == CourseType.MASTERS) {
                System.out.println(student.getName() + " foi para o último nível de estudos! Parabéns! Foi promovido de " + courseTypeBefore + " para " + student.getCourseType());
            } else {
                System.out.println(student.getName() + " foi promovido de " + courseTypeBefore + " para " + student.getCourseType());
            }
        }
    }

    // Check if all subjects were passed
    private boolean allSubjectsPassed(Student student) {
        CourseSubjectChecker subjectChecker = getSubjectChecker(student);
        return subjectChecker.allSubjectsPassed(student);
    }

    private CourseSubjectChecker getSubjectChecker(Student student) {
        if (student.getCourseType() == CourseType.TECHNICAL) {
            return new TechnicalCourseSubjectChecker();
        }
        if (student.getCourseType() == CourseType.BACHELORS) {
//            return BachelorsCourseSubjectChecker.getInstance(); // Usando o Singleton aqui
            return new BachelorsCourseSubjectChecker();
        }
        if (student.getCourseType() == CourseType.MASTERS) {
            return new MastersCourseSubjectChecker();
        }
        throw new IllegalArgumentException("Invalid course type");
    }
}
