import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class RegistrationFileHandler {
    private final String FILENAME = "registrations.txt";
    private File file;

    public RegistrationFileHandler(){
        file = new File(FILENAME);
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException ex ){
            System.out.println("Error creating file: " + ex.getMessage());
        }
    }

    public void appendToFile(String content){
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.append(content);
            fw.close();
        } catch (IOException ex){
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }

    public void printFileInfo(){
        try {
            System.out.println(Files.readString(file.toPath()));
        } catch (IOException ex){
            System.out.println("Error opening file: " + ex.getMessage());
        }
    }
}
