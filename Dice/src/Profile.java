import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Profile extends JPanel{

	private String name = "???";
	private int HP = 14;
	private int[] HPset = {14,17,20,23};
	private ImageIcon[] imgs = {new ImageIcon(getClass().getResource("img/tomb.png")),new ImageIcon(getClass().getResource("img/archer.png")),new ImageIcon(getClass().getResource("img/knight.png")),new ImageIcon(getClass().getResource("img/gunner.png"))};
	private HP setHP = new HP();
	private Name setName = new Name();
	private ProfileImg profileImg = new ProfileImg();
	public Profile() {
		setLayout(new FlowLayout());
		setBackground(Color.white);
		setPreferredSize(new Dimension(110,60));
		add(setName);
		add(setHP);
		add(profileImg);
	}
	
	public void levelHP(int i) {
		this.HP = HPset[i];
		repaint();
	}
	
	public void setName(String name) {
		this.name= name;
		setName.setText("이름: "+name);
	}
	
	public String getName() {
		return name;
	}

	public void setHP(int HP) {
		this.HP -= HP;
		setHP.setText("현재 체력: "+Integer.toString(this.HP));
	}
	
	public int getHP() {
		return HP;
	}

	public void setProfile(int i) {
		profileImg.setIcon(imgs[i]);
	}
	
	
	private class Name extends JLabel{
		
		public Name() {
			setText("이름: "+name);
		}
	}
	
	private class HP extends JLabel{
		public HP() {
			setText("현재 체력: "+HP);
		}
	}
	
	private class ProfileImg extends JLabel{
		public ProfileImg() {
			this.setOpaque(true);
			this.setIcon(imgs[0]);
		}
	}
	
}