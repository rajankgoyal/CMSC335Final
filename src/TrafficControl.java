class TrafficControl extends Thread {
    boolean runner = true;
    TrafficLight tl1 = GuiMain.trafficLight1;
    TrafficLight tl2 = GuiMain.trafficLight2;
    TrafficLight tl3 = GuiMain.trafficLight3;

    Cars car1 = GuiMain.car1;
    Cars car2 = GuiMain.car2;
    Cars car3 = GuiMain.car3;

    TrafficLight[] tls = {tl1, tl2, tl3};
    Cars[] cars = {car1, car2, car3};
    int stopDistance = 25;

    @Override
    public void run() {
        while (runner) {
            // Monitors all red lights.
            for (TrafficLight tl : tls) {
                if (tl.getColor().toString().equals("RED")) {
                    for (Cars car : cars) {
                        if (car.location < tl.getLocation() &&
                                car.location > tl.getLocation() - stopDistance)
                            car.pauseCar();
                    }
                }
            }
            // Monitors all Green lights.
            for (TrafficLight tl : tls) {
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

    synchronized void cancel() {
        tl1.stopTL();
        tl2.stopTL();
        tl3.stopTL();

        car1.stopCar();
        car2.stopCar();
        car3.stopCar();

        runner = false;
    }
}
