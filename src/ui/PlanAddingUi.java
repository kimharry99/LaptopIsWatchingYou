package ui;

import javax.swing.*;

import alarmMethod.ReadExProcessList;
import buttonActionListener.AddingUiButtonActionListener;
import planAndFileManagement.Plan;
import planAndFileManagement.PlanAdder;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * AddingUi는 Plan을 저장하기 위한 정보를 입력받는 Ui이다. 
 * 계획의 이름, 알람시간, 알람방법의 정보를 입력받아 객체 Plan을 생성한다.
 * 저장버튼을 통해 PlanAdder클래스를 호출한다. 
 * @author kimha
 *
 */
public class PlanAddingUi extends SuperUi {
	
	// *** AddingUi의 변수선언 ***
	JLabel label =new JLabel("계획 추가");
	JTextField planTitle = new JTextField("계획의 이름을 설정하십시오", 1);
	JButton btAdd = this.makeButton("저장", 100, 40, 1000, 450);
	JButton btAddAlarm = makeButton("알람 추가",100,40,760,160);
	Plan plan = new Plan();
	JScrollPane jScrollPane = new JScrollPane();
	Vector<JComboBox<Integer>> vtimeComboBox = new Vector<JComboBox<Integer>>();
	Vector<JComboBox> vaMComboBox = new Vector<JComboBox>();

	/**
	 * AddingUi의 생성자
	 * 컴포넌트들을 등록한다. 
	 */
	public PlanAddingUi() {
		super();
		setTitle("PlanAddingUi");
		
		jScrollPane.setLayout(null);
		this.addLabel();
		
		//PlanTitle을 입력받을 텍스트 필드 planTitle 등록
		this.makePlanTitle();
		
		//계획을 파일로 저장할 계획 저장 버튼 등록
		this.addPlanAdderButton();

		btAddAlarm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//시간 콤보박스 등록
				Integer[] time = new Integer[120];
				for(int i=0;i<120;i++) {
					time[i]=Integer.valueOf(i);
					}
				System.out.println("알람 추가 버튼 확인");
				JComboBox<Integer> timeComboBox = new JComboBox<Integer>(time);
				System.out.println("timeComboBox 생성");
				timeComboBox.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JComboBox<Integer> cb = (JComboBox<Integer>)e.getSource();
						plan.addTimeSetting(cb.getSelectedIndex());
						System.out.println(cb.getSelectedIndex());
						cb.setEnabled(false);
					}
				});
				System.out.println("vComboBox벡터에 콤보박스 등록");
				timeComboBox.setSize(100,20);
				timeComboBox.setLocation(150,0+vtimeComboBox.size()*50);
				System.out.println("크기, 위치 설정");
				vtimeComboBox.add(timeComboBox);
				jScrollPane.add(vtimeComboBox.lastElement());
				System.out.println("ScrollPane에 등록");

				//alarmMethod 콤보박스 등록
				ReadExProcessList readExProcessList = new ReadExProcessList();
				Vector<String> vFileList = new Vector<String>();
				vFileList = readExProcessList.getvFileList();
				vFileList.add(0,"알람 화면 출력");
				JComboBox aMComboBox = new JComboBox<String>(vFileList);
				System.out.println("알람 추가 버튼 확인");
				System.out.println("aMComboBox 생성");
				aMComboBox.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JComboBox<String> cb = (JComboBox<String>)e.getSource();
						plan.addAlarmMethod((String)cb.getSelectedItem());
						System.out.println((String)cb.getSelectedItem());
						plan.addAlarm();
						cb.setEnabled(false);
					}
				});
				vaMComboBox.add(aMComboBox);
				System.out.println("vaMComboBox벡터에 콤보박스 등록");
				aMComboBox.setSize(100,20);
				aMComboBox.setLocation(550,-50+vaMComboBox.size()*50);
				System.out.println("크기, 위치 설정");
				jScrollPane.add(vaMComboBox.lastElement());
				System.out.println("ScrollPane에 등록");
				JFrame superFrame =(JFrame)((JButton)arg0.getSource()).getTopLevelAncestor();
				superFrame.repaint();
				//alarmMethod 콤보박스 등록
				
			}
			
		});
		//jScrollPane 등록
		jScrollPane.setLocation(50,150);
		jScrollPane.setSize(700,400);
		getContentPane().add(jScrollPane);
		System.out.println("ScrollPane출력");
		
		
		getContentPane().add(btAddAlarm);
		System.out.println("알람추가 버튼 출력");
	}

	public void addLabel() {
		//문자열 레이블 "계획 출력" 등록
				label.setFont(new Font("Serif", Font.BOLD, 20));
				label.setLocation(50, 20);
				label.setSize(400, 50);
				getContentPane().add(label);
				System.out.println("label " + label.getText() + " 출력");
	}
	
	public void makePlanTitle() {
		//PlanTitle을 입력받을 텍스트 필드 planTitle 등록
				planTitle.setFont(new Font("Serif", Font.PLAIN, 20));
				planTitle.setLocation(50, 70);
				planTitle.setSize(600, 50);
				planTitle.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						plan.rename(((JTextField)e.getSource()).getText());
						System.out.println(((JTextField)e.getSource()).getText()+"으로 설정");
					}
					
				});
				getContentPane().add(planTitle);
				System.out.println("textField " + planTitle.getText() + " 출력");
	}
	
	public void addPlanAdderButton() {
		btAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PlanAdder(plan);
				JFrame superFrame =(JFrame)((JButton)e.getSource()).getTopLevelAncestor();
				superFrame.dispose();
			}
			
		});
		getContentPane().add(btAdd);
		System.out.println("계획 저장 버튼 출력");
	}
}
