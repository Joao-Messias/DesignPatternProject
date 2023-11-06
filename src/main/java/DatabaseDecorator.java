public abstract class DatabaseDecorator implements IDatabase {
    protected IDatabase decoratedDatabase;

    public DatabaseDecorator(IDatabase decoratedDatabase) {
        this.decoratedDatabase = decoratedDatabase;
    }

    @Override
    public void saveStudentResult(Student student) {
        decoratedDatabase.saveStudentResult(student);
    }
}
