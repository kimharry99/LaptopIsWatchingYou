package buttonActionListener;

import javax.swing.*;

import planAndFileManagement.PlanEliminator;
import ui.AddingUi;
import ui.ExecutionUi;
import ui.ModifieUi;
import ui.OptionUi;

import java.awt.*;
import java.awt.event.*;

/**
 * private_Project의 모든 gui에서 사용하는 JButton에 대한 액션리스너
 * 버튼의 이름을 입력받아 그에 알맞은 이벤트를 실행한다.
 * Ui별로 버튼 리스너를 쪼개는 것이 좋을 것 같다. 
 * @author kimha
 *
 */
public class ButtonActionListener implements ActionListener {	//모든 버튼에 대한 액션리스너

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		JFrame superFrame =(JFrame)((JButton)e.getSource()).getTopLevelAncestor();
		switch(cmd) {	//메뉴아이템의 종류 구분, 닫기,설정,실행,추가,수정,삭제
		//모든 Ui의 닫기 버튼
		case "닫기" :
			superFrame.dispose();
			System.out.println(superFrame.getTitle()+" 창 닫기");
			break;
		
		//MainUi의 설정 버튼
		case "설정" :
			new OptionUi();
			System.out.println("OptionUi 출력");
			break;
		
		//MainUi의 실행 버튼
		case "실행":
			new ExecutionUi();
			System.out.println("ExecutionUi 출력");
			break;
		
		//OptionUi의 추가 버튼 
		case "추가":
			new AddingUi();
			System.out.println("AddingUi 출력");
			break;
			
		//OptionUi의 수정버튼
		case "수정":
			new ModifieUi();
			System.out.println("ModifingUi 출력");
			break;
			
		//OptionUi의 삭제버튼
		case "삭제" :
			new PlanEliminator().planEliminating();
			System.out.println("삭제 실행");
			break;
			
		//OptionUi의 알람방법 버튼
		case "알람 방법 " :
			System.out.println("AlamMethodUi 출력");
			break;
		
		//AddingUi의 저장 버튼 
		case "저장":
			//new PlanAdder().add();
			System.out.println("계획 저장");
			superFrame.dispose();
			System.out.println(superFrame.getTitle()+" 창 닫기");
			break;
		}
	}
	
}
