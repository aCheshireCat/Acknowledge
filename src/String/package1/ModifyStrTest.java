package String.package1;

public class ModifyStrTest {
	public static void main(String args[]){
		
		String sourceStr = "this is a string text example!";
	//	StringBuffer sourceSrt
		String strObj1 = sourceStr.substring(0);
		String strObj2 = sourceStr.substring(8, 16);
		String strObj3 = strObj2.toUpperCase();
		String strObj4 = sourceStr.replace("is","si");
		String strObj5 = sourceStr.concat(strObj1);
		
		
		System.out.println("sourcr String:"+ sourceStr);
		System.out.println("Sub String 1:"+strObj1);
		System.out.println("Sub String 2:"+strObj2);
		System.out.println("UpperCase of sub String 2:"+strObj3);
		System.out.println("String after replacing source string:"+strObj4);
		System.out.println("Making source string and sub string:"+strObj5);
		
		
		
		
	}

}
