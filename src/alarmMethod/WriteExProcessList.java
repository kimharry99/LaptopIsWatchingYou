package alarmMethod;

import java.io.FileWriter;
import java.io.IOException;

// *** WriteExProcessList 클래스 ***
/**
 * 파일 작성
 * 알람의 방법으로 사용될 외부 파일들의 경로를 파일로 저장한다. 
 * 파일작성은 AlarmMethodAddingUi에서 이뤄진다.
 * @author kimha
 *
 */
public class WriteExProcessList {
	// *** 멤버변수 선언 ***
	FileWriter fout = null;
	
	/**
	 * WriteExProcessList의 생성자
	 * @param fileName 알람시각에 실행할 파일의 이름 \n
	 * JComboBox와 ExProcessList에 표시될 이름 
	 * @param filePath 알람시각에 실행할 파일의 경로
	 */
	public WriteExProcessList(String fileName, String filePath) {
		try {
			//새 데이터를 파일의 마지막에 추가
			fout = new FileWriter("c:\\PrivateAlarm\\ExProcessList.txt",true);
			fout.write(fileName+","+filePath+"\n");
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
