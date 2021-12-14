// Try This 12-1

// A simulation of a traffic light that uses 
// an enumeration to describe the light's color. 

import javax.swing.*;

// An enumeration of the colors of a traffic light.
enum TrafficLightColor {
    RED, GREEN, YELLOW
}

// A computerized traffic light. 
public class TrafficLight implements Runnable {
    private TrafficLightColor tlc; // holds the current traffic light color
    private boolean stop = false; // set to true to stop the simulation
    private boolean changed = false; // true when the light has changed
    boolean lightSuspended = false;
    private int location;
    Thread thread;
    JLabel label;

    TrafficLight(TrafficLightColor init, String name, int location) {
        tlc = init;
        thread = new Thread(this, name);
        this.location = location;
        label = new JLabel(tlc.toString());
    }

    TrafficLight() {
        tlc = TrafficLightColor.RED;
    }

    // Start up the light.
    public void run() {
        while (!stop) {
            changeColor();
            try {
                switch (tlc) {
                    case GREEN -> Thread.sleep(5000); // green for 10 seconds
                    case YELLOW -> Thread.sleep(500);  // yellow for 2 seconds
                    case RED -> Thread.sleep(8000); // red for 12 seconds
                }
                // Checks if the thread is set to suspend
                synchronized (this) {
                    while (lightSuspended) {
                        System.out.println("Traffic light Thread is suspended - " + thread.getName());
                        wait();
                    }
                }
            } catch (InterruptedException exception) {
                System.out.println(exception);
            }

        }
    }

    // Change color.
    synchronized void changeColor() {
        switch (tlc) {
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
        }
        label.setText(tlc.toString());
        changed = true;
        //notify(); // signal that the light has changed
    }

    // Wait until a light change occurs.
    synchronized void waitForChange() {
        try {

            wait(); // wait for light to change
            System.out.println("waiting");

//            changed = false;
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }

    // Return current color.
    synchronized TrafficLightColor getColor() {
        return tlc;
    }

    // Stop the traffic light.
    public void stopTL() {
        stop = true;
        System.out.println("Thread stopped for light - " + thread.getName());
    }

    public int getLocation() {
        return location;
    }

    public void pauseTLight() {
        lightSuspended = true;
    }

    public synchronized void resumeTLight() {
        lightSuspended = false;
        notify();
        System.out.println("Traffic light Thread is resumed - " + thread.getName());
    }


}
