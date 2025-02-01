class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinScheduling {
    private Process head;
    private Process current;
    private int timeQuantum;

    public RoundRobinScheduling(int timeQuantum) {
        this.timeQuantum = timeQuantum;
        this.head = null;
        this.current = null;
    }

    // Add a new process at the end
    public void addProcessAtEnd(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    // Remove a process by Process ID after its execution
    public void removeProcessById(int processId) {
        if (head == null) return;
        if (head.processId == processId) {
            if (head.next == head) {
                head = null;
            } else {
                Process temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
            }
            return;
        }
        Process current = head;
        while (current.next != head && current.next.processId != processId) {
            current = current.next;
        }
        if (current.next.processId == processId) {
            current.next = current.next.next;
        }
    }

    // Simulate the scheduling of processes in a round-robin manner
    public void simulateRoundRobin() {
        int currentTime = 0;
        while (head != null) {
            current = head;
            do {
                if (current.burstTime > 0) {
                    int execTime = Math.min(timeQuantum, current.burstTime);
                    System.out.println("Executing Process ID: " + current.processId + " for " + execTime + " units.");
                    current.burstTime -= execTime;
                    currentTime += execTime;
                    if (current.burstTime == 0) {
                        System.out.println("Process ID: " + current.processId + " completed at time " + currentTime + ".");
                        removeProcessById(current.processId);
                    }
                }
                current = current.next;
            } while (current != head);
            displayAllProcesses();
        }
        System.out.println("All processes have been executed.");
    }

    // Display the list of processes in the circular queue
    public void displayAllProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.println("Current processes in the queue:");
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        RoundRobinScheduling rr = new RoundRobinScheduling(3);

        rr.addProcessAtEnd(1, 10, 1);
        rr.addProcessAtEnd(2, 5, 2);
        rr.addProcessAtEnd(3, 8, 1);

        System.out.println("Initial list of processes:");
        rr.displayAllProcesses();

        System.out.println("\nSimulating Round Robin Scheduling:");
        rr.simulateRoundRobin();
    }
}
