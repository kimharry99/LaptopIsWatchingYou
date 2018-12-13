package buttonActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AddingUiButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		JFrame superFrame =(JFrame)((JButton)e.getSource()).getTopLevelAncestor();
		switch(cmd) {	
		//AddingUi의 저장 버튼 
			case "저장":
				//new PlanAdder().add();
				System.out.println("계획 저장");
				superFrame.dispose();
				System.out.println(superFrame.getTitle()+" 창 닫기");
				break;
			case "알람 추가" :
				System.out.println("알람 추가 버튼 확인");
				break;
			}
		}
	}

