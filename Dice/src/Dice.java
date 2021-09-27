import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

//bottom패널에 오른쪽에 들어갈 주사위
public class Dice extends JLabel {

	Config config = new Config();
	Dice dice = this;

	// 주사위의 눈 갯수를 위한 변수
	private int num;

	public Dice() {
		dice.setSize(41, 41);
		dice.setBackground(Color.white);
		dice.setOpaque(true);
		dice.setIcon(imgs[0]);
		dice.setText("  주사위 : 0  ");
		dice.addMouseListener(new DiceMouseListener());
		dice.addMouseListener(config.dungeonPanel().tm);
	}

	// 주사위를 굴리면 1~6사이의 랜덤 숫자를 주사위 눈에 저장하고 라벨이미지를 설정하는 메소드
	public void roll() {
		this.num = new Random().nextInt(6) + 1;
		dice.setIcon(imgs[num - 1]);
		dice.setText("  주사위 : " + num + "  ");
	}

	// 주사위의 눈 갯수 리턴 메소드
	public int getNum() {
		return num;
	}

	// 주사위 라벨에 기능을 추가하는 마우스리스너 클래스
	class DiceMouseListener extends MouseAdapter {
		Config config = new Config();
		int i = 0;

		@Override
		public void mouseEntered(MouseEvent e) {
			t.start();
		}

		public void mouseExited(MouseEvent e) {
			t.stop();
		}

		public void mouseClicked(MouseEvent e) {
			if (config.dungeonPanel().tx.textNum == 6) {
				config.music(1);
				t.stop();
				roll();
				config.dungeonPanel().config.dungeonPanel().tx.textNum++;
				config.dungeonPanel().tx.setText(config.dungeonPanel().tx.textSet[config.dungeonPanel().tx.textNum]);
				repaint();
			}
		}

		// 주사위의 애니메이션 효과를 위한 Timer
		Timer t = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dice.setIcon(imgs[i]);
				i++;
				if (i == 6)
					i = 0;
			}
		});

	}

	// 주사위 1~6 이미지 배열
	ImageIcon[] imgs = new ImageIcon[] { new ImageIcon(getClass().getResource("img/dice_icon_1.png")),
			new ImageIcon(getClass().getResource("img/dice_icon_2.png")),
			new ImageIcon(getClass().getResource("img/dice_icon_3.png")),
			new ImageIcon(getClass().getResource("img/dice_icon_4.png")),
			new ImageIcon(getClass().getResource("img/dice_icon_5.png")),
			new ImageIcon(getClass().getResource("img/dice_icon_6.png")) };
}
