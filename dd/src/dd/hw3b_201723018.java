package dd;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class hw3b_201723018 extends JFrame {
	JLabel imgLabel = new JLabel();
	JRadioButton[] fruits = new JRadioButton[3];
	ImageIcon[] images = { new ImageIcon("images/apple.jpg"), new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg") };
	String[] fruitName = { "사과", "배", "체리" };

	public hw3b_201723018() {
		setTitle("CheckBoxItemEventEx_201723018");
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("201723018 서영준"));

		ButtonGroup bg = new ButtonGroup();

		RadioItemListener listener = new RadioItemListener();

		for (int i = 0; i < 3; i++) {
			fruits[i] = new JRadioButton(fruitName[i]);
			fruits[i].addItemListener(listener);
			bg.add(fruits[i]);
			add(fruits[i]);
		}
		c.add(imgLabel);

	}

	class RadioItemListener implements ItemListener {
		private int sum = 0;

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.DESELECTED)
				return;
			if (fruits[0].isSelected())
				imgLabel.setIcon(images[0]);
			else if (fruits[1].isSelected())
				imgLabel.setIcon(images[1]);
			else if (fruits[2].isSelected())
				imgLabel.setIcon(images[2]);

		}
	}

	public static void main(String[] args) {
		new hw3b_201723018();
	}
}
