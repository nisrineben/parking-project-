package parking.refactored.Log;

import java.io.IOException;

public interface ReceiptLog {
    String name();
    void log(String text) throws IOException;
}
