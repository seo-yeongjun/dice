
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

//몬스터에게 사망시 나타날 LoseFrame 클래스
public class LoseFrame extends JInternalFrame {

	public LoseFrame() {
	
		setMaximizable(true);
		setTitle("You Lose");
		setLayout(new FlowLayout());
		setVisible(true);
		setClosable(true);
		setResizable(true);
		setOpaque(true);
		setBackground(new Color(255, 255, 255, 80));
		dieLabel.setFont(new Font("맑은 고딕", Font.BOLD, 80));
		exit.setFont(new Font("맑은 고딕", Font.BOLD, 80));
		
		//종료를 위한 마우스리스너
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(dieLabel);
		add(exit);
		repaint();
	}
	
	//배경 그리기
	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon(getClass().getResource("img/back1.jpg")).getImage(), 0, 0, null);
	}

	JLabel dieLabel = new JLabel("YOU DIE");
	JButton exit = new JButton("종료하기");
}
