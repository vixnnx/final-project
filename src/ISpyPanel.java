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
    private Item car;
    private Item cat;
    private Item crane;
    private Item dogcar;
    private Item fastfood;
    private Item firetruck;
    private Item flag;
    private Item surfboard;
    private Item trafficcone;
    private Item train;
    private Item truck;

    private JButton menu;
    private JFrame frame;
    private int[] gone;



    public ISpyPanel(JFrame f) {
        frame = f;
        gone = new int[] {-100, -100};
        menu = new JButton("Menu");
        add(menu);
        menu.addActionListener(this);
        try {
            background = ImageIO.read(new File("src/assets/ispy.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //900,640
        semi = new Item("src/assets/ispy/semi.png", 10, 50);
        car = new Item("src/assets/ispy/bluecar.png",90,100);
        cat = new Item("src/assets/ispy/cat.png",100,150); // smaller
        crane = new Item("src/assets/ispy/crane.png",260,100);
        dogcar = new Item("src/assets/ispy/dogcar.png",150,62);
        fastfood = new Item("src/assets/ispy/fastfood.png",39,12);
        firetruck = new Item("src/assets/ispy/firetruck.png",206,100);
        flag = new Item("src/assets/ispy/flag.png",300,65);
        surfboard = new Item("src/assets/ispy/surfboard.png",196,36);
        trafficcone = new Item("src/assets/ispy/trafficcone.png");
        truck= new Item("src/assets/ispy/truck.png");
        train = new Item("src/assets/ispy/train.png");
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();

    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(semi.getImg(), semi.getX(), semi.getY(), null);
        g.drawImage(car.getImg(), car.getX(), car.getY(), null);
        g.drawImage(cat.getImg(), cat.getX(), cat.getY(), null);
        g.drawImage(crane.getImg(), crane.getX(), crane.getY(), null);
        g.drawImage(dogcar.getImg(), dogcar.getX(), dogcar.getY(), null);
        g.drawImage(fastfood.getImg(), fastfood.getX(), fastfood.getY(), null);
        g.drawImage(firetruck.getImg(), firetruck.getX(), firetruck.getY(), null);
        g.drawImage(surfboard.getImg(), surfboard.getX(), surfboard.getY(), null);
        g.drawImage(flag.getImg(), flag.getX(), flag.getY(), null);
        g.drawImage(trafficcone.getImg(), trafficcone.getX(), trafficcone.getY(), null);
        g.drawImage(train.getImg(), train.getX(), train.getY(), null);
        g.drawImage(truck.getImg(), truck.getX(), truck.getY(), null);




        menu.setLocation(3, 27);

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
