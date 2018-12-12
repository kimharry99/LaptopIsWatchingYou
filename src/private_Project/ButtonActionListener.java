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
			break;
		case "설정" :
			new OptionUi();
			break;
		case "실행":
			new ExecutionUi();
			break;
		case "추가":
			new AddingUi();
			break;
		case "수정":
			new ModifieUi();
			break;
		case "삭제" :
			break;
		}
	}
	
}
