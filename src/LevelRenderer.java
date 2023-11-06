import java.awt.*;

public class LevelRenderer {
    private Brick[][] bricks;
    public LevelRenderer(int row, int col){
        bricks = new Brick[row][col];
        for(int i = 0; i < bricks.length; i++){
            for(int j = 0; j < bricks[0].length; j++) {
                bricks[i][j] = new Brick(i, j);
            }
        }
    }

    public void drawLevel(Graphics2D graphics2D, Ball ball){
        for(int i = 0; i < bricks.length; i++){
            for(int j = 0; j < bricks[0].length; j++) {
                if(isBallTouchedBrick(ball, bricks[i][j])){
                    bricks[i][j].setDestroyed(true);
                    ball.changeDirection(bricks[i][j]);
                }
                bricks[i][j].drawBrick(graphics2D);
            }
        }
    }

    public boolean isBallTouchedBrick(Ball ball, Brick brick){
        if(brick.isDestroyed()){
            return false;
        }
        Rectangle ballRectangle = new Rectangle(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());
        Rectangle brickRectangle = new Rectangle(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
        return brickRectangle.intersects(ballRectangle);
    }
    public boolean isLevelCompleted(){
        for(int i = 0; i < bricks.length; i++){
            for(int j = 0; j < bricks[0].length; j++) {
                if(!bricks[i][j].isDestroyed()){
                    return false;
                }
            }
        }
        return true;
    }
}
