import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // Class-level annotation
@interface RoleAllowed {

    String value(); // Allowed role (e.g., ADMIN)
}

class UserContext {

    private static String currentRole;

    public static void setRole(String role) {
        currentRole = role;
    }

    public static String getRole() {
        return currentRole;
    }
}

@RoleAllowed("ADMIN")
class AdminService {

    public void deleteUser() {
        System.out.println("User deleted successfully.");
    }
}

 class SecurityManager {

    public static void invoke(Object obj, String methodName) {

        Class<?> cls = obj.getClass();

        // Check class-level annotation
        if (cls.isAnnotationPresent(RoleAllowed.class)) {

            RoleAllowed roleAllowed = cls.getAnnotation(RoleAllowed.class);
            String allowedRole = roleAllowed.value();

            String currentRole = UserContext.getRole();

            if (!allowedRole.equals(currentRole)) {
                System.out.println("Access Denied!");
                return;
            }
        }

        // Invoke method if allowed
        try {
            cls.getMethod(methodName).invoke(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class RoleALlowedAnnotation{

    public static void main(String[] args) {

        AdminService service = new AdminService();

        // Case 1: USER role
        UserContext.setRole("USER");
        SecurityManager.invoke(service, "deleteUser");

        // Case 2: ADMIN role
        UserContext.setRole("ADMIN");
        SecurityManager.invoke(service, "deleteUser");
    }
}
