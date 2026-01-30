import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListManagerTest {


    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
    	ListManager.addElement(list, 10);
    	ListManager.addElement(list, 20);

        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertEquals(2, ListManager.getSize(list));
    }

    @Test
    void testRemoveElement() {
        list.add(10);
        list.add(20);

        ListManager.removeElement(list, 10);

        assertFalse(list.contains(10));
        assertEquals(1, ListManager.getSize(list));
    }

    @Test
    void testGetSize() {
        assertEquals(0, ListManager.getSize(list));

        ListManager.addElement(list, 5);
        ListManager.addElement(list, 15);

        assertEquals(2, ListManager.getSize(list));
    }
}
