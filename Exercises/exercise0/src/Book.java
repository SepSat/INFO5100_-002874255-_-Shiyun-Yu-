public class Book {
    static int counter = 0;
    private int id; // an unique id for each creation
    private String name;
    String author;
    String language;
    String type;
    int pageCount;
    int publishYear;
    int price;

    Book (String name, String language) {
        System.out.println("A new book is created!");
        SetName(name);
        SetId(++counter);
        System.out.println("Book id is: "+ this.id + " and its name is: " + this.name);
    }
    void SetId (int id) {
        this.id = id;
    }
    void SetName (String name){
        this.name = name;
    }
    void SetPrice(int newValue) {
        price = newValue;
    }

}
