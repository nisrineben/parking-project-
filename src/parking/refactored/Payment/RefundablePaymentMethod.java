package parking.refactored.Payment;

public interface RefundablePaymentMethod extends PaymentMethod{
    void refund(double amount);
}
