// Main class to demonstrate functionality
public class Main {
    public static void main(String[] args) {
        // Initialize the DatabaseFactory
        DatabaseFactory databaseFactory = new DatabaseFactory();

        // Create MySQL and MongoDB instances
        Database mySqlDatabase = databaseFactory.createDatabase(DatabaseType.MYSQL);
        Database mongoDbDatabase = databaseFactory.createDatabase(DatabaseType.MONGODB);

        // Process a technical course student using MySQL
        Student technicalCourseStudent = new Student("John Doe", CourseType.TECHNICAL, new double[]{6.0, 8.0, 9.0});
        CourseProcessor courseProcessorMySql = new CourseProcessor(mySqlDatabase);
        courseProcessorMySql.processStudent(technicalCourseStudent);

        // Process a master's degree student using MongoDB
        Student mastersDegreeStudent = new Student("Jane Doe", CourseType.MASTERS, new String[]{"A", "B", "C"});
        CourseProcessor courseProcessorMongoDB = new CourseProcessor(mongoDbDatabase);
        courseProcessorMongoDB.processStudent(mastersDegreeStudent);
    }
}
