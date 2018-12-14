package planAndFileManagement;

import java.util.*;

import alarmMethod.AlarmMethod;

/**
 * 계획 객체, 이름과 알람 시각과 알람 방법의 배열을 멤버로 가진다. rename addTimeSetting을 통해 멤버를 수정할 수 있다.
 * @author kimha
 */

public class Plan {
	
	// *** Plan의 변수 선언 ***
	
	//계획 이름
	String name;	
	//알람시각의 벡터
	Vector<Integer> vTimeSetting =new Vector<Integer>();
	//알람방법의 벡터
	Vector<String> vAlarmMethods = new Vector<String>();
	//알람의 해쉬맵
	HashMap<Integer, String> hAlarm = new HashMap<Integer, String>();
	
	
	/**
	 * Plan의 이름을 최조지정, 재지정하는 메소드 
	 * @param name 계획의 이름
	 */
	public void rename(String name) {
		this.name=name;
	}
	
	
	/**
	 * 
	 * @param hour
	 * @param minute
	 */
	public void addTimeSetting(int minute) {	//알람 시각 추가
		vTimeSetting.add(minute);
	}
	
	public int getTimeSetting() {
		return vTimeSetting.lastElement();
	}
	
	public Vector<Integer> getTimeSettingList(){
		return vTimeSetting;
	}
	
	/**
	 * vAlarmMethods 벡터에 alarmMethod를 등록
	 * @param alarmMethod
	 */
	public void addAlarmMethod(String string) {
		vAlarmMethods.add(string);
	}
	
	public String getAlarmMethod() {
		return vAlarmMethods.lastElement();
	}
	
	public Vector<String> getAlarmMethodList(){
		return vAlarmMethods;
	}
	
	/**
	 * @brief hAlarm과 vTimeSetting, vAlarmMethods에 정보 기록
	 * @param hour
	 * @param minute
	 * @param alarmMethod
	 */
	public void addAlarm() {
		if(vTimeSetting.size()>0&&vAlarmMethods.size()>0) {
			System.out.println(vTimeSetting.lastElement()+","+ vAlarmMethods.lastElement());
			hAlarm.put(vTimeSetting.lastElement(), vAlarmMethods.lastElement());
		}
	}
	public HashMap<Integer, String> getAlarm (){
		return this.hAlarm;
	}
	
	/**
	 * @return name : 계획이름을 리턴
	 */
	public String getName() {
		return name;
	}
}
