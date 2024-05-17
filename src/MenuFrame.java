import javax.swing.*;
public class MenuFrame {
    private MenuPanel panel;
    private JFrame frame;

    public MenuFrame() {
        frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        // create and add panel
        panel = new MenuPanel(frame);
        frame.add(panel);

        // display the frame
        frame.setVisible(true);
    }
}
