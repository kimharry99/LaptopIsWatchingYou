package planAndFileManagement;

import java.io.File;

public class PlanEliminator {
	public PlanEliminator(String fileName) {
		
		File f=new File("c:\\PrivateAlarm\\"+fileName);
		if( f.exists() ){
            if(f.delete()){
                System.out.println("파일삭제 성공");
            }else{
                System.out.println("파일삭제 실패");
            }
        }else{
            System.out.println("파일이 존재하지 않습니다.");
        }

	}
}
