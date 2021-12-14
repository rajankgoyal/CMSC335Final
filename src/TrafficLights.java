import javax.swing.*;

// Enum for three colors of Traffic light
enum TrafficLightColor {
    RED, GREEN, YELLOW
}

public class TrafficLights implements Runnable {
    private TrafficLightColor trafficLightColor; // Current color of Traffic light.
    private boolean stop = false; // if True terminates the Traffic light thread
    boolean lightSuspended = false; // Used to monitor if the light is set to suspend
    private int location; // Location of the light
    JLabel label; // Used to return a JLabel for intersection GUI
    Thread thread;

    TrafficLights(TrafficLightColor init, String name, int location) {
        trafficLightColor = init;
        thread = new Thread(this, name);
        this.location = location;
        label = new JLabel(trafficLightColor.toString());
    }

    // Starts the light
    public void run() {
        while (!stop) {

            try {
                switch (trafficLightColor) {
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
        switch (trafficLightColor) {
            case RED -> trafficLightColor = TrafficLightColor.GREEN;
            case YELLOW -> trafficLightColor = TrafficLightColor.RED;
            case GREEN -> trafficLightColor = TrafficLightColor.YELLOW;
        }
        label.setText(trafficLightColor.toString());
    }

    // Return current color.
    synchronized TrafficLightColor getColor() {
        return trafficLightColor;
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
