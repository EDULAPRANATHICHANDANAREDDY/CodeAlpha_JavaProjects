import java.util.*;

class Room {
    int roomNumber;
    String type;
    boolean isBooked;

    Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
    }
}

public class HotelReservationSystem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));

        System.out.println("Available Rooms:");
        for (Room r : rooms) {
            if (!r.isBooked)
                System.out.println(r.roomNumber + " - " + r.type);
        }

        System.out.print("Enter room number to book: ");
        int roomNo = sc.nextInt();

        boolean found = false;

        for (Room r : rooms) {
            if (r.roomNumber == roomNo && !r.isBooked) {
                r.isBooked = true;
                found = true;
                System.out.println("Room booked successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Room not available!");
        }

        System.out.print("Do you want to cancel? (yes/no): ");
        String cancel = sc.next();

        if (cancel.equalsIgnoreCase("yes")) {
            System.out.print("Enter room number to cancel: ");
            int cancelRoom = sc.nextInt();

            for (Room r : rooms) {
                if (r.roomNumber == cancelRoom && r.isBooked) {
                    r.isBooked = false;
                    System.out.println("Booking cancelled!");
                }
            }
        }

        System.out.println("\nFinal Room Status:");
        for (Room r : rooms) {
            System.out.println(r.roomNumber + " - " + r.type + " - " + (r.isBooked ? "Booked" : "Available"));
        }
    }
}