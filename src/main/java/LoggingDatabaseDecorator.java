public class LoggingDatabaseDecorator extends DatabaseDecorator {

    public LoggingDatabaseDecorator(IDatabase decoratedDatabase) {
        super(decoratedDatabase);
    }

    @Override
    public void saveStudentResult(Student student) {
        logBeforeSave(student);
        super.saveStudentResult(student);
        logAfterSave(student);
    }

    private void logBeforeSave(Student student) {
        System.out.println("Salvando resultados para o estudante: " + student.getName());
    }

    private void logAfterSave(Student student) {
        System.out.println("Resultados salvos para o estudante: " + student.getName());
    }
}
