package Exception.package5;

public class test {
	public static void main(String[] args){

	baseClass personA = new baseClass("A",777,"I am A");
	try
	{	
		if(personA.getAge() >=100 ||personA.getAge() <=0)
		throw new MyException();
	}catch( MyException x){
		x.getMessage();
	}
}
	
}
