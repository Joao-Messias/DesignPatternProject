public class LoggingStudentProcessorDecorator extends StudentProcessorDecorator {

    public LoggingStudentProcessorDecorator(StudentProcessor decoratedProcessor) {
        super(decoratedProcessor);
    }

    @Override
    public void processStudent(Student student) {
        logBeforeProcessing(student);
        super.processStudent(student);
        logAfterProcessing(student);
    }

    private void logBeforeProcessing(Student student) {
        System.out.println("Iniciando o processamento do estudante: " + student.getName());
    }

    private void logAfterProcessing(Student student) {
        System.out.println("Processamento do estudante concluído: " + student.getName());
    }
}