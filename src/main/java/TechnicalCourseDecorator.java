public class TechnicalCourseDecorator extends CourseDecorator {
    public TechnicalCourseDecorator(Student student) {
        super(student);
        setCourseType();
    }

    @Override
    public void setCourseType() {
        student.setCourseType(CourseType.TECHNICAL);
    }
}