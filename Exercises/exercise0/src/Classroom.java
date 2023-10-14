public class Classroom {
    static int counter = 0;
    int id;
    int floor;
    String name;
    int tableCount;
    float length;
    float width;
    float height;
    String schoolName;
    void GetName() {
        System.out.println("Classroom name is: " + this.name);
    }

    void SetName(String name) {
        this.name = name;
        System.out.println("Classroom get renamed to: " + this.name);
    }

    void GetId() {
        System.out.println("Classroom id: " + this.id);
    }
    Classroom (String name) {
        System.out.println("A new classroom is created!");
        this.name = name;
        this.id = ++counter;
        System.out.println("Classroom id is: "+ this.id + " and its name is: " + this.name);
    }
    public static class Student{
        static int studentCounter = 0;
        int id;
        String name;
        String grade;
        float tuition;
        String gender;
        int age;
        boolean fullTimeOrNot;
        String Nationality;
        Student (String name) {
            System.out.println("A new student is created!");
            this.name = name;
            this.id = ++studentCounter;
            System.out.println("Student id is: "+ this.id + " and their name is: " + this.name);
        }
        void GetName() {
            System.out.println("Student name is: " + this.name);
        }

        void SetName(String name) {
            this.name = name;
            System.out.println("Student get renamed to: " + this.name);
        }

        void GetId() {
            System.out.println("Student id: " + this.id);
        }
    }

    public static class Teacher{
        static int teacherCounter = 0;
        int id;
        String name;
        String course;
        float salary;
        String gender;
        int age;
        boolean fullTimeOrNot;
        String Nationality;
        Teacher (String name) {
            System.out.println("A new teacher is created!");
            this.name = name;
            this.id = ++teacherCounter;
            System.out.println("Teacher id is: "+ this.id + " and their name is: " + this.name);
        }
        void GetName() {
            System.out.println("Teacher name is: " + this.name);
        }

        void SetName(String name) {
            this.name = name;
            System.out.println("Teacher get renamed to: " + this.name);
        }

        void GetId() {
            System.out.println("Teacher id: " + this.id);
        }
    }









}
