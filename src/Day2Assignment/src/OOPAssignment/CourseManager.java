package OOPAssignment;

public class CourseManager {



    public void AddStudentToCourse(Course course)
    {
        System.out.println("Student added to" + course.title);
    }

    public void RemoveStudentFromCourse(Course course)
    {
        System.out.println("Student removed from" + course.title);
    }
}
