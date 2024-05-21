import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


//find location of all the holes, where to put thr mole
//set a time for how long the mole will be there, and move it
//score++ when hits + music

public class WhackPanel extends JPanel implements MouseListener, ActionListener {

    private BufferedImage background;
    private BufferedImage mole;
    private int random; // which hole
    private static int score;
    private JButton menu;
    private JFrame frame;



    public WhackPanel (JFrame f) {
        frame = f;
        score = 0;
        menu = new JButton("Menu");
        add(menu);
        menu.addActionListener(this);
        try {
            background = ImageIO.read(new File("src/assets/WhackAMoleBG.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();

    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.setColor(Color.BLACK);
        try {
            g.drawImage(ImageIO.read(new File("src/assets/mole.png")), 50, 50, null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + score, 7, 20);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Georgia", Font.BOLD, 24));
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


    public int getScore() {
        return score;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
        Point mouse;
        if (e.getButton() == MouseEvent.BUTTON1) {  // left mouse click
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}
