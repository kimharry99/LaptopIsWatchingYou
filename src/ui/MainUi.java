package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainUi extends SuperUi {
	public MainUi() {
		super();
		setTitle("MainUi");
		JButton modifie = this.makeButton("설정", 100, 40, 1000, 450);	//설정Ui를 출력하는 설정 버튼 생성
		System.out.println("설정Ui를 출력하는 설정 버튼 생성");
		JButton execution = this.makeButton("실행", 100, 40, 1000, 400);	//실행Ui를 출력하는 실행 버튼 생성
		System.out.println("실행Ui를 출력하는 실행 버튼 생성");
		getContentPane().add(execution);
		getContentPane().add(modifie);
	}
	
	public static void main(String[] args) {
		new MainUi();
	}

}
