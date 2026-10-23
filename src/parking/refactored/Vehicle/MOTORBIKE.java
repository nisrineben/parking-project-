package parking.refactored.Vehicle;



public class MOTORBIKE implements TypeVehicle {

    public double tariff(int hours) {
       return hours * 2.0;
    }

}
