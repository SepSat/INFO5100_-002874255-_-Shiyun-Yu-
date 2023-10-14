public class Car {
    private int id;
    private String name;
     String color;
    private String brand;
    private String type;
    String owner;
    int milage=0;
    String interiorColor;

    Car (String name,String owner) {
        System.out.println("A new car is created!");
        this.name = name;
        System.out.println("Car name is: "+ this.name);
        this.owner = owner;
        System.out.println("The owner is: "+ this.owner);
    }
    void SetColor(String NewColor){
        color=NewColor;
    }
    void SetInteriorColor(String NewInteriorColor){
        interiorColor=NewInteriorColor;
    }

    void PrintALLColor(){
        System.out.println("The color of the car is: "+color+"The interior color of the car is: "+interiorColor);
    }










}
