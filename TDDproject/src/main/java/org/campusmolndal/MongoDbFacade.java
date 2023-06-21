package org.campusmolndal;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDbFacade {
    MongoClient client; //Instans av MongoDB-klienten som används för att ansluta till en databas.
    MongoDatabase db; //Instansen av en databas som används för att kommunicera med databasen.
    MongoCollection<Document> collection; //MongoCollection innehåller dokument som lagras i databasen.
    KeyReader KeyReader = new KeyReader("todoKey"); // SKapa en instans av KeyReader

    String connString = KeyReader.getKey(); // MongoDB-anslutningssträngen som definierar plats för databasen.
    String collectionName = "todo"; // Namnet på den samling/dokument som innehåller todo
    String databaseName = "todoDB"; // Namnet på databasen

    public MongoDbFacade(String connString, String databaseName, String collectionName) {
        this.connString = connString;
        this.collectionName = collectionName;
        this.databaseName = databaseName;
        Connect();
    }

    public MongoDbFacade() {

        Connect();
    }

    private void Connect() {
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build(); // Skapar en instans av MongoDB Server API.

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connString))
                .serverApi(serverApi)
                .build(); // Skapar inställningarna för MongoDB-klienten.

        try {
            client = MongoClients.create(settings); // Skapar en instans av MongoDB-klienten.
            db = client.getDatabase(databaseName); // Hämtar instansen av databasen.
            collection = db.getCollection(collectionName); // Hämtar instansen av samlingen.
            System.out.println("Anslutning lyckades!"); // Skriver ut ett meddelande om anslutningen lyckades.

        } catch (Exception ex) {

            System.out.println("Misslyckad anslutning!"); // Skriver ut ett meddelande om anslutningen misslyckades.
            System.out.println(ex.getMessage()); // Skriver ut felet som orsakade anslutningsmisslyckandet.
        }
    }
    // Metod för att skapa ett index på todo-fältet i samlingen.
    public void createIndex() {
        collection.createIndex(new Document("todo", 1),
                new IndexOptions().unique(true));
    }

    // Utför CRUD operationer

    public void addTodo(Todo todo) {
        Document doc = todo.toDoc();
        collection.insertOne(doc);
    }

    public void updateTodoById(String id, Todo updatedTodo) {
        Document filter = new Document("_id", id);
        Document update = new Document("$set", updatedTodo.toDoc());
        collection.updateOne(filter, update);
    }

    public void deleteTodoById(String id) {
        Document filter = new Document("_id", id);
        collection.deleteOne(filter);
    }

    public Todo getTodoById(String id) {
        Document filter = new Document("_id", id);
        Document doc = collection.find(filter).first();
        if (doc != null) {
            return Todo.fromDoc(doc);
        }
        return null;
    }

    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        for (Document doc : collection.find()) {
            Todo todo = Todo.fromDoc(doc);
            todos.add(todo);
        }
        return todos;
    }

    public void addSampleTodos() {
        Todo todo1 = new Todo("1", "Köpa kaffe", false);
        Todo todo2 = new Todo("2", "Hämta paket", true);
        Todo todo3 = new Todo("3", "Föräldramöte kl 15", false);
        try {
            addTodo(todo1);
            addTodo(todo2);
            addTodo(todo3);

            System.out.println("Todos tillagda i databasen!");
        } catch (Exception ex) {
            System.out.println("Misslyckades att lägga till todos i databasen!");
            System.out.println(ex.getMessage());
        }
    }
}


