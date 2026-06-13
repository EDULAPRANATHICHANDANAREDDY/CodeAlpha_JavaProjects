import java.util.*;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class User {
    String name;
    double balance;
    Map<String, Integer> portfolio = new HashMap<>();

    User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void buyStock(Stock stock, int qty) {
        double cost = stock.price * qty;
        if (balance >= cost) {
            balance -= cost;
            portfolio.put(stock.name, portfolio.getOrDefault(stock.name, 0) + qty);
            System.out.println("Bought " + qty + " shares of " + stock.name);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void sellStock(Stock stock, int qty) {
        int owned = portfolio.getOrDefault(stock.name, 0);
        if (owned >= qty) {
            balance += stock.price * qty;
            portfolio.put(stock.name, owned - qty);
            System.out.println("Sold " + qty + " shares of " + stock.name);
        } else {
            System.out.println("Not enough shares!");
        }
    }

    void displayPortfolio() {
        System.out.println("\nPortfolio: " + portfolio);
        System.out.println("Balance: " + balance);
    }
}

public class StockTrading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stock apple = new Stock("Apple", 150);
        Stock tesla = new Stock("Tesla", 200);

        User user = new User("Pranathi", 1000);

        System.out.println("Market Data:");
        System.out.println("1. Apple - 150");
        System.out.println("2. Tesla - 200");

        System.out.print("Enter choice (1-buy, 2-sell): ");
        int ch = sc.nextInt();

        System.out.print("Enter stock (1-Apple, 2-Tesla): ");
        int stockChoice = sc.nextInt();

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        Stock selected = (stockChoice == 1) ? apple : tesla;

        if (ch == 1)
            user.buyStock(selected, qty);
        else
            user.sellStock(selected, qty);

        user.displayPortfolio();
    }
}