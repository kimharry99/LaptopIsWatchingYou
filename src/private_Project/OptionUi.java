package private_Project;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class OptionUi extends SuperUi {
	String[] planNames = new PlanLoader().loadPlanList(); // PlanLoader로 부터 계획 이름 전달
	JButton adding = this.makeButton("추가", 100, 40, 1000, 100);
	JButton modifing = this.makeButton("수정", 100, 40, 1000, 150);
	JButton eliminating = this.makeButton("삭제", 100, 40, 1000, 200);
	
	OptionUi() {
		super();
		setTitle("Option");
		
		JList<String> planList = new JList<String>(planNames); // 계획이름 JList 생성
		planList.setFont(new Font("Serif", Font.PLAIN, 30));
		planList.setSize(200, 200);
		planList.addListSelectionListener(new PlanListSelection());
		

		JScrollPane scrollPane = new JScrollPane(planList);
		scrollPane.setLocation(100, 50);
		scrollPane.setSize(700, 500);
		
		getContentPane().add(scrollPane);
		
		getContentPane().add(adding);
		modifing.setEnabled(false);
		
		getContentPane().add(modifing);
		eliminating.setEnabled(false);
		
		getContentPane().add(eliminating);
	}
	
	class PlanListSelection implements ListSelectionListener{
		int firstIndex, lastIndex =0;
		@Override
		public void valueChanged(ListSelectionEvent e) {
			firstIndex = e.getFirstIndex();
			lastIndex = e.getLastIndex();
			boolean adjust = e.getValueIsAdjusting();
			if(!adjust) {
				JList list = (JList) e.getSource();
				int selections[] = list.getSelectedIndices();
				@SuppressWarnings("deprecation")
				Object selectionValues[] = list.getSelectedValues();
				if(selections.length==1) {
					modifing.setEnabled(true);
					eliminating.setEnabled(true);
				}
		}}
		
	}
}
