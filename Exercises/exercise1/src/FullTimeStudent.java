public class FullTimeStudent extends Student {
    float[] examScores;
    FullTimeStudent(String name,float[] quizScore,float[] examScores) {
        super(name, quizScore);
        this.examScores = examScores;
    }
}
