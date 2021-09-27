

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

//스테이지 클리어시 띄어질 WinFrame
public class WinFrame extends JInternalFrame {
	Config config = new Config();
	
	public WinFrame() {
	
		setTitle("Go Next Dungeon");
		setLayout(new GridLayout(3,1));
		setVisible(true);
		
		JButton next = new JButton();
		next.setText("다음 스테이지로");
		next.setHorizontalAlignment(JLabel.CENTER);
		next.setBounds(380, 480, 200, 50);
		
		//몬스터의 레벨, 체력과 케릭터의 체력을 다음 스테이지에 맞게 초기화하고, 각 패널에 위치에 새로 그리기 위한 Listener
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			config.setDungeonLevel();
			config.stageScript().script.setText(config.stageScript().scriptSet[config.getDungeonLevel()+1]);
			config.monster().levelSet(config.getDungeonLevel());
			config.dungeonPanel().tx.textNum=0;
			config.dungeonPanel().tx.textSet[0]="스테이지 : "+(config.getDungeonLevel()+1) + config.dungeonPanel().tx.textClick;
			config.dungeonPanel().tx.setText(config.dungeonPanel().tx.textSet[0]);
			config.profile().levelHP(config.getDungeonLevel());
			config.profile().setHP(0);
			config.dungeonPanel().setVisible(true);
			config.winFrame().setVisible(false);
			}
		});
		
		setResizable(true);
		setOpaque(true);
		setBackground(new Color(255, 255, 255, 80));
		
		winLabel.setFont(new Font("맑은 고딕", Font.BOLD, 80));
		winLabel.setHorizontalAlignment(JLabel.CENTER);
		
		levelUp.setFont(new Font("맑은 고딕", Font.BOLD, 80));
		levelUp.setHorizontalAlignment(JLabel.CENTER);
		add(winLabel);
		add(levelUp);
		add(next);
	}

	//배경 이미지 그리기
	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon(getClass().getResource("img/back1.jpg")).getImage(), 0, 0, null);
	}

	JLabel winLabel = new JLabel("적을 처치하였습니다.");
	JLabel levelUp = new JLabel("레벨 업!!");
}
