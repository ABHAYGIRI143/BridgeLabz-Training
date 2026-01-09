
class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}


class TextEditor {

    private TextState head;      // Oldest state
    private TextState tail;      // Latest state
    private TextState current;   // Current state
    private int size = 0;
    private final int MAX = 10;  // history limit

    // Add new text state
    void type(String newText) {
        TextState newNode = new TextState(newText);

        // If we typed after undo, delete redo history
        if (current != null && current.next != null) {
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = newNode;
        }

        size++;

        // Remove oldest state if limit exceeded
        if (size > MAX) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo operation
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo possible");
        }
    }

    // Redo operation
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo possible");
        }
    }

    // Display current state
    void show() {
        if (current != null)
            System.out.println("Current Text: " + current.content);
        else
            System.out.println("Editor empty");
    }

    // Display full history
    void showHistory() {
        TextState temp = head;
        System.out.print("History: ");
        while (temp != null) {
            if (temp == current)
                System.out.print("[" + temp.content + "] ");
            else
                System.out.print(temp.content + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}


public class UndoRedoEditor {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.type("Hello");
        editor.type("Hello World");
        editor.type("Hello World!");
        editor.type("Hello World!!");

        editor.show();
        editor.showHistory();

        editor.undo();
        editor.show();

        editor.undo();
        editor.show();

        editor.redo();
        editor.show();

        editor.type("Hello Java");
        editor.showHistory();
    }
}
