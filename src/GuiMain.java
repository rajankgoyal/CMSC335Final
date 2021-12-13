import javax.swing.*;
import java.awt.*;

public class GuiMain {
    public GuiMain() {

        // Creates a new JFrame.
        JFrame frame = new JFrame("Traffic Monitor");
        frame.setSize(500, 400);
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
        JLabel timeLabel = new JLabel(" 14:32");
        timePanel.add(timeLabel);


        // Intersection panel
        JPanel intersectionPanel1 = new JPanel();
        intersectionPanel1.setLayout(new BoxLayout(intersectionPanel1, BoxLayout.PAGE_AXIS));
        JLabel intersection1 = new JLabel("Intersection 1");
        JLabel intersectionDis1 = new JLabel("1000 Meters");
        JLabel intersection1Status = new JLabel("Green");
        intersectionPanel1.add(intersection1);
        intersectionPanel1.add(intersectionDis1);
        intersectionPanel1.add(Box.createRigidArea(new Dimension(0,10)));
        intersectionPanel1.add(intersection1Status);

        // Intersection panel
        JPanel intersectionPanel2 = new JPanel();
        intersectionPanel2.setLayout(new BoxLayout(intersectionPanel2, BoxLayout.PAGE_AXIS));
        JLabel intersection2 = new JLabel("Intersection 2");
        JLabel intersectionDis2 = new JLabel("2000 Meters");
        JLabel intersection2Status = new JLabel("Green");
        intersectionPanel2.add(intersection2);
        intersectionPanel2.add(intersectionDis2);
        intersectionPanel2.add(Box.createRigidArea(new Dimension(0,10)));
        intersectionPanel2.add(intersection2Status);

        // Intersection panel
        JPanel intersectionPanel3 = new JPanel();
        intersectionPanel3.setLayout(new BoxLayout(intersectionPanel3, BoxLayout.PAGE_AXIS));
        JLabel intersection3 = new JLabel("Intersection 3");
        JLabel intersectionDis3 = new JLabel("3000 Meters");
        JLabel intersection3Status = new JLabel("Green");
        intersectionPanel3.add(intersection3);
        intersectionPanel3.add(intersectionDis3);
        intersectionPanel3.add(Box.createRigidArea(new Dimension(0,10)));
        intersectionPanel3.add(intersection3Status);





        // Buttons for control
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JButton continueButton = new JButton("Continue");
        JButton pauseButton = new JButton("Pause");
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(continueButton);
        buttonPanel.add(pauseButton);


        JPanel intersectionPanel = new JPanel();
        intersectionPanel.setLayout(new BoxLayout(intersectionPanel, BoxLayout.LINE_AXIS));


        intersectionPanel.add(intersectionPanel1);
        intersectionPanel.add(Box.createRigidArea(new Dimension(50,100)));
        intersectionPanel.add(intersectionPanel2);
        intersectionPanel.add(Box.createRigidArea(new Dimension(50,100)));
        intersectionPanel.add(intersectionPanel3);

        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.PAGE_AXIS));
        upperPanel.add(Box.createRigidArea(new Dimension(25,25)));
        // Added the time panel to main panel
        upperPanel.add(timePanel);
        upperPanel.add(intersectionPanel);

        mainPanel.add(BorderLayout.NORTH, upperPanel);
        // Added the button panel to main panel
        mainPanel.add(BorderLayout.SOUTH, buttonPanel);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuiMain());
    }
}
