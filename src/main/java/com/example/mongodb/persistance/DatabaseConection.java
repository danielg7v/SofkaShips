package com.example.mongodb.persistance;

import com.example.mongodb.model.lanzadera;
import com.example.mongodb.model.notripulada;
import com.example.mongodb.model.tripulada;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseConection {
    private MongoClientURI uri;
    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> typeOneCollection;
    private MongoCollection<Document> typeTwoCollection;
    private MongoCollection<Document> typeThreeCollection;

    public DatabaseConection(String uri){
        this.uri = new MongoClientURI(uri);
        this.client = new MongoClient(this.uri);
    }

    public void setDatabase(String dbName) {
        this.db = this.client.getDatabase(dbName);
    }

    public void setTypeOneCollection(String collection) {
        this.typeOneCollection = this.db.getCollection(collection);
    }
    public void setTypeTwoCollection(String collection) {
        this.typeTwoCollection = this.db.getCollection(collection);
    }
    public void setTypeThreeCollection(String collection) { this.typeThreeCollection = this.db.getCollection(collection); }

    public void insertLanzaderaToCollection(lanzadera lanzadera){
        this.typeOneCollection.insertOne(shipOneToDocument(lanzadera));
    }

    public void insertNoTripuladaToCollection(notripulada notripulada){
        this.typeTwoCollection.insertOne(shipTwoToDocument(notripulada));
    }

    public void insertTripuladaToCollection(tripulada tripulada){
        this.typeThreeCollection.insertOne(shipThreeToDocument(tripulada));
    }

    public  Document shipOneToDocument(lanzadera lanzadera) {
        Document doc = new Document();
        doc.append("name", lanzadera.getName());
        doc.append("description", lanzadera.getDescription());
        doc.append("color", lanzadera.getColor());
        return doc;
    }

    public  Document shipTwoToDocument(notripulada notripulada) {
        Document doc = new Document();
        doc.append("name", notripulada.getName());
        doc.append("description", notripulada.getDescription());
        doc.append("color", notripulada.getColor());
        return doc;
    }

    public  Document shipThreeToDocument(tripulada tripulada) {
        Document doc = new Document();
        doc.append("name", tripulada.getName());
        doc.append("description", tripulada.getDescription());
        doc.append("color", tripulada.getColor());
        return doc;
    }
}
