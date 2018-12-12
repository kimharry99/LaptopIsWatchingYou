package private_Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddingUi extends SuperUi{
	public AddingUi() {
		setTitle("AddingUi");
		
		JTextField planTitle = new JTextField ("계획의 이름을 설정하십시오",1);
		
		planTitle.setLocation(50,50);
		planTitle.setSize(600,50);
		getContentPane().add(planTitle);
	}
}
