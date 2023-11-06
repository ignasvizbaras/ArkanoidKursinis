import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements ActionListener, KeyListener {
    LevelRenderer levelRenderer;
    Pad pad;
    Ball ball;
    Timer timer = new Timer(5, this);
    private boolean gameEnd = false;

    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setDoubleBuffered(true);
        initializeGameStart();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameEnd){
            ball.moveBall(isBallTouchedPad());
            if (ball.checkIfBallIsOutOfScreen() || levelRenderer.isLevelCompleted()){
                gameEnd = true;
                timer.stop();
                int choice = JOptionPane.showConfirmDialog(this, "Game over \nDo you want to restart the game?", "Game Over", JOptionPane.YES_NO_OPTION);
                if(choice == JOptionPane.YES_OPTION){
                    restartGame();
                }
                else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION){
                    System.exit(0);
                }
            }
            repaint();
        }
    }

    public void initializeGameStart(){
        levelRenderer = new LevelRenderer(4, 8);
        pad = new Pad();
        ball = new Ball();
    }
    public void restartGame(){
        gameEnd = false;
        initializeGameStart();
    }

    public boolean isBallTouchedPad(){
        int paddleStart = pad.getX();
        int paddleEnd = paddleStart + pad.getWidth();
        if ((ball.getX() >= paddleStart && ball.getX() <= paddleEnd) && ball.getY() + ball.getDiameter() == pad.getY()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        levelRenderer.drawLevel((Graphics2D) g, ball);
        pad.drawPad((Graphics2D) g);
        ball.drawBall((Graphics2D) g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (pad.getX() < Main.screenWidth - pad.getWidth()){
                pad.moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(pad.getX() > 0){
                pad.moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            timer.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
