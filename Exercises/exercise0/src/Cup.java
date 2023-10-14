public class Cup {
    static int counter = 0;
    int id;
    float price;
    String brand;
    String color;
    String material;
    float volume;
    Boolean straw;
    String style;

    Cup (String brand) {
        System.out.println("A new cup is created!");
        this.brand = brand;
        this.id = ++counter;
        System.out.println("Cup id is: "+ this.id + " and its brand is: " + this.brand);
    }

    void SetStyle(String NewStyle){
        style=NewStyle;
    }
    void SetVolume(float NewVolume){
        volume=NewVolume;
    }
    void PrintStyle(){
        System.out.println("The cup's style is: "+ style);
    }








}
