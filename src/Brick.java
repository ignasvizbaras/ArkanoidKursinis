import java.awt.*;

public class Brick {

    private int row;
    private int col;
    private int width = 50;
    private int height = 20;

    private int margin = 43;

    private int gap = 2;
    private int x;
    private int y;
    private boolean destroyed;

    public Brick(int row, int col){
        this.row = row;
        this.col = col;
        this.x = col * (this.width + gap) + margin;
        this.y = row * (this.height + gap) + margin;
        this.destroyed = false;
    }

    public void drawBrick(Graphics2D graphics2D) {
        if(!destroyed){
            graphics2D.setColor(Color.getHSBColor(0.75f, 1f, 1f));
            graphics2D.fillRect(x, y, width, height);
        }
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
