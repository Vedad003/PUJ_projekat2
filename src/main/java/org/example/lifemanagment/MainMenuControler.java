package org.example.lifemanagment;

import javafx.fxml.FXML;
import financeapp.FinanceTrackerFormFrame;
import org.example.lifemanagment.trackers.*;
import org.example.lifemanagment.session.UserSession;

public class MainMenuControler {

    @FXML
    protected void onFinanceButtonClick() {
        String username = UserSession.getUser();
        javax.swing.SwingUtilities.invokeLater(() ->
                new FinanceTrackerFormFrame(username).setVisible(true)
        );
    }

    @FXML
    protected void onHabitTrackerClick() {
        HabitTracker.display(UserSession.getUser());
    }

    @FXML
    protected void onSleepTrackerClick() {
        SleepTracker.display(UserSession.getUser());
    }

    @FXML
    protected void onStudyPlannerClick() {
        StudyPlanner.display(UserSession.getUser());
    }

    @FXML
    protected void onMoodTrackerClick() {
        MoodTracker.display(UserSession.getUser());
    }
}
