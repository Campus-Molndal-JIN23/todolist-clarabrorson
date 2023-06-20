package org.campusmolndal;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        MongoDbFacade newMongoDbFacade = new MongoDbFacade();
        KeyReader keyReader = new KeyReader("todoKey");
        Logger.getLogger("org.mongodb.driver")
                .setLevel(Level.SEVERE);
    }
}

