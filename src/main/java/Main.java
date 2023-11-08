public class Main {
    public static void main(String[] args) {

        DatabaseFactory mySqlFactory = DatabaseFactory.getMySQLInstance();
        IDatabase mySqlDatabase = new LoggingDatabaseDecorator(mySqlFactory.createDatabase());

        DatabaseFactory mongoDbFactory = DatabaseFactory.getMongoDBInstance();
        IDatabase mongoDbDatabase = new LoggingDatabaseDecorator(mongoDbFactory.createDatabase());

        Student technicalStudent = new Student("Mary Lake", new Double[]{6.0, 8.0, 9.0});
        new TechnicalCourseDecorator(technicalStudent);
        StudentProcessor technicalProcessor = new TechnicalCourseProcessor();
        CourseProcessor courseProcessorMySqlTechnical = new CourseProcessor(mySqlDatabase, technicalProcessor);
        courseProcessorMySqlTechnical.processStudent(technicalStudent);

        Student mastersStudent = new Student("John Doe", new Double[]{5.0, 7.0, 8.0});
        new MastersCourseDecorator(mastersStudent);
        StudentProcessor mastersProcessor = new MastersCourseProcessor();
        CourseProcessor courseProcessorMySqlMasters = new CourseProcessor(mySqlDatabase, mastersProcessor);
        courseProcessorMySqlMasters.processStudent(mastersStudent);

        Student bachelorsStudent = new Student("Jane Smith", new Double[]{7.0, 8.5, 9.0});
        new BachelorsCourseDecorator(bachelorsStudent);
        StudentProcessor bachelorsProcessor = new BachelorsCourseProcessor();
        CourseProcessor courseProcessorMongoDbBachelors = new CourseProcessor(mongoDbDatabase, bachelorsProcessor);
        courseProcessorMongoDbBachelors.processStudent(bachelorsStudent);
    }
}
