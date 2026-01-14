package service;
import model.Vehicle;
import model.VehicleStatus;
import model.VehicleType;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

import java.util.stream.Collectors;

public class VehicleService {

    public List<Vehicle> filterTypeAndStatus(List<Vehicle> vehicles, VehicleType type, VehicleStatus status) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getType().equals(type))
                .filter(vehicle -> vehicle.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public List<Vehicle> getSortedVehicles(List<Vehicle> vehicles) {
        List<Vehicle> sortedList = new ArrayList<>();

        sortedList.sort(Comparator
                .comparing(Vehicle::getOwnerCity)
                .thenComparing(Vehicle::getId).reversed());

        return vehicles;
    }

    public void saveVehiclesToFile(List<Vehicle> vehicles, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Vehicle vehicle : vehicles) {
                writer.println(vehicle.toString());
            }
        }
    }
}
