package org.campusmolndal;

import java.util.List;
import java.util.Scanner;

public class Application {

    private MongoDbFacade dbFacade;
    private Scanner lineScanner;
    private Scanner intScanner; 

    public Application() {
        dbFacade = new MongoDbFacade();
        lineScanner = new Scanner(System.in);
        intScanner = new Scanner(System.in);
    }
    public void addToDo(){

    }
    public void showToDo(){

    }

    public void showAllToDos(){

    }
    public void updateToDo(){

    }
    public void deleteToDo(){

    }
}

