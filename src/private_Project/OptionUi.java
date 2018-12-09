package private_Project;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class OptionUi extends SuperUi {
	String[] planNames = new PlanLoader().loadPlanList(); // PlanLoader로 부터 계획 이름 전달

	OptionUi() {
		super();
		setTitle("Option");

		JList<String> planList = new JList<String>(planNames); // 계획이름 JList 생성
		planList.setFont(new Font("Serif", Font.PLAIN, 30));
		planList.setSize(200, 200);
		planList.addListSelectionListener(null);

		JScrollPane spane = new JScrollPane(planList);
		spane.setLocation(100, 50);
		spane.setSize(700, 500);
		
		getContentPane().add(spane);
		
		JButton adding = this.makeButton("추가", 100, 40, 1000, 100);
		getContentPane().add(adding);
		
		JButton modifing = this.makeButton("수정", 100, 40, 1000, 150);
		getContentPane().add(modifing);
		
		JButton eliminating = this.makeButton("삭제", 100, 40, 1000, 200);
		getContentPane().add(eliminating);
	}
	
	class PlanListSelection implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
