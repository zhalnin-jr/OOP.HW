package HW2;

import java.util.ArrayList;
import java.util.List;

interface QueueBehaviour {
    boolean isEmpty();

    int size();

    void enqueue(Object item);

    Object dequeue();
}

interface MarketBehaviour {
    void addCustomer(Person person);

    void removeCustomer(Person person);

    List<Person> getCustomerQueue();
}

abstract class Market implements QueueBehaviour, MarketBehaviour {
    protected List<Person> customerQueue = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return customerQueue.isEmpty();
    }

    @Override
    public int size() {
        return customerQueue.size();
    }

    @Override
    public void enqueue(Object item) {
        customerQueue.add((Person) item);
    }

    @Override
    public Object dequeue() {
        if (!customerQueue.isEmpty()) {
            return customerQueue.remove(0);
        }
        return null;
    }

    @Override
    public void addCustomer(Person person) {
        enqueue(person);
    }

    @Override
    public void removeCustomer(Person person) {
        customerQueue.remove(person);
    }

    @Override
    public List<Person> getCustomerQueue() {
        return customerQueue;
    }

    public abstract void update();
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Supermarket extends Market {
    private List<String> orders = new ArrayList<>();

    public void addOrder(String order) {
        orders.add(order);
    }

    public void removeOrder(String order) {
        orders.remove(order);
    }

    @Override
    public void update() {
        if (!isEmpty()) {
            Person person = (Person) dequeue();
            String order = orders.get(0);
            System.out.println("Клиент: " + person.getName() +" заказал "+ " - " + order);
            orders.remove(0);
        } else {
            System.out.println("В очереди нет клиентов.");
        }
    }
    public void printAllOrders() {
        int count = 1;
        for (String order : orders) {
            System.out.println("Заказ №"+ count +": "+ order);
            count++;
        }
    }
    public void getOrdersCount() {
        int countOrders=0;
        countOrders = orders.size();
        System.out.println("Заказов всего: "+ countOrders);
    }
}

public class Main {
    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();

        supermarket.addCustomer(new Person("Алиса"));
        supermarket.addOrder("Пончики");

        supermarket.addCustomer(new Person("Никита"));
        supermarket.addOrder("Хлеб");

        supermarket.addCustomer(new Person("Игорь"));
        supermarket.addOrder("Булочка с маком");
        supermarket.getOrdersCount();
        supermarket.printAllOrders();

        supermarket.update();
        supermarket.update();
        supermarket.update();
        supermarket.update();

    }
}
