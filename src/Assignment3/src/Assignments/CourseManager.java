package Assignments;

public class CourseManager {

    public void addStudentToCourse(Course course, User student){

        course.addStudentToCourse(student);

        System.out.println("Student named " + student.getFullName() + " added to " + course.getCourseName() + " course");

        studentCountMessage(course);
    }

    public void removeStudentFromCourse(Course course, User student){

        course.removeStudentFromCourse(student);

        System.out.println("Student named " + student.getFullName() + " removed from " + course.getCourseName() + " course");

        studentCountMessage(course);
    }

    public void studentCountMessage(Course course){
        System.out.println(course.getCourseName() + " named course has " + course.getAttendantCount() + " students");
    }

    public void setCourseInstructor(Course course,User instructor){
        course.setInstructor(instructor);

        System.out.println(course.getCourseName() + " course instructor changed. New instructor is "+ instructor.getFullName());
    }

}
