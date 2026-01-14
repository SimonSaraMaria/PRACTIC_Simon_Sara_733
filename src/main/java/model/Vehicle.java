package model;

public class Vehicle {
    private int id;
    private String licensePlate;
    private VehicleType type;
    private String ownerCity;
    private VehicleStatus status;

    public Vehicle() {}

    public Vehicle(int id, String licensePlate, VehicleType type, String ownerCity, VehicleStatus status) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.type = type;
        this.ownerCity = ownerCity;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getOwnerCity() {
        return ownerCity;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", type=" + type +
                ", ownerCity='" + ownerCity + '\'' +
                ", status=" + status +
                '}';
    }
}
