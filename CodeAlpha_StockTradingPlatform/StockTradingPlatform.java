import java.util.HashMap;
import java.util.Scanner;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, Double> market = new HashMap<>();
        market.put("TCS", 3500.0);
        market.put("INFOSYS", 1600.0);
        market.put("RELIANCE", 2800.0);
        market.put("HDFC", 1700.0);

        HashMap<String, Integer> portfolio = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Stocks:");
                    for (String stock : market.keySet()) {
                        System.out.println(stock + " : ₹" + market.get(stock));
                    }
                    break;

                case 2:
                    System.out.print("Enter Stock Name: ");
                    String buyStock = sc.nextLine().toUpperCase();

                    if (market.containsKey(buyStock)) {
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        portfolio.put(
                                buyStock,
                                portfolio.getOrDefault(buyStock, 0) + qty);

                        System.out.println("Stock Purchased Successfully!");
                    } else {
                        System.out.println("Stock Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Stock Name: ");
                    String sellStock = sc.nextLine().toUpperCase();

                    if (portfolio.containsKey(sellStock)) {

                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        int currentQty = portfolio.get(sellStock);

                        if (qty <= currentQty) {
                            portfolio.put(sellStock, currentQty - qty);

                            if (portfolio.get(sellStock) == 0) {
                                portfolio.remove(sellStock);
                            }

                            System.out.println("Stock Sold Successfully!");
                        } else {
                            System.out.println("Not Enough Shares!");
                        }

                    } else {
                        System.out.println("You Do Not Own This Stock!");
                    }
                    break;

                case 4:

                    double totalValue = 0;

                    System.out.println("\n===== PORTFOLIO =====");

                    if (portfolio.isEmpty()) {
                        System.out.println("No Stocks Purchased Yet.");
                    } else {

                        for (String stock : portfolio.keySet()) {

                            int qty = portfolio.get(stock);
                            double value = qty * market.get(stock);

                            totalValue += value;

                            System.out.println(
                                    stock +
                                            " | Shares: " + qty +
                                            " | Value: ₹" + value);
                        }

                        System.out.println("\nTotal Portfolio Value: ₹" + totalValue);
                    }

                    break;

                case 5:
                    System.out.println("Thank You For Using Stock Trading Platform.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}