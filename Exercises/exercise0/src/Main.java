public class Main {
    public static void main(String[] args) {
        System.out.println("==============Printing starts here================");
        System.out.println("=================  Book class   ==================");
        Book harryPotter = new Book("Harry Potter", "English");
        Book harryPotter2 = new Book("Harry Potter2","English");
        Book boneshaker = new Book("Boneshaker","English");

        System.out.println("=================  Bag class   ==================");
        Bag smallWallet= new Bag (323432, "SmallWallet");
        Bag tote= new Bag (45254, "Tote");
        Bag backpack= new Bag (2453468, "Backpack");

        System.out.println("=================  Car class   ==================");
        Car porsche911= new Car ("Porsche911","Tim") ;
        Car AstonMartin= new Car ("Aston Martin","Brando") ;
        Car Cadillac= new Car ("Cadillac","Christian") ;

        System.out.println("=================  Watch class   ==================");
        Watch TimWatch= new Watch (23525250,"Tim Robbins");
        Watch FrankWatch= new Watch (7445250,"Frank");
        Watch ChristopherWatch= new Watch (265325250,"Christopher");

        System.out.println("=================  Shampoo class   ==================");
        Shampoo LuxShampoo= new Shampoo ("Head&Shoulders");
        Shampoo BodyShop= new Shampoo ("Pantene");
        Shampoo Lush= new Shampoo ("xyz brand");

        System.out.println("=================  Bowl class   ==================");
        Bowl StonewareBowel=new Bowl ("abc brand");
        Bowl CerealBowl=new Bowl ("def brand");
        Bowl UnbreakableBowel=new Bowl ("xyz brand");

        System.out.println("=================  Cup class   ==================");
        Cup CoffeeCup= new Cup ("abc brand");
        Cup InsulatedCup= new Cup ("def brand");
        Cup PaperCap= new Cup ("ghj brand");

        System.out.println("=================  Camera class   ==================");
        Camera canon= new Camera ("Canon");
        Camera sony= new Camera ("Sony");
        Camera fuji= new Camera ("Fuji");

        System.out.println("=================  Phone class   ==================");
        Phone samsung = new Phone("Samsung");
        Phone pixel = new Phone("pixel");
        Phone Sony = new Phone("Sony");

        System.out.println("=================  Classroom class   ==================");
        Classroom classroom1 = new Classroom("class1");
        Classroom classroom2 = new Classroom("class2");
        Classroom classroom3 = new Classroom("class3");
        System.out.println("=================  Teacher (nested) class   ==================");
        Classroom.Teacher teacher1 = new Classroom.Teacher("Hua li");
        Classroom.Teacher teacher2 = new Classroom.Teacher("gong li");
        Classroom.Teacher teacher3 = new Classroom.Teacher("chu li");
        System.out.println("=================  Student (nested) class   ==================");
        Classroom.Student student1 = new Classroom.Student("Cha Li");
        Classroom.Student student2 = new Classroom.Student("Chen Chen");
        Classroom.Student student3 = new Classroom.Student("Cheng Wang");
    }
}
