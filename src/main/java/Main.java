public class Main {
    public static void main(String[] args) {
        try {
            Knight knight = new Knight("Рицар");

            Ammunition sword1 = new Sword("Великий меч", 3, 1200);
            Ammunition sword2 = new Sword("Кинджал", 0.5, 300);
            Ammunition armor1 = new Armor("Кольчуга", 15, 2500);
            Ammunition shield1 = new Shield("Металевий шит", 2.5, 1000);

            System.out.printf("Меч 1: %s (%.2f кг, %.2f) %n", sword1.getName(), sword1.getWeight(), sword1.getPrice());
            System.out.printf("Меч 2: %s (%.2f кг, %.2f) %n", sword2.getName(), sword2.getWeight(), sword2.getPrice());
            System.out.printf("Броня: %s (%.2f кг, %.2f) %n", armor1.getName(), armor1.getWeight(), armor1.getPrice());
            System.out.printf("Щит: %s (%.2f кг, %.2f) %n", shield1.getName(), shield1.getWeight(), shield1.getPrice());

            System.out.printf("-".repeat(40) + "%n");
            System.out.printf("Ім'я рицаря: %s%n", knight.getName());
            knight.equip(sword1);
            knight.equip(sword2);
            knight.equip(armor1);
            knight.equip(shield1);
            System.out.println("Амуніція рицаря:");
            for (Ammunition item : knight.getItems()) {
                if (item != null) {
                    System.out.printf("    -%s%n", item.getName());
                }
            }

            System.out.printf("-".repeat(40) + "%n");
            System.out.printf("Загальна вартість амуніції: %.2f%n", knight.calculateTotalCost());
            System.out.println("Амуніція рицаря (сортована за вагою за зростанням):");
            knight.sortByWeight();
            for (Ammunition item : knight.getItems()) {
                if (item != null) {
                    System.out.printf("    -%s%n", item.getName());
                }
            }
            System.out.println("Знайдемо обладунки ціною від 1000 до 2000:");
            Ammunition[] foundItems = knight.findByPriceRange(1000, 2000);
            for (Ammunition item : foundItems) {
                System.out.printf("    -%s%n", item.getName());
            }
        } catch (IllegalArgumentException e) {
            System.err.printf("Помилка аргументу: %s%n", e.getMessage());
        } catch (IllegalStateException e) {
            System.err.printf("Помилка стану: %s%n", e.getMessage());
        } catch (Exception e) {
            System.err.printf("Помилка: %s%n", e.getMessage());
        }
        }
    }