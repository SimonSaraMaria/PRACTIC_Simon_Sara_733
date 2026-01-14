package service;
import model.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.io.PrintWriter;
import java.util.Map;
import java.util.LinkedHashMap;

public class EreignisService {

    public int calculateRisikoScore(TrafficEvent e) {
        int severity = e.getSeverity();

        return switch (e.getType()) {
            case SPEEDING -> severity * 2;
            case RED_LIGHT -> severity * 3;
            case ACCIDENT -> severity * 5;
            case PRIORITY_PASS -> severity * 1;
        };
    }

    public void printTop5(List<Vehicle> vehicles, List<TrafficEvent> events, List<Fine> fines) {
        Map<Integer, Integer> scores = new HashMap<>();

        for (Vehicle vehicle : vehicles) {
            scores.put(vehicle.getId(), 0);
        }
        for (TrafficEvent event : events) {
            int currentScore = scores.getOrDefault(event.getVehicleId(), 0);
            scores.put(event.getVehicleId(), currentScore + calculateRisikoScore(event));
        }

        for (Fine fine : fines) {
            int currentScore = scores.getOrDefault(fine.getVehicleId(), 0);
            scores.put(fine.getVehicleId(), currentScore + fine.getAmount());
        }

        List<Vehicle> sortedVehicle = new ArrayList<>(vehicles);
        sortedVehicle.sort((v1, v2) -> {
            int score1 = scores.get(v1.getId());
            int score2 = scores.get(v2.getId());
            if (score1 != score2) return Integer.compare(score2, score1);
            return v1.getId().compareTo(v2.getId());
        });

        System.out.println("Top 5 Ranking:");
        for (int i = 0; i < 5 && i < sortedVehicle.size(); i++) {
            Vehicle v = sortedVehicle.get(i);
            System.out.println(v.getId() + " (" +  scores.get(v.getId()));
        }
    }
}
