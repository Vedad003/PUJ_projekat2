package org.example.lifemanagment;

import javafx.fxml.FXML;
import financeapp.FinanceTrackerFormFrame;
import org.example.lifemanagment.trackers.*;

public class MainMenuControler {

    @FXML
    protected void onFinanceButtonClick() {
        // Swing prozor iz Projekta 1
        javax.swing.SwingUtilities.invokeLater(() -> new FinanceTrackerFormFrame().setVisible(true));
    }

    @FXML
    protected void onHabitTrackerClick() {
        HabitTracker.display("korisnik1");
    }

    @FXML
    protected void onSleepTrackerClick() {
        SleepTracker.display("korisnik1");
    }

    @FXML
    protected void onStudyPlannerClick() {
        StudyPlanner.display("korisnik1");
    }

    @FXML
    protected void onMoodTrackerClick() {
        MoodTracker.display("korisnik1");
    }
}
