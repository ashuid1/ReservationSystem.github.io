
    import java.util.Scanner;

    public class ReservationSystem {

        private static int[][] seats = new int[10][10]; // seats array to keep track of availability
        private static Scanner scanner = new Scanner(System.in);
        static String name;
        static String pass;

        public static void main(String[] args) {

            boolean isLoggedIn = false;
            String username = "";
            String password = "";


            System.out.println("WElcome to Reservation System");
            System.out.println("Enter your username : ");
            name = scanner.nextLine();
            System.out.println("Enter your password : ");
            pass = scanner.nextLine();
            System.out.println("Succesfully created your account");

            while (!isLoggedIn) {
                System.out.print("Enter username: ");
                username = scanner.nextLine();
                System.out.print("Enter password: ");
                password = scanner.nextLine();
                if (authenticate(name, pass)) {
                    isLoggedIn = true;
                } else {
                    System.out.println("Incorrect username or password.");
                }
            }

            boolean isRunning = true;

            while (isRunning) {
                System.out.println("1. Check availability");
                System.out.println("2. Reserve a seat");
                System.out.println("3. Cancel a reservation");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkAvailability();
                        break;
                    case 2:
                        reserveSeat();
                        break;
                    case 3:
                        cancelReservation();
                        break;
                    case 4:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        }


        private static boolean authenticate(String username, String password) {
            // authentication logic goes here
            return username.equals(name) && password.equals(pass);
        }

        private static void checkAvailability() {

            System.out.println("Available seats:");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (seats[i][j] == 0) {
                        System.out.print("[" + (i+1) + "," + (j+1) + "] ");
                    }
                }
            }
            System.out.println();
        }

        private static void reserveSeat() {

            System.out.print("Enter row number: ");
            int row = scanner.nextInt() - 1;
            System.out.print("Enter seat number: ");
            int seat = scanner.nextInt() - 1;

            if (row < 0 || row >= 10 || seat < 0 || seat >= 10) {
                System.out.println("Invalid seat.");
            } else if (seats[row][seat] == 1) {
                System.out.println("Seat is already reserved.");
            } else {
                seats[row][seat] = 1;
                System.out.println("Seat reserved.");
            }
        }

        private static void cancelReservation() {

            System.out.print("Enter row number: ");
            int row = scanner.nextInt() - 1;
            System.out.print("Enter seat number: ");
            int seat = scanner.nextInt() - 1;

            if (row < 0 || row >= 10 || seat < 0 || seat >= 10) {
                System.out.println("Invalid seat.");
            } else if (seats[row][seat] == 0) {
                System.out.println("Seat is not reserved.");
            } else {
                seats[row][seat] = 0;
                System.out.println("Reservation cancelled.");
            }
        }
    }


