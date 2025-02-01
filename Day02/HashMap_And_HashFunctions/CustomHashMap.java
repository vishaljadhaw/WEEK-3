import java.util.*;

class CustomHashMap {
    
    // Node class to represent each key-value pair
    static class Node {
        int key;
        int value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    // Array of linked lists (buckets) for separate chaining
    private Node[] table;
    private int size;
    
    // Constructor to initialize the hash map with a default size
    public CustomHashMap(int capacity) {
        this.size = capacity;
        this.table = new Node[size];
    }
    
    // Hash function to compute index for a given key
    private int hash(int key) {
        return key % size;
    }
    
    // Insert key-value pair into the hash map
    public void put(int key, int value) {
        int index = hash(key);
        
        // If there's no node at the index, create a new one
        if (table[index] == null) {
            table[index] = new Node(key, value);
            return;
        }
        
        // Handle collisions using separate chaining (linked list)
        Node current = table[index];
        while (current != null) {
            if (current.key == key) {
                current.value = value; // Update value if key exists
                return;
            }
            current = current.next;
        }
        
        // If key does not exist, insert at the head of the list
        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }
    
    // Retrieve value associated with the key
    public int get(int key) {
        int index = hash(key);
        
        // Traverse the linked list at the computed index
        Node current = table[index];
        while (current != null) {
            if (current.key == key) {
                return current.value; // Return value if key is found
            }
            current = current.next;
        }
        
        return -1; // Return -1 if key is not found
    }
    
    // Delete key-value pair from the hash map
    public void remove(int key) {
        int index = hash(key);
        
        // If there's no node at the index, nothing to remove
        if (table[index] == null) {
            return;
        }
        
        // If the first node has the key, remove it
        if (table[index].key == key) {
            table[index] = table[index].next;
            return;
        }
        
        // Traverse the linked list and remove the node with the matching key
        Node current = table[index];
        while (current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next; // Remove node
                return;
            }
            current = current.next;
        }
    }
    
    // Function to print the hash map for testing purposes
    public void print() {
        for (int i = 0; i < size; i++) {
            Node current = table[i];
            if (current != null) {
                System.out.print("Index " + i + ": ");
                while (current != null) {
                    System.out.print("[" + current.key + "=" + current.value + "] ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        // Create a hash map with 10 buckets
        CustomHashMap map = new CustomHashMap(10);
        
        // Test put, get, and remove operations
        map.put(1, 100);
        map.put(2, 200);
        map.put(12, 300);
        map.put(15, 400);
        
        System.out.println("Value for key 1: " + map.get(1));  // Output: 100
        System.out.println("Value for key 12: " + map.get(12)); // Output: 300
        
        // Remove a key and test again
        map.remove(2);
        System.out.println("Value for key 2: " + map.get(2));  // Output: -1 (not found)
        
        // Print the hash map for verification
        map.print();
    }
}
