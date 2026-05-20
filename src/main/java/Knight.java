import java.util.Arrays;
import java.util.Comparator;


public class Knight {
    private String name;
    private Ammunition[] items;
    private int itemCount;

    public Knight(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ім'я лицаря не може бути порожнім");
        }
        this.name = name;
        this.items = new Ammunition[5];
        this.itemCount = 0;
    }

    public void equip(Ammunition item) {
        if (itemCount == 5) {
            throw new IllegalStateException("Лицар не може мати більше 5 речей");
        }
        items[itemCount] = item;
        itemCount++;
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (int i = 0; i < itemCount; i++) {
            totalCost += items[i].getPrice();
        }
        return totalCost;
    }

    public void sortByWeight() {
        if (itemCount == 0) {
            return;
        }
        Arrays.sort(items, 0, itemCount, Comparator.comparingDouble(Ammunition::getWeight));
    }

    public Ammunition[] findByPriceRange(double minPrice, double maxPrice) {
        if (minPrice < 0 || maxPrice < 0) {
            throw new IllegalArgumentException("Межі ціни повинні бути більше 0");
        }
        if (minPrice > maxPrice) {
            throw new IllegalArgumentException("Мінімальна ціна повинна бути меншою за макимальну");
        }

        int matches = 0;
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getPrice() >= minPrice && items[i].getPrice() <= maxPrice) {
                matches++;
            }
        }
        Ammunition[] result = new Ammunition[matches];
        int index = 0;
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getPrice() >= minPrice && items[i].getPrice() <= maxPrice) {
                result[index++] = items[i];
            }
        }
        return result;
    }

    public Ammunition[] getItems() {
        return items;
    }

    public String getName() {
        return name;
    }
}
