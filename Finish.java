package GenderReveal;
import java.awt.*;
import javax.swing.*;

public class Finish {
	
    JFrame frame = new JFrame();
    ImageIcon reveal = new ImageIcon(getClass().getResource("reveal.jpg"));
    JLabel background = new JLabel(reveal);
    
    Finish() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

		background.setBounds(0, 0, 500, 600);
		
        frame.add(background);
        frame.setVisible(true);
    }
}