import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StageScript extends JPanel {

	String[] scriptSet = { "<html>4스테이지 까지 있으며<br>적 공격, 내 공격의 턴이 반복됩니다.<br>주사위의 눈으로 공격력이 정해집니다.</html>",
			"<html>몬스터 : 축축한 멀록<br>설명 : 습하고 어두운 곳을 좋아하는 멀록 아직은 어린 듯 하다.</html>"
			,"<html>몬스터 : 바위 정령<br>설명 : 수천년 전 누군가에 의해 생명이 부여 된 존재<br>동쪽바위 숲에 살고있다.</html>"
			,"<html>몬스터 : 알로이라<br>설명 : 오션타운의 악명난 악당,<br>최근 산 마스크가 마음에 드는 모양이다.</html>"
			,"<html>몬스터 : 워웍<br>설명 : 워웍이다,<br>워윅이라 부르면 화를 낸다.</html>"};
	JLabel script = new JLabel();
	
	public StageScript() {
		script.setText(scriptSet[0]);
		script.setOpaque(true);
		script.setBackground(new Color(255, 255, 255, 80));
		script.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		script.setHorizontalAlignment(JLabel.CENTER);
		script.setBounds(280, 110, 400, 65);
		add(script);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon("img/diceBack.png").getImage(), 0, 0, null);
	}

}
