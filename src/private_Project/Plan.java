package private_Project;

public class Plan {
	String name;	//계획 이름
	int [] timeSetting = new int [10];	//알람시각의 배열
	Plan(String name){
		name=this.name;
	}
	
	void addTimeSetting(int num, int hour, int minute) {	//알람 시각 추가
		timeSetting[num]=hour*60+minute;
	}
	
	int getTimeSetting(int num) {	//num번째 알람의 알람 시각을 리턴
		return timeSetting[num];
	}
	
	String getName() {	//계획이름을 리턴
		return name;
	}
}
