import javax.swing.*;

public class Cars implements Runnable {
    boolean carRunner;
    boolean isCarRunning;
    String carName;
    final Thread thread;
    int location;
    int speedAddition;
    JLabel carLocation;
    JLabel carSpeed;

    public Cars(String carName, int location) {
        this.carName = carName;
        this.thread = new Thread(this, carName);
        this.location = location;
        carRunner = true;
        speedAddition = 5;
        isCarRunning = true;
        carLocation = new JLabel(location + ", 0");
        carSpeed = new JLabel("0 mph");
    }

    @Override
    public void run() {
        carSpeed.setText("100 mph");
        while (carRunner) {
            //Resets cars back to 0 if it reaches outside the simulation window.
            if (location > 3500)
                location = 0;

            try {
                Thread.sleep(100);
                synchronized (this) {
                    while (!isCarRunning) {
                        System.out.println("Car Thread is suspended - " + thread.getName());
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            location += speedAddition;
            carLocation.setText(location + ", 0");
        }
    }

    // Temporarily suspends the car.
    public void pauseCar() {
        carSpeed.setText("0 mph");
        isCarRunning = false;
    }

    // Resumes temporarily suspended car.
    public synchronized void resumeCar() {
        carSpeed.setText("100 mph");
        isCarRunning = true;
        notify();
        System.out.println("Car Thread is resumed - " + thread.getName());
    }
    // Stop the car thread.
    public void stopCar() {
        carRunner = false;
        carSpeed.setText("0 mph");
        System.out.println("Thread stopped for car - " + thread.getName());
    }
}
