/*
        Name - GuiMain.java
        Date - 12/14/2021
        Author - Rajan Goyal
        Purpose - Creates the GUI for the intersection project
*/
import javax.swing.*;
import java.awt.*;

public class GuiMain extends JFrame {

    // JLabel for time
    public static JLabel timeLabel = new JLabel(" 14:32");
    // Buttons for GUI control
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");
    JButton continueButton = new JButton("Continue");
    JButton pauseButton = new JButton("Pause");

    TrafficControl worker = new TrafficControl();
    // Traffic lights
    public static TrafficLights trafficLights1 = new TrafficLights(LightColor.YELLOW, "tl1", 1000);
    public static TrafficLights trafficLights2 = new TrafficLights(LightColor.RED, "tl2", 2000);
    public static TrafficLights trafficLights3 = new TrafficLights(LightColor.GREEN, "tl3", 3000);
    // Traffic light related JLabels
    public static JLabel intersection1Status = trafficLights1.label;
    public static JLabel intersection2Status = trafficLights2.label;
    public static JLabel intersection3Status = trafficLights3.label;
    // Cars
    public static Cars car1 = new Cars("car1", 800);
    public static Cars car2 = new Cars("car2", 1700);
    public static Cars car3 = new Cars("car3", 2500);
    // Car related JLabels
    public static JLabel car1Speed = car1.carSpeed;
    public static JLabel car1Location = car1.carLocation;
    public static JLabel car2Speed = car2.carSpeed;
    public static JLabel car2Location = car2.carLocation;
    public static JLabel car3Speed = car3.carSpeed;
    public static JLabel car3Location = car3.carLocation;

    public GuiMain() {

        // Creates a new JFrame.
        JFrame frame = new JFrame("Traffic Monitor");
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Panels

        // Main panel which will house rest of the panel.
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        //Time Panel
        JPanel timePanel = new JPanel();
        timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.LINE_AXIS));
        JLabel currentTimeLabel = new JLabel("Current Time : ");
        timePanel.add(currentTimeLabel);

        timePanel.add(timeLabel);

        // Intersection 1 panel
        JPanel intersectionPanel1 = new JPanel();
        intersectionPanel1.setLayout(new BoxLayout(intersectionPanel1, BoxLayout.PAGE_AXIS));
        JLabel intersection1 = new JLabel("Intersection 1");
        JLabel intersectionDis1 = new JLabel("1000 Meters");
        intersectionPanel1.add(intersection1);
        intersectionPanel1.add(intersectionDis1);
        intersectionPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
        intersectionPanel1.add(intersection1Status);

        // Intersection 2 panel
        JPanel intersectionPanel2 = new JPanel();
        intersectionPanel2.setLayout(new BoxLayout(intersectionPanel2, BoxLayout.PAGE_AXIS));
        JLabel intersection2 = new JLabel("Intersection 2");
        JLabel intersectionDis2 = new JLabel("2000 Meters");
        intersectionPanel2.add(intersection2);
        intersectionPanel2.add(intersectionDis2);
        intersectionPanel2.add(Box.createRigidArea(new Dimension(0, 10)));
        intersectionPanel2.add(intersection2Status);

        // Intersection 3 panel
        JPanel intersectionPanel3 = new JPanel();
        intersectionPanel3.setLayout(new BoxLayout(intersectionPanel3, BoxLayout.PAGE_AXIS));
        JLabel intersection3 = new JLabel("Intersection 3");
        JLabel intersectionDis3 = new JLabel("3000 Meters");
        intersectionPanel3.add(intersection3);
        intersectionPanel3.add(intersectionDis3);
        intersectionPanel3.add(Box.createRigidArea(new Dimension(0, 10)));
        intersectionPanel3.add(intersection3Status);


        // Cars 1 panel
        JPanel carPanel1 = new JPanel();
        carPanel1.setLayout(new BoxLayout(carPanel1, BoxLayout.PAGE_AXIS));
        JLabel car1 = new JLabel("Car 1");
        JLabel carSpeedDis1 = new JLabel("Speed");
        JLabel carLocationDis1 = new JLabel("Location");
        carPanel1.add(car1);
        carPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
        carPanel1.add(carSpeedDis1);
        carPanel1.add(car1Speed);
        carPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
        carPanel1.add(carLocationDis1);
        carPanel1.add(car1Location);
        carPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
        // Cars 2 panel
        JPanel carPanel2 = new JPanel();
        carPanel2.setLayout(new BoxLayout(carPanel2, BoxLayout.PAGE_AXIS));
        JLabel car2 = new JLabel("Car 2");
        JLabel carSpeedDis2 = new JLabel("Speed");
        JLabel carLocationDis2 = new JLabel("Location");
        carPanel2.add(car2);
        carPanel2.add(Box.createRigidArea(new Dimension(0, 10)));
        carPanel2.add(carSpeedDis2);
        carPanel2.add(car2Speed);
        carPanel2.add(Box.createRigidArea(new Dimension(0, 10)));
        carPanel2.add(carLocationDis2);
        carPanel2.add(car2Location);
        carPanel2.add(Box.createRigidArea(new Dimension(0, 10)));
        // Cars 3 panel
        JPanel carPanel3 = new JPanel();
        carPanel3.setLayout(new BoxLayout(carPanel3, BoxLayout.PAGE_AXIS));
        JLabel car3 = new JLabel("Car 3");
        JLabel carSpeedDis3 = new JLabel("Speed");
        JLabel carLocationDis3 = new JLabel("Location");
        carPanel3.add(car3);
        carPanel3.add(Box.createRigidArea(new Dimension(0, 10)));
        carPanel3.add(carSpeedDis3);
        carPanel3.add(car3Speed);
        carPanel3.add(Box.createRigidArea(new Dimension(0, 10)));
        carPanel3.add(carLocationDis3);
        carPanel3.add(car3Location);
        carPanel3.add(Box.createRigidArea(new Dimension(0, 10)));
        // Buttons for control
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(startButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(stopButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(continueButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(pauseButton);
        // Added intersections
        JPanel intersectionPanel = new JPanel();
        intersectionPanel.setLayout(new BoxLayout(intersectionPanel, BoxLayout.LINE_AXIS));
        intersectionPanel.add(intersectionPanel1);
        intersectionPanel.add(Box.createRigidArea(new Dimension(50, 100)));
        intersectionPanel.add(intersectionPanel2);
        intersectionPanel.add(Box.createRigidArea(new Dimension(50, 100)));
        intersectionPanel.add(intersectionPanel3);
        // Added cars
        JPanel carPanel = new JPanel();
        carPanel.setLayout(new BoxLayout(carPanel, BoxLayout.LINE_AXIS));
        carPanel.add(carPanel1);
        carPanel.add(Box.createRigidArea(new Dimension(25, 100)));
        carPanel.add(carPanel2);
        carPanel.add(Box.createRigidArea(new Dimension(25, 100)));
        carPanel.add(carPanel3);
        // Panel to include Time and intersections
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.PAGE_AXIS));
        upperPanel.add(Box.createRigidArea(new Dimension(25, 25)));
        // Added the time panel to main panel
        upperPanel.add(timePanel);
        upperPanel.add(intersectionPanel);
        // Added upper intersection Panel
        mainPanel.add(BorderLayout.NORTH, upperPanel);
        // Added the cars panel
        mainPanel.add(BorderLayout.CENTER, carPanel);
        // Added the button panel to main panel
        mainPanel.add(BorderLayout.SOUTH, buttonPanel);
        // Setting buttons actions
        buttons();
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void buttons() {
        continueButton.setEnabled(false);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
        // Start button
        startButton.addActionListener(e -> {
            if (!worker.isAlive()) {
                trafficLights1.thread.start();
                trafficLights2.thread.start();
                trafficLights3.thread.start();
                car1.thread.start();
                car2.thread.start();
                car3.thread.start();
                worker.start();

                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                pauseButton.setEnabled(true);

            }
        });
        // Stop button
        stopButton.addActionListener(e -> {
            worker.stopAll();
            continueButton.setEnabled(false);
            pauseButton.setEnabled(false);
            stopButton.setEnabled(false);
        });

        // Continue button
        continueButton.addActionListener(e -> {
            trafficLights1.resumeTLight();
            trafficLights2.resumeTLight();
            trafficLights3.resumeTLight();
            car1.resumeCar();
            car2.resumeCar();
            car3.resumeCar();
            continueButton.setEnabled(false);
            pauseButton.setEnabled(true);

        });

        // Pause Button
        pauseButton.addActionListener(e -> {
            trafficLights1.pauseTLight();
            trafficLights2.pauseTLight();
            trafficLights3.pauseTLight();
            car1.pauseCar();
            car2.pauseCar();
            car3.pauseCar();
            pauseButton.setEnabled(false);
            continueButton.setEnabled(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuiMain::new);
        Thread timer = new Thread(new Timer());
        timer.start();

    }
}