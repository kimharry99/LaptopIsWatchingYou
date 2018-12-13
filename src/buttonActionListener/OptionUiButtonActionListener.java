package buttonActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import planAndFileManagement.PlanEliminator;
import ui.AlarmMethodAddingUi;
import ui.ModifieUi;
import ui.PlanAddingUi;

public class OptionUiButtonActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		JFrame superFrame =(JFrame)((JButton)e.getSource()).getTopLevelAncestor();
		switch(cmd) {	//메뉴아이템의 종류 구분, 닫기,설정,실행,추가,수정,삭제
		//OptionUi의 추가 버튼 
				case "추가":
					new PlanAddingUi();
					System.out.println("AddingUi 출력");
					break;
					
				//OptionUi의 수정버튼
				case "수정":
					new ModifieUi();
					System.out.println("ModifingUi 출력");
					break;

					
				//OptionUi의 알람방법 버튼
				case "알람 방법" :
					new AlarmMethodAddingUi();
					System.out.println("AlarmMethodUi 출력");
					break;
				
		}
	}

}
