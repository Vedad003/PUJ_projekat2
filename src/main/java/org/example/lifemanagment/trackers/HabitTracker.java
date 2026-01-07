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
import java.util.stream.Collectors;

public class HabitTracker {

    private static MongoCollection<Document> collection;

    static {
        MongoDatabase db = MongoDBConnection.getDatabase();
        collection = db.getCollection("habits");
    }

    public static void display(String username) {
        Stage window = new Stage();
        window.setTitle("Habit Tracker - " + username);

        VBox layout = new VBox(10);

        Label label = new Label("Unesi habit:");
        TextField input = new TextField();
        Button saveButton = new Button("Save");
        Button statsButton = new Button("Show Stats");
        Label statsLabel = new Label();

        saveButton.setOnAction(e -> {
            String habit = input.getText();
            if (!habit.isEmpty()) {
                Document doc = new Document("username", username)
                        .append("habit", habit);
                collection.insertOne(doc);
                input.clear();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Habit saved!");
                alert.showAndWait();
            }
        });

        statsButton.setOnAction(e -> {
            List<Document> docs = collection.find(new Document("username", username))
                    .into(new java.util.ArrayList<>());
            int total = docs.size();
            String habits = docs.stream()
                    .map(d -> d.getString("habit"))
                    .collect(Collectors.joining(", "));
            statsLabel.setText("Total habits: " + total + "\n" + habits);
        });

        layout.getChildren().addAll(label, input, saveButton, statsButton, statsLabel);

        Scene scene = new Scene(layout, 400, 400);
        window.setScene(scene);
        window.show();
    }
}
