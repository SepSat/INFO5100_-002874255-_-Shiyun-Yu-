public class Main {
    public static void main(String[] args) {
        // Demonstrate Singleton design pattern.
        singleton();
        // Demonstrate Observer design pattern.
        observer();
        // Demonstrate Factory design pattern.
        factory();
    }

    private static void singleton(){
        AppSettingsSingleton settings = AppSettingsSingleton.getInstance();

        System.out.println("Current theme: " + settings.getSetting("theme"));
        System.out.println("Current language: " + settings.getSetting("language"));

        // Change a setting
        settings.setSetting("theme", "Dark");
        System.out.println("New theme: " + settings.getSetting("theme"));
    }
    private static void observer(){
        StockMarketTracker marketTracker = new StockMarketTracker();

        StockDisplay display1 = new StockDisplay("Observer 1");
        StockDisplay display2 = new StockDisplay("Observer 2");

        marketTracker.addStockObserver(display1);
        marketTracker.addStockObserver(display2);

        // Simulating stock price changes
        marketTracker.setStockPrice("AAPL", 150.5f);
        marketTracker.setStockPrice("MSFT", 250.75f);
    }

    private static void factory(){
        VehicleFactory factory = new VehicleFactory();

        Vehicle myCar = factory.getVehicle("CAR");
        myCar.startEngine();

        Vehicle myMotorbike = factory.getVehicle("MOTORBIKE");
        myMotorbike.startEngine();
    }
}
