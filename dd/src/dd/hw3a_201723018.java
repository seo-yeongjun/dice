package dd;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class hw3a_201723018 extends JFrame {

	JLabel sumLabel = new JLabel("현재 가격 : ");
	JCheckBox[] fruits = new JCheckBox[3];

	public hw3a_201723018() {
		setTitle("CheckBoxItemEventEx_201723018");
		setSize(220, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("201723018 서영준"));
		c.add(new JLabel("사과 1000원  배 2000원  체리 5000원"));

		String[] fruitName = { "사과", "배", "체리" };

		SumItemListener listener = new SumItemListener();

		for (int i = 0; i < 3; i++) {
			fruits[i] = new JCheckBox(fruitName[i]);
			fruits[i].setBorderPainted(true);
			fruits[i].addItemListener(listener);
			c.add(fruits[i]);
		}
		c.add(sumLabel);

	}

	class SumItemListener implements ItemListener {
		private int sum = 0;

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getItem() == fruits[0])
					sum += 1000;
				else if (e.getItem() == fruits[1])
					sum += 2000;
				else
					sum += 5000;
			} else {
				if (e.getItem() == fruits[0])
					sum -= 1000;
				else if (e.getItem() == fruits[1])
					sum -= 2000;
				else
					sum -= 5000;
			}
			sumLabel.setText("현재 가격 : " + sum + "원");
		}

	}

	public static void main(String[] args) {
		new hw3a_201723018();
	}
}
