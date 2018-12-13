package planAndFileManagement;

// *** PlanAdder 클래스 ***
/**
 * Plan객체를 .plan 파일로 바꾸어 저장하는 클래스
 * @author kimha
 */



public class PlanAdder extends PlanManager{
	// *** PlanAdder의 변수 선언 ***
	
	Plan plan;
	
	
	
	/**
	 * [PlanAdder의 생성자] 
	 * File로 변환할 Plan객체를 호출한다.
	 * @param plan
	 */
	public PlanAdder(Plan plan){
		plan = plan;
	}
	
	
	
	// *** Plan저장 메소드 ***
	/**
	 * [Plan 저장 메소드]
	 * Plan을 받아와 Plan의 정보를 Plan이름의 파일이름으로 저장한다. 
	 * @return 저장에 성공하면 true 아니라면 false
	 */
	boolean savePlanToFile() {
		return true;
	}
}
