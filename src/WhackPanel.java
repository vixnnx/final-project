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
    private Item mole;
    private int random; // which hole
    private static int score;
    private JButton menu;
    private JFrame frame;
    private int[][] location; // each array is the x,y of one hole



    public WhackPanel (JFrame f) {
        location = new int[][]{{77, 5}, {67, 105}, {137,205}, {195,45}, {220, 128}, {337, 27}, {373, 90}, {353,179}};
        frame = f;
        mole = new Item ("src/assets/mole.png");
        random = (int) (Math.random()*8);
        mole.setXY(location[random]);
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
        g.drawImage(mole.getImg(), location[random][0], location[random][1], null);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + score, 7, 20);
        g.setColor(Color.BLACK);
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
        Point mouse;
        if (e.getButton() == MouseEvent.BUTTON1) {
            mouse = e.getPoint();
            if (mole.rect().contains(mouse)) {
                random = (int) (Math.random() * 8);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        Point mouse;
        if (e.getButton() == MouseEvent.BUTTON1) {  // left mouse click
            mouse = e.getPoint();
            if (mole.rect().contains(mouse)) {
                score++;
                mole.setXY(location[random]);
            }
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}
