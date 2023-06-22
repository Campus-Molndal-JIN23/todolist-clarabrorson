package org.campusmolndal;

import java.util.Scanner;

public class Menu {

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
            System.out.println("Välkommen till Todo-appen!");
            System.out.println("1. Lägg till en todo");
            System.out.println("2. Visa en todo");
            System.out.println("3. Visa alla todos");
            System.out.println("4. Uppdatera en todo");
            System.out.println("5. Ta bort en todo");
            System.out.println("6. Avsluta");
            System.out.println();
            int choice = getIntInput("Ange ditt val: ");

            switch (choice) {
                case 1:
                    application.addToDo();
                    break;
                case 2:
                    application.showToDo();
                    break;
                case 3:
                    application.showAllToDos();
                    break;
                case 4:
                    application.updateToDo();
                    break;
                case 5:
                    application.deleteToDo();
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





