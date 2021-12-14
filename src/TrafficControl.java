class TrafficControl extends Thread {
    boolean runner = true;

    @Override
    public void run() {
        while (runner) {

            String trafficLight1 = GuiMain.trafficLight1.getColor().toString();
            String trafficLight2 = GuiMain.trafficLight2.getColor().toString();
            String trafficLight3 = GuiMain.trafficLight3.getColor().toString();
            GuiMain.intersection1Status.setText(trafficLight1);
            GuiMain.intersection2Status.setText(trafficLight2);
            GuiMain.intersection3Status.setText(trafficLight3);

            int car1Location = GuiMain.car1.location;
            GuiMain.car1Location.setText(car1Location + ", 0");

            int car2Location = GuiMain.car2.location;
            GuiMain.car2Location.setText(car2Location + ", 0");

            int car3Location = GuiMain.car3.location;
            GuiMain.car3Location.setText(car3Location + ", 0");


            if (trafficLight1.equals("RED")) {
                if (car1Location == 990)
                    GuiMain.car1.cancel();
                if (car2Location == 990)
                    GuiMain.car2.cancel();
                if (car3Location == 990)
                    GuiMain.car3.cancel();
            }

            if (trafficLight2.equals("RED")) {
                if (car1Location == 1980)
                    GuiMain.car1.cancel();
                if (car2Location == 1980)
                    GuiMain.car2.cancel();
                if (car3Location == 1980)
                    GuiMain.car3.cancel();
            }

            if (trafficLight3.equals("RED")) {
                if (car1Location == 2970)
                    GuiMain.car1.cancel();
                if (car2Location == 2970)
                    GuiMain.car2.cancel();
                if (car3Location == 2970)
                    GuiMain.car3.cancel();
            }


            if (trafficLight1.equals("GREEN")) {
                if (!GuiMain.car1.isCarRunning)
                    GuiMain.car1.restart();
                if (!GuiMain.car2.isCarRunning)
                    GuiMain.car2.restart();
                if (!GuiMain.car3.isCarRunning)
                    GuiMain.car3.restart();

            }

        }
    }

    synchronized void cancel() {
        runner = false;
    }
}
