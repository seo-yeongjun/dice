import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Profile extends JPanel{

	private String name = "임시용";
	private String HP = "11";
	private ImageIcon[] imgs = {new ImageIcon(Profile.class.getResource("img/player.png")),new ImageIcon(Profile.class.getResource("img/tomb.png"))};

	public Profile() {
		setLayout(new FlowLayout());
		setBackground(Color.gray);
		setPreferredSize(new Dimension(110,60));
		add(new Name());
		add(new HP());
		add(new ProfileImg());
	}
	
	public void setName(String name) {
		this.name= name;
	}
	
	public String getName() {
		return name;
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