public class Bag {
    int itemNumber;
    String name;
    int saleNumber;
    int price;
    String color;
    String mainMaterial;
    String designer;
    String type;


    Bag (int itemNumber,String name) {
        System.out.println("A new bag is created!");
        this.itemNumber = itemNumber;
        System.out.println("Bag ItemNumber is: "+ this.itemNumber);
        this.name = name;
        System.out.println("Bag name is: "+ this.name);
    }


    void GetOrder(int newValue){
        saleNumber+=newValue;
    }
    void PrintSaleNumber(){
        System.out.println(saleNumber);
    }
    void SetPrice(int newValue){
        price+=newValue;
    }

}
