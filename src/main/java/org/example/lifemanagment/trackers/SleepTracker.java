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

public class SleepTracker {

    private static MongoCollection<Document> collection;

    static {
        MongoDatabase db = MongoDBConnection.getDatabase();
        collection = db.getCollection("sleep");
    }

    public static void display(String username) {
        Stage window = new Stage();
        window.setTitle("Sleep Tracker - " + username);

        VBox layout = new VBox(10);

        Label label = new Label("Unesi sate sna:");
        TextField input = new TextField();
        Button saveButton = new Button("Save");
        Button statsButton = new Button("Show Stats");
        Label statsLabel = new Label();

        saveButton.setOnAction(e -> {
            try {
                int hours = Integer.parseInt(input.getText());
                Document doc = new Document("username", username)
                        .append("hours", hours);
                collection.insertOne(doc);
                input.clear();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Sleep saved!");
                alert.showAndWait();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Unesite validan broj sati!");
                alert.showAndWait();
            }
        });

        statsButton.setOnAction(e -> {
            List<Document> docs = collection.find(new Document("username", username))
                    .into(new java.util.ArrayList<>());
            int totalEntries = docs.size();
            double avgHours = docs.stream()
                    .mapToInt(d -> d.getInteger("hours"))
                    .average()
                    .orElse(0);
            statsLabel.setText("Total entries: " + totalEntries + "\nAverage sleep: " + avgHours + "h");
        });

        layout.getChildren().addAll(label, input, saveButton, statsButton, statsLabel);

        Scene scene = new Scene(layout, 400, 400);
        window.setScene(scene);
        window.show();
    }
}
