
public class ExceptionTestDemo {
	public static void main(String args[]){
		
		int arrayObj[] = new int[3];
		try{
			arrayObj[1] = 1;
			arrayObj[2] = 2;
			arrayObj[3] = 3;
		}catch(ArrayIndexOutOfBoundsException x){
			System.out.println("³¬³öÊý×é·¶Î§");
		}
		
	}

}
