import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    private UserRegistration userRegistration;

    @BeforeEach
    void setUp() {
        userRegistration = new UserRegistration();
    }

    // ✅ Test valid registration
    @Test
    void testValidUserRegistration() {
        String result = userRegistration.registerUser(
                "abhay",
                "abhay@example.com",
                "password123"
        );

        assertEquals("User registered successfully", result);
    }

    // ✅ Test invalid username
    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser(
                    "",
                    "abhay@example.com",
                    "password123"
            );
        });
    }

    // ✅ Test invalid email
    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser(
                    "abhay",
                    "abhay.com",  // invalid email
                    "password123"
            );
        });
    }

    // ✅ Test invalid password
    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser(
                    "abhay",
                    "abhay@example.com",
                    "123" // password too short
            );
        });
    }
}
