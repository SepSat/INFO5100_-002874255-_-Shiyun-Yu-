import java.util.Arrays;

public class Session {
    Student[] students;
    Session (Student[] students){
        this.students = students;
    }

    public float calculateAvgQuizScore(Student student){
        float totalScorePerStudent = 0;
        for (float quizScore : student.quizScores) {
            totalScorePerStudent += quizScore;
        }
        return totalScorePerStudent / this.students.length;
    }

    // I think the instruction of this problem is confusing.
    // My assumption is: we are printing ascending order of
    // the *average* quiz score of every student for the session,
    // by using the calculateAvgQuizScore defined above.
    public void printListOfQuizScoresInAscendingOrder(){
        int studentCount = this.students.length;
        float[] listAvgQuizScoresOfSession = new float[studentCount];
        for (int i = 0; i < studentCount; i++){
           float avgScore = calculateAvgQuizScore(this.students[i]);
            listAvgQuizScoresOfSession[i] = avgScore;
        }
        Arrays.sort(listAvgQuizScoresOfSession);
        System.out.println("List of quiz scores in ascending order: ");
        for (float score : listAvgQuizScoresOfSession) {
            System.out.print(score + " ");
        }
        System.out.println(" ");
    }

    public void printNameOfPartTimeStudents(){
        for (Student student : this.students){
            if (student instanceof PartTimeStudent){
                System.out.println("This part-time student's name is: " + student.name);
            }
        }
    }

    public void printExamScoreOfFullTimeStudents(){
        for (Student student : this.students){
            if (student instanceof FullTimeStudent) {
                System.out.println(student.name + " exam scores: ");
                for (int j = 0; j < ((FullTimeStudent) student).examScores.length; j++){
                    System.out.println(j+1 + ". " + ((FullTimeStudent) student).examScores[j]);
                }
            }
        }
    }
}
