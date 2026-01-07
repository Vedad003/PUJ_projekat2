package org.example.lifemanagment.auth;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.bson.Document;
import org.example.lifemanagment.MongoDBConnection;

public class RegisterController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    private MongoCollection<Document> users;

    public RegisterController() {
        MongoDatabase db = MongoDBConnection.getDatabase();
        users = db.getCollection("users");
    }

    @FXML
    public void handleRegister() throws Exception {

        Document existing = users.find(
                new Document("username", usernameField.getText())
        ).first();

        if (existing != null) {
            new Alert(Alert.AlertType.ERROR, "Username već postoji!").showAndWait();
            return;
        }

        Document user = new Document("username", usernameField.getText())
                .append("password", passwordField.getText());

        users.insertOne(user);

        new Alert(Alert.AlertType.INFORMATION, "Registracija uspješna!").showAndWait();

        Stage stage = (Stage) usernameField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/lifemanagment/Login.fxml")
        );
        stage.setScene(new Scene(loader.load(), 400, 300));
    }
}
