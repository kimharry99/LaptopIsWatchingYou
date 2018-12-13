package ui;
import javax.swing.*;

import buttonActionListener.ButtonActionListener;

import java.awt.*;
import java.awt.event.*;



public class SuperUi extends JFrame{
	JButton[] buttonArray = new JButton[20];
	public SuperUi() {
		setTitle("Ui");
		Container c = getContentPane();
		c.setLayout(null);
		//UI기본 설정들 (layout null)
		
		setSize(1250,640);
		setVisible(true);
		
		JButton btClose = this.makeButton("닫기", 100, 40, 1000, 500);//창을 닫는 닫기 버튼 출력
		
		c.add(btClose);

	}
	JButton makeButton(String buttonName, int sizex, int sizey, int coX,int coY) {//버튼의 인스턴스 변수 리턴
		JButton bt = new JButton(buttonName);
		bt.setSize(sizex,sizey);
		bt.setLocation(coX,coY);
		bt.addActionListener(new ButtonActionListener());
		return bt;
	}
}
