package parking.refactored.Vehicle;



public class CAR implements TypeVehicle {
    public double tariff(int hours) {
        return hours * 5.0;
    }
}
