import java.lang.reflect.Method;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
 @interface TaskInfo {

    int priority();          // annotation field
    String assignedTo();     // annotation field
}


class TaskManager {

    @TaskInfo(priority = 1, assignedTo = "Abhay")
    public void completeTask() {
        System.out.println("Task completed");
    }
}


public class CustomAnnotation {

    public static void main(String[] args) throws Exception {

        Class<TaskManager> cls = TaskManager.class;

        Method method = cls.getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {

            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}
