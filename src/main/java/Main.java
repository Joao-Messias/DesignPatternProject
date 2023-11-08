public class Main {
    public static void main(String[] args) {

        DatabaseFactory mySqlFactory = DatabaseFactory.getMySQLInstance();
        IDatabase mySqlDatabase = new LoggingDatabaseDecorator(mySqlFactory.createDatabase());

        DatabaseFactory mongoDbFactory = DatabaseFactory.getMongoDBInstance();
        IDatabase mongoDbDatabase = new LoggingDatabaseDecorator(mongoDbFactory.createDatabase());

        // MYSQL
        Student technicalStudentMysql = new Student("João MySql A", new Double[]{6.0, 8.0, 9.0});
        new TechnicalCourseDecorator(technicalStudentMysql);
        StudentProcessor technicalProcessorMySql = new TechnicalCourseProcessor();
        CourseProcessor courseProcessorMySqlTechnical = new CourseProcessor(mySqlDatabase, technicalProcessorMySql);
        courseProcessorMySqlTechnical.processStudent(technicalStudentMysql);

        Student mastersStudentMysql = new Student("João MySql B", new String[]{"A", "B", "C"});
        new MastersCourseDecorator(mastersStudentMysql);
        StudentProcessor mastersProcessorMysql = new MastersCourseProcessor();
        CourseProcessor courseProcessorMySqlMasters = new CourseProcessor(mySqlDatabase, mastersProcessorMysql);
        courseProcessorMySqlMasters.processStudent(mastersStudentMysql);

        Student bachelorsStudentMysql = new Student("João MySql C", new Double[]{6.0, 7.0, 8.0});
        new BachelorsCourseDecorator(bachelorsStudentMysql);
        StudentProcessor bachelorsProcessorMySql = new BachelorsCourseProcessor();
        CourseProcessor courseProcessorMySqlBachelors = new CourseProcessor(mySqlDatabase, bachelorsProcessorMySql);
        courseProcessorMySqlBachelors.processStudent(bachelorsStudentMysql);


        // MONGODB
        Student technicalStudentMongoDb = new Student("João Mongo A", new Double[]{6.0, 8.0, 9.0});
        new TechnicalCourseDecorator(technicalStudentMongoDb);
        StudentProcessor technicalProcessorMongoDB = new TechnicalCourseProcessor();
        CourseProcessor courseProcessorMongoDbTechnical = new CourseProcessor(mongoDbDatabase, technicalProcessorMongoDB);
        courseProcessorMongoDbTechnical.processStudent(technicalStudentMongoDb);

        Student mastersStudentMongoDb = new Student("João Mongo B", new String[]{"A", "B", "C"});
        new MastersCourseDecorator(mastersStudentMongoDb);
        StudentProcessor mastersProcessorMongoDB = new MastersCourseProcessor();
        CourseProcessor courseProcessorMongoDbMasters = new CourseProcessor(mongoDbDatabase, mastersProcessorMongoDB);
        courseProcessorMongoDbMasters.processStudent(mastersStudentMongoDb);

        Student bachelorsStudentMongoDb = new Student("João Mongo C", new Double[]{6.0, 7.0, 8.0});
        new BachelorsCourseDecorator(bachelorsStudentMongoDb);
        StudentProcessor bachelorsProcessorMongoDB = new BachelorsCourseProcessor();
        CourseProcessor courseProcessorMongoDbBachelors = new CourseProcessor(mongoDbDatabase, bachelorsProcessorMongoDB);
        courseProcessorMongoDbBachelors.processStudent(bachelorsStudentMongoDb);
    }
}
