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
                String[] concepts = student.getConcepts();
                if (concepts != null) {
                    List<String> conceptsList = Arrays.asList(concepts);
                    document.append("concepts", conceptsList);
                }
            } else {
                Double[] grades = student.getGrades();
                if (grades != null) {
                    document.append("grades", Arrays.asList(grades));
                }
            }

            String[] subjects = student.getSubjects().toArray(new String[0]);
            document.append("subjects", Arrays.asList(subjects));

            collection.insertOne(document);
        } catch (NullPointerException npe) {
            System.err.println("Um valor nulo foi encontrado ao tentar salvar os resultados do estudante.");
            npe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
