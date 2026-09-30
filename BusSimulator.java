import java.util.Scanner;

public class BusSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Enter Data
        System.out.print("Enter the number of stops on the route: ");
        int numStops = scanner.nextInt();
        scanner.nextLine();

        String[] stopNames = new String[numStops];
        int[] passengersBoarding = new int[numStops];
        int[] passengersAlighting = new int[numStops];
        int[] currentOccupancy = new int[numStops];

        System.out.print("Enter the seating capacity of the bus: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        int currentPassengersDuringInput = 0;

        for (int i = 0; i < numStops; i++) {
            System.out.println("\n--- Stop " + (i + 1) + " ---");
            System.out.print("Stop name: ");
            stopNames[i] = scanner.nextLine();

            System.out.print("Passengers boarding: ");
            passengersBoarding[i] = scanner.nextInt();

            currentPassengersDuringInput += passengersBoarding[i];

            // While döngüsü ve ödevdeki hata mesajının birleşimi
            while (true) {
                System.out.print("Passengers alighting (getting off): ");
                int alighting = scanner.nextInt();

                if (alighting > currentPassengersDuringInput) {
                    System.out.println("Data error at [" + stopNames[i] + "]: cannot have more passengers alighting than are currently on the bus.");
                    System.out.println("Currently " + currentPassengersDuringInput + " passengers on board. Please enter a valid number.");
                } else {
                    passengersAlighting[i] = alighting;
                    currentPassengersDuringInput -= alighting;
                    break;
                }
            }
            scanner.nextLine();
        }

        System.out.println("\n===========================================");
        System.out.println("ROUTE SIMULATION");
        System.out.println("===========================================\n");

        // 2 & 3. Occupancy Calculation & Capacity Check
        int currentPassengers = 0;
        int overCapacityCount = 0;

        int maxBoarding = -1;
        String busiestStop = "";
        int totalOccupancyAcrossStops = 0;

        for (int i = 0; i < numStops; i++) {
            // Gereksiz if bloğu buradan tamamen kaldırıldı
            currentPassengers = currentPassengers + passengersBoarding[i] - passengersAlighting[i];

            currentOccupancy[i] = currentPassengers;
            totalOccupancyAcrossStops += currentPassengers;
            System.out.println("Passengers currently on the bus after " + stopNames[i] + ": " + currentPassengers);

            if (currentPassengers > capacity) {
                System.out.println("Warning: Bus is over capacity at [" + stopNames[i] + "]!");
                overCapacityCount++;
            }

            if (passengersBoarding[i] > maxBoarding) {
                maxBoarding = passengersBoarding[i];
                busiestStop = stopNames[i];
            }
        }

        // 4. Display All
        System.out.println("\n===========================================");
        System.out.println("SUMMARY OF ALL STOPS");
        System.out.println("===========================================");
        System.out.printf("%-20s %-10s %-10s %-15s\n", "Stop Name", "Boarding", "Alighting", "Current Occupancy");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < numStops; i++) {
            System.out.printf("%-20s %-10d %-10d %-15d\n", stopNames[i], passengersBoarding[i], passengersAlighting[i], currentOccupancy[i]);
        }

        // 5. Statistics
        System.out.println("\n===========================================");
        System.out.println("STATISTICS");
        System.out.println("===========================================");

        System.out.println("- Busiest stop (highest boarding): " + busiestStop + " (" + maxBoarding + " passengers)");

        double averageOccupancy = (double) totalOccupancyAcrossStops / numStops;
        System.out.printf("- Average occupancy of the bus across all stops: %.2f\n", averageOccupancy);

        System.out.println("- Number of stops where the bus exceeded capacity: " + overCapacityCount);

        if (currentPassengers != 0) {
            System.out.println("\nWarning: " + currentPassengers + " passengers still on the bus after the final stop - please check your data.");
        }
    }
}