import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.AWTEventMulticaster.add;

public class MenuPanel extends JPanel implements ActionListener{
    private JButton RPSButton;
    private JButton WhackButton;
    private JFrame frame;


    public MenuPanel(JFrame frame) {
        this.frame = frame;
        RPSButton = new JButton("Rock Paper Scissors");
        WhackButton = new JButton("Whack a Mole");
        add(RPSButton);
        add(WhackButton);
        RPSButton.addActionListener(this);
        WhackButton.addActionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        g.setColor(Color.PINK);
        g.drawString("Pick a game to play!", 70, 75);
        RPSButton.setLocation(50, 120);
        WhackButton.setLocation(225, 120);
    }



    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == RPSButton) {
                new RPSFrame();
                frame.setVisible(false);
            } else {
                new WhackFrame();
                frame.setVisible(false);
            }
        }
    }
}
