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
        if (allSubjectsPassed(student)) {
            student.promoteCourseType();
            System.out.println(student.getName() + " foi promovido para " + student.getCourseType());
        }
        database.saveStudentResult(student);
    }

    // Check if all subjects were passed
    private boolean allSubjectsPassed(Student student) {
        CourseSubjectChecker subjectChecker = getSubjectChecker(student);
        return subjectChecker.allSubjectsPassed(student);
    }

    private CourseSubjectChecker getSubjectChecker(Student student) {
        switch (student.getCourseType()) {
            case TECHNICAL:
                return new TechnicalCourseSubjectChecker();
            case BACHELORS:
                return BachelorsCourseSubjectChecker.getInstance(); // Usando o Singleton aqui
            case MASTERS:
                return new MastersCourseSubjectChecker();
            default:
                throw new IllegalArgumentException("Invalid course type");
        }
    }
}
