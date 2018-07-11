package String;

public class stringClass {
	String strObj1;
	String strObj2;
	
	void setStrObj(String x,String y){
		strObj1 = x;
		strObj2 = y;
	}
	void getByLength(){
		int num = strObj1.length();
		System.out.println(num);
	}
	void getByCharAt(){
		char charObj = strObj2.charAt(0);
		System.out.println(charObj);
	}
//	void Print(){
		
		
//	}
	
	
}
