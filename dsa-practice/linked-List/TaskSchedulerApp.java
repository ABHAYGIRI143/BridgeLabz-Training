class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;

    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {

    private Task head = null;
    private Task current = null;

    // Add at beginning
    void addAtBeginning(int id, String name, int priority, String dueDate) {

        Task newTask = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newTask.next = head;
        temp.next = newTask;
        head = newTask;
    }

    // Add at end
    void addAtEnd(int id, String name, int priority, String dueDate) {

        Task newTask = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newTask;
        newTask.next = head;
    }

    // Add at specific position (1-based)
    void addAtPosition(int position, int id, String name, int priority, String dueDate) {

        if (position <= 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task temp = head;
        int count = 1;

        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove task by ID
    void removeTask(int taskId) {

        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Task curr = head;
        Task prev = null;

        do {
            if (curr.taskId == taskId) {

                if (curr == head) {

                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }

                    if (head == head.next) {
                        head = current = null;
                    } else {
                        last.next = head.next;
                        head = head.next;
                        current = head;
                    }
                } else {
                    prev.next = curr.next;
                }

                System.out.println("Task removed successfully");
                return;
            }

            prev = curr;
            curr = curr.next;

        } while (curr != head);

        System.out.println("Task not found");
    }

    // View current task and move to next
    void viewNextTask() {

        if (current == null) {
            System.out.println("No tasks scheduled");
            return;
        }

        System.out.println("Current Task:");
        displayTask(current);

        current = current.next;
    }

    // Display all tasks
    void displayTasks() {

        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Task temp = head;

        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    void searchByPriority(int priority) {

        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No task found with given priority");
    }

    // Helper method
    private void displayTask(Task t) {
        System.out.println("Task ID: " + t.taskId +
                ", Name: " + t.taskName +
                ", Priority: " + t.priority +
                ", Due Date: " + t.dueDate);
    }
}


public class TaskSchedulerApp {

    public static void main(String[] args) {

        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(1, "Design Module", 1, "10-02-2026");
        scheduler.addAtEnd(2, "Code Review", 2, "12-02-2026");
        scheduler.addAtBeginning(3, "Requirement Analysis", 1, "08-02-2026");
        scheduler.addAtPosition(2, 4, "Testing", 3, "15-02-2026");

        System.out.println("\n--- All Tasks ---");
        scheduler.displayTasks();

        System.out.println("\n--- View Current & Next Tasks ---");
        scheduler.viewNextTask();
        scheduler.viewNextTask();

        System.out.println("\n--- Search by Priority ---");
        scheduler.searchByPriority(1);

        System.out.println("\n--- Remove Task ---");
        scheduler.removeTask(2);

        System.out.println("\n--- Final Task List ---");
        scheduler.displayTasks();
    }
}
