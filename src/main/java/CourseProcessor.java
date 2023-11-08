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
        if (student.getCourseType() == CourseType.TECHNICAL) {
            return new TechnicalCourseDecorator(new TechnicalCourseSubjectChecker());
        }
        if (student.getCourseType() == CourseType.BACHELORS) {
            return new BachelorsCourseDecorator(BachelorsCourseSubjectChecker.getInstance());
        }
        if (student.getCourseType() == CourseType.MASTERS) {
            return new MastersCourseDecorator(new MastersCourseSubjectChecker());
        }
        throw new IllegalArgumentException("Invalid course type");
    }
}
