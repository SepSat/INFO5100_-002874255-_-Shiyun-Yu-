public class Watch {
    int id;
    String color;
    String type;
    String material;
    int size;
    String brand;
    int price=300;
    String owner;
    Watch (int id,String owner) {
        System.out.println("A new watch is created!");
        this.id = id;
        System.out.println("The watch id is: "+ this.id);
        this.owner = owner;
        System.out.println("The owner is: "+ this.owner);
    }
    void SetType(String NewType){
        type=NewType;
    }
    void SetSize(int NewSize){
        size=NewSize;
        if (size==38){
            price-=100;
        }
        if (size==40){
            price+=100;
        }
    }
    void PrintPrice(){
        System.out.println(price);
    }


}
