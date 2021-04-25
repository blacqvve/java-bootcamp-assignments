package OOPAssignment;

public class Main {

    public static void main(String[] args) {

        Course javaCourse = new Course("Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)",
                "2 ay sürecek ücretsiz ve profesyonel bir programla, sıfırdan yazılım geliştirme öğreniyoruz.",
                "Engin Demirog",
                "Free");
        Course cSharpCourse = new Course("Yazılım Geliştirici Yetiştirme Kampı (C# + ANGULAR)",
                "2 ay sürecek ücretsiz ve profesyonel bir programla, sıfırdan yazılım geliştirme öğreniyoruz.",
                "Engin Demirog",
                "Free");
        Course introductionToProgrammingCourse = new Course("Programlamaya Giriş için Temel Kurs",
                "PYTHON, JAVA, C# gibi tüm programlama dilleri için temel programlama mantığını anlaşılır",
                "Engin Demirog",
                "Free");


        Course[] courses = new Course[]{javaCourse,cSharpCourse,introductionToProgrammingCourse};

        for (Course course:courses) {
            System.out.println(course);
        }

        CourseManager courseManager = new CourseManager();

        courseManager.AddStudentToCourse(javaCourse);

        courseManager.RemoveStudentFromCourse(cSharpCourse);
    }
}
