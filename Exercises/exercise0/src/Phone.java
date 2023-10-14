public class Phone {
    static int counter = 0;
    int id;
    String brand;
    String color;
    float length;
    float width;
    float thickness;
    String processor;
    String material;
    void SetId(int id){
        this.id = id;
    }
    void SetBrand(String brand){
        this.brand = brand;
    }
    void GetId() {
        System.out.println("This phone's id is: " + this.id);
    }
    Phone(String brand) {
        System.out.println("A new phone is created!");
        SetBrand(brand);
        SetId(++counter);
        System.out.println("This phone's id is: " + this.id);
        System.out.println("This phone's brand is: " + this.brand);
    }

}
