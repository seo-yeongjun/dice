import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class NamePanel extends JPanel {

	Config config = new Config();
	int i = 0;

	public NamePanel() {

		setLayout(null);

		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(new Color(255, 255, 255, 80));
		label.setBounds(100,200,200,50);
		label.setText("<html>Dice<br>text 기반 게임<br>캐릭터 이름 설정</html>");

		JTextField field = new JTextField();
		field.setOpaque(true);
		field.setBackground(new Color(255, 255, 255, 100));
		field.setFont(new Font(label.getName(), Font.PLAIN, Math.min(50, 300)));
		field.setText(config.profile().getName());

		JButton submit = new JButton();
		submit.setText("시작하기");

		add(label);
		add(field);
		add(submit);
		repaint();
		timer.start();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon(Profile.class.getResource("img/back1.jpg")).getImage(), 0, 0, null);
	}

	Timer timer = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			i++;
			repaint();
			System.out.println(i);

		}
	});
}
