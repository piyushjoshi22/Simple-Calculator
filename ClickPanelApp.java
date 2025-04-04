import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ClickPanelApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Click Coordinates");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Clicked at: X=" + e.getX() + " Y=" + e.getY());
            }
        });
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
