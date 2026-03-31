import java.util.LinkedList;
import java.util.Queue;

// ================= Vehicle Node =================
class Vehicle {
    String number;
    Vehicle next;

    Vehicle(String number) {
        this.number = number;
        this.next = null;
    }
}

// ================= Circular Linked List =================
class Roundabout {

    private Vehicle head = null;
    private Vehicle tail = null;

    // Add vehicle into circular path
    public void addVehicle(String number) {
        Vehicle newCar = new Vehicle(number);

        if (head == null) {
            head = newCar;
            tail = newCar;
            newCar.next = head;   // circular link
        } else {
            tail.next = newCar;
            tail = newCar;
            tail.next = head;
        }

        System.out.println(number + " entered the roundabout.");
    }

    // Remove vehicle (exit)
    public void removeVehicle() {
        if (head == null) {
            System.out.println("No vehicles in roundabout.");
            return;
        }

        System.out.println(head.number + " exited the roundabout.");

        if (head == tail) { // only one vehicle
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    // Print roundabout state
    public void display() {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        System.out.print("Roundabout: ");
        Vehicle temp = head;

        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to " + head.number + ")");
    }
}

// ================= Traffic Manager =================
public class TrafficManager {

    static final int MAX_QUEUE_SIZE = 5;

    public static void main(String[] args) {

        Roundabout roundabout = new Roundabout();
        Queue<String> waitingQueue = new LinkedList<>();

        // Vehicles arriving
        enqueue(waitingQueue, "CAR101");
        enqueue(waitingQueue, "CAR102");
        enqueue(waitingQueue, "CAR103");
        enqueue(waitingQueue, "CAR104");
        enqueue(waitingQueue, "CAR105");
        enqueue(waitingQueue, "CAR106");   // overflow

        // Move some vehicles into roundabout
        moveToRoundabout(waitingQueue, roundabout);
        moveToRoundabout(waitingQueue, roundabout);
        moveToRoundabout(waitingQueue, roundabout);

        roundabout.display();

        // Vehicle exits
        roundabout.removeVehicle();
        roundabout.display();

        // More vehicles enter
        moveToRoundabout(waitingQueue, roundabout);
        moveToRoundabout(waitingQueue, roundabout);

        roundabout.display();
    }

    // ================= Queue Handling =================

    static void enqueue(Queue<String> q, String car) {
        if (q.size() == MAX_QUEUE_SIZE) {
            System.out.println("Queue Overflow! " + car + " must wait outside.");
        } else {
            q.add(car);
            System.out.println(car + " added to waiting queue.");
        }
    }

    static void moveToRoundabout(Queue<String> q, Roundabout r) {
        if (q.isEmpty()) {
            System.out.println("Queue Underflow! No cars waiting.");
        } else {
            String car = q.poll();
            r.addVehicle(car);
        }
    }
}
