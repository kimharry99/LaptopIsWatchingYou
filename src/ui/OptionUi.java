package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import buttonActionListener.ButtonActionListener;
import buttonActionListener.OptionUiButtonActionListener;
import planAndFileManagement.PlanEliminator;
import planAndFileManagement.PlanLoader;

import java.awt.event.*;
import java.io.File;
import java.util.Vector;

public class OptionUi extends SuperUi {
	Vector<String> planNames = new Vector<String>();// PlanLoader로 부터 계획 이름 전달
	JButton adding = this.makeButton("추가", 100, 40, 1000, 100);
	// JButton modifing = this.makeButton("수정", 100, 40, 1000, 150);
	JButton eliminating = this.makeButton("삭제", 100, 40, 1000, 200);

	JList<String> planList = new JList<String>(planNames); // 계획이름 JList 생성
	JScrollPane scrollPane = new JScrollPane(planList);
	JButton alarmMethod = this.makeButton("알람 방법", 100, 40, 1000, 300);
	String selectedFileName = null;

	public OptionUi() {
		super();
		setTitle("Option");

		adding.addActionListener(new OptionUiButtonActionListener());
		// modifing.addActionListener(new OptionUiButtonActionListener());
		eliminating.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PlanEliminator(selectedFileName);
			}

		});
		alarmMethod.addActionListener(new OptionUiButtonActionListener());

		JLabel label = new JLabel("계획 목록");
		label.setFont(new Font("Serif", Font.BOLD, 30));
		label.setLocation(100, 50);
		label.setSize(700, 50);
		getContentPane().add(label);

		this.loadPlanList();

		planList.setFont(new Font("Serif", Font.PLAIN, 30));
		planList.setSize(200, 200);
		planList.addListSelectionListener(new PlanListSelection());

		scrollPane.setLocation(100, 100);
		scrollPane.setSize(700, 450);

		getContentPane().add(scrollPane);

		getContentPane().add(adding);

		// modifing.setEnabled(false);
		// getContentPane().add(modifing);
		eliminating.setEnabled(false);

		getContentPane().add(eliminating);

		getContentPane().add(alarmMethod);
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
					// modifing.setEnabled(true);
					eliminating.setEnabled(true);
				}
			}
		}

	}
}
