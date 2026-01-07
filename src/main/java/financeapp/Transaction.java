package financeapp;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Transaction {

    private ObjectId id;
    private String username;  // dodano
    private String type;
    private double amount;
    private String description;
    private String category;

    public Transaction(String username, String type, double amount, String description,String category) {
        this.username = username;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.category=category;
    }

    public Transaction(ObjectId id, String username, String type, double amount, String description, String category) {
        this.id = id;
        this.username = username;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.category = category;
    }

    public Document toDocument() {
        Document d = new Document("username", username)
                .append("type", type)
                .append("amount", amount)
                .append("description", description)
                .append("category", category);

        if (id != null)
            d.append("_id", id);

        return d;
    }

    public ObjectId getId() { return id; }
    public String getUsername() { return username; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
}
