public class MastersCourseDecorator extends CourseDecorator {
    public MastersCourseDecorator(Student student) {
        super(student);
    }

    @Override
    public void setCourseType() {
        student.setCourseType(CourseType.MASTERS);
    }
}