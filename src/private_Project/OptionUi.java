package private_Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OptionUi extends SuperUi {
	String[] planNames = new PlanLoader().loadPlanList(); // PlanLoader로 부터 계획 이름 전달

	OptionUi() {
		super();
		setTitle("Option");

		JList<String> planList = new JList<String>(planNames); // 계획이름 JList 생성
		planList.setFont(new Font("Serif", Font.PLAIN, 30));
		planList.setSize(200, 200);

		JScrollPane spane = new JScrollPane(planList);
		spane.setLocation(100, 50);
		spane.setSize(700, 500);

		getContentPane().add(spane);
		
		JButton adding = new JButton ("추가");
		//adding.setLocation(p);
		//adding.setSize(d);
		getContentPane().add(adding);
		
		JButton modifing = new JButton("수정");
	}
}
