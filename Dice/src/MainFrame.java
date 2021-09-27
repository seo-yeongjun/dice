import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;


//MainFrame
public class MainFrame extends JFrame{
	Container c = getContentPane();
	Config config = new Config();
	
	MainFrame(){
		setTitle("개인프로젝트 201723018 서영준 간단한 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setSize(1000,700);
		setLayout(new BorderLayout());
		
		//bottomPanel 추가
		c.add(config.bottomPanel(),BorderLayout.SOUTH);
		//center에 startPanel 추가
		c.add(config.startPanel(),BorderLayout.CENTER);
	}
	
	//center에 들어갈 panel을 변경하기 위한 메소드
	public void changeCenter(JPanel before, JPanel after) {
		remove(before);
		add(after,BorderLayout.CENTER);
		repaint();
	}
	
}
