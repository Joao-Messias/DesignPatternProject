public class TechnicalCourseDecorator extends CourseDecorator {
    public TechnicalCourseDecorator(Student student) {
        super(student);
    }

    @Override
    public void setCourseType() {
        student.setCourseType(CourseType.TECHNICAL);
    }
}