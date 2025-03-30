package GenderReveal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Start implements ActionListener{

	JFrame frame = new JFrame();
	JButton button = new JButton("START!");
	ImageIcon gender = new ImageIcon(getClass().getResource("gender.jpg"));
	JLabel background = new JLabel(gender);
	
	Start(){
		button.setBounds(200,400,100,40);
		button.setFocusable(false);
		button.addActionListener(this);

		frame.add(button);
		
		background.setBounds(0, 0, 500, 600);
        frame.add(background);
        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
            frame.dispose();
            Gender gender = new Gender();
		}
	}
}
