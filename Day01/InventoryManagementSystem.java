class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagementSystem {
    private Item head;

    // Add an item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
    }

    // Add an item at a specific position
    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (position == 0) {
            newItem.next = head;
            head = newItem;
        } else {
            Item current = head;
            for (int i = 0; i < position - 1; i++) {
                if (current != null) {
                    current = current.next;
                } else {
                    throw new IndexOutOfBoundsException("Position out of bounds");
                }
            }
            newItem.next = current.next;
            current.next = newItem;
        }
    }

    // Remove an item based on Item ID
    public void removeItemById(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Update the quantity of an item by Item ID
    public void updateItemQuantity(int itemId, int newQuantity) {
        Item item = searchItemById(itemId);
        if (item != null) {
            item.quantity = newQuantity;
        }
    }

    // Search for an item based on Item ID
    public Item searchItemById(int itemId) {
        Item current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search for an item based on Item Name
    public Item searchItemByName(String itemName) {
        Item current = head;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Calculate and display the total value of inventory
    public double calculateTotalValue() {
        double totalValue = 0;
        Item current = head;
        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }
        return totalValue;
    }

    // Sort the inventory based on Item Name in ascending order
    public void sortByName() {
        if (head == null || head.next == null) return;
        head = mergeSortByName(head);
    }

    private Item mergeSortByName(Item head) {
        if (head == null || head.next == null) {
            return head;
        }
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSortByName(head);
        Item right = mergeSortByName(nextOfMiddle);
        return sortedMergeByName(left, right);
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Item sortedMergeByName(Item left, Item right) {
        if (left == null) return right;
        if (right == null) return left;
        Item result;
        if (left.itemName.compareToIgnoreCase(right.itemName) <= 0) {
            result = left;
            result.next = sortedMergeByName(left.next, right);
        } else {
            result = right;
            result.next = sortedMergeByName(left, right.next);
        }
        return result;
    }

    // Display all items
    public void displayAllItems() {
        Item current = head;
        while (current != null) {
            System.out.println("Item Name: " + current.itemName + ", Item ID: " + current.itemId + 
                               ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        
        ims.addItemAtEnd("Item1", 1, 10, 100.0);
        ims.addItemAtBeginning("Item2", 2, 20, 200.0);
        ims.addItemAtPosition("Item3", 3, 15, 150.0, 1);

        System.out.println("All Items:");
        ims.displayAllItems();

        System.out.println("\nUpdating Quantity for Item ID 2:");
        ims.updateItemQuantity(2, 30);
        ims.displayAllItems();

        System.out.println("\nSearching for Item with ID 3:");
        Item item = ims.searchItemById(3);
        if (item != null) {
            System.out.println("Found: Item Name: " + item.itemName + ", Item ID: " + item.itemId + 
                               ", Quantity: " + item.quantity + ", Price: " + item.price);
        } else {
            System.out.println("Item not found");
        }

        System.out.println("\nTotal Value of Inventory:");
        double totalValue = ims.calculateTotalValue();
        System.out.println("Total Value: " + totalValue);

        System.out.println("\nSorting Inventory by Item Name:");
        ims.sortByName();
        ims.displayAllItems();

        System.out.println("\nRemoving Item with ID 1:");
        ims.removeItemById(1);
        ims.displayAllItems();
    }
}
