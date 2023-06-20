package org.campusmolndal;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDbFacade {
    MongoClient client; //Instans av MongoDB-klienten som används för att ansluta till en databas.
    MongoDatabase db; //Instansen av en databas som används för att kommunicera med databasen.
    MongoCollection<Document> collection; //MongoCollection innehåller dokument som lagras i databasen.
    KeyReader KeyReader = new KeyReader("todoKey"); // SKapa en instans av KeyReader

    String connString = KeyReader.getKey(); // MongoDB-anslutningssträngen som definierar plats för databasen.
    String collectionName = "Todo"; // Namnet på den samling/dokument som innehåller todo
    String databaseName = "TodoDB"; // Namnet på databasen

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

    // Utför CRUD operationer






}


