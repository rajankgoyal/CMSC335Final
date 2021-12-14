public class Cars implements Runnable {
    boolean carRunner;
    boolean isCarRunning;
    String carName;
    final Thread thread;
    int location;
    int locationAddition;

    public Cars(String carName, int location) {
        this.carName = carName;
        this.thread = new Thread(this, carName);
        this.location = location;
        carRunner = true;
        locationAddition = 5;
        isCarRunning = true;
    }

    @Override
    public void run() {
        while (carRunner) {
            //Resets cars back to 0 if it reaches outside the simulation window.
            if (location > 3500)
                location = 0;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            location += locationAddition;
            System.out.println(location);
        }
    }

    // Stop the car.
    public void cancel() {
        locationAddition = 0;
        isCarRunning = false;
    }


    // Restart the car.
    public void restart() {
        locationAddition = 5;
        isCarRunning = true;
    }

    public int getLocationAddition(){
        return locationAddition;
    }
}
