import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RPSPanel extends JPanel implements MouseListener, ActionListener {

    private BufferedImage background;
    private Item rock;
    private Item scissors;
    private Item paper; // item instead of each thing getting its own class



    public RPSPanel() {
        try {
            background = ImageIO.read(new File("src/RPSbackground.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        rock = new Item();
        paper = new Item();
        scissors = new Item();
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();

    }



    public void actionPerformed(ActionEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
