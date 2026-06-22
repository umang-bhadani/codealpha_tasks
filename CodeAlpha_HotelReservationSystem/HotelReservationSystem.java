import java.util.HashMap;
import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<Integer, String> rooms = new HashMap<>();

        rooms.put(101, "Standard");
        rooms.put(102, "Deluxe");
        rooms.put(103, "Suite");

        HashMap<Integer, String> bookings = new HashMap<>();

        int choice;

        do {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\nAvailable Rooms:");

                    for (Integer room : rooms.keySet()) {

                        if (!bookings.containsKey(room)) {

                            System.out.println(
                                    "Room " + room +
                                            " - " + rooms.get(room));
                        }
                    }

                    break;

                case 2:

                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();
                    sc.nextLine();

                    if (rooms.containsKey(roomNo)
                            && !bookings.containsKey(roomNo)) {

                        System.out.print("Enter Customer Name: ");
                        String customer = sc.nextLine();

                        bookings.put(roomNo, customer);

                        System.out.println("\nPayment Successful!");
                        System.out.println("Room Booked Successfully!");

                    } else {
                        System.out.println("Room Not Available!");
                    }

                    break;

                case 3:

                    System.out.print("Enter Room Number to Cancel: ");
                    int cancelRoom = sc.nextInt();

                    if (bookings.containsKey(cancelRoom)) {

                        bookings.remove(cancelRoom);

                        System.out.println("Booking Cancelled Successfully!");
                    } else {
                        System.out.println("No Booking Found!");
                    }

                    break;

                case 4:

                    System.out.println("\n===== BOOKING DETAILS =====");

                    if (bookings.isEmpty()) {

                        System.out.println("No Bookings Found.");
                    } else {

                        for (Integer room : bookings.keySet()) {

                            System.out.println(
                                    "Room: " + room +
                                            " | Type: " + rooms.get(room) +
                                            " | Customer: " + bookings.get(room));
                        }
                    }

                    break;

                case 5:

                    System.out.println("Thank You For Using Hotel Reservation System.");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}