class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    private Ticket head;

    // Add a new ticket reservation at the end
    public void addTicketAtEnd(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    // Remove a ticket by Ticket ID
    public void removeTicketById(int ticketId) {
        if (head == null) return;
        if (head.ticketId == ticketId) {
            if (head.next == head) {
                head = null;
            } else {
                Ticket temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
            }
            return;
        }
        Ticket current = head;
        while (current.next != head && current.next.ticketId != ticketId) {
            current = current.next;
        }
        if (current.next != null && current.next.ticketId == ticketId) {
            current.next = current.next.next;
        }
    }

    // Display the current tickets in the list
    public void displayAllTickets() {
        if (head == null) {
            System.out.println("No tickets available");
            return;
        }
        Ticket temp = head;
        System.out.println("Current tickets in the list:");
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName + 
                               ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber + 
                               ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name
    public Ticket searchTicketByCustomerName(String customerName) {
        if (head == null) return null;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    // Search for a ticket by Movie Name
    public Ticket searchTicketByMovieName(String movieName) {
        if (head == null) return null;
        Ticket temp = head;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    // Calculate the total number of booked tickets
    public int countTotalTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public static void main(String[] args) {
        TicketReservationSystem trs = new TicketReservationSystem();
        
        // Adding tickets
        trs.addTicketAtEnd(1, "Alice", "Inception", "A1", "10:00 AM");
        trs.addTicketAtEnd(2, "Bob", "Interstellar", "B2", "11:00 AM");
        trs.addTicketAtEnd(3, "Charlie", "Dunkirk", "C3", "12:00 PM");

        // Display all tickets
        trs.displayAllTickets();

        // Search for a ticket by customer name
        Ticket ticket = trs.searchTicketByCustomerName("Bob");
        if (ticket != null) {
            System.out.println("\nFound ticket for Bob: Ticket ID: " + ticket.ticketId + 
                               ", Movie Name: " + ticket.movieName + ", Seat Number: " + ticket.seatNumber + 
                               ", Booking Time: " + ticket.bookingTime);
        } else {
            System.out.println("\nTicket for Bob not found");
        }

        // Count total tickets
        int totalTickets = trs.countTotalTickets();
        System.out.println("\nTotal number of booked tickets: " + totalTickets);

        // Remove a ticket by Ticket ID
        trs.removeTicketById(2);

        // Display all tickets after removal
        trs.displayAllTickets();
    }
}
