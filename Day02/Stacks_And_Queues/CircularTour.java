import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {
    
    // Function to find the starting point for completing the circular tour
    public static int getStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        
        // Create a queue to simulate the circular tour
        Queue<Integer> queue = new LinkedList<>();
        
        // Track the total surplus petrol
        int totalSurplus = 0;
        int currentSurplus = 0;
        int startIndex = 0;

        // Simulate the tour using the queue
        for (int i = 0; i < n; i++) {
            int surplusAtPump = petrol[i] - distance[i];
            
            // Add the surplus at the current pump to the queue
            queue.add(surplusAtPump);
            totalSurplus += surplusAtPump;
            
            // Update the current surplus
            currentSurplus += surplusAtPump;

            // If the current surplus becomes negative, we can't complete the tour from here
            if (currentSurplus < 0) {
                // Remove the first pump from the queue and move the starting point
                queue.poll();
                startIndex = i + 1;
                currentSurplus = 0;  // Reset the current surplus for the next attempt
            }
        }
        
        // If total surplus is negative, it's impossible to complete the circular tour
        return totalSurplus >= 0 ? startIndex : -1;
    }

    public static void main(String[] args) {
        // Test case: petrol at each pump and the distance to the next pump
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        
        // Find the starting point for the circular tour
        int start = getStartingPoint(petrol, distance);
        
        if (start != -1) {
            System.out.println("The circular tour can start at pump " + start);
        } else {
            System.out.println("It is not possible to complete the circular tour.");
        }
    }
}
