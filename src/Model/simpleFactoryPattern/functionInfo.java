package simpleFactoryPattern;

public class functionInfo {
	
	private long Number_1 ; 
	private long Number_2 ;
	
	private String Sign ;
	
	public void setNumber_1(long Number_1){
		this.Number_1 = Number_1;
	}
	public void setNumber_2(long Number_2){
		this.Number_2 = Number_2;
	}
	public void setSign (String Sign){
		this.Sign = Sign;
	}
	public String getSign(){
		return Sign;
	}
	public long getNumber_1(){
		return Number_1;
	}
	public long getNumber_2(){
		return Number_2;
	}
	


}




class test{
	public static void main(String[] args, long Number_1 , long Number_2 )
	{
		System.out.println("please input number A and B:");
		functionInfo test_1 = new functionInfo();

		test_1.setNumber_1(Number_1);
		test_1.setNumber_2(Number_2);
		
		
		
	}
	
	
}
