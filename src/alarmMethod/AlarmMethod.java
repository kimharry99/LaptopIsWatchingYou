package alarmMethod;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.*;

import ui.MessageUi;
import ui.SuperUi;

// *** 알람 방법 메소드 ***
/**
 * 주어진 알람 방법대로 알람을 수행하는 클래스 계획 생성, 수정에서 콤보박스를 통해 알람방법을 문자열로 전달받음 설정하면 생성 String
 * name을 통해 창 출력확인 후 파일 리스트 검색
 * 
 * @author kimha
 *
 */
public class AlarmMethod {
	// *** AlarmMethod의 멤버변수
	boolean isFile;
	String methodName;
	ReadExProcessList repl = new ReadExProcessList();

	// ***AlarmMethod의 생성자
	public AlarmMethod(String name) {
		System.out.println("생성자 AlarmMethod(" + name + ") 호출");
		methodName = name;
		if (name.equals("알람 화면 출력")) {
			new MessageUi();
		} else {
			this.exProcess(name);
		}

	}

	public void exProcess(String name) {
		String fileName = null;
		Iterator<String> it = repl.getvFileList().iterator();
		while (it.hasNext()) {
			fileName = it.next();
			if (fileName.equals(name))
				break;
		}
		System.out.println("알람 실행 파일 경로 : " + repl.getFileAndPath().get(fileName));
		Runtime rt = Runtime.getRuntime();
		Process pc = null;
		try {
			// �ܺ� ���μ��� ����
			pc = rt.exec(repl.getFileAndPath().get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pc.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pc.destroy();
		}
	}

	/**
	 * 알람화면을 출력하는 메소드
	 */

	public String getName() {
		return methodName;
	}
}
