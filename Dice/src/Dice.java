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

	Dice dice = this;
	private int num;

	public Dice() {
		dice.setSize(41, 41);
		dice.setBackground(Color.yellow);
		dice.setOpaque(true);
		dice.setIcon(imgs[0]);
		dice.setText("  주사위 : 0  ");
		dice.addMouseListener(new FirstMouseListener());
	}

	public void roll() {
		this.num = new Random().nextInt(6) + 1;
		dice.setIcon(imgs[num-1]);
		dice.setText("  주사위 : "+num+"  ");
	}
	
	public int getNum() {
		return num;
	}


	class FirstMouseListener extends MouseAdapter {
		int i = 0;
		@Override
		public void mouseEntered(MouseEvent e) {
			t.start();
		}
		
		public void mouseExited(MouseEvent e) {
			t.stop();
		}
		
		public void mouseClicked(MouseEvent e) {
			t.stop();
			roll();
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

	ImageIcon[] imgs = new ImageIcon[] { new ImageIcon("img/dice_icon_1.png"),
			new ImageIcon("img/dice_icon_2.png"),
			new ImageIcon("img/dice_icon_3.png"),
			new ImageIcon("img/dice_icon_4.png"),
			new ImageIcon("img/dice_icon_5.png"),
			new ImageIcon("img/dice_icon_6.png") };
}
