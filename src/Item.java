import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Item {

    private BufferedImage img;
    private int x;
    private int y;


    public Item(String i, int a, int b) {
        x = a;
        y = b;

        try {
            img = ImageIO.read(new File(i));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public Item(String i) {
        try {
            img = ImageIO.read(new File(i));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public BufferedImage getImg() {
        return img;
    }


    public Rectangle rect() {
        int imageHeight = img.getHeight();
        int imageWidth = img.getWidth();
        Rectangle rect = new Rectangle((int) x, (int) y, imageWidth, imageHeight);
        return rect;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


    public void setXY(int[] a) {
        x = a[0];
        y = a[1];
    }

    public void setImg(String name) {
        try {
            img = ImageIO.read(new File(name));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
