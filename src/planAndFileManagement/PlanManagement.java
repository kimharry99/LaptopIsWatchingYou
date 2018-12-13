package planAndFileManagement;

import java.util.Iterator;

import alarmMethod.AlarmMethod;

// *** 계획 관리 클래스 ***


public class PlanManagement {	
	// *** 멤버 변수 선언 ***
	Plan plan;
	int stTime;
	int edTime;
	// *** 계획 관리클래스의 생성자
	/**
	 * fileName을 통해 PlanLoader을 호출 한다. 
	 * @param fileName
	 */
	public PlanManagement(String fileName) {
		Plan plan = new PlanLoader(fileName).toPlan();
		stTime = (int)System.currentTimeMillis();
		while((int)System.currentTimeMillis()-stTime<(1000*3600*2)) {
			this.TimeMatching((int)System.currentTimeMillis());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void TimeMatching(int time) {
		Iterator<Integer>it = plan.getTimeSettingList().iterator();
		while(it.hasNext()) {
			int n = it.next();
			if(n*60-time<1000 && n*60-time >1000) {
				new AlarmMethod(plan.getAlarm().get(n));
			break;
			}
		}
	}
}