import java.util.Arrays;
import java.util.Comparator;

/**
 * Клас самого рицаря.
 */
public class Knight {
    private String name;
    private Ammunition[] items;
    private int itemCount;

    /**
     * Конструктор для рицаря
     *
     * @param name ім'я рицаря
     * @throws IllegalArgumentException якщо name порожній
     */
    public Knight(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ім'я лицаря не може бути порожнім");
        }
        this.name = name;
        this.items = new Ammunition[5]; // Виставимо максимальне число амуніції 5
        this.itemCount = 0; // Будемо разувати скільки амуніції у рицаря в моменті
    }

    /**
     * Додає до масиву items переданий об'єкт item
     *
     * @param item амуніція
     * @throws IllegalStateException якщо в items вже є 5 об'єктів
     */
    public void equip(Ammunition item) {
        if (itemCount == 5) {
            throw new IllegalStateException("Лицар не може мати більше 5 речей");
        }
        items[itemCount] = item;
        itemCount++;
    }

    /**
     * Рахує загальну суму price об'єктів Ammunition в масиві items
     *
     * @return загальнну суму totalCost
     */
    public double calculateTotalCost() {
        double totalCost = 0;
        for (int i = 0; i < itemCount; i++) {
            if (items[i] != null) {
                totalCost += items[i].getPrice();
            }
        }
        return totalCost;
    }

    /**
     * Сортує об'єкти Ammunition в масиві items за зростанням за атрибутом weight
     */
    public void sortByWeight() {
        if (itemCount == 0) {
            return;
        }
        Arrays.sort(items, 0, itemCount, Comparator.comparingDouble(Ammunition::getWeight));
    }

    /**
     * Знаходить амуніцію рицаря з ціною в заданих межах
     *
     * @param minPrice нижня межа ціни
     * @param maxPrice верхня межа ціни
     * @return масив result, який містить в собі об'єкти mmunition, що мають price в межах від minPrice до maxPrice
     */
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
