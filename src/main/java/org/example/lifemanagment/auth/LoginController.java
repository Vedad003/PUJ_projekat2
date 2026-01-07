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
import org.example.lifemanagment.session.UserSession;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    private MongoCollection<Document> users;

    public LoginController() {
        MongoDatabase db = MongoDBConnection.getDatabase();
        users = db.getCollection("users");
    }

    @FXML
    public void handleLogin() throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();

        Document user = users.find(
                new Document("username", username)
                        .append("password", password)
        ).first();

        if (user != null) {
            UserSession.setUser(username);

            Stage stage = (Stage) usernameField.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/org/example/lifemanagment/MainMenu.fxml")
            );
            stage.setScene(new Scene(loader.load(), 800, 600));
        } else {
            new Alert(Alert.AlertType.ERROR, "Pogrešan username ili password!").showAndWait();
        }
    }

    @FXML
    public void goToRegister() throws Exception {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/lifemanagment/Register.fxml")
        );
        stage.setScene(new Scene(loader.load(), 400, 300));
    }
}
