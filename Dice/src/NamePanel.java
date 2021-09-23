import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class NamePanel extends JPanel {

	Config config = new Config();
	int i = 0;

	public NamePanel() {

		JCheckBox[] fruits = new JCheckBox[3];
		
		// 라벨 컬러
		Color textBackColor = new Color(255, 255, 255, 80);

		setLayout(null);

		// 게임 제목
		JLabel gameName = new JLabel("Dice");
		gameName.setOpaque(true);
		gameName.setBackground(textBackColor);
		gameName.setFont(new Font("맑은 고딕", Font.BOLD, 76));
		gameName.setHorizontalAlignment(JLabel.CENTER);
		gameName.setBounds(280, 200, 400, 65);

		// 게임 설명
		JLabel sub = new JLabel("text 기반 주사위 RPG");
		sub.setOpaque(true);
		sub.setBackground(textBackColor);
		sub.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		sub.setHorizontalAlignment(JLabel.CENTER);
		sub.setBounds(280, 265, 400, 65);

		// 게임 이름 설정
		JLabel nameSetLabel = new JLabel("↓ 용사 이름을 입력해 주세요 ↓");
		nameSetLabel.setOpaque(true);
		nameSetLabel.setBackground(textBackColor);
		nameSetLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nameSetLabel.setHorizontalAlignment(JLabel.CENTER);
		nameSetLabel.setBounds(360, 350, 240, 50);

		// 게임 이름 설정 필드
		JTextField field = new JTextField();
		field.setOpaque(true);
		field.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		field.setBounds(405, 405, 150, 30);
		field.setHorizontalAlignment(JLabel.CENTER);

		// 직업 설정 라벨
		JLabel jobSetLabel = new JLabel("↓ 직업을 선택해 주세요 ↓ ");
		jobSetLabel.setOpaque(true);
		jobSetLabel.setBackground(textBackColor);
		jobSetLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jobSetLabel.setHorizontalAlignment(JLabel.CENTER);
		jobSetLabel.setBounds(360, 450, 240, 50);

		// 직업설정 라디오 채크
		JTextField fiel1d = new JTextField();
		field.setOpaque(true);
		field.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		field.setBounds(405, 405, 150, 30);
		field.setHorizontalAlignment(JLabel.CENTER);

		JButton submit = new JButton();
		submit.setText("시작하기");

		add(sub);
		add(gameName);
		add(nameSetLabel);
		add(field);
		add(submit);
		add(jobSetLabel);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon("img/back1.jpg").getImage(), 0, 0, null);
	}

	Timer timer = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			i++;

			System.out.println(i);

		}
	});
}
