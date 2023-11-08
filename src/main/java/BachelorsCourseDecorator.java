public class BachelorsCourseDecorator extends CourseDecorator {
    public BachelorsCourseDecorator(Student student) {
        super(student);
        setCourseType();
    }

    @Override
    public void setCourseType() {
        student.setCourseType(CourseType.BACHELORS);
    }
}