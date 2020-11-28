import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiseTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fil = null;
        try {
            Properties properties = new Properties();
            fil = new FileInputStream("jdbc.properties");
            properties.load(fil);
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");
            System.out.println("name=" + name + "," + "passsword=" + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fil.close();
        }


    }
}
