package Logger;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        // Customize the log format as needed
        return record.getMessage() + System.lineSeparator();
    }
}