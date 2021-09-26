import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//start 패널에서 시작 버튼을 누르면, 메인 프레임에 center에 오르는 던전 패널
public class DungeonPanel extends JPanel {
	Config config = new Config();
	TurnText tx = new TurnText();
	TurnMouseEvent tm = new TurnMouseEvent();

	public DungeonPanel() {
		setLayout(new FlowLayout());
		setBackground(Color.yellow);
		tx.addMouseListener(tm);
		add(config.monster());
		add(tx);
	}

	//배경 이미지 설정
	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon(getClass().getResource("img/back1.jpg")).getImage(), 0, 0, null);
	}

	//각 턴마다 textLabel의 setText를 하고
	//적을 처치시 winFrame을 케릭터가 죽었을 시, loseFrame을 띄우는 역할을 하는 마우스이벤트
	class TurnMouseEvent extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {

			if (config.mainFrame().c.getComponent(1) == config.dungeonPanel()) {
				if (tx.textNum != 6) {
					if (tx.textNum != 7 && tx.textNum != 8)
						tx.textNum++;

					if (config.profile().getHP() <= 0) {
						config.mainFrame().remove(config.dungeonPanel());
						config.mainFrame().c.add(new LoseFrame());
						config.mainFrame().repaint();
						tx.textNum = 8;
					}
					if (tx.textNum == 8 && config.monster().getHP() > 0) {
						monsterAttackAnimaion.stop();
						i = 0;
						tx.textNum = 2;
					}

					if (config.monster().getHP() <= 0) {
						config.dungeonPanel().setVisible(false);
						if (config.getDungeonLevel() == 0) {
							config.mainFrame().c.add(config.winFrame());
						}
						else if(config.getDungeonLevel()==3) {
							config.mainFrame().add(new FinalWinFrame());
						}
						else{
							config.winFrame().setVisible(true);
						}
						config.mainFrame().repaint();
					}

					if (tx.textNum == 3) {
						monsterAttackAnimaion.start();
						tx.setText(tx.textSet[tx.textNum]);
					} else if (tx.textNum == 4) {
						monsterAttackAnimaion.stop();
						i = 0;
						int atk = config.monster().attack();
						tx.setText(atk + tx.textSet[tx.textNum]);
						config.profile().setHP(atk);
					} else if (tx.textNum == 7) {
						monsterAttackAnimaion.start();
						tx.setText("적에게 " + config.dice().getNum() + tx.textSet[tx.textNum]);
						config.monster().setHP(config.dice().getNum());
						tx.textNum++;
					} else
						tx.setText(tx.textSet[tx.textNum]);
					repaint();
				}
			}

		}

		int i = 0;
		
		//공격시 애니메이션 효과를 위한 Timer
		Timer monsterAttackAnimaion = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (i == 0 || i == 2) {
					config.dungeonPanel().setLocation(10, 0);
					i++;
				} else if (i == 1 || i == 3) {
					config.dungeonPanel().setLocation(-10, 0);
					i++;
				} else {
					config.dungeonPanel().setLocation(0, 0);
				}
			}
		});

	}

}

//각 턴에 사용 될 JLabel
class TurnText extends JLabel {
	int textNum = 0;
	String textClick = "      ..클릭";
	Config config = new Config();
	String[] textSet = { "스테이지 : 1" + textClick, "적이 나타났다." + textClick, "적의 턴" + textClick, "적이 공격했다." + textClick,
			"의 피해를 입었다." + textClick, "나의 턴" + textClick, "주사위를 굴려주세요", "의 피해를 입혔다." + textClick,
			"적을 처치했다. 다음 스테이지->" };

	public TurnText() {
		setText(textSet[textNum]);
		setOpaque(true);
		setBackground(new Color(255, 255, 255, 40));
		setPreferredSize(new Dimension(800, 120));
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 40));
	}

}
