package parking.refactored.Vehicle;

public class Vehicle {
    private final String plate;
    private final TypeVehicle typeVehicle;

    public Vehicle(String plate, TypeVehicle typeVehicle) {
        this.plate = plate;
        this.typeVehicle = typeVehicle;
    }

    public String getPlate() { return plate; }
    public TypeVehicle getTypeVehicle()  { return typeVehicle; }
}
