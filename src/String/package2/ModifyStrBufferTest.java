package String.package2;

public class ModifyStrBufferTest {
	public static void main(String args[]){
		
		StringBuffer sourceStr = new StringBuffer("this is a StringBuffer example!");
//		StringBuffer sourceStr = "this is a StringBuffer example!";
		System.out.println("sourceStr:"+sourceStr);
		String subStr = "very good!";
		char charObj = '*';
		sourceStr.setCharAt(4,charObj);
		System.out.println("After setting char * At 4:" + sourceStr);
		sourceStr.deleteCharAt(4);
		System.out.println("After deleting char at 4:" + sourceStr);
		sourceStr.append("hello");
		System.out.println("After appending sub string 'hello':" + sourceStr);
		sourceStr.insert(0,subStr);
		System.out.println("After inserting sub string :" + sourceStr);
		sourceStr.delete(1,6);
		System.out.println("After deleting sub string :" + sourceStr);
	}

}
