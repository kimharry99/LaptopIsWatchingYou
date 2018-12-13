package ui;
//*** 알람 방법 추가 ui ***

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import alarmMethod.WriteExProcessList;

/**
 * 알람시각에 실행될 파일의 경로와 그 파일의 이름을 입력받는 Ui WriteExProcessList를 호출
 * 
 * @author kimha
 *
 */
public class AlarmMethodAddingUi extends SuperUi {
	// ***멤버변수 선언 ***
	JTextField inputFileName;
	JTextField inputFilePath;
	JLabel noticeFileName;
	JLabel noticeFilePath;
	String fileName;
	String filePath;

	public AlarmMethodAddingUi() {
		super();
		setTitle("AlarmMethodAddingUi");
		this.setSize(550, 320);

		noticeFileName = new JLabel("파일 이름");
		noticeFileName.setLocation(50, 50);
		noticeFileName.setSize(200, 40);
		getContentPane().add(noticeFileName);

		inputFileName = new JTextField();
		inputFileName.setSize(200, 20);
		inputFileName.setLocation(50, 100);
		inputFileName.addActionListener(new TextFieldActionListener());
		getContentPane().add(inputFileName);

		noticeFilePath = new JLabel("파일 경로");
		noticeFilePath.setSize(200, 40);
		noticeFilePath.setLocation(300, 50);
		getContentPane().add(noticeFilePath);

		inputFilePath = new JTextField();
		inputFilePath.setSize(200, 20);
		inputFilePath.setLocation(300, 100);
		inputFilePath.addActionListener(new TextFieldActionListener());
		getContentPane().add(inputFilePath);

		JButton saveAlarm = makeButton("저장", 100, 40, 400, 150);
		//saveAlarm.addActionListener(new AlarmMethodAddingActionLIstener(fileName,filePath));
		saveAlarm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame superFrame =(JFrame)((JButton)e.getSource()).getTopLevelAncestor();
				new WriteExProcessList(fileName, filePath);
				System.out.println("알람 방법 저장");
				superFrame.dispose();
				System.out.println(superFrame.getTitle()+" 창 닫기");
			}});
		getContentPane().add(saveAlarm);

		btClose.setLocation(400, 200);

	}
	
	public class TextFieldActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JTextField t = (JTextField) e.getSource();
			if ((int) t.getLocation().getX() == 50) {
				fileName = t.getText();
				System.out.println("fileName : " + t.getText());
			} else {
				filePath = t.getText();
				System.out.println("filePath : " + t.getText());
			}
		}
	}

}
