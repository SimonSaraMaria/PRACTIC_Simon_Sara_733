package controller;
import model.*;
import repository.TrafficRepository;
import service.VehicleService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TrafficController {

    public void run() {
        try{
            TrafficRepository repo = new TrafficRepository();
            Scanner scanner = new Scanner(System.in);
            VehicleService service = new VehicleService();

            List<Vehicle> vehicles = repo.readVehicles("vehicles.json");
            List<Fine> fines = repo.readFines("fines.json");
            List<TrafficEvent> events = repo.readEvents("events.json");

            boolean running = true;
            while(running){
                System.out.println("\n--- Traffic Control Menu ---");
                System.out.println("1. Task 1: Show Counts and All Vehicles");
                System.out.println("2. Task 2: Filter by Type and Status");
                System.out.println("3. Task 3: Sort vehicles");
//                System.out.println("4. Task 4: Saving sorted tributes to file");
//                System.out.println("5. Task 5: Computed points for first 5 events");
//                System.out.println("6. Task 6: Top 5 tributes");
//                System.out.println("7. Task 7: Arena report");
                System.out.println("0. Exit");
                System.out.print("Choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Vehicles loaded: " + vehicles.size());
                        System.out.println("Events loaded: " + events.size());
                        System.out.println("Fines loaded: " + fines.size());
                        for (Vehicle vehicle : vehicles) {
                            System.out.println(vehicle);
                        }
                    }
                    case 2 -> {
                        scanner.nextLine();
                        System.out.print("Input type: ");
                        VehicleType typeinput = VehicleType.valueOf(scanner.nextLine());
                        System.out.print("Input status: ");
                        VehicleStatus statusinput = VehicleStatus.valueOf(scanner.nextLine());
                        List<Vehicle> filtered = service.filterTypeAndStatus(vehicles, typeinput, statusinput);
                        for (Vehicle vehicle : filtered) {
                            System.out.println(vehicle);
                        }
                    }
                    case 3 -> {
                        System.out.print("Sorted vehicles: ");
                        List<Vehicle> sorted = service.getSortedVehicles(vehicles);
                        for (Vehicle v : sorted) {
                            System.out.println(v);
                        }
                    }
//                    case 4 -> {
//                        System.out.print("Saving sorted tributes: ");
//                        try {
//                            List<Tribut> sorted = tributeService.getSortedTributes(tributes);
//                            tributeService.saveTributesToFile(sorted, "tributes_sorted.txt");
//                            System.out.println("Successfully saved sorted tributes!");
//                        } catch (IOException e) {
//                            System.err.println(e);
//                        }
//                    }
//                    case 5 -> {
//                        System.out.print("Computed points: ");
//                        EventService eventService = new EventService();
//                        for (int i = 0; i < 5 && i < events.size(); i++) {
//                            Ereignis e = events.get(i);
//                            int computedPoints = eventService.calculateComputedPoints(e);
//                            System.out.println("Event" + e.getId() + "-> rawPoints" + e.getPoints() +
//                                    "-> computedPoints = " + computedPoints);
//                        }
//                    }
//                    case 6 -> {
//                        System.out.println("Top 5 Tributes:");
//                        EventService eventService = new EventService();
//                        var top5 = eventService.calculateTopTributes(tributes, events, gifts);
//                        int rank = 1;
//                        for (var entry : top5) {
//                            System.out.println(rank + ". " + entry.getKey().getName() + " -> " + entry.getValue());
//                            rank++;
//                        }
//                    }
//                    case 7 -> {
//                        System.out.println("Arena report:");
//                        try {
//                            EventService eventService = new EventService();
//                            eventService.generateArenaReport(events, "arena_report.txt");
//                            System.out.println("Successfully saved arena report!");
//                        } catch (Exception e) {
//                            System.err.println(e);
//                        }
//                    }
                    case 0 -> {
                        running = false;
                        System.out.println("Exiting...");
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
