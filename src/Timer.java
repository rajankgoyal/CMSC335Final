import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer implements Runnable{

    public String getTime()
    {
        final String pattern = "HH:mm:ss";
        final SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);

    }
    @Override
    public void run() {
            while (true) {
                GuiMain.timeLabel.setText(getTime());
            }

    }
}
