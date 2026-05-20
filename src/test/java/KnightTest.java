import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    private Knight knight;
    private Ammunition sword1;
    private Ammunition sword2;


    @BeforeEach
    public void setUp() {
        knight = new Knight("Рицар");
        sword1 = new Sword("Великий меч", 3, 1200);
        sword2 = new Sword("Кинджал", 0.5, 300);
    }

    @Test
    public void testEquipAndCalculateTotalCost() {
        knight.equip(sword1);
        knight.equip(sword2);
        assertEquals(1500, knight.calculateTotalCost());
    }

    @Test
    public void testEquipThrowsExceptionWhenFull() {
        knight.equip(sword1);
        knight.equip(sword1);
        knight.equip(sword1);
        knight.equip(sword1);
        knight.equip(sword1);
        assertThrows(IllegalStateException.class, () -> {
            knight.equip(sword1);
        });
    }
}