package stringclass;

public class stringTest  {
	public static void main(String[] args){
		stringClass Testdemo = new stringClass();
		Testdemo.setStrObj("abcde", "ABCDE");
		Testdemo.getByLength();
		Testdemo.getByCharAt();
		
		String  superStr = "How do you do?";
		int firstPoint1 = superStr.indexOf(' ',3);
		int firstPoint2 = superStr.indexOf("How");
		System.out.println(firstPoint1);
		System.out.println(firstPoint2);
		

		
	}

}
