public class BachelorsCourseDecorator extends CourseDecorator {
    public BachelorsCourseDecorator(Student student) {
        super(student);
    }

    @Override
    public void setCourseType() {
        student.setCourseType(CourseType.BACHELORS);
    }
}