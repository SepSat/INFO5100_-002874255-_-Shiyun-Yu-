public class Camera {
    static int counter = 0;
    int id;
    float price;
    String brand;
    String color;
    String type;
    int pixel;
    boolean AntiShake;
    String owner;

    Camera (String brand) {
        System.out.println("A new camera is created!");
        this.brand = brand;
        this.id = ++counter;
        System.out.println("Camera id is: "+ this.id + " and its brand is: " + this.brand);
    }
    void SetId(int NewId){
        id=NewId;
    }
    void SetPrice(float NewPrice){
        price=NewPrice;
    }
    void PrintIdPrice(){
        System.out.println(id+":"+price);
    }







}
