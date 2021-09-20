import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class BottomPanel extends JPanel{
	Config config = new Config();
	
	public BottomPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.blue);
		setPreferredSize(new Dimension(1600,150));
		add(config.dice(),BorderLayout.EAST);
		add(config.profile(),BorderLayout.WEST);
	}
	
	
}
