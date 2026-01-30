public class UserRegistration {

    public String registerUser(String username, String email, String password) {

        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username is invalid");
        }

        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Email is invalid");
        }

        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password is invalid");
        }

        return "User registered successfully";
    }
}
