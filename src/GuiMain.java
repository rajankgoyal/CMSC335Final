import javax.swing.*;

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
        // Added the time panel to main panel
        mainPanel.add(timePanel);

        JPanel intersectionPanel = new JPanel();
        intersectionPanel.setLayout(new BoxLayout(intersectionPanel, BoxLayout.LINE_AXIS));





        frame.add(mainPanel);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuiMain());
    }
}
