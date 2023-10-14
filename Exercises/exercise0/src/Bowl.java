public class Bowl {
    static int counter = 0;
    int id;
    String brand;
    String material;
    String Style;
    String shape;
    String color;
    float price;
    float volume;
    Bowl (String brand) {
        System.out.println("A new bowl is created!");
        this.brand = brand;
        this.id = ++counter;
        System.out.println("Bowl id is: "+ this.id + " and its brand is: " + this.brand);
    }

    void SetPrice(float NewPrice){
        price=NewPrice;
    }
    void SetVolume(float NewVolume){
        volume=NewVolume;
    }
    void PrintBowl(){
        System.out.println("The Bowl Price is: "+ price);
    }
}
