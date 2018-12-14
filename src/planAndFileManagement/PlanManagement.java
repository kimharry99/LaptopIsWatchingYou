package planAndFileManagement;

import java.util.Iterator;

import alarmMethod.AlarmMethod;

// *** 계획 관리 클래스 ***


public class PlanManagement {	
	// *** 멤버 변수 선언 ***
	Plan plan=null;
	int stTime;
	int edTime;
	// *** 계획 관리클래스의 생성자
	/**
	 * fileName을 통해 PlanLoader을 호출 한다. 
	 * @param fileName
	 */
		public PlanManagement(String fileName) {
		System.out.println("생성자 PlanManagement("+fileName+")호출");
		plan = (new PlanLoader(fileName)).toPlan();
		System.out.println("file "+fileName+" >>> "+plan.getName());
		Iterator<Integer>tempIt = plan.getTimeSettingList().iterator();
		while(tempIt.hasNext())
			System.out.println("알람시각 : "+tempIt.next());
		stTime = (int)System.currentTimeMillis();
		while((int)System.currentTimeMillis()-stTime<(1000*10)) {
			System.out.println("지난 시간 : "+((int)System.currentTimeMillis()-stTime)/1000);
			this.TimeMatching((int)System.currentTimeMillis()-stTime);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("계획 종료");
	}
	
	public void TimeMatching(int time) {
		Iterator<Integer>it = plan.getTimeSettingList().iterator();
		while(it.hasNext()) {
			int n = it.next();
			time/=1000;
			if(n*2-time==0) {
				System.out.println("알람 이름 : "+plan.getAlarm().get(n));
				new AlarmMethod(plan.getAlarm().get(n));
				break;
			}
		}
	}
}