package org.campusmolndal;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        MongoDbFacade dbFacade = new MongoDbFacade();
        KeyReader keyReader = new KeyReader("todoKey");
        // Lägg till tre sample todos i databasen
        dbFacade.addSampleTodos();

        Logger.getLogger("org.mongodb.driver")
                .setLevel(Level.SEVERE);




    }
}

