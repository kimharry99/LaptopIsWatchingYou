package planAndFileManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// *** PlanAdder 클래스 ***
/**
 * Plan객체를 .plan 파일로 바꾸어 저장하는 클래스
 * @author kimha
 * @version
 * 
 */

public class PlanAdder{
	// *** PlanAdder의 멤버 선언 ***
	
	Plan plan=null;
	FileWriter fout =null;
	
	/**
	 * [PlanAdder의 생성자] 
	 * File로 변환할 Plan객체를 호출한다.
	 * savePlanNametoFile과 saveAlarmtoFile을 호출해 파일 기록
	 * @param plan
	 */
	public PlanAdder(Plan p){
		this.plan = p;
		System.out.println(plan.getName()+"전달 받다.");
		try {
			fout = new FileWriter("c:\\PrivateAlarm\\"+plan.getName()+".txt");
			System.out.println("파일 경로 : "+"c:\\PrivateAlarm\\"+plan.getName()+".txt");
			System.out.println(this.writePlanNametoFile(fout));
			System.out.println(this.writeAlarmtoFile(fout));
			System.out.println("파일"+plan.getName()+".txt 생성 완료!");
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// *** PlanName저장 메소드 ***
	/**
	 * [PlanName 저장 메소드]
	 * Plan을 받아와 PlanName : ----\n 으로 작성
	 * @return 저장에 성공하면 true 아니라면 false
	 */
	boolean writePlanNametoFile(FileWriter fout) {
			try {
				fout.write("PlanName : "+plan.getName()+"\n");
				System.out.println("계획 이름 기록 완료");
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}
	
	// *** PlanAlarm저장 메소드 ***
	/**
	 * [PlanAlarm 저장 메소드]
	 * Plan을 받아와 Alarms : \n timeSetting,alarmMethodName \n ... 으로 작성
	 * @return 저장에 성공하면 true 아니라면 false
	 */
	boolean writeAlarmtoFile(FileWriter fout) {
		try {
			fout.write("Alarms :\n");
			Set<Integer> keys = plan.hAlarm.keySet();
			Iterator<Integer>it=keys.iterator();
			while(it.hasNext()) {
				Integer timeSetting = it.next();
				String alarmMethod = plan.hAlarm.get(timeSetting);
				System.out.println(timeSetting+","+alarmMethod);
				fout.write(timeSetting+","+alarmMethod+"\n");
				System.out.println("알람 기록 완료");
			}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
