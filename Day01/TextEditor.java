class TextState {
    String content;
    TextState next;
    TextState prev;

    public TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

public class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int maxSize;
    private int size;

    public TextEditor(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    // Add a new text state at the end of the list
    public void addTextState(String content) {
        TextState newState = new TextState(content);
        if (head == null) {
            head = tail = current = newState;
        } else {
            newState.prev = tail;
            tail.next = newState;
            tail = newState;
            current = newState;
        }
        size++;
        if (size > maxSize) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Implement the undo functionality
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    // Implement the redo functionality
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No text available");
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);

        // Simulate typing actions
        editor.addTextState("Hello");
        editor.addTextState("Hello World");
        editor.addTextState("Hello World!");

        // Display current state
        editor.displayCurrentState();  // Output: Hello World!

        // Perform undo operations
        editor.undo();
        editor.displayCurrentState();  // Output: Hello World

        editor.undo();
        editor.displayCurrentState();  // Output: Hello

        // Perform redo operations
        editor.redo();
        editor.displayCurrentState();  // Output: Hello World

        editor.redo();
        editor.displayCurrentState();  // Output: Hello World!
    }
}
