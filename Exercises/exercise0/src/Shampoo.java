public class Shampoo {
    static int counter = 0;
    String brand;
    String name;
    float volume;
    String producingArea;
    int id;
    String color;
    float price;
    String salesPlatform;
    Shampoo (String brand) {
        System.out.println("A new shampoo is created!");
        this.brand = brand;
        this.id = ++counter;
        System.out.println("Shampoo id is: "+ this.id + " and its brand is: " + this.brand);
    }
    void SetPrice(float NewPrice){
        price=NewPrice;
    }
    void SetVolume(float NewVolume){
        volume=NewVolume;
    }
    void UnitPrice(){
        System.out.println(price/volume);
    }








}
