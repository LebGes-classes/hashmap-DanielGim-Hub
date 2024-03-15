package Hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    private HashMap<String, Integer> map;

    @BeforeEach
    public void setUp() {
        map = new HashMap<>();
    }

    @Test
    public void testPutAndGet() {
        map.put("один", 1);
        map.put("два", 2);

        assertEquals(Integer.valueOf(1), map.get("один"));
        assertEquals(Integer.valueOf(2), map.get("два"));
    }

    @Test
    public void testContainsKey() {
        map.put("три", 3);
        map.put("четыре", 4);

        assertTrue(map.containsKey("три"));
        assertFalse(map.containsKey("пять"));
    }

    @Test
    public void testSize() {
        assertEquals(0, map.size());

        map.put("пять", 5);
        map.put("шесть", 6);

        assertEquals(2, map.size());
    }

    @Test
    public void testCollision() {
        map.put("кот", 1);
        map.put("собака", 2);

        // Проверяем, что оба ключа находятся в одном бакете
        assertTrue(map.containsKey("кот"));
        assertTrue(map.containsKey("собака"));

        // Проверяем, что значения сохраняются правильно
        assertEquals(Integer.valueOf(1), map.get("кот"));
        assertEquals(Integer.valueOf(2), map.get("собака"));
    }
}
