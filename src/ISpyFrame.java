import javax.swing.*;

public class ISpyFrame implements Runnable {
    private ISpyPanel panel;

    public ISpyFrame() {
        JFrame frame = new JFrame("ISPY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 640); // 540 height of image + 40 for window menu bar
        frame.setLocationRelativeTo(null); // auto-centers frame in screen

        // create and add panel
        panel = new ISpyPanel(frame);
        frame.add(panel);

        // display the frame
        frame.setVisible(true);

        // start thread, required for animation
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (true) {
            panel.repaint();  // we don't ever call "paintComponent" directly, but call this to refresh the panel
        }
    }
}
