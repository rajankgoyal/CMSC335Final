/*
        Name - TrafficControl.java
        Date - 12/14/2021
        Author - Rajan Goyal
        Purpose - Controls the flow of the traffic. Switches individual car
        to suspend or resume based on their location and status of the traffic light
*/
class TrafficControl extends Thread {
    boolean runner = true;
    // Traffic lights
    TrafficLights tl1 = GuiMain.trafficLights1;
    TrafficLights tl2 = GuiMain.trafficLights2;
    TrafficLights tl3 = GuiMain.trafficLights3;
    // Cars
    Cars car1 = GuiMain.car1;
    Cars car2 = GuiMain.car2;
    Cars car3 = GuiMain.car3;
    // Array of all Traffic lights
    TrafficLights[] tls = {tl1, tl2, tl3};
    // Array of all cars
    Cars[] cars = {car1, car2, car3};
    // Minimum distance for cars to stop at traffic light
    int stopDistance = 25;

    @Override
    public void run() {
        while (runner) {
            // Monitors all red lights. stops any car that is driving through the intersection
            for (TrafficLights tl : tls) {
                if (tl.getColor().toString().equals("RED")) {
                    for (Cars car : cars) {
                        if (car.location < tl.getLocation() &&
                                car.location > tl.getLocation() - stopDistance)
                            car.pauseCar();
                    }
                }
            }
            // Monitors all Green lights. Resumes any stopped car at the intersection
            for (TrafficLights tl : tls) {
                if (tl.getColor().toString().equals("GREEN")) {
                    for (Cars car : cars) {
                        if (!car.isCarRunning && car.location < tl.getLocation() &&
                                car.location > tl.getLocation() - stopDistance)
                            car.resumeCar();
                    }
                }
            }
        }
    }
    // Method to stop all the threads.
    synchronized void stopAll() {
        // Terminates traffic lights
        tl1.stopTL();
        tl2.stopTL();
        tl3.stopTL();
        // Terminates cars
        car1.stopCar();
        car2.stopCar();
        car3.stopCar();
        // Terminates its self
        runner = false;
    }
}
