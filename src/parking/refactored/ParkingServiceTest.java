package parking.refactored;


import parking.refactored.Log.ReceiptLog;
import parking.refactored.Payment.CashPayment;
import parking.refactored.Vehicle.CAR;
import parking.refactored.Vehicle.MOTORBIKE;
import parking.refactored.Vehicle.TRUCK;
import parking.refactored.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingServiceTest {
    static class FakeReceiptLog implements ReceiptLog {
        final List<String> lines = new ArrayList<>();

        @Override
        public String name() {
            return "fake";
        }

        public void log(String receipt) { lines.add(receipt); }
    }
    public static void main(String[] args) throws Exception {

        ParkingService service = new ParkingService(new FakeReceiptLog(), new ReceiptFormatter());

        Vehicle car =new Vehicle("A-1",new CAR());
        Vehicle motorbike=new Vehicle("M-2",new MOTORBIKE());
        Vehicle truck =new Vehicle("T-3",new TRUCK());

        System.out.println(car.getTypeVehicle().tariff(4) == 20.0);        // true
        System.out.println(motorbike.getTypeVehicle().tariff(4) == 8.0);   // true
        System.out.println(truck.getTypeVehicle().tariff(4) == 60.0);      // true

        service.checkout(car, 4, new CashPayment());
        service.checkout(motorbike, 4, new CashPayment());
        service.checkout(truck, 4, new CashPayment());

        System.out.println(service.dailyReport());
    }
}