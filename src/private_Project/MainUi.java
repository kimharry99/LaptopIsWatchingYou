package private_Project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainUi extends SuperUi {
	public MainUi() {
		super();
		setTitle("MainUi");
		JButton modifie = new JButton("설정");	//설정Ui를 출력하는 설정 버튼 생성

		modifie.addActionListener(new ToOptionActionListener());
		modifie.setLocation(1000, 450);
		modifie.setSize(100, 40);

		JButton execution = new JButton("실행");	//실행Ui를 출력하는 실행 버튼 생성
		
		execution.addActionListener(new ToExecutionActionListener());
		execution.setLocation(1000, 400);
		execution.setSize(100, 40);
		
		getContentPane().add(execution);
		getContentPane().add(modifie);
	}

	class ToOptionActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new OptionUi();
		}
	}
	
	class ToExecutionActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new ExecutionUi();
		}
		
	}

}
