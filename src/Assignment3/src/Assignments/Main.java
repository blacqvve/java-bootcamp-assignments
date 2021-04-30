package Assignments;

public class Main {

    public static void main(String[] args) {

        Instructor instructor1 = new Instructor(1,"Engin","Demiroğ","Software consultant");

        Course javaCourse = new Course(1,"Java Bootcamp","Java Developer Bootcamp");

        Student student1 = new Student(1,"John","Doe");
        Student student2 = new Student(2,"Jane","Doe");
        Student student3 = new Student(3,"Tom","Doe");

        CourseManager courseManager = new CourseManager();

        courseManager.setCourseInstructor(javaCourse,instructor1);

        courseManager.addStudentToCourse(javaCourse,student1);

        courseManager.addStudentToCourse(javaCourse,student2);

        courseManager.addStudentToCourse(javaCourse,student3);

        courseManager.removeStudentFromCourse(javaCourse,student2);

    }
}
