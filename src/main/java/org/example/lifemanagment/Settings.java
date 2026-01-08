package org.example.lifemanagment;

public class Settings {

    private static boolean notificationsEnabled = true;

    public static boolean isNotificationsEnabled() { return notificationsEnabled; }
    public static void setNotificationsEnabled(boolean notificationsEnabled) {
        Settings.notificationsEnabled = notificationsEnabled;
    }
}
