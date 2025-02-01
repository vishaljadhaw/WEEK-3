class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    private Task head;
    private Task current;

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
        } else {
            Task temp = head;
            for (int i = 0; i < position - 1; i++) {
                if (temp != null && temp.next != head) {
                    temp = temp.next;
                } else {
                    throw new IndexOutOfBoundsException("Position out of bounds");
                }
            }
            newTask.next = temp.next;
            temp.next = newTask;
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId) {
            if (head.next == head) {
                head = null;
            } else {
                Task temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
            }
            return;
        }
        Task current = head;
        while (current.next != head && current.next.taskId != taskId) {
            current = current.next;
        }
        if (current.next.taskId == taskId) {
            current.next = current.next.next;
        }
    }

    // View the current task and move to the next task
    public void viewCurrentTaskAndMoveToNext() {
        if (current == null) {
            current = head;
        }
        if (current != null) {
            System.out.println("Current Task: " + current.taskName + " (Priority: " + current.priority + ")");
            current = current.next;
        } else {
            System.out.println("No tasks available");
        }
    }

    // Display all tasks in the list starting from the head node
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + 
                               ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public Task searchTaskByPriority(int priority) {
        if (head == null) return null;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();

        ts.addTaskAtEnd(1, "Task 1", 1, "2025-01-01");
        ts.addTaskAtBeginning(2, "Task 2", 2, "2025-02-01");
        ts.addTaskAtPosition(3, "Task 3", 3, "2025-03-01", 1);

        System.out.println("All Tasks:");
        ts.displayAllTasks();

        System.out.println("\nViewing Current Task and Moving to Next:");
        ts.viewCurrentTaskAndMoveToNext();

        System.out.println("\nSearching for Task with Priority 2:");
        Task task = ts.searchTaskByPriority(2);
        if (task != null) {
            System.out.println("Found: Task ID: " + task.taskId + ", Task Name: " + task.taskName + 
                               ", Priority: " + task.priority + ", Due Date: " + task.dueDate);
        } else {
            System.out.println("Task not found");
        }

        System.out.println("\nRemoving Task with Task ID 2:");
        ts.removeTaskById(2);
        ts.displayAllTasks();
    }
}
