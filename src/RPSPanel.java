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
    private Item paper;
    private BufferedImage[] pc;
    private int random;
    private boolean won;
    private boolean tie;
    private int count;
    private int score;
    private JButton menu;



    public RPSPanel() {
        count = 0;
        random = 3;
        score = 0;
        menu = new JButton("Menu");
        add(menu);
        menu.addActionListener(this);
        try {
            background = ImageIO.read(new File("src/RPSbackground.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            pc = new BufferedImage[] {ImageIO.read(new File("src/rock.png")),
                    ImageIO.read(new File("src/paper.png")),
                    ImageIO.read(new File("src/scissors.png")),
                    ImageIO.read(new File("src/4.png"))};
        } catch  (IOException e) {
            System.out.println(e.getMessage());
        }
        rock = new Item("src/rock.png", 40, 175);
        paper = new Item("src/paper.png", 180, 175);
        scissors = new Item("src/scissors.png",300, 175);

        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();

    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(rock.getImg(), 40, 175, null);
        g.drawImage(paper.getImg(), 180, 175, null);
        g.drawImage(scissors.getImg(), 300, 175, null);
        g.drawImage(pc[random], 170, 20, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + score, 7, 17);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Courier New", Font.BOLD, 24));
        if (count != 0) {
            if (won) {
                g.drawString("You Won :D", 100, 120);
            } else if (tie) {
                g.drawString("You Tied :/", 100, 120);
            } else {
                g.drawString("You Lost :(", 100, 120);
            }
        } else {
            g.drawString("Click an image to play!", 50, 120);
        }
    }


//how to go back to menu
  /*  public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == menu) {
                new MainFrame();
                frame.setVisible(false);
            }
        }
    }
*/

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
        Point mouse;
        if (e.getButton() == MouseEvent.BUTTON1) {  // left mouse click
            mouse = e.getPoint();
            count++;
            if (rock.rect().contains(mouse)) {
                if (random == 0) {// tie, rock
                    won = false;
                    tie = true;
                } else if (random == 1) { //paper, lose
                    won = false;
                    tie = false;
                } else { // scissors, won
                    score++;
                    won = true;
                    tie = false;
                }
                random = (int) (Math.random() * 3);
            } else if (paper.rect().contains(mouse)) {
                if (random == 0) { // rock
                    score++;
                    won = true;
                    tie = false;
                } else if (random == 1) { // paper
                    won = false;
                    tie = true;
                } else { // scissors
                    won = false;
                    tie = false;
                }
                random = (int) (Math.random() * 3);
            } else if (scissors.rect().contains(mouse)) {// scissors
                if (random == 0) {
                    won = false;
                    tie = false;
                } else if (random == 1) { // paper
                    score++;
                    won = true;
                    tie = false;
                } else {
                    won = false;
                    tie = true;
                }
                random = (int) (Math.random() * 3);
            }
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
