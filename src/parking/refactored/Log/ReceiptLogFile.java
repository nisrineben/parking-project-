package parking.refactored.Log;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptLogFile implements ReceiptLog{
    private final String fileName;

    public ReceiptLogFile(String fileName) { this.fileName = fileName; }
    public String name() {
        return "FileLogger";
    }


    public void log(String text) throws IOException {
            try (FileWriter fw = new FileWriter(fileName, true)) {   // append
                fw.write(text + System.lineSeparator());
            }
    }
}
