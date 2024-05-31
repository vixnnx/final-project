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

    private static Item semi = new Item("src/assets/ispy/semi.png", 10, 50);
    private static Item car = new Item("src/assets/ispy/bluecar.png",700,200);
    private static Item cat = new Item("src/assets/ispy/cat.png",400,160); // smaller
    private static Item crane = new Item("src/assets/ispy/crane.png",240,480);
    private static Item dogcar = new Item("src/assets/ispy/dogcar.png",300,25);
    private static Item fastfood = new Item("src/assets/ispy/fastfood.png",100,300);
    private static Item firetruck = new Item("src/assets/ispy/firetruck.png",600,500);
    private static Item flag = new Item("src/assets/ispy/flag.png",236,207);
    private static Item surfboard = new Item("src/assets/ispy/surfboard.png",796,36);
    private static Item trafficcone = new Item("src/assets/ispy/trafficcone.png", 800, 361);
    private static Item truck= new Item("src/assets/ispy/truck.png",600,50);
    private static Item train = new Item("src/assets/ispy/train.png",50,150);
    private static Item plane = new Item("src/assets/ispy/plane.png",350,390);
    private static Item stop = new Item("src/assets/ispy/stop.png",50,450);
    private static Item gas = new Item("src/assets/ispy/gas.png",580,280);

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
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();

    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(train.getImg(), train.getX(), train.getY(), null);
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
        g.drawImage(truck.getImg(), truck.getX(), truck.getY(), null);
        g.drawImage(plane.getImg(), plane.getX(), plane.getY(), null);
        g.drawImage(stop.getImg(), stop.getX(), stop.getY(), null);
        g.drawImage(gas.getImg(), gas.getX(), gas.getY(), null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Garamond", Font.BOLD, 24));
        menu.setLocation(3, 5);
        g.drawString("if you see it outside, click it", 5, 595);

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

    }

    public void mouseReleased(MouseEvent e) {
        Point mouse;
        if (e.getButton() == MouseEvent.BUTTON1) {
            mouse = e.getPoint();

            if (semi.rect().contains(mouse)) {
                semi.setImg("src/assets/4.png");
            }
            if (car.rect().contains(mouse)) {
                car.setImg("src/assets/4.png");
            }
            if (cat.rect().contains(mouse)) {
                cat.setImg("src/assets/4.png");
            }
            if (crane.rect().contains(mouse)) {
                crane.setImg("src/assets/4.png");
            }
            if (dogcar.rect().contains(mouse)) {
                dogcar.setImg("src/assets/4.png");
            }
            if (fastfood.rect().contains(mouse)) {
                fastfood.setImg("src/assets/4.png");
            }
            if (firetruck.rect().contains(mouse)) {
                firetruck.setImg("src/assets/4.png");
            }
            if (flag.rect().contains(mouse)) {
                flag.setImg("src/assets/4.png");
            }
            if (surfboard.rect().contains(mouse)) { //
                surfboard.setImg("src/assets/4.png");
            }
            if (trafficcone.rect().contains(mouse)) {
                trafficcone.setImg("src/assets/4.png");
            }
            if (truck.rect().contains(mouse)) {
                truck.setImg("src/assets/4.png");
            }

            if (stop.rect().contains(mouse)) {
                stop.setImg("src/assets/4.png");
            }
            if (plane.rect().contains(mouse)) {
                plane.setImg("src/assets/4.png");
            }
            if (gas.rect().contains(mouse)) {
                gas.setImg("src/assets/4.png");
            }
            if (train.rect().contains(mouse)) {
                train.setImg("src/assets/4.png");
            }
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}
