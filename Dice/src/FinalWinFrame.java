

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class FinalWinFrame extends JInternalFrame {
	Config config = new Config();
	
	public FinalWinFrame() {
	
		setTitle("YOU WIN");
		setLayout(new GridLayout(2,1));
		setVisible(true);
		
		JButton next = new JButton();
		next.setText("종료 하기");
		next.setHorizontalAlignment(JLabel.CENTER);
		next.setBounds(380, 480, 200, 50);
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		
		setResizable(true);
		setOpaque(true);
		setBackground(new Color(255, 255, 255, 80));
		
		winLabel.setFont(new Font("맑은 고딕", Font.BOLD, 80));
		winLabel.setHorizontalAlignment(JLabel.CENTER);
		

		add(winLabel);
		
		add(next);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon("img/back1.jpg").getImage(), 0, 0, null);
	}

	JLabel winLabel = new JLabel("YOU WIN, CONGRATULATION");
	
}
