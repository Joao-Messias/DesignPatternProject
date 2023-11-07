public abstract class CourseProcessorDecorator extends CourseProcessor {
    protected CourseProcessor decoratedCourseProcessor;

    public CourseProcessorDecorator(IDatabase database, StudentProcessor studentProcessor, CourseProcessor decoratedCourseProcessor) {
        super(database, studentProcessor);
        this.decoratedCourseProcessor = decoratedCourseProcessor;
    }

    @Override
    public void processStudent(Student student) {
        decoratedCourseProcessor.processStudent(student);
    }
}
