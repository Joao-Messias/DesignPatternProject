// Main class to demonstrate functionality
public class Main {
    public static void main(String[] args) {

        // Initialize the DatabaseFactory
        DatabaseFactory mySqlFactory = new MySqlDatabaseFactory();
        IDatabase mySqlDatabase = mySqlFactory.createDatabase();

        DatabaseFactory mongoDbFactory = new MongoDBFactory();
        IDatabase mongoDbDatabase = mongoDbFactory.createDatabase();

        // Process a technical course student using MySQL
        Student technicalCourseStudent = new Student("John Lake", CourseType.TECHNICAL, new double[]{6.0, 8.0, 9.0});

        // Create processor that handle students grades
        StudentProcessor technicalCourseProcessor = new TechnicalCourseProcessor();

        // inject sql dependency to save in my sql database
        CourseProcessor courseProcessorMySql = new CourseProcessor(mySqlDatabase, technicalCourseProcessor);

        // process student grades using injected processor
        courseProcessorMySql.processStudent(technicalCourseStudent);

        // Process a master's degree student using MongoDB
        Student mastersDegreeStudent = new Student("Jane Doe", CourseType.MASTERS, new String[]{"A", "B", "C"});
        StudentProcessor masterCourseProcessor = new MastersCourseProcessor();
        CourseProcessor courseProcessorMongoDB = new CourseProcessor(mongoDbDatabase, masterCourseProcessor);
        courseProcessorMongoDB.processStudent(mastersDegreeStudent);

    }
}
