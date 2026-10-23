package parking.refactored;

import parking.refactored.Log.ReceiptLog;
import parking.refactored.Payment.PaymentMethod;
import parking.refactored.Payment.RefundablePaymentMethod;
import parking.refactored.Vehicle.Vehicle;

import java.io.IOException;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;

public class ParkingService {
    private final List<String> receipts = new ArrayList<>();
    private ReceiptFormatter receiptFormatter;
    private ReceiptLog receiptLog;
    private double total;

    public ParkingService(ReceiptLog receiptLog,ReceiptFormatter receiptFormatter){
        this.receiptFormatter=receiptFormatter;
        this.receiptLog=receiptLog;
    }

    public double fee(Vehicle vehicle, int hours) {
        return vehicle.getTypeVehicle().tariff(hours);
    }

    public void checkout(Vehicle vehicle, int hours, PaymentMethod method)
            throws IOException {
        double amount = fee(vehicle, hours);
        method.pay(amount);
        total += amount;

        String receipt = receiptFormatter.formatReceipt(vehicle,hours,amount,method);
        receipts.add(receipt);
        receiptLog.log(receipt);
    }

    public void cancel(Vehicle vehicle, int hours, RefundablePaymentMethod method) {
        double amount = fee(vehicle, hours);

        System.out.println("Refund " + amount + " MAD at the desk for "
                + vehicle.getPlate());

        method.refund(amount);

        total -= amount;
    }

    public String dailyReport() {
       return receiptFormatter.formatReport(receipts,total);
    }
}
