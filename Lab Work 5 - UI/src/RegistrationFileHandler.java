import java.io.File;
import java.io.IOException;

public class RegistrationFileHandler {

    File file;

    public RegistrationFileHandler(){
        file = new File("/registrations.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException ex ){
            System.out.println("Error creating file: " + ex.getMessage());
        }
    }


    public void overrideToFile(){

    }

    public void appendToFile(){

    }

    public void printFileInfo(){

    }
}
