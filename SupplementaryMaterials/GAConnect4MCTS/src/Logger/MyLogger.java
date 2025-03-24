package Logger;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;

public class MyLogger {

    private Logger logger;
    public String filename;
    public MyLogger(String filename) {
        this.filename = filename;
        logger = Logger.getLogger(filename); // Use filename as Logger name
        try {
            String logFolderPath = "log";
            //String logFolderPath = File.separator + "log";
            File logFolder = new File(logFolderPath);
            
            // Create the folder if it doesn't exist
            if (!logFolder.exists()) {
                logFolder.mkdirs();
            }

            String logFilePath = logFolderPath + File.separator + filename + ".log"; // Append filename with .log extension
            FileHandler fileHandler = new FileHandler(logFilePath);

            // Set your custom formatter
            fileHandler.setFormatter(new CustomFormatter());

            // Remove default console handler
            logger.setUseParentHandlers(false);

            // Add the FileHandler to the logger
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            System.out.println("LMAO");
            e.printStackTrace();
        }
    }

    public void deleteLockFiles(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Directory does not exist or is not a directory: " + directoryPath);
            return;
        }
    
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".lck")) {
                    file.delete();
                }
            }
        }
    }

    
    

    public void addInfo(String info) {
        logger.info(info);
    }
}