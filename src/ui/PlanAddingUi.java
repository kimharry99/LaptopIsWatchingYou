package ui;

import javax.swing.*;

import planAndFileManagement.Plan;
import planAndFileManagement.PlanAdder;

import java.awt.*;
import java.awt.event.*;

/**
 * AddingUi는 Plan을 저장하기 위한 정보를 입력받는 Ui이다. 
 * 계획의 이름, 알람시간, 알람방법의 정보를 입력받아 객체 Plan을 생성한다.
 * 저장버튼을 통해 PlanAdder클래스를 호출한다. 
 * @author kimha
 *
 */
public class AddingUi extends SuperUi {
	
	// *** AddingUi의 변수선언 ***
	JLabel label = new JLabel("계획 추가");
	JTextField planTitle = new JTextField("계획의 이름을 설정하십시오", 1);
	JButton btAdd = this.makeButton("저장", 100, 40, 1000, 450);
	Plan plan = new Plan();
	PlanAdder planAdder = new PlanAdder(plan);
	String columnNames[] = { "시각", "방법" };
	Object rowData[][] = { { 1, "맛동산" }, { 2, "아폴로" }, { 3, "칸쵸코" } };
	JTable jTable = new JTable(rowData, columnNames);
	JScrollPane jScrollPane = new JScrollPane(jTable);

	/**
	 * AddingUi의 생성자
	 * 컴포넌트들을 등록한다. 
	 */
	public AddingUi() {
		setTitle("AddingUi");
		
		//문자열 레이블 "계획 출력" 등록
		label.setFont(new Font("Serif", Font.BOLD, 20));
		label.setLocation(50, 20);
		label.setSize(400, 50);
		getContentPane().add(label);
		System.out.println("label " + label.getText() + " 출력");
		
		//PlanTitle을 입력받을 텍스트 필드 planTitle 등록
		planTitle.setFont(new Font("Serif", Font.PLAIN, 20));
		planTitle.setLocation(50, 70);
		planTitle.setSize(600, 50);
		getContentPane().add(planTitle);
		System.out.println("textField " + planTitle.getText() + " 출력");

		//계획을 파일로 저장할 계획 저장 버튼 등록
		getContentPane().add(btAdd);
		System.out.println("계획 저장 버튼 출력");
		
		//계획이 알람 시간과 알람 방법을 입력받는 jTable 등록
		jScrollPane.setLocation(50,150);
		jScrollPane.setSize(700,400);
		jTable.setFont(new Font("Serif", Font.PLAIN, 20));
		jTable.setShowHorizontalLines(false);
		jTable.setRowHeight(50);
		getContentPane().add(jScrollPane);
		System.out.println("ScrollPane에 부착된 jTbable 출력");
		
		JButton btAddAlarm = makeButton("알람 추가",100,40,760,160);
		getContentPane().add(btAddAlarm);
		System.out.println("알람추가 버튼 출력");
	}
}
