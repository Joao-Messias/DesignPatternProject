public abstract class CourseProcessorDecorator extends CourseProcessor {
    protected CourseProcessor decoratedCourseProcessor;

    public CourseProcessorDecorator(CourseProcessor decoratedCourseProcessor) {
        super(decoratedCourseProcessor.database, decoratedCourseProcessor.studentProcessor);
        this.decoratedCourseProcessor = decoratedCourseProcessor;
    }

    @Override
    public void processStudent(Student student) {
        decoratedCourseProcessor.processStudent(student);
    }
}
