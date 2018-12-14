package ui;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.*;


public class MessageUi extends JFrame{
	public class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.setFont(new Font("Arial",Font.BOLD,200));
			g.drawString("Time's up!!!!!", 100, 100);
		}
	}
	
	public MessageUi() {
		MyPanel mypanel = new MyPanel();
		setTitle("목표 시간 도달");
		setBackground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mypanel);
		
		setSize(1920,1080);
		setVisible(true);
	}	

}