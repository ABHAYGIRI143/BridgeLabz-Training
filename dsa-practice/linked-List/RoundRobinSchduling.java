
class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;

    int waitingTime = 0;
    int turnAroundTime = 0;

    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}


class RoundRobinScheduler {

    private Process head = null;
    private Process tail = null;

    // Add process at end
    void addProcess(int pid, int burstTime, int priority) {
        Process newP = new Process(pid, burstTime, priority);

        if (head == null) {
            head = tail = newP;
            newP.next = head;
        } else {
            tail.next = newP;
            newP.next = head;
            tail = newP;
        }
    }

    // Remove process by PID
    void removeProcess(int pid) {
        if (head == null) return;

        Process curr = head, prev = tail;

        do {
            if (curr.pid == pid) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } 
                else {
                    prev.next = curr.next;
                    if (curr == head) head = curr.next;
                    if (curr == tail) tail = prev;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Display circular queue
    void displayQueue() {
        if (head == null) return;

        Process temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print("[P" + temp.pid + " RT=" + temp.remainingTime + "] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Round Robin Scheduling
    void runScheduler(int timeQuantum) {

        Process curr = head;
        int time = 0;
        int totalWT = 0, totalTAT = 0;
        int count = countProcesses();

        while (head != null) {

            if (curr.remainingTime > 0) {

                if (curr.remainingTime > timeQuantum) {
                    time += timeQuantum;
                    curr.remainingTime -= timeQuantum;
                } else {
                    time += curr.remainingTime;
                    curr.remainingTime = 0;

                    curr.turnAroundTime = time;
                    curr.waitingTime = curr.turnAroundTime - curr.burstTime;

                    totalWT += curr.waitingTime;
                    totalTAT += curr.turnAroundTime;

                    int pid = curr.pid;
                    curr = curr.next;
                    removeProcess(pid);
                    displayQueue();
                    continue;
                }
            }

            curr = curr.next;
            displayQueue();
        }

        System.out.println("\nAverage Waiting Time = " + (double) totalWT / count);
        System.out.println("Average Turnaround Time = " + (double) totalTAT / count);
    }

    int countProcesses() {
        if (head == null) return 0;

        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}


public class RoundRobinSchduling {

    public static void main(String[] args) {

        RoundRobinScheduler rr = new RoundRobinScheduler();

        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 5, 2);
        rr.addProcess(3, 8, 1);
        rr.addProcess(4, 6, 3);

        System.out.println("Initial Process Queue:");
        rr.displayQueue();

        int timeQuantum = 3;
        System.out.println("\nRunning Round Robin with Time Quantum = " + timeQuantum);
        rr.runScheduler(timeQuantum);
    }
}
