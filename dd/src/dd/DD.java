package dd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DD extends JFrame {
   JLabel la = new JLabel();
   public DD(String labelName) {
      setTitle("201914077 허지영");
      setSize(600,600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      la.setText(labelName);
      c.addMouseListener(new MyMouseListener()); // 마우스 이벤트(더블클릭 시 랜덤으로 색 바뀜)
      JButton btn = new JButton("제 신상이 궁금하다면 눌러보세요");
      btn.addActionListener(new MyActionListener()); // 버튼 액션 이벤트 (누르면 글 바뀜)
      c.add(btn);
      JButton nextBtn = new JButton("next");
      nextBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
               setVisible(false);
               new YourFrame("F1~F9 사이의 키를 눌러보세요");
         }
      });
      c.add(la);
      c.add(nextBtn);
      setVisible(true);
   }
   public static void main(String[] args) {
      new DD("화면을 더블클릭 해보세요");
   }

}
class MyActionListener implements ActionListener {

   @Override
   public void actionPerformed(ActionEvent e) {
      JButton b = (JButton)e.getSource();
      if(b.getText().equals("제 신상이 궁금하다면 눌러보세요")) {
         b.setText("소프트웨어공학 201914077 허지영");
      }
      else
         b.setText("제 신상이 궁금하다면 눌러보세요");
      
   }
   
}

class MyMouseListener extends MouseAdapter {
   public void mouseClicked(MouseEvent e) {
      if(e.getClickCount() == 2) {
         int r = (int) (Math.random() * 256);
         int g = (int) (Math.random() * 256);
         int b = (int) (Math.random() * 256);
         Component c = (Component) e.getSource();
         c.setBackground(new Color(r, g, b));
      }
   }
}

class YourFrame extends JFrame{
   private JLabel la = new JLabel();
   YourFrame(String labelName){
      super("201914077 허지영");
      setSize(300,300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.addKeyListener(new MyKeyListener());
      c.add(la);
      setSize(300, 150);
      setVisible(true);
      c.setFocusable(true);
      c.requestFocus();
      c.setLayout(new FlowLayout());
      JButton backBtn = new JButton("back");
      backBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
               setVisible(false);
               new DD("My Change");
         }
      });
      la.setText(labelName);
      c.add(la);
      c.add(backBtn);
      setVisible(true);
   }
   class MyKeyListener extends KeyAdapter {
      public void keyPressed(KeyEvent e) {
         la.setText(KeyEvent.getKeyText(e.getKeyCode())+"키가 입력됨");
         Container c = (Container) e.getSource();
         
         if(e.getKeyCode()== KeyEvent.VK_F1)
            c.setBackground(Color.GREEN);
         else if(e.getKeyCode()== KeyEvent.VK_F2)
            c.setBackground(Color.PINK);
         else if(e.getKeyCode()== KeyEvent.VK_F3)
            c.setBackground(Color.RED);
         else if(e.getKeyCode()== KeyEvent.VK_F4)
            c.setBackground(Color.ORANGE);
         else if(e.getKeyCode()== KeyEvent.VK_F5)
            c.setBackground(Color.BLACK);
         else if(e.getKeyCode()== KeyEvent.VK_F6)
            c.setBackground(Color.BLUE);
         else if(e.getKeyCode()== KeyEvent.VK_F7)
            c.setBackground(Color.WHITE);
         else if(e.getKeyCode()== KeyEvent.VK_F8)
            c.setBackground(Color.DARK_GRAY);
         else if(e.getKeyCode()== KeyEvent.VK_F9)
            c.setBackground(Color.CYAN);

      }
   };
}