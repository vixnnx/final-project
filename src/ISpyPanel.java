import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ISpyPanel extends JPanel implements MouseListener, ActionListener {

    private BufferedImage background;
    private Item semi;
    private Item scissors;
    private Item paper;
    private JButton menu;
    private JFrame frame;



    public ISpyPanel(JFrame f) {
        frame = f;
        menu = new JButton("Menu");
        add(menu);
        menu.addActionListener(this);
        try {
            background = ImageIO.read(new File("src/assets/ispy.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        semi = new Item("src/assets/semi.png", 40, 175);
        paper = new Item("src/assets/paper.png", 180, 175);
        scissors = new Item("src/assets/scissors.png",300, 175);

        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();

    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(semi.getImg(), 40, 175, null);
        g.drawImage(paper.getImg(), 180, 175, null);
        g.drawImage(scissors.getImg(), 300, 175, null);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Garamond", Font.BOLD, 24));
        menu.setLocation(7, 27);
    }


    //how to go back to menu
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == menu) {
                new MenuFrame();
                frame.setVisible(false);
            }
        }
    }



    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        Point mouse;
        if (e.getButton() == MouseEvent.BUTTON1) {
            mouse = e.getPoint();

        }
    }

    public void mouseReleased(MouseEvent e) {
        Point mouse;

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}
