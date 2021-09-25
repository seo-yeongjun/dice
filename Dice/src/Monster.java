import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Monster extends JLabel{
	Config config = new Config();
	private ImageIcon[] monsterImgs = {new ImageIcon("img/monster1.png"),new ImageIcon("img/monster2.png"),new ImageIcon("img/monster3.png"),new ImageIcon("img/monster4.png")};
	private int hp[] = {8,15,20,25};
	public Monster() {
		setText("HP :"+hp[config.getDungeonLevel()]);
		setIcon(monsterImgs[config.getDungeonLevel()]);
		setOpaque(true);
		setBackground(new Color(255, 255, 255, 80));
		setFont(new Font("맑은 고딕", Font.BOLD, 60));
	}
	
	
	public int attack() {
		return new Random().nextInt(6) + 1;
	}
	
	public Monster(int level) {
		setText("HP :"+hp[level]);
		setIcon(monsterImgs[level]);
		setOpaque(true);
		setBackground(new Color(255, 255, 255, 80));
	}
	
	public void levelSet(int level) {
		setText("HP :"+hp[level]);
		setIcon(monsterImgs[level]);
	}
	
	public void setHP(int i) {
		hp[config.getDungeonLevel()] -= i;
		setText("HP :" +hp[config.getDungeonLevel()]);
	}
	
	public int getHP() {
		return hp[config.getDungeonLevel()];
	}
}
