package private_Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SuperUi extends JFrame{
	JButton[] buttonArray = new JButton[20];
	public SuperUi() {
		setTitle("Ui");
		Container c = getContentPane();
		c.setLayout(null);
		//UI기본 설정들 (layout null)
		
		setSize(1250,640);
		setVisible(true);
		
		JButton btClose = this.makeButton("닫기", 100, 40, 1000, 500);//창을 닫는 닫기 버튼 출력
		
		c.add(btClose);

	}
	JButton makeButton(String buttonName, int sizex, int sizey, int coX,int coY) {//버튼의 인스턴스 변수 리턴
		JButton bt = new JButton(buttonName);
		bt.setSize(sizex,sizey);
		bt.setLocation(coX,coY);
		bt.addActionListener(new ButtonActionListener());
		return bt;
	}
	class ButtonActionListener implements ActionListener {	//모든 버튼에 대한 액션리스너

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String cmd = e.getActionCommand();
			switch(cmd) {	//메뉴아이템의 종류 구분, 닫기,설정,실행,추가,수정,삭제
			case "닫기" :
				dispose();
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
	
	public static void main(String[] args) {
		new MainUi();
	}
}
