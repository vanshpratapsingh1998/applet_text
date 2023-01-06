import javax.swing.*;
import java.applet.Applet;
import java.awt.*;


    /*
    <applet code = "TextMover" width=1500 height=800>
    </applet>
    */

public class TextMover extends Applet implements Runnable {
    String movtext = null;
    Thread t = null;
    boolean flag;
    int x =50;
    int y = 10;
    int i = 10;

    public void init(){

        String fn = JOptionPane.showInputDialog("Enter String");
        movtext = fn.toUpperCase();
        setBackground(Color.cyan);
        setForeground(Color.red);
    }

    public void start(){
        t = new Thread(this);
        flag = false;
        t.start();
    }

    @Override
    public void run() {
        for (;;){
            try{
                repaint();
                Thread.sleep(250);
                if(y>=750){
                    y = 10;
                    i =10;
                }
                y+=10;
                i++;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop(){
        flag = true;
        t = null;
    }
    public void paint(Graphics g){
        g.setFont(new Font("Arial", Font.BOLD, i));
        g.drawString(movtext, x, y);
    }

}
