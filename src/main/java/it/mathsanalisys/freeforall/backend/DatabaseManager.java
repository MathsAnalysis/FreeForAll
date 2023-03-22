package it.mathsanalisys.freeforall.backend;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

import java.util.UUID;

@Getter
@Setter
public class DatabaseManager {

    @Getter
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> players;

    public DatabaseManager(){
        this.client = new MongoClient(new ServerAddress("localhost", 27017), MongoClientOptions.builder().build());
        this.database = this.client.getDatabase("FreeForAll");
        this.players = this.database.getCollection("players");
    }


    public Document getPlayer(UUID uuid){
        return this.players.find(Filters.eq("uuid", uuid.toString())).first();
    }

    public void replacePlayer(){

    }

    public void close(){
        this.client.close();
    }

}
