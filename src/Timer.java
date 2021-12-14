/*
        Name - Timer.java
        Date - 12/14/2021
        Author - Rajan Goyal
        Purpose - Creates a timer with a runnable thread. It is used to display time in the GUI.
        Timer runs on its own thread.
*/
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer implements Runnable {
    boolean timeRunner = true;
    // Returns current time in proper format
    public String getTime() {
        // Sets the pattern for time
        final String pattern = "HH:mm:ss";
        // Sets format for the time
        final SimpleDateFormat format = new SimpleDateFormat(pattern);
        // Gets the current time from the system
        Date date = new Date(System.currentTimeMillis());
        // Returns current time in format described above
        return format.format(date);
    }
    // starts to update the timer
    @Override
    public void run() {
        while (timeRunner) {
            GuiMain.timeLabel.setText(getTime());
        }

    }
}
