


class StageNode {
    String stage;
    StageNode next;

    StageNode(String stage) {
        this.stage = stage;
        this.next = null;
    }
}


class ParcelTracker {

    private StageNode head;

    // Add stage at end
    public void addStage(String stage) {
        StageNode newNode = new StageNode(stage);

        if (head == null) {
            head = newNode;
            return;
        }

        StageNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add custom checkpoint after a given stage
    public void addCheckpointAfter(String existingStage, String newStage) {
        StageNode temp = head;

        while (temp != null && !temp.stage.equals(existingStage)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Stage not found. Parcel may be lost.");
            return;
        }

        StageNode newNode = new StageNode(newStage);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Forward tracking
    public void trackParcel() {
        if (head == null) {
            System.out.println("No tracking data available.");
            return;
        }

        StageNode temp = head;
        while (temp != null) {
            System.out.print(temp.stage);
            if (temp.next != null) {
                System.out.print(" → ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    // Handle lost parcel (break chain)
    public void markParcelLostAfter(String stage) {
        StageNode temp = head;

        while (temp != null && !temp.stage.equals(stage)) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.next = null; // Lost parcel
            System.out.println("Parcel lost after stage: " + stage);
        }
    }
}


public class ParcelApp {

    public static void main(String[] args) {

        ParcelTracker tracker = new ParcelTracker();

        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        tracker.trackParcel();

        tracker.addCheckpointAfter("Shipped", "Customs Check");
        tracker.trackParcel();

        tracker.markParcelLostAfter("In Transit");
        tracker.trackParcel();
    }
}
