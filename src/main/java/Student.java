import java.util.ArrayList;
import java.util.List;
public class Student {
    private String name;
    private CourseType courseType;
    private Double[] grades;
    private String[] concepts;
    private List<String> subjects = new ArrayList<>();

    public List<String> getSubjects() { return subjects; }

    // Constructor for technical and bachelor courses
    public Student(String name, Double[] grades) {
        this.name = name;
        this.grades = grades;
    }

    // Constructor for master's degree courses
    public Student(String name, String[] concepts) {
        this.name = name;
        this.concepts = concepts;
    }

    public void addSubject(String subject) {
        this.subjects.add(subject);
    }

    public void promoteCourseType() {
        switch (this.courseType) {
            case TECHNICAL:
                this.courseType = CourseType.BACHELORS;
                break;
            case BACHELORS:
                this.courseType = CourseType.MASTERS;
                break;
            default:
                System.out.println("O estudante já está no nível máximo de curso.");
        }
    }


    // Getters
    public String getName() { return name; }
    public CourseType getCourseType() { return courseType; }
    public Double[] getGrades() { return grades; }
    public String[] getConcepts() { return concepts; }

    protected void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }
}
