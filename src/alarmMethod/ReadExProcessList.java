package alarmMethod;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

// *** ReadExProcessList클래스 ***
/**
 * 알람시 실행할 파일들의 경로를 기록해놓은 파일을 로드한다.
 * 알람 실행파일의 이름을 Vector<String>으로 저장한다. 
 * PlanAddingUi의 알람 추가의 JCombobox의 생성을 위해 호출된다. 
 * @author kimha
 *
 */

public class ReadExProcessList {
	// *** 멤버 변수 선언 ***
	//파일이름이 저장되는 Vector
	Vector<String> vFileList = new Vector <String>();
	Vector<String> vFilePath= new Vector <String>();
	HashMap<String, String> FileAndPath = new HashMap<String,String>();
	//ExProcessList의 경로 fout
	FileReader fin = null; 
	
	public ReadExProcessList() {
		try {
			fin = new FileReader("c:\\PrivateAlarm\\ExProcessList.txt");
			char [] buf = new char[1024];
			fin.read(buf);
			String fileName = String.valueOf(buf);
			System.out.println(fileName);
			StringTokenizer st = new StringTokenizer(fileName,",\n");
			addtovFileList(st);
			fin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * StringTokenizer을 받아 실행파일의 이름부분만 vFileList에 저장한다. 
	 * @param st
	 */
	public void addtovFileList (StringTokenizer st) {
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			vFileList.add(token);
			System.out.println("파일 이름 토큰 : "+token);
			if(!st.hasMoreTokens())
				break;
			token = st.nextToken();
			vFilePath.add(token);
			System.out.println("파일 경로 토큰 : "+token);
		}
	}
	
	public void makeHashMap() {
		Iterator<String>itFile = vFileList.iterator();
		Iterator<String>itPath = vFilePath.iterator();
		
		while(itPath.hasNext()) {
			FileAndPath.put(itFile.next(),itPath.next());
		}
	}
	
	public Vector<String> getvFileList(){
		System.out.println("vFileList의 크기"+vFileList.size());
		return vFileList;
	}
	
	public Vector<String> getvFilePath(){
		System.out.println("vFilePath의 크기"+vFilePath.size());
		return vFilePath;
	}
	
	public HashMap<String,String> getFileAndPath(){
		return FileAndPath;
	}
}
