package Assignments;

public class Course {

    private int id;

    private String courseName;

    private String description;

    private User instructor;

    private int attendantStudentCount;

    public Course(int id, String courseName, String description) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
    }

    public Course(int id, String courseName, String description, User instructor) {
        this(id, courseName, description);
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public int getAttendantCount(){
        return attendantStudentCount;
    }


    public void addStudentToCourse(User attendant) {
        attendantStudentCount++;
    }

    public void removeStudentFromCourse(User attendant) {

        if (attendantStudentCount > 0)
            attendantStudentCount--;
    }

}
