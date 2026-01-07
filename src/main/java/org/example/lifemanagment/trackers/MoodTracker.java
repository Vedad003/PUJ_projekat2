package org.example.lifemanagment.trackers;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.lifemanagment.MongoDBConnection;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class MoodTracker {

    private static MongoCollection<Document> collection;

    static {
        MongoDatabase db = MongoDBConnection.getDatabase();
        collection = db.getCollection("mood");
    }

    public static void display(String username) {
        Stage window = new Stage();
        window.setTitle("Mood Tracker - " + username);

        VBox layout = new VBox(10);

        Label label = new Label("Unesi raspoloženje (1-10):");
        TextField input = new TextField();
        Button saveButton = new Button("Save");
        Button statsButton = new Button("Show Stats");
        Label statsLabel = new Label();

        saveButton.setOnAction(e -> {
            try {
                int mood = Integer.parseInt(input.getText());
                if(mood < 1 || mood > 10) throw new NumberFormatException();
                Document doc = new Document("username", username)
                        .append("mood", mood);
                collection.insertOne(doc);
                input.clear();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Mood saved!");
                alert.showAndWait();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Unesite broj od 1 do 10!");
                alert.showAndWait();
            }
        });

        statsButton.setOnAction(e -> {
            List<Document> docs = collection.find(new Document("username", username))
                    .into(new java.util.ArrayList<>());
            int total = docs.size();
            double avgMood = docs.stream()
                    .mapToInt(d -> d.getInteger("mood"))
                    .average()
                    .orElse(0);
            statsLabel.setText("Total entries: " + total + "\nAverage mood: " + avgMood);
        });

        layout.getChildren().addAll(label, input, saveButton, statsButton, statsLabel);

        Scene scene = new Scene(layout, 400, 400);
        window.setScene(scene);
        window.show();
    }
}
