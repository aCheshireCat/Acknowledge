package String;

import java.util.ArrayList;

public class stringTest {
	public static void main(String[] args){
//		stringClass Testdemo = new stringClass();
//		Testdemo.setStrObj("abcde", "ABCDE");
//		Testdemo.getByLength();
//		Testdemo.getByCharAt();
//		
//		String  superStr = "How do you do?";
//		int firstPoint1 = superStr.indexOf(' ',3);
//		int firstPoint2 = superStr.indexOf("How");
//		System.out.println(firstPoint1);
//		System.out.println(firstPoint2);
//		StringBuffer sb = new StringBuffer("dfadf");
//			System.out.println(sb.toString() + "|");
//			System.out.println((sb.length()>0));
		System.out.println(getInteger("efghi"));
		
	}

	/**
	 * @see
	 * @param aInputStr
	 * @return
	 */
	 public static boolean isNotNull(String aInputStr) {
	        if (aInputStr == null || aInputStr.trim().equals("")) {
	            return false;
	        }else return true;
	}

	public static String getInteger(String input)
	{
		String str 			= input;
		String retStr 		= "";
		char[] col 			= str.toCharArray();
		System.out.println(col);
		int valueA 			= 'a';
//		System.out.println(valueA);
		int valueZ 			= 'z';
//		System.out.println(valueZ);
		ArrayList dealCol 	= new ArrayList(col.length);
		char endChar ='\0';
		for (char dealChar:col
			 ) {
			int dealValue = dealChar;
//			System.out.println("begin endChar:" + endChar);
			if( ( dealValue <= valueZ-5 ) && dealValue >= valueA )
			{
				endChar = (char)(dealValue+5);
//				System.out.println("if:" + endChar);
				dealCol.add(endChar);
			}else{
				endChar = (char)(valueA + (5-(valueZ-dealValue)) -1 );
//				System.out.println("else:" + endChar);
				dealCol.add(endChar);
			}
		}
		System.out.println(dealCol);
		StringBuffer sb = new StringBuffer();
		for (Object singleChar :
				dealCol) {
			sb.append(singleChar);
		}
		retStr = sb.toString();
		assert retStr == "jklmn";
		return retStr;
	}

}
