import java.util.Random;

public class Main {
    public static float[] getRandomFloatArray(int arrayLength) {
        float[] randomFloatArray = new float[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++){
            // Get a random float from 0 - 100;
            float randomFloat = random.nextFloat() * 100;
            randomFloatArray[i] = randomFloat;
        }
        return randomFloatArray;
    }
    public static void main(String[] args) {
        Student[] students= new Student [20] ;
        students[0]=new FullTimeStudent("Francis Ford Coppola", getRandomFloatArray(15), getRandomFloatArray(2));
        students[1]=new FullTimeStudent("Frank Darabont", getRandomFloatArray(15), getRandomFloatArray(2));
        students[2]=new FullTimeStudent("Christopher Nolan", getRandomFloatArray(15), getRandomFloatArray(2));
        students[3]=new FullTimeStudent("Sidney Lumet", getRandomFloatArray(15), getRandomFloatArray(2));
        students[4]=new FullTimeStudent("Peter Jackson", getRandomFloatArray(15), getRandomFloatArray(2));
        students[5]=new FullTimeStudent("Quentin Tarantino", getRandomFloatArray(15), getRandomFloatArray(2));
        students[6]=new FullTimeStudent("Steven Spielberg", getRandomFloatArray(15), getRandomFloatArray(2));
        students[7]=new FullTimeStudent("Christopher Nolan", getRandomFloatArray(15), getRandomFloatArray(2));
        students[8]=new FullTimeStudent("David Fincher", getRandomFloatArray(15), getRandomFloatArray(2));
        students[9]=new FullTimeStudent("Martin Scorsese", getRandomFloatArray(15), getRandomFloatArray(2));
        students[10]=new PartTimeStudent("Robert Zemeckis", getRandomFloatArray(15));
        students[11]=new PartTimeStudent("Sergio Leone", getRandomFloatArray(15));
        students[12]=new PartTimeStudent("Eli Wallach", getRandomFloatArray(15));
        students[13]=new PartTimeStudent("Lana Wachowski", getRandomFloatArray(15));
        students[14]=new PartTimeStudent("Mark Hamill", getRandomFloatArray(15));
        students[15]=new PartTimeStudent("Leslie Odom Jr.", getRandomFloatArray(15));
        students[16]=new PartTimeStudent("Alexandre Rodrigues", getRandomFloatArray(15));
        students[17]=new PartTimeStudent("Tom Hanks", getRandomFloatArray(15));
        students[18]=new PartTimeStudent("Laurence Fishburne", getRandomFloatArray(15));
        students[19]=new PartTimeStudent("Peter Brocco", getRandomFloatArray(15));

        Session session1 = new Session(students);
        session1.printListOfQuizScoresInAscendingOrder();
        session1.printNameOfPartTimeStudents();
        session1.printExamScoreOfFullTimeStudents();
    }
}



