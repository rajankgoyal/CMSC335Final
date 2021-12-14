class TrafficControl extends Thread {
    boolean runner = true;

    int stopDistance = 100;

    @Override
    public void run() {
        while (runner) {

            String trafficLight1 = GuiMain.trafficLight1.getColor().toString();
            String trafficLight2 = GuiMain.trafficLight2.getColor().toString();
            String trafficLight3 = GuiMain.trafficLight3.getColor().toString();

            int tlLocation1 = GuiMain.trafficLight1.getLocation();
            int tlLocation2 = GuiMain.trafficLight2.getLocation();
            int tlLocation3 = GuiMain.trafficLight3.getLocation();

            GuiMain.intersection1Status.setText(trafficLight1);
            GuiMain.intersection2Status.setText(trafficLight2);
            GuiMain.intersection3Status.setText(trafficLight3);

            int car1Location = GuiMain.car1.location;
            GuiMain.car1Location.setText(car1Location + ", 0");

            int car2Location = GuiMain.car2.location;
            GuiMain.car2Location.setText(car2Location + ", 0");

            int car3Location = GuiMain.car3.location;
            GuiMain.car3Location.setText(car3Location + ", 0");

            if (GuiMain.car1.isCarRunning)
                GuiMain.car1Speed.setText("100 mph");
            else
                GuiMain.car1Speed.setText("0 mph");

            if (GuiMain.car2.isCarRunning)
                GuiMain.car2Speed.setText("100 mph");
            else
                GuiMain.car2Speed.setText("0 mph");


            if (GuiMain.car3.isCarRunning)
                GuiMain.car3Speed.setText("100 mph");
            else
                GuiMain.car3Speed.setText("0 mph");

            if (trafficLight1.equals("RED")) {
                if (car1Location == 990)
                    GuiMain.car1.pauseCar();
                if (car2Location == 990)
                    GuiMain.car2.pauseCar();
                if (car3Location == 990)
                    GuiMain.car3.pauseCar();
            }

            if (trafficLight2.equals("RED")) {
                if (car1Location == 1980)
                    GuiMain.car1.pauseCar();
                if (car2Location == 1980)
                    GuiMain.car2.pauseCar();
                if (car3Location == 1980)
                    GuiMain.car3.pauseCar();
            }

            if (trafficLight3.equals("RED")) {
                if (car1Location == 2970)
                    GuiMain.car1.pauseCar();
                if (car2Location == 2970)
                    GuiMain.car2.pauseCar();
                if (car3Location == 2970)
                    GuiMain.car3.pauseCar();
            }

            if (trafficLight1.equals("GREEN")) {
                int tlLocation = tlLocation1;
                if (!GuiMain.car1.isCarRunning
                        && car1Location < tlLocation
                        && car1Location > (tlLocation - stopDistance))
                    GuiMain.car1.restartCar();
                if (!GuiMain.car2.isCarRunning
                        && car2Location < tlLocation
                        && car2Location > (tlLocation - stopDistance))
                    GuiMain.car2.restartCar();
                if (!GuiMain.car3.isCarRunning
                        && car3Location < tlLocation
                        && car3Location > (tlLocation - stopDistance))
                    GuiMain.car3.restartCar();

            }

        }
    }

    synchronized void cancel() {
        runner = false;
    }
}
