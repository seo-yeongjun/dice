import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;

public class StartPanel extends JPanel {

	Config config = new Config();
	JRadioButton[] jobs = new JRadioButton[3];
	String[] str = { "archer", "knight", "gunner" };

	int i = 0;

	public StartPanel() {

		// 라벨 컬러
		Color textBackColor = new Color(255, 255, 255, 80);

		setLayout(null);

		// 게임 제목
		JLabel gameName = new JLabel("Dice");
		gameName.setOpaque(true);
		gameName.setBackground(textBackColor);
		gameName.setFont(new Font("맑은 고딕", Font.BOLD, 76));
		gameName.setHorizontalAlignment(JLabel.CENTER);
		gameName.setBounds(280, 110, 400, 65);

		// 게임 설명
		JLabel sub = new JLabel("text 기반 주사위 RPG");
		sub.setOpaque(true);
		sub.setBackground(textBackColor);
		sub.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		sub.setHorizontalAlignment(JLabel.CENTER);
		sub.setBounds(280, 175, 400, 65);

		// 게임 이름 설정
		JLabel nameSetLabel = new JLabel("↓ 용사 이름을 입력해 주세요 ↓");
		nameSetLabel.setOpaque(true);
		nameSetLabel.setBackground(textBackColor);
		nameSetLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		nameSetLabel.setHorizontalAlignment(JLabel.CENTER);
		nameSetLabel.setBounds(360, 260, 240, 50);

		// 게임 이름 설정 필드
		JTextField field = new JTextField();
		field.setOpaque(true);
		field.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		field.setBounds(405, 315, 150, 30);
		field.setHorizontalAlignment(JLabel.CENTER);

		// 직업 설정 라벨
		JLabel jobSetLabel = new JLabel("↓ 직업을 선택해 주세요 ↓ ");
		jobSetLabel.setOpaque(true);
		jobSetLabel.setBackground(textBackColor);
		jobSetLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		jobSetLabel.setHorizontalAlignment(JLabel.CENTER);
		jobSetLabel.setBounds(360, 360, 240, 50);

		// 직업설정 라디오 채크
		ButtonGroup g = new ButtonGroup();
		for (int i = 0; i < jobs.length; i++) {
			jobs[i] = new JRadioButton(str[i]);
			jobs[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			jobs[i].setBounds(360 + (i * 80), 420, 80, 50);
			g.add(jobs[i]);
			add(jobs[i]);
		}

		// 시작 버튼
		JButton submit = new JButton();
		submit.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		submit.setHorizontalAlignment(JLabel.CENTER);
		submit.setBounds(380, 480, 200, 50);
		submit.setText("시작하기");
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				config.profile().setName(field.getText());
				if (jobs[0].isSelected()) {
					config.profile().setProfile(1);
				} else if (jobs[1].isSelected()) {
					config.profile().setProfile(2);
				} else {
					config.profile().setProfile(3);
				}
				config.mainFrame().changeCenter(config.startPanel(), config.dungeonPanel());
				config.stageScript().script.setText(config.stageScript().scriptSet[1]);
			}
		});

		add(sub);
		add(gameName);
		add(nameSetLabel);
		add(field);
		add(submit);
		add(jobSetLabel);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon(getClass().getResource("img/back1.jpg")).getImage(), 0, 0, null);
	}

	
}
