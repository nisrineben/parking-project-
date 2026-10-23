package parking.refactored;


import parking.refactored.Vehicle.*;
import parking.refactored.Payment.*;
import parking.refactored.Log.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ParkingService garage = new ParkingService(
                new ReceiptLogFile("parking.log") {
                }, new ReceiptFormatter());

        Vehicle car   = new Vehicle("12345-A-6", new CAR());
        Vehicle bike  = new Vehicle("67890-B-1", new MOTORBIKE());
        Vehicle truck = new Vehicle("24680-D-8", new TRUCK());

        RefundablePaymentMethod card = new CardPayment("4242");
        PaymentMethod cash = new CashPayment();

        garage.checkout(car, 3, card);
        garage.checkout(bike, 2, cash);
        garage.checkout(truck, 4, card);

        garage.cancel(truck, 4, card);   // card is refundable, so this compiles
        // garage.cancel(bike, 2, cash); // does not compile: cash is not refundable

        System.out.println(garage.dailyReport());
    }
}