

class VehicleNode {
    String vehicleNumber;
    VehicleNode next;

    VehicleNode(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.next = null;
    }
}

class Roundabout {
    private VehicleNode head = null;

    // Add vehicle to roundabout
    public void addVehicle(String vehicleNumber) {
        VehicleNode newNode = new VehicleNode(vehicleNumber);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        VehicleNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    // Remove a vehicle
    public void removeVehicle(String vehicleNumber) {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        VehicleNode curr = head, prev = null;

        do {
            if (curr.vehicleNumber.equals(vehicleNumber)) {

                if (curr == head && curr.next == head) {
                    head = null;
                } else {
                    if (curr == head) {
                        head = head.next;
                    }
                    if (prev != null) {
                        prev.next = curr.next;
                    } else {
                        VehicleNode temp = head;
                        while (temp.next != curr) {
                            temp = temp.next;
                        }
                        temp.next = curr.next;
                    }
                }
                System.out.println("Vehicle removed: " + vehicleNumber);
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Vehicle not found");
    }

    // Print roundabout state
    public void printRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        VehicleNode temp = head;
        System.out.print("Roundabout: ");
        do {
            System.out.print(temp.vehicleNumber + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }
}


class VehicleQueue {
    private String[] queue;
    private int front = 0, rear = -1, size = 0;
    private int capacity;

    VehicleQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
    }

    public void enqueue(String vehicleNumber) {
        if (size == capacity) {
            throw new RuntimeException("Queue Overflow: Waiting lane full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = vehicleNumber;
        size++;
    }

    public String dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue Underflow: No vehicles waiting");
        }
        String vehicle = queue[front];
        front = (front + 1) % capacity;
        size--;
        return vehicle;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}


public class TrafficManager {

    public static void main(String[] args) {

        Roundabout roundabout = new Roundabout();
        VehicleQueue waitingQueue = new VehicleQueue(3);

        // Vehicles arriving
        waitingQueue.enqueue("CAR-101");
        waitingQueue.enqueue("CAR-102");
        waitingQueue.enqueue("CAR-103");

        // Move vehicles from queue to roundabout
        while (!waitingQueue.isEmpty()) {
            roundabout.addVehicle(waitingQueue.dequeue());
        }

        roundabout.printRoundabout();

        // Remove vehicle
        roundabout.removeVehicle("CAR-102");
        roundabout.printRoundabout();

        // Overflow example
        try {
            waitingQueue.enqueue("CAR-104");
            waitingQueue.enqueue("CAR-105");
            waitingQueue.enqueue("CAR-106");
            waitingQueue.enqueue("CAR-107"); // overflow
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}




