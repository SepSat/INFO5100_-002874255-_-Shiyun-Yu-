public class FullTimeStudent extends Student {
    float[] examScores;
    public FullTimeStudent(String name,float[] quizScore,float[] examScores) {
        super(name, quizScore);
        this.examScores = examScores;
    }
}
