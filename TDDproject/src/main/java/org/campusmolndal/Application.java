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
        System.out.println("Skriv in en todo: ");
        String id = getStringInput("Ange ID: ");
        String text = getStringInput("Ange text: ");
        boolean done = getBooleanInput("Är den klar? (ja/nej): ");

        Todo todo = new Todo(id, text, done);
        dbFacade.addTodo(todo);

        System.out.println("Todo'n har lagts till!");

    }
    public void showToDo(){
        System.out.println("Visa en todo");
        String id = getStringInput("Ange ID: ");
        Todo todo = dbFacade.getTodoById(id);
        if (todo != null) {
            System.out.println(todo);
        } else {
            System.out.println("Todo'n finns inte!");
    }

    }
    public void showAllToDos(){
        System.out.println("Visa alla todos");
        List<Todo> todos = dbFacade.getAllTodos();
        for (Todo todo : todos) {
            System.out.println(todo);
    }

    }
    public void updateToDo(){

    }
    public void deleteToDo(){

    }

    //Hjälpt av chatGPT
    private String getStringInput(String message) {
        System.out.print(message);
        return lineScanner.nextLine();
    }

    // Hjälpt av chatGPT
    private boolean getBooleanInput(String message) {
        System.out.print(message);
        String input = lineScanner.nextLine();
        return input.equalsIgnoreCase("ja");
}

