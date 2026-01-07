package financeapp;

import javax.swing.*;

public class FinanceTrackerFormFrame extends JFrame {

    public FinanceTrackerFormFrame() {
        setTitle("Finance Tracker");
        setContentPane(new FinanceTrackerForm().getMainPanel());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
    }
}
