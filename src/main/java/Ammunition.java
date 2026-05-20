public class Ammunition {
    private String name;
    private double weight;
    private double price;

    public Ammunition(String name, double weight, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва амуніції не може бути порожньою");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Вага амуніції повинна бути більшою за 0");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цінна амуніції повинна бути за 0");
        }
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    public double getPrice() {
        return price;
    }
}
