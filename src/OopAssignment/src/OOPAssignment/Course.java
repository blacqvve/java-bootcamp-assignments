package OOPAssignment;

public class Course {
    String title;
    String description;
    String traineeFullName;
    String coursePrice;

    public Course(String title, String description, String traineeFullName, String coursePrice) {
        this.title = title;
        this.description = description;
        this.traineeFullName = traineeFullName;
        this.coursePrice = coursePrice;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ","+'\n'+" description='" + description + '\'' +
                ","+'\n'+" traineeFullName='" + traineeFullName + '\'' +
                ","+'\n'+" coursePrice='" + coursePrice + '\'' +
                '}';
    }
}
