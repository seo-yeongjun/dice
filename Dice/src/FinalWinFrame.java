

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

//4스테이지 최종 몬스터를 죽이면 나타날 FinalWinFrame 클래스
public class FinalWinFrame extends JInternalFrame {
	
	public FinalWinFrame() {
	
		setTitle("YOU WIN");
		setLayout(new GridLayout(2,1));
		setVisible(true);
		
		//종료 버튼
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

	//배경 이미지 그리기
	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon(getClass().getResource("img/back1.jpg")).getImage(), 0, 0, null);
	}

	JLabel winLabel = new JLabel("YOU WIN, CONGRATULATION");
	
}
