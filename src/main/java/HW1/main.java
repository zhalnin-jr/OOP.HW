package HW1;
class NameDrink {
    public String name;
    public int value;

    public NameDrink(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void drink() {
        System.out.println("Вы пьете " + name +" объемом в " + value +"мл");
    }

}
class DrinkTemp extends NameDrink {
    private int temp;
    public DrinkTemp(String name, int value, int temp) {
        super(name, value);
        this.temp = temp;

    }

    public void drink() {
        System.out.println("Вы пьете " + name + " при температуре " + temp + " градусов");
    }
}
class HotDrinkMachine  {
    public void getProduct(int name, int value) {
        switch (name) {
            case 1:
                NameDrink tea = new NameDrink("Чай", value);
                tea.drink();
                break;
            case 2:
                NameDrink coffee = new NameDrink("Кофе", value);
                coffee.drink();
                break;
            case 3:
                NameDrink juice = new NameDrink("Сок яблочный", value);
                juice.drink();
                break;
        }
    }

    public void getProduct(int name, int volume, int temperature) {
        switch (name) {
            case 1:
                DrinkTemp tea = new DrinkTemp("Чай", volume, temperature);
                tea.drink();
                break;
            case 2:
                DrinkTemp coffee = new DrinkTemp("Кофе", volume, temperature);
                coffee.drink();
                break;
            case 3:
                DrinkTemp coffee1 = new DrinkTemp("Капучино", volume,temperature);
                coffee1.drink();
                break;
        }
    }
}


public class main {
    public static void main(String[] args) {
        HotDrinkMachine machine = new HotDrinkMachine();

        machine.getProduct(1, 250);
        machine.getProduct(2, 350);

        machine.getProduct(1, 250, 80);
        machine.getProduct(2, 350, 90);
        machine.getProduct(3, 500);
        machine.getProduct(3,330,70);
    }
}