import java.awt.*;

public class Ball {
    private int diameter = 20;
    private int x = 240;
    private int y = 409;
    private int ballMovementToX = -1;
    private int ballMovementToY = -1;

    public void drawBall(Graphics2D g) {
        g.setColor(Color.black);
        g.fillOval(x, y, diameter, diameter);
    }

    public void moveBall(boolean isBallTouchedPad) {
        if(isBallTouchedPad){
            ballMovementToY = -ballMovementToY;
        }
        x += ballMovementToX;
        y += ballMovementToY;
        if (x  < 0 || x + diameter > Main.screenWidth){
            ballMovementToX = -ballMovementToX;
        }
        if (y < 0){
            ballMovementToY = -ballMovementToY;
        }
    }

    public void changeDirection(Brick brick){
        int brickCenterX = brick.getX() + brick.getWidth() / 2;
        int brickCenterY = brick.getY() + brick.getHeight() / 2;
        int dx = brickCenterX - (x + diameter / 2);
        int dy = brickCenterY - (y + diameter / 2);
        if (Math.abs(dx) > Math.abs(dy)) {
            changeBallMovementX();
        } else {
            changeBallMovementY();
        }
    }

    public boolean checkIfBallIsOutOfScreen(){
        return y + diameter > Main.screenHeight;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getX() {
        return x;
    }

    public void changeBallMovementX() {
        this.ballMovementToX = -ballMovementToX;
    }

    public void changeBallMovementY() {
        this.ballMovementToY = -ballMovementToY;
    }
}

