import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Observer interface
interface StockObserver {
    void update(String stockSymbol, float stockValue);
}

// Concrete Observer
class StockDisplay implements StockObserver {
    private String displayId;

    public StockDisplay(String displayId) {
        this.displayId = displayId;
    }

    @Override
    public void update(String stockSymbol, float stockValue) {
        System.out.println(displayId + " - Stock Update: " + stockSymbol + " $" + stockValue);
    }
}

// Subject interface
interface StockMarket {
    void addStockObserver(StockObserver o);
    void removeStockObserver(StockObserver o);
    void notifyStockObservers(String stockSymbol, float stockValue);
}

// Concrete Subject
class StockMarketTracker implements StockMarket {
    private List<StockObserver> observers;
    private Map<String, Float> stockPrices;

    public StockMarketTracker() {
        observers = new ArrayList<>();
        stockPrices = new HashMap<>();
    }

    public void addStockObserver(StockObserver o) {
        observers.add(o);
    }

    public void removeStockObserver(StockObserver o) {
        observers.remove(o);
    }

    public void setStockPrice(String stockSymbol, float stockValue) {
        stockPrices.put(stockSymbol, stockValue);
        notifyStockObservers(stockSymbol, stockValue);
    }

    public void notifyStockObservers(String stockSymbol, float stockValue) {
        for (StockObserver observer : observers) {
            observer.update(stockSymbol, stockValue);
        }
    }
}

