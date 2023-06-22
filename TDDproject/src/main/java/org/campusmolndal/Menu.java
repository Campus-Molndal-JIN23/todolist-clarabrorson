package org.campusmolndal;

import java.util.Scanner;

public class Menu {

    //Meny
    //Switch case
    //Anropa metoder från MongoDbFacade
    private Application application;
    private Scanner scanner;
    private Scanner lineScanner;
    private Scanner intScanner;

    public Menu() {

        application = new Application();
        scanner = new Scanner(System.in);
        lineScanner = new Scanner(System.in);
        intScanner = new Scanner(System.in);
    }

    public void showMenu() {

        boolean exit = false;

        while (!exit) {
            System.out.println("1. Lägg till en todo");
            System.out.println("2. Visa en todo");
            System.out.println("3. Visa alla todos");
            System.out.println("4. Uppdatera en todo");
            System.out.println("5. Ta bort en todo");
            System.out.println("6. Avsluta");
            System.out.println("Välj ett alternativ: ");

            int choice = getIntInput("Ange ditt val: ");

            switch (choice) {
                case 1:
                    application.addTodo();
                    break;
                case 2:
                    application.showTodo();
                    break;
                case 3:
                    application.showAllTodos();
                    break;
                case 4:
                    application.updateTodo();
                    break;
                case 5:
                    application.deleteTodo();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
                    break;
            }

            System.out.println();
        }
        scanner.close();
        lineScanner.close();
        intScanner.close();

    }

    private int getIntInput(String message) { // Metod för att läsa in heltal från användaren
        System.out.print(message);
        return intScanner.nextInt();
    }
}





