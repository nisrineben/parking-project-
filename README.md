# parking-project

Nissrine Benallal


The table of question 2
| Principle | Class | Lines of code | Smell |
    |---|---|---|---|
    | SRP | `ParkingGarage` | The whole class: `fee()`, `checkout()`, `cancel()`, `dailyReport()` | One class serves several actors (Management, Finance, Reporting), so a change for one can break another. |
    | OCP | `ParkingGarage` (method `fee`) | `switch (vehicle.getType()) { case "CAR" -> ... }` | Adding a new vehicle type (BUS) requires editing existing code. |
    | LSP | `CashPayment` | `refund()` throws an exception, and `cancel` uses `instanceof CashPayment` | `CashPayment` cannot safely replace a `PaymentMethod`, so callers must check its type. |
    | ISP | `PaymentMethod` | `void refund(double amount);` | The interface forces every payment method to have a refund, even cash, which cannot be used. |
    | DIP | `ParkingGarage` | `private final FileLogger logger = new FileLogger("parking.log");` | The business logic depends on a detail (file logging), so it cannot be tested or switched to a database. |

NB: the class diagram is in the docs folder