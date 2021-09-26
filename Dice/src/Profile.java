import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//bottom패널의 왼쪽에 들어갈 프로필 패널
public class Profile extends JPanel{

	//케릭터 이름
	private String name = "???";
	//케릭터 체력
	private int HP = 14;
	//스테이지별 케릭터 체력
	private int[] HPset = {14,17,20,23};
	//케릭터 직업 이미지 배열
	private ImageIcon[] imgs = {new ImageIcon(getClass().getResource("img/tomb.png")),new ImageIcon(getClass().getResource("img/archer.png")),new ImageIcon(getClass().getResource("img/knight.png")),new ImageIcon(getClass().getResource("img/gunner.png"))};
	//라벨상 현재 체력
	private HP setHP = new HP();
	//라벨상 이름
	private Name setName = new Name();
	//라벨상 직업 이미지
	private ProfileImg profileImg = new ProfileImg();
	
	public Profile() {
		
		setLayout(new FlowLayout());
		setBackground(Color.white);
		setPreferredSize(new Dimension(110,60));
		
		add(setName);
		add(setHP);
		add(profileImg);
	}
	
	//케릭터 레벨에 따른 체력 설정 메서드
	public void levelHP(int i) {
		this.HP = HPset[i];
		repaint();
	}
	
	//케릭터 이름 설정 메소드
	public void setName(String name) {
		this.name= name;
		setName.setText("이름: "+name);
	}
	
	//케릭터 이름을 리턴하는 메소드
	public String getName() {
		return name;
	}
	
	//라벨상 체력 설정 메소드
	public void setHP(int HP) {
		this.HP -= HP;
		setHP.setText("현재 체력: "+Integer.toString(this.HP));
	}
	
	//현재 체력 리턴 메소드
	public int getHP() {
		return HP;
	}

	//직업 이미지 설정 메소드
	public void setProfile(int i) {
		profileImg.setIcon(imgs[i]);
	}
	
	//이름 라벨
	private class Name extends JLabel{
		
		public Name() {
			setText("이름: "+name);
		}
	}
	
	//체력 라벨
	private class HP extends JLabel{
		public HP() {
			setText("현재 체력: "+HP);
		}
	}
	//직업 이미지 라벨
	private class ProfileImg extends JLabel{
		public ProfileImg() {
			this.setOpaque(true);
			this.setIcon(imgs[0]);
		}
	}
	
}