package HW6;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Введите заказ:");
        Order order = createOrderFromConsole();
        order.saveToJson();
    }

    public static Order createOrderFromConsole() {
        String clientName = prompt("Client name: ");
        String product = prompt("Product: ");
        int qnt = Integer.parseInt(prompt("Quantity: "));
        int price = Integer.parseInt(prompt("Price: "));

        return new Order(clientName, product, qnt, price);
    }

    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
