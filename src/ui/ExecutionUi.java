package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import planAndFileManagement.PlanManagement;
import ui.OptionUi.PlanListSelection;

public class ExecutionUi extends SuperUi {
	Vector<String> planNames = new Vector<String>();// PlanLoader로 부터 계획 이름 전달
	JList<String> planList = new JList<String>(planNames); // 계획이름 JList 생성
	JButton Execution = new JButton("계획 선택");
	JScrollPane scrollPane = new JScrollPane(planList);
	String selectedFileName = null;

	public ExecutionUi() {
		super();
		setTitle("ExecutionUi");

		this.loadPlanList();

		planList.setFont(new Font("Serif", Font.PLAIN, 30));
		planList.setSize(200, 200);
		planList.addListSelectionListener(new PlanListSelection());

		scrollPane.setLocation(100, 100);
		scrollPane.setSize(700, 450);
		getContentPane().add(scrollPane);
		
		Execution.setSize(100,40);
		Execution.setLocation(1000,450);
		Execution.setEnabled(false);
		Execution.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new PlanManagement(selectedFileName);
				System.out.println(selectedFileName+" 계획 실행");
			}
			
		});
		getContentPane().add(Execution);
	}

	public void loadPlanList() {
		File f = new File("c:\\PrivateAlarm");
		File[] subfiles = f.listFiles();
		for (int i = 0; i < subfiles.length; i++) {
			if (!"ExProcessList.txt".equals(subfiles[i].getName()))
				planNames.add(subfiles[i].getName());
			System.out.println(subfiles[i].getPath());
		}
	}

	class PlanListSelection implements ListSelectionListener {
		int firstIndex, lastIndex = 0;

		@Override
		public void valueChanged(ListSelectionEvent e) {
			firstIndex = e.getFirstIndex();
			lastIndex = e.getLastIndex();
			boolean adjust = e.getValueIsAdjusting();
			if (!adjust) {
				JList list = (JList) e.getSource();
				int selections[] = list.getSelectedIndices();
				@SuppressWarnings("deprecation")
				Object selectionValues[] = list.getSelectedValues();
				if (selections.length == 1) {
					selectedFileName = (String) list.getSelectedValue();
					System.out.println(selectedFileName);
					Execution.setEnabled(true);
				}
			}
		}
	}
}
