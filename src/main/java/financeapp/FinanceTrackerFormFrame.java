package financeapp;

import javax.swing.*;

public class FinanceTrackerFormFrame extends JFrame {

    private final String username;

    public FinanceTrackerFormFrame(String username) {
        this.username = username;
        setTitle("Finance Tracker - " + username);
        setContentPane(new FinanceTrackerForm(username).getMainPanel());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
    }
}
