import javax.swing.*;

public class Main {
    public static int screenWidth = 500;
    public static int screenHeight = 500;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Arkanoid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenWidth, screenHeight);
        frame.setResizable(false);
        Gameplay gameplay = new Gameplay();
        frame.add(gameplay);
        frame.setVisible(true);
    }
}