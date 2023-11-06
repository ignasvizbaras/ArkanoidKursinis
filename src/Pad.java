import java.awt.*;

public class Pad {
    private int width = 100;
    private int height = 20;
    private int x = 200;
    private int y = 430;

    public void drawPad(Graphics2D graphics2D) {
        graphics2D.setColor(Color.darkGray);
        graphics2D.fillRoundRect(x, y, width, height, 20, 20);
        graphics2D.drawRoundRect(x, y, width, height, 20, 20);
    }

    public void moveRight() {
        x += 20;
    }

    public void moveLeft() {
        x -= 20;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }
}
