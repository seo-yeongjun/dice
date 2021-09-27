import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//적의 정보를 담는 클래스
public class Monster extends JLabel{
	Config config = new Config();
	
	//던전 스테이지 별 적 이미지 배열
	private ImageIcon[] monsterImgs = {new ImageIcon(getClass().getResource("img/monster1.png")),new ImageIcon(getClass().getResource("img/monster2.png")),new ImageIcon(getClass().getResource("img/monster3.png")),new ImageIcon(getClass().getResource("img/monster4.png"))};
	//던전 스테이지 별 적 HP 배열
	private int hp[] = {8,15,20,25};
	
	public Monster() {
		setText("HP :"+hp[config.getDungeonLevel()]);
		setIcon(monsterImgs[config.getDungeonLevel()]);
		setOpaque(true);
		setBackground(new Color(255, 255, 255, 80));
		setFont(new Font("맑은 고딕", Font.BOLD, 60));
	}
	
	//몬스터 공격 데미지 리턴 메소드
	public int attack() {
		return new Random().nextInt(6) + 1;
	}
	
	public Monster(int level) {
		setText("HP :"+hp[level]);
		setIcon(monsterImgs[level]);
		setOpaque(true);
		setBackground(new Color(255, 255, 255, 80));
	}
	
	//스테이지 클리어시 레벨을 세팅하기위한 메소드
	public void levelSet(int level) {
		setText("HP :"+hp[level]);
		setIcon(monsterImgs[level]);
	}
	
	//스테이지 클리어시 HP를 세팅하기 위한 메소드
	public void setHP(int i) {
		hp[config.getDungeonLevel()] -= i;
		setText("HP :" +hp[config.getDungeonLevel()]);
	}
	
	//몬스터의 현재 체력을 리턴하는 메소드
	public int getHP() {
		return hp[config.getDungeonLevel()];
	}
}
