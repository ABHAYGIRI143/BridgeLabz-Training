import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void testReverse() {
        assertEquals("avaJ", StringUtils.reverse("Java"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("madam"));
        assertTrue(StringUtils.isPalindrome("level"));
        assertFalse(StringUtils.isPalindrome("java"));
        assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    void testToUpperCase() {
        assertEquals("JAVA", StringUtils.toUpperCase("java"));
        assertEquals("HELLO", StringUtils.toUpperCase("Hello"));
        assertNull(StringUtils.toUpperCase(null));
    }
}
