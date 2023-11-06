import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class MongoDB implements IDatabase {
    @Override
    public void saveStudentResult(Student student) {
        try (MongoClient mongoClient = MongoClients.create(new ConnectionString("mongodb://localhost:27017"))) {
            MongoDatabase database = mongoClient.getDatabase("university");
            MongoCollection<Document> collection = database.getCollection("students");

            Document document = new Document("name", student.getName())
                    .append("courseType", student.getCourseType().toString());

            if (student.getCourseType() == CourseType.MASTERS) {
                List<String> conceptsList = Arrays.asList(student.getConcepts());
                document.append("concepts", conceptsList);
            } else {
                document.append("grades", student.getGrades());
            }

            document.append("subjects", student.getSubjects());

            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
