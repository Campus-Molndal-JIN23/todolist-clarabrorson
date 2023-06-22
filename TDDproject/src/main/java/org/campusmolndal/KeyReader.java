package org.campusmolndal;
import java.io.File;
import java.util.Properties;

public class KeyReader {
    Properties prop;

    public KeyReader(String file) {
        // Skapa ett nytt Properties-objekt
        prop = new Properties();
        // Hämta sökvägen till användarens hemkatalog
        String userHome = System.getProperty("user.home");

        String filename= "/Documents/todoKey/" + file + ".txt";
        File newfile = new File("/Documents/todoKey/" + file + ".txt");
        if (!newfile.exists()) {
            try {
                prop.setProperty("connectionString", "mongodb://localhost:27017");
                prop.setProperty("database", "todoDB");
                prop.setProperty("collection", "todo");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }
    public String getKey() {

        return prop.getProperty("connectionString");
    }
}
