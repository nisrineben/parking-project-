package parking.refactored.Vehicle;



public class TRUCK implements TypeVehicle {

    public double tariff(int hours) {
        return  20 + hours * 10.0;
    }
}
