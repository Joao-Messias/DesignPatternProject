public class Main {
    public static void main(String[] args) {

        // Initialize the DatabaseFactory
        DatabaseFactory mySqlFactory = DatabaseFactory.getMySQLInstance();
        IDatabase mySqlDatabase = new LoggingDatabaseDecorator(mySqlFactory.createDatabase());

        DatabaseFactory mongoDbFactory = DatabaseFactory.getMongoDBInstance();
        IDatabase mongoDbDatabase = new LoggingDatabaseDecorator(mongoDbFactory.createDatabase());

        // Process a technical course student using MySQL
        Student technicalCourseStudent = new Student("Mary Lake", CourseType.TECHNICAL, new Double[]{6.0, 8.0, 9.0});
        CourseSubjectChecker technicalChecker = new TechnicalCourseDecorator(new TechnicalCourseSubjectChecker());
        StudentProcessor technicalCourseProcessor = new TechnicalCourseProcessor(technicalChecker);
        CourseProcessor courseProcessorMySql = new CourseProcessor(mySqlDatabase, technicalCourseProcessor);
        courseProcessorMySql.processStudent(technicalCourseStudent);

        // Process a bachelor's degree student using MySQL
        Student bachelorsStudent = new Student("Jane Smith", CourseType.BACHELORS, new Double[]{5.5, 9.0, 7.0});
        CourseSubjectChecker bachelorsChecker = new BachelorsCourseDecorator(BachelorsCourseSubjectChecker.getInstance());
        StudentProcessor bachelorsProcessor = new BachelorsCourseProcessor(bachelorsChecker);
        courseProcessorMySql.processStudent(bachelorsStudent);

        // Process a master's degree student using MongoDB
        Student mastersDegreeStudent = new Student("John Doe", CourseType.MASTERS, new String[]{"A", "B", "C"});
        CourseSubjectChecker mastersChecker = new MastersCourseDecorator(new MastersCourseSubjectChecker());
        StudentProcessor masterCourseProcessor = new MastersCourseProcessor(mastersChecker);
        CourseProcessor courseProcessorMongoDB = new CourseProcessor(mongoDbDatabase, masterCourseProcessor);
        courseProcessorMongoDB.processStudent(mastersDegreeStudent);
    }
}
