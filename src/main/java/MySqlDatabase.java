import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringJoiner;

public class MySqlDatabase implements IDatabase {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/university";
    private static final String USER = "principal";
    private static final String PASSWORD = "principal";

    @Override
    public void saveStudentResult(Student student) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO students (name, course_type, grades, concepts) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getCourseType().name());

                if (student.getCourseType() == CourseType.MASTERS) {
                    preparedStatement.setNull(3, java.sql.Types.VARCHAR);
                    preparedStatement.setString(4, arrayToString(student.getConcepts()));
                } else {
                    preparedStatement.setString(3, arrayToString(student.getGrades()));
                    preparedStatement.setNull(4, java.sql.Types.VARCHAR);
                }

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String arrayToString(Object[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        StringJoiner joiner = new StringJoiner(",");
        for (Object element : array) {
            joiner.add(element.toString());
        }

        return joiner.toString();
    }
}
