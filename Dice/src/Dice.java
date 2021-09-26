import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Dice extends JLabel {

	Config config = new Config();
	Dice dice = this;
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

	public void roll() {
		this.num = new Random().nextInt(6) + 1;
		dice.setIcon(imgs[num-1]);
		dice.setText("  주사위 : "+num+"  ");
	}
	
	public int getNum() {
		return num;
	}


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
			if(config.dungeonPanel().tx.textNum == 6) {
			t.stop();
			roll();
			config.dungeonPanel().config.dungeonPanel().tx.textNum++;
			config.dungeonPanel().tx.setText(config.dungeonPanel().tx.textSet[config.dungeonPanel().tx.textNum]);
			repaint();
			}
		}
		
		Timer t = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dice.setIcon(imgs[i]);
				i++;
				if(i==6)i=0;
			}
		});

	}

	ImageIcon[] imgs = new ImageIcon[] { new ImageIcon(getClass().getResource("img/dice_icon_1.png")),
			new ImageIcon(getClass().getResource("img/dice_icon_2.png")),
			new ImageIcon(getClass().getResource("img/dice_icon_3.png")),
			new ImageIcon(getClass().getResource("img/dice_icon_4.png")),
			new ImageIcon(getClass().getResource("img/dice_icon_5.png")),
			new ImageIcon(getClass().getResource("img/dice_icon_6.png")) };
}
