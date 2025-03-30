package GenderReveal;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gender {
    JFrame frame = new JFrame();
    ImageIcon boy = new ImageIcon(getClass().getResource("boy.png"));
    ImageIcon girl = new ImageIcon(getClass().getResource("girl.png"));
    JProgressBar progressBar; 

    Gender() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3, 3, 3)); 

        String[] buttons = {
            "", "", "",
            "", "", "",
            "", "", ""};

        boy = new ImageIcon(boy.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH));
        girl = new ImageIcon(girl.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH));

        boolean[] isButtonPressed = new boolean[9];
        int[] pressedCount = {0};

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton(buttons[i]);
            buttonPanel.add(button);
            final int index = i;

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!isButtonPressed[index]) {

                    	if (index == 0 || index == 2 || index == 5  || index == 7) {  
                    	    button.setIcon(boy);
                    	} else {
                    	    button.setIcon(girl);
                    	}

                        isButtonPressed[index] = true;
                        pressedCount[0]++;

                        if (pressedCount[0] == 9) {
                            buttonPanel.removeAll();

                            progressBar = new JProgressBar();
                            progressBar.setValue(0);
                            progressBar.setStringPainted(true);

                            buttonPanel.add(progressBar);
                            buttonPanel.revalidate();
                            buttonPanel.repaint();

                            fill();
                        }
                    }
                }
            });
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public void fill() {
        Timer timer = new Timer(100, new ActionListener() {
            int counter = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                counter += 10;
                progressBar.setValue(counter);

                if (counter >= 100) {
                    ((Timer) e.getSource()).stop();
                    frame.dispose();
                    Finish finish = new Finish();
                }
            }
        });
        timer.start(); 
    }
}
