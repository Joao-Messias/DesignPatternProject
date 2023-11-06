public abstract class StudentProcessorDecorator implements StudentProcessor {
    protected StudentProcessor decoratedProcessor;

    public StudentProcessorDecorator(StudentProcessor decoratedProcessor) {
        this.decoratedProcessor = decoratedProcessor;
    }

    public void processStudent(Student student) {
        decoratedProcessor.processStudent(student);
    }
}
