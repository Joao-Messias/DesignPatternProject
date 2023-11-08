public abstract class CourseDecorator extends Student {
    protected Student student;

    public CourseDecorator(Student student) {
        super(student.getName(), student.getGrades());
        this.student = student;
    }

    public abstract void setCourseType();
}