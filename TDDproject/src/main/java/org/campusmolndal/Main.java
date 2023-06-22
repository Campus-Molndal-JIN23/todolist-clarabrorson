package org.campusmolndal;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.showMenu();

        MongoDbFacade dbFacade = new MongoDbFacade();

        KeyReader keyReader = new KeyReader("todoKey");

        dbFacade.addSampleTodos();

        Logger.getLogger("org.mongodb.driver")
                .setLevel(Level.SEVERE);




    }
}

