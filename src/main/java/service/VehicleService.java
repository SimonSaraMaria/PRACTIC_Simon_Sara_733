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

    //Filtern nach Fahrzeugtyp und Status
//Lesen Sie von der Tastatur:
//● einen Fahrzeugtyp (VehicleType)
//● einen Fahrzeugstatus (VehicleStatus)

    public List<Vehicle> filterTypeAndStatus(List<Vehicle> vehicles, VehicleType type, VehicleStatus status) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getType().equals(type))
                .filter(vehicle -> vehicle.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}
