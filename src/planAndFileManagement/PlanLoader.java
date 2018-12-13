package planAndFileManagement;

import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * 계획파일을 받아 Plan객체로 리턴하기 위한 클래스
 * @author kimha
 *
 */

public class PlanLoader {
	// *** 멤버 변수 선언 ***
		//파일이름이 저장되는 Vector
		Vector<String> vFileList = new Vector <String>();
		
		//계획파일의 경로 fout
		FileReader fin = null; 
		
		//파일로부터 만드는 계획 객체
		Plan plan = new Plan();
		
		public PlanLoader(String fileName) {
			try {
				fin = new FileReader("c:\\PrivateAlarm\\"+fileName);
				char [] buf = new char[1024];
				fin.read(buf);
				String alarmList = String.valueOf(buf);
				System.out.println(fileName);

				makePlan(alarmList, fileName);
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * 
		 * @param alarmList
		 * @param fileName
		 */
		public void makePlan(String alarmList, String fileName) {
			StringTokenizer st = new StringTokenizer(alarmList,",\n");
			plan.rename(fileName);
			String token = st.nextToken();
			token = st.nextToken();
			while(st.hasMoreTokens()) {
				token = st.nextToken();
				plan.addTimeSetting(Integer.valueOf(token));
				token = st.nextToken();
				plan.addAlarmMethod(token);
				plan.addAlarm();
				System.out.println(token);
			}
		}
		public Plan toPlan() {
			return plan;
		}
}
