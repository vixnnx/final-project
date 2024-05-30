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
    private JButton ISpyButton;
    private JFrame frame;


    public MenuPanel(JFrame frame) {
        this.frame = frame;
        RPSButton = new JButton("Rock Paper Scissors");
        WhackButton = new JButton("Whack a Mole");
        ISpyButton = new JButton("ISPY");
        add(RPSButton);
        add(WhackButton);
        add(ISpyButton);
        RPSButton.addActionListener(this);
        WhackButton.addActionListener(this);
        ISpyButton.addActionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
           g.drawImage(ImageIO.read(new File("src/assets/roadtrip.png")), 0, -16, null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        g.setFont(new Font("Georgia", Font.BOLD, 30));
        g.setColor(Color.BLUE);
        g.drawString("Road Trip Hub", 75, 80);

        RPSButton.setLocation(10, 160);
        WhackButton.setLocation(260, 160);
        ISpyButton.setLocation(180, 160);
    }



    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == RPSButton) {
                new RPSFrame();
                frame.setVisible(false);
            } else if (button == WhackButton) {
                new WhackFrame();
                frame.setVisible(false);
            } else if (button == ISpyButton) {
                new ISpyFrame();
                frame.setVisible(false);
            }
        }
    }
}
