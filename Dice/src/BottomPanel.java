import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

//메인 프레임에 SOUTH에 들어갈 bottom 패널
public class BottomPanel extends JPanel{
	Config config = new Config();
	
	public BottomPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.blue);
		setPreferredSize(new Dimension(1600,120));
		add(config.dice(),BorderLayout.EAST);
		add(config.profile(),BorderLayout.WEST);
		add(config.stageScript(),BorderLayout.CENTER);
	}
	
}
