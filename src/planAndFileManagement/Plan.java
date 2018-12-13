package planAndFileManagement;

import private_Project.AlarmMethod;

/**
 * 계획 객체, 이름과 알람 시각과 알람 방법의 배열을 멤버로 가진다. rename addTimeSetting을 통해 멤버를 수정할 수 있다.
 * @author kimha
 */

public class Plan {
	
	// *** Plan의 변수 선언 ***
	
	String name;	//계획 이름
	int [] timeSetting = new int [10];	//알람시각의 배열
	
	/**
	 * Plan의 이름을 최조지정, 재지정하는 메소드 
	 * @param name 계획의 이름
	 */
	void rename(String name) {
		name=this.name;
	}
	
	
	/**
	 * 
	 * @param num
	 * @param hour
	 * @param minute
	 */
	void addTimeSetting(int num, int hour, int minute) {	//알람 시각 추가
		timeSetting[num]=hour*60+minute;
	}
	
	
	int getTimeSetting(int num) {	//num번째 알람의 알람 시각을 리턴
		return timeSetting[num];
	}
	
	void addAlarmMethod(int num, AlarmMethod alarmMethod) {
		
	}
	String getName() {	//계획이름을 리턴
		return name;
	}
}
