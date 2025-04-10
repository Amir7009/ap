package ap.exercises.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Main_EX2_PM_3_2 extends JFrame implements KeyListener {

    Point pacmanPoint = new Point();
    int width = 0, height = 0;
    static int direction = 1;
    final int LEFT = 1, RIGHT = 2, TOP = 3, BOTTOM = 4, boxSize = 10;


    public static void main(String[] args) {

        Main_EX2_PM_3_2 frame = new Main_EX2_PM_3_2();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Main_EX2_PM_3_2() {
        addKeyListener(this);
        System.out.println("Please enter map size: ");
        Scanner input = new Scanner(System.in);
        width = height = (input.nextInt()+2) * 10;
        setSize(width, height);
        pacmanPoint.setLocation((width / boxSize) / 2, (height / boxSize) / 2);

    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(10));
        g2D.drawRect(0, 0, width - 1, height - 1);

        logic();
        drawPacman(g2D);
    }

    private void drawPacman(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.fillRect(pacmanPoint.x * boxSize, pacmanPoint.y * boxSize, boxSize, boxSize);
    }

    private void logic() {
        movePacman();
    }

    private void movePacman() {
        int xMovement;
        int yMovement;
        switch (direction) {
            case LEFT:
                xMovement = -1;
                yMovement = 0;
                break;
            case RIGHT:
                xMovement = 1;
                yMovement = 0;
                break;
            case TOP:
                xMovement = 0;
                yMovement = -1;
                break;
            case BOTTOM:
                xMovement = 0;
                yMovement = 1;
                break;
            default:
                xMovement = yMovement = 0;
                break;
        }
        pacmanPoint.setLocation(pacmanPoint.x + xMovement, pacmanPoint.y + yMovement);
        handleCrossBorder();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP)
            direction = 3;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            direction = 4;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            direction = 1;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            direction = 2;
        else if (e.getKeyCode() == KeyEvent.VK_P)
            direction = 0;
        else if (e.getKeyCode() == KeyEvent.VK_Q)
            System.exit(0);
        else
            direction = -1;

        System.out.println("direction:" + direction + "    <- e.getKeyCode()=" + e.getKeyCode());

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void handleCrossBorder() {
        if (pacmanPoint.x < 1) {
            pacmanPoint.x = 1;
        } // Left border control
        else if (pacmanPoint.x >= (width / boxSize)-1) {
            pacmanPoint.x = (width / boxSize) - 2;
        } // Right border control
        if (pacmanPoint.y < 1) {
            pacmanPoint.y = 1;
        } // Top border control
        else if (pacmanPoint.y >= (height / boxSize)-1) {
            pacmanPoint.y = (height / boxSize) - 2;
        } // Down border control
    }
}
