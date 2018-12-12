package private_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonActionListener implements ActionListener {	//모든 버튼에 대한 액션리스너

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		JFrame superFrame =(JFrame)((JButton)e.getSource()).getTopLevelAncestor();
		switch(cmd) {	//메뉴아이템의 종류 구분, 닫기,설정,실행,추가,수정,삭제
		case "닫기" :
			superFrame.dispose();
			System.out.println(superFrame.getTitle()+" 창 닫기");
			break;
		case "설정" :
			new OptionUi();
			System.out.println("OptionUi 출력");
			break;
		case "실행":
			new ExecutionUi();
			System.out.println("ExecutionUi 출력");
			break;
		case "추가":
			new AddingUi();
			System.out.println("AddingUi 출력");
			break;
		case "수정":
			new ModifieUi();
			System.out.println("ModifingUi 출력");
			break;
		case "삭제" :
			System.out.println("삭제 실행");
			break;
		}
	}
	
}
