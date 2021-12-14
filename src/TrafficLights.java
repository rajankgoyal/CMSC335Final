/*
        Name - TrafficLights.java
        Date - 12/14/2021
        Author - Rajan Goyal
        Purpose - Creates a traffic light with a runnable thread. Accompanying some helper methods
        Which helps control the traffic light.
*/
import javax.swing.*;

// Enum for three colors of Traffic light
enum LightColor {
    RED, GREEN, YELLOW
}

public class TrafficLights implements Runnable {
    private LightColor lightColor; // Current color of Traffic light.
    private boolean stop = false; // if True terminates the Traffic light thread
    boolean lightSuspended = false; // Used to monitor if the light is set to suspend
    private final int location; // Location of the light
    JLabel label; // Used to return a JLabel for intersection GUI
    Thread thread;

    TrafficLights(LightColor init, String name, int location) {
        lightColor = init;
        thread = new Thread(this, name);
        this.location = location;
        label = new JLabel(lightColor.toString());
    }

    // Starts the light
    public void run() {
        while (!stop) {

            try {
                switch (lightColor) {
                    // green for min 2 max 8 seconds
                    case GREEN -> Thread.sleep((int) Math.floor(Math.random()*(10000-2000+1)+2000));
                    // yellow for 1 second
                    case YELLOW -> Thread.sleep(1000);
                    // red for min 2 max 8 seconds
                    case RED -> Thread.sleep((int) Math.floor(Math.random()*(8000-2000+1)+2000));
                }
                // Checks if the thread is set to suspend
                synchronized (this) {
                    while (lightSuspended) {
                        System.out.println("Traffic light Thread is suspended - " + thread.getName());
                        wait();
                    }
                }
                changeColor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Changes color.
    synchronized void changeColor() {
        switch (lightColor) {
            case RED -> lightColor = LightColor.GREEN;
            case YELLOW -> lightColor = LightColor.RED;
            case GREEN -> lightColor = LightColor.YELLOW;
        }
        label.setText(lightColor.toString());
    }

    // Return current color.
    synchronized LightColor getColor() {
        return lightColor;
    }

    // Stop the traffic light.
    public void stopTL() {
        stop = true;
        System.out.println("Thread stopped for light - " + thread.getName());
    }
    // Returns the location of the traffic light
    public int getLocation() {
        return location;
    }
    // Temporarily suspends traffic light
    public void pauseTLight() {
        lightSuspended = true;
    }
    // Resumes temporarily suspended traffic light
    public synchronized void resumeTLight() {
        lightSuspended = false;
        notify();
        System.out.println("Traffic light Thread is resumed - " + thread.getName());
    }
}
